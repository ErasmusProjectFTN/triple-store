package com.ErasmusProject.model;

public class CourseUnit {

	private String courseUnitCode;
	private String courseUnitTitle;
	private String courseUnitType;
	private String courseUnitLevel;
	private Double credit;
	private String url;
	
	public CourseUnit(String courseUnitCode, String courseUnitTitle, String courseUnitType, String courseUnitLevel,
			Double credit, String url) {
		super();
		this.courseUnitCode = courseUnitCode;
		this.courseUnitTitle = courseUnitTitle;
		this.courseUnitType = courseUnitType;
		this.courseUnitLevel = courseUnitLevel;
		this.credit = credit;
		this.url = url;
	}
	public String getCourseUnitCode() {
		return courseUnitCode;
	}
	public void setCourseUnitCode(String courseUnitCode) {
		this.courseUnitCode = courseUnitCode;
	}
	public String getCourseUnitTitle() {
		return courseUnitTitle;
	}
	public void setCourseUnitTitle(String courseUnitTitle) {
		this.courseUnitTitle = courseUnitTitle;
	}
	public String getCourseUnitType() {
		return courseUnitType;
	}
	public void setCourseUnitType(String courseUnitType) {
		this.courseUnitType = courseUnitType;
	}
	public String getCourseUnitLevel() {
		return courseUnitLevel;
	}
	public void setCourseUnitLevel(String courseUnitLevel) {
		this.courseUnitLevel = courseUnitLevel;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "CourseUnit [courseUnitCode=" + courseUnitCode + ", courseUnitTitle=" + courseUnitTitle
				+ ", courseUnitType=" + courseUnitType + ", courseUnitLevel=" + courseUnitLevel + ", credit=" + credit
				+ ", url=" + url + "]";
	}
}
