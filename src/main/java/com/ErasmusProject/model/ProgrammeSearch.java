package com.ErasmusProject.model;

public class ProgrammeSearch {

	private String id;
	private String title;
	private String containsCourse;
	private String qualification;
	private String location;
	private Double cost;
	private Double credits;
	private Integer duration;
	private String language;
	private String prerequisite;
	
	public ProgrammeSearch(){
		this.id = "";
		this.title = "";
		this.containsCourse = "";
		this.qualification = "";
		this.location = "";
		this.cost = -1.0;
		this.credits = -1.0;
		this.duration = -1;
		this.language = "";
		this.prerequisite = "";
	}

	public ProgrammeSearch(String id, String title, String containsCourse, String qualification, String location,
			Double cost, Double credits, Integer duration, String language, String prerequisite) {
		super();
		this.id = id;
		this.title = title;
		this.containsCourse = containsCourse;
		this.qualification = qualification;
		this.location = location;
		this.cost = cost;
		this.credits = credits;
		this.duration = duration;
		this.language = language;
		this.prerequisite = prerequisite;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContainsCourse() {
		return containsCourse;
	}

	public void setContainsCourse(String containsCourse) {
		this.containsCourse = containsCourse;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getCredits() {
		return credits;
	}

	public void setCredits(Double credits) {
		this.credits = credits;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	@Override
	public String toString() {
		return "ProgrammeSearch [id=" + id + ", title=" + title + ", containsCourse=" + containsCourse
				+ ", qualification=" + qualification + ", location=" + location + ", cost=" + cost + ", credits="
				+ credits + ", duration=" + duration + ", language=" + language + ", prerequisite=" + prerequisite
				+ "]";
	}
}
