package com.shujia.read;

import com.shujia.bean.Student;
import com.shujia.compare.SortClazzScore;
import com.shujia.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *按班级排名
 *
 */
public class ClazzSort extends Base{

    public void clazzSort() throws Exception {
        //计算学生总分
        HashMap<String, Integer> hashMap = super.comSumScore();


        //班级名称作为key,班级里面所有学生的集合作为value
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        //关联学生信息表
        for (Student student : students) {
            //获取学生总分
            Integer sumScore = hashMap.get(student.getId());
            //学号，姓名，总分，名次(还没有排序，所以名次现在加不了)
            String s = student.getId() + "\t" + student.getName() + "\t" + sumScore;
            //获取班级名称
            String clazz = student.getClazz();
            ArrayList<String> arrayList = map.get(clazz);
            if(arrayList==null){//说明刚循环到这个班级的第一个学生
                //创建这个班级的集合
                arrayList = new ArrayList<String>();
                //讲这个学生加入到这个集合中
                arrayList.add(s);
                map.put(clazz,arrayList);
            }else {
                //说明这个班级在map里面已经存在，直接增加一个新的学生即可
                arrayList.add(s);
            }
        }

        //班级内按总分排名
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            //班级学生的集合
            ArrayList<String> value = entry.getValue();
            //自定义排序规则排序
            Collections.sort(value,new SortClazzScore());
        }

        //增加名次
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            //使用写好的工具
            Utils.addRank(entry.getValue());
        }


        //保存到文件
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            //拼接文件名
            String fileName = "outData/"+entry.getKey()+".txt";
            Utils.saveDataByFile(entry.getValue(),fileName);
        }


    }
}
