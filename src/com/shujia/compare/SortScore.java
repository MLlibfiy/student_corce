package com.shujia.compare;

import java.util.Comparator;

public class SortScore implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int score1 = Integer.parseInt(o1.split("\t")[4]);
        int score2 = Integer.parseInt(o2.split("\t")[4]);
        //降序排序
        return score2-score1;
    }
}