package com.shujia.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * 自定义文件读取工具
 *
 * 注意:保证自定义对象属性的顺序和文件列的顺序一样
 *
 */
public class ReadUtil {

    /**
     *  读取数据方法
     * @param filName  文件路径
     * @param clazz  返回集合泛型的类型
     * @param <T> 泛型方法
     * @return
     * @throws Exception
     */
    public static <T> List<T> readData(String filName, Class<T> clazz) throws Exception {
        //创建一个集合存放对象
        ArrayList<T> lists = new ArrayList<>();
        //相对路径读取文件
        FileInputStream fileInputStream = new FileInputStream(filName);
        //字节流转字符流可以指定转换编码
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
        String line;
        while ((line = buffer.readLine()) != null) {
            String strs[] = line.split(",");
            //创建clszz类对象的对象
            //调用无参构造函数创建对象
            //clazz.getConstructor().newInstance()  都可以
            T t = clazz.newInstance();
            //给对象的属性赋值,调用Set方法
            //获取到传进来的clazz对象的所有属性
            Field[] fields = clazz.getDeclaredFields();
            //保证自定义对象属性的顺序和文件列的顺序一样
            for (int i = 0; i < fields.length; i++) {
                //属性名
                String fieldName = fields[i].getName();
                //获取属性的类型
                Class type = fields[i].getType();
                //拼接set方法,比如setName()
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                //更具方法的名称和参数类型获取方法对象
                Method method = clazz.getDeclaredMethod(methodName, type);
                //当属性是int的时候强制转换成int
                if (type == int.class) {
                    method.invoke(t, Integer.parseInt(strs[i]));
                } else {
                    method.invoke(t, strs[i]);
                }
            }
            lists.add(t);
        }
        return lists;
    }
}