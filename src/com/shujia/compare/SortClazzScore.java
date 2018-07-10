package com.shujia.compare;

import java.util.Comparator;


/**
 *班级排名时用的的排名规则
 *
 */
public class SortClazzScore implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int score1 = Integer.parseInt(o1.split("\t")[2]);
        int score2 = Integer.parseInt(o2.split("\t")[2]);
        //降序排序
        return score2-score1;
    }
}