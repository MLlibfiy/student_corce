package com.shujia.test;

public class TestFanx {

    public static void main(String[] args) {
        String asdsd = show("asdsd");

        System.out.println(asdsd);
    }


    /**
     * 泛型方法
     *
     * T的类型在方法被调用的时候确定
     */

    public static <T> T show(T t){
        return t;
    }
}
