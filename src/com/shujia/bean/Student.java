package com.shujia.bean;


/**
 * 学生实体类
 */
public class Student {
	/**
 	* 学号
	*姓名
	*年龄
	*性别
	*班级
	*/
	
	private String id;
	private String name;
	private int age;
	private String gender;
	private String clazz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public Student(String id, String name, int age, String gender, String clazz) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", clazz='" + clazz + '\'' +
				'}';
	}
}
