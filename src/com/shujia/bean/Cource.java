package com.shujia.bean;

/**
 * 课程表
 * @author Teacher
 *
 */
public class Cource {
	private String id;
	private String name;
	private int score;
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

	public Cource() {
		super();
	}
	public Cource(String id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return id + "," + name + "," + score ;
	}
	
	

	
}
