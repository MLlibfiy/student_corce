package com.shujia.read;

import com.shujia.bean.Cource;
import com.shujia.bean.Score;
import com.shujia.bean.Student;
import com.shujia.compare.SortScore;
import com.shujia.util.ReadUtil;
import com.shujia.util.Utils;

import java.io.*;
import java.util.*;

/**
 * 1、将数据读取到程序，用集合存起来
 *
 *
 */
public class mainDemo {
    public static void main(String[] args) throws Exception {
        List<Score> scores = ReadUtil.readData("data/score.txt", Score.class);

        /**
         * 1、计算学生总分
         *
         */

        //创建一个hashmap学号对应总分
        HashMap<String, Integer> hashMap = new HashMap<>();

        //循环分数表，对每个人的分数累加
        for (Score score : scores) {
            Integer integer = hashMap.get(score.getStudentId());
            if(integer==null){
                hashMap.put(score.getStudentId(),score.getScore());
            }else {
                //相同的key后面put会覆盖前面的
                hashMap.put(score.getStudentId(),integer+score.getScore());
            }
        }

        /**
         * 2、关联学生信息表
         *
         * 循环学生信息表，每次去分数表里面查询学生总分
         */

        List<Student> students = ReadUtil.readData("data/students.txt", Student.class);
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
        Collections.sort(wen,new SortScore());
        Collections.sort(li,new SortScore());
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


