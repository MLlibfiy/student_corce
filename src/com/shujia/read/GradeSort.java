package com.shujia.read;

import com.shujia.bean.Student;
import com.shujia.compare.SortGradeScore;
import com.shujia.util.Utils;

import java.util.*;

/**
 *
 * 按年级排名
 * 1、将数据读取到程序，用集合存起来
 *
 *
 */
public class GradeSort extends Base{
    public void gradeSort() throws Exception {
        /**
         * 2、关联学生信息表
         *
         * 循环学生信息表，每次去分数表里面查询学生总分
         */

        //调用用父类计算总分的方法
        HashMap<String, Integer> hashMap = super.comSumScore();
        //文科
        ArrayList<String> wen = new ArrayList<>();
        //理科
        ArrayList<String> li = new ArrayList<>();
        for (Student student : students) {
            //获取该学生总分
            Integer sumScore = hashMap.get(student.getId());
            String str = student.getId()+"\t"+student.getName()+"\t"+student.getGender()+"\t"+student.getClazz()+"\t"+sumScore;
            //按文理科分开,判断学生是文科还是理科
            if(student.getClazz().startsWith("文科")){
                wen.add(str);
            }else {
                li.add(str);
            }
        }

        /**
         *
         * 3、按总分降序排序
         */
        Collections.sort(wen,new SortGradeScore());
        Collections.sort(li,new SortGradeScore());
        /**
         * 4、增加名次列
         *
         */
        Utils.addRank(wen);
        Utils.addRank(li);

        for (String s : wen) {
            // System.out.println(s);
        }

        //保存数据到文件
        Utils.saveDataByFile(wen,"outData/文科.txt");
        Utils.saveDataByFile(li,"outData/理科.txt");
    }



}


