package com.shujia.read;

import com.shujia.bean.Cource;
import com.shujia.bean.Score;
import com.shujia.bean.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * 1、将数据读取到程序，用集合存起来
 *
 *
 */
public class mainDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<Score> scores = new ArrayList<>();

        //读取分数表
        readScore(scores);

        for (Score score : scores) {
            //System.out.println(score);
        }

        ArrayList<Student> students = new ArrayList<>();

        //读取学生表
        readStudent(students);

        for (Student student : students) {
            //System.out.println(student);
        }

        ArrayList<Cource> cources = new ArrayList<>();
        //读取科目表
        readCource(cources);

        for (Cource cource : cources) {
            System.out.println(cource);
        }



    }


    /**
     *读取分数表
     *
     * @param scores 存放分数的集合
     * @throws Exception
     */
    public static void readScore(ArrayList<Score> scores) throws Exception {
        //相对路径读取文件
        FileInputStream fileInputStream = new FileInputStream("data/score.txt");
        //字节流转字符流可以指定转换编码
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream,"utf-8"));
        String line ;
        while(( line = buffer.readLine()) !=null){
            //按照文件分隔符切分
            String [] strs =  line.split(",");
            Score score = new Score();
            score.setStudentId(strs[0]);
            score.setCourceId(strs[1]);
            //将字符串转int  nteger.parseInt
            score.setScore(Integer.parseInt(strs[2]));
            scores.add(score);
        }
    }

    /**
     *读取学生表
     *
     * @param students
     * @throws Exception
     */

    public static void readStudent(ArrayList<Student> students) throws Exception{
        //相对路径读取文件
        FileInputStream fileInputStream = new FileInputStream("data/students.txt");
        //字节流转字符流可以指定转换编码
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream,"utf-8"));
        String line ;
        while(( line = buffer.readLine()) !=null){
            //按照文件分隔符切分
            String [] strs =  line.split(",");
            Student student = new Student(strs[0],strs[1],Integer.parseInt(strs[2]),strs[3],strs[4]);
            students.add(student);
        }
    }


    public static void readCource(ArrayList<Cource> cources)throws Exception{
        //相对路径读取文件
        FileInputStream fileInputStream = new FileInputStream("data/Cource.txt");
        //字节流转字符流可以指定转换编码
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream,"utf-8"));
        String line ;
        while(( line = buffer.readLine()) !=null){
            //按照文件分隔符切分
            String [] strs =  line.split(",");

            Cource cource = new Cource(strs[0], strs[1], Integer.parseInt(strs[2]));

            cources.add(cource);
        }
    }
}
