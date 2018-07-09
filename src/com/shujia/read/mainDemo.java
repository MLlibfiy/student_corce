package com.shujia.read;

import com.shujia.bean.Cource;
import com.shujia.bean.Score;
import com.shujia.bean.Student;
import com.shujia.util.ReadUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、将数据读取到程序，用集合存起来
 *
 *
 */
public class mainDemo {
    public static void main(String[] args) throws Exception {
        List<Score> scores = ReadUtil.readData("data/score.txt", Score.class);

        for (Score score : scores) {
            //System.out.println(score);
        }
        List<Student> students = ReadUtil.readData("data/students.txt", Student.class);
        for (Student student : students) {
            //System.out.println(student);
        }
        List<Cource> cources = ReadUtil.readData("data/Cource.txt", Cource.class);
        for (Cource cource : cources) {
            System.out.println(cource);
        }
        
    }


}
