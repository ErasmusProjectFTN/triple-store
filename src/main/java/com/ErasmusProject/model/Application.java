package com.ErasmusProject.model;

public class Application {

	private Student student;
	private DegreeProgramme degree;
	private String status;
	private String id;
	
	
	public Application(Student student, DegreeProgramme degree, String status, String id) {
		super();
		this.student = student;
		this.degree = degree;
		this.status = status;
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public DegreeProgramme getDegree() {
		return degree;
	}


	public void setDegree(DegreeProgramme degree) {
		this.degree = degree;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
}
