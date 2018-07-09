package com.shujia.bean;

/**
 * 成绩表
 * @author Teacher
 *
 */
public class Score {
	private String studentId;
	private String courceId ;
	private int score ;

	public Score(String studentId, String courceId, int score) {
		this.studentId = studentId;
		this.courceId = courceId;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score{" +
				"studentId='" + studentId + '\'' +
				", courceId='" + courceId + '\'' +
				", score=" + score +
				'}';
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourceId() {
		return courceId;
	}

	public void setCourceId(String courceId) {
		this.courceId = courceId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Score() {
	}
}
