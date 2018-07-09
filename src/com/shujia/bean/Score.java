package com.shujia.bean;

/**
 * 成绩表
 * @author Teacher
 *
 */
public class Score {
	private String dtudentId;
	private String courceId ;
	private int score ;
	public String getDtudentId() {
		return dtudentId;
	}
	public void setDtudentId(String dtudentId) {
		this.dtudentId = dtudentId;
	}
	public String getCourceId() {
		return courceId;
	}
	public void setCourceId(String courceId) {
		this.courceId = courceId;
	}

	

	@Override
	public String toString() {
		return  dtudentId + "," + courceId+ "," + score ;
	}
	public Score(String dtudentId, String courceId, int score) {
		super();
		this.dtudentId = dtudentId;
		this.courceId = courceId;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Score() {
		super();
	}
	
	
}
