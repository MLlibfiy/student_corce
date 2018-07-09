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
        //读取分数表
        ArrayList<Score> scores = readScore();

        for (Score score : scores) {
            //System.out.println(score);
        }
        //读取学生表
        ArrayList<Student> students  = readStudent();

        for (Student student : students) {
            //System.out.println(student);
        }

        //读取科目表
        ArrayList<Cource> cources = readCource();

        for (Cource cource : cources) {
            System.out.println(cource);
        }
    }

    /**
     *读取分数表
     *
     * @throws Exception
     */
    public static  ArrayList<Score> readScore() throws Exception {
        ArrayList<Score> scores = new ArrayList<>();
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
        return scores;
    }

    /**
     *读取学生表
     *
     * @throws Exception
     */

    public static  ArrayList<Student> readStudent() throws Exception{
        ArrayList<Student> students = new ArrayList<>();
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
        return students;
    }


    public static  ArrayList<Cource> readCource()throws Exception{
        ArrayList<Cource> cources = new ArrayList<>();
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
        return cources;
    }
}
