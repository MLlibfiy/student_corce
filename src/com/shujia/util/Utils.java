package com.shujia.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Utils {

    /**
     *增加名次列
     *
     * @param list
     */
    public static void addRank(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            s = s+"\t"+(i+1);
            //替换原来位置的元素
            list.set(i,s);
        }
    }


    /**
     *保存文件方法
     *
     */

    public static void saveDataByFile(ArrayList<String> list,String fileName) throws IOException {
        BufferedWriter liout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (String s : list) {
            liout.write(s);
            liout.newLine();
        }
        liout.close();
    }
}
