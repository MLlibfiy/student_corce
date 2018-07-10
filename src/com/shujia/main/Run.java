package com.shujia.main;

import com.shujia.read.ClazzSort;
import com.shujia.read.GradeSort;

public class Run {
    public static void main(String[] args) throws Exception {
        //结算年级排名
        new GradeSort().gradeSort();
        new ClazzSort().clazzSort();
    }
}
