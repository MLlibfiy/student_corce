package com.shujia.read;

import com.shujia.bean.Score;
import com.shujia.bean.Student;
import com.shujia.util.ReadUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Base提取公共的部分
 */
public class Base {

    //定义私有变量
    static List<Score> scores = null;
    static List<Student> students = null;

    static {
        //在静态代码块里面不能抛出异常
        try {
            scores = ReadUtil.readData("data/score.txt", Score.class);
            students = ReadUtil.readData("data/students.txt", Student.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算学生总分
     */
    public HashMap<String, Integer> comSumScore() {

        /**
         * 1、计算学生总分
         *
         */

        //创建一个hashmap学号对应总分
        HashMap<String, Integer> hashMap = new HashMap<>();

        //循环分数表，对每个人的分数累加
        for (Score score : scores) {
            Integer integer = hashMap.get(score.getStudentId());
            if (integer == null) {
                hashMap.put(score.getStudentId(), score.getScore());
            } else {
                //相同的key后面put会覆盖前面的
                hashMap.put(score.getStudentId(), integer + score.getScore());
            }
        }

        return hashMap;
    }

}
