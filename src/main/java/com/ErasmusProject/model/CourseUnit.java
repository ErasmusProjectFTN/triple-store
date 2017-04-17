package com.ErasmusProject.model;

public class CourseUnit {

	private String courseUnitCode;
	private String courseUnitTitle;
	private String courseUnitType;
	private String courseUnitLevel;
	private Double credit;
	private String url;
	
	private String courseUnitYearOfStudy;
	private String courseUnitContent;
	private String courseLocation;
	private String qualification;
	private String lecturer;
	private String languageOfInstruction;
	private String places;
	private String courseUnitTermPattern;
	private String courseUnitCompetence;
	private String courseUnitLearningOutcome;
	private String prerequisite;
	private String courseUnitRecommendedReading;
	private String courseUnitTeachingMethods;
	private String courseUnitAssessmentMethods;
	private String start;
	private Integer duration;
	private Double cost;
	
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
	
	
	public CourseUnit(String courseUnitCode, String courseUnitTitle, String courseUnitType, String courseUnitLevel,
			Double credit, String url, String courseUnitYearOfStudy, String courseUnitContent, String courseLocation,
			String qualification, String lecturer, String languageOfInstruction, String places,
			String courseUnitTermPattern, String courseUnitCompetence, String courseUnitLearningOutcome,
			String prerequisite, String courseUnitRecommendedReading, String courseUnitTeachingMethods,
			String courseUnitAssessmentMethods, String start, Integer duration, Double cost) {
		super();
		this.courseUnitCode = courseUnitCode;
		this.courseUnitTitle = courseUnitTitle;
		this.courseUnitType = courseUnitType;
		this.courseUnitLevel = courseUnitLevel;
		this.credit = credit;
		this.url = url;
		this.courseUnitYearOfStudy = courseUnitYearOfStudy;
		this.courseUnitContent = courseUnitContent;
		this.courseLocation = courseLocation;
		this.qualification = qualification;
		this.lecturer = lecturer;
		this.languageOfInstruction = languageOfInstruction;
		this.places = places;
		this.courseUnitTermPattern = courseUnitTermPattern;
		this.courseUnitCompetence = courseUnitCompetence;
		this.courseUnitLearningOutcome = courseUnitLearningOutcome;
		this.prerequisite = prerequisite;
		this.courseUnitRecommendedReading = courseUnitRecommendedReading;
		this.courseUnitTeachingMethods = courseUnitTeachingMethods;
		this.courseUnitAssessmentMethods = courseUnitAssessmentMethods;
		this.start = start;
		this.duration = duration;
		this.cost = cost;
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
	
	
	public String getCourseUnitYearOfStudy() {
		return courseUnitYearOfStudy;
	}


	public void setCourseUnitYearOfStudy(String courseUnitYearOfStudy) {
		this.courseUnitYearOfStudy = courseUnitYearOfStudy;
	}


	public String getCourseUnitContent() {
		return courseUnitContent;
	}


	public void setCourseUnitContent(String courseUnitContent) {
		this.courseUnitContent = courseUnitContent;
	}


	public String getCourseLocation() {
		return courseLocation;
	}


	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getLecturer() {
		return lecturer;
	}


	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}


	public String getLanguageOfInstruction() {
		return languageOfInstruction;
	}


	public void setLanguageOfInstruction(String languageOfInstruction) {
		this.languageOfInstruction = languageOfInstruction;
	}


	public String getPlaces() {
		return places;
	}


	public void setPlaces(String places) {
		this.places = places;
	}


	public String getCourseUnitTermPattern() {
		return courseUnitTermPattern;
	}


	public void setCourseUnitTermPattern(String courseUnitTermPattern) {
		this.courseUnitTermPattern = courseUnitTermPattern;
	}


	public String getCourseUnitCompetence() {
		return courseUnitCompetence;
	}


	public void setCourseUnitCompetence(String courseUnitCompetence) {
		this.courseUnitCompetence = courseUnitCompetence;
	}


	public String getCourseUnitLearningOutcome() {
		return courseUnitLearningOutcome;
	}


	public void setCourseUnitLearningOutcome(String courseUnitLearningOutcome) {
		this.courseUnitLearningOutcome = courseUnitLearningOutcome;
	}


	public String getPrerequisite() {
		return prerequisite;
	}


	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}


	public String getCourseUnitRecommendedReading() {
		return courseUnitRecommendedReading;
	}


	public void setCourseUnitRecommendedReading(String courseUnitRecommendedReading) {
		this.courseUnitRecommendedReading = courseUnitRecommendedReading;
	}


	public String getCourseUnitTeachingMethods() {
		return courseUnitTeachingMethods;
	}


	public void setCourseUnitTeachingMethods(String courseUnitTeachingMethods) {
		this.courseUnitTeachingMethods = courseUnitTeachingMethods;
	}


	public String getCourseUnitAssessmentMethods() {
		return courseUnitAssessmentMethods;
	}


	public void setCourseUnitAssessmentMethods(String courseUnitAssessmentMethods) {
		this.courseUnitAssessmentMethods = courseUnitAssessmentMethods;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "CourseUnit [courseUnitCode=" + courseUnitCode + ", courseUnitTitle=" + courseUnitTitle
				+ ", courseUnitType=" + courseUnitType + ", courseUnitLevel=" + courseUnitLevel + ", credit=" + credit
				+ ", url=" + url + ", courseUnitYearOfStudy=" + courseUnitYearOfStudy + ", courseUnitContent="
				+ courseUnitContent + ", courseLocation=" + courseLocation + ", qualification=" + qualification
				+ ", lecturer=" + lecturer + ", languageOfInstruction=" + languageOfInstruction + ", places=" + places
				+ ", courseUnitTermPattern=" + courseUnitTermPattern + ", courseUnitCompetence=" + courseUnitCompetence
				+ ", courseUnitLearningOutcome=" + courseUnitLearningOutcome + ", prerequisite=" + prerequisite
				+ ", courseUnitRecommendedReading=" + courseUnitRecommendedReading + ", courseUnitTeachingMethods="
				+ courseUnitTeachingMethods + ", courseUnitAssessmentMethods=" + courseUnitAssessmentMethods
				+ ", start=" + start + ", duration=" + duration + ", cost=" + cost + ", getCourseUnitCode()="
				+ getCourseUnitCode() + ", getCourseUnitTitle()=" + getCourseUnitTitle() + ", getCourseUnitType()="
				+ getCourseUnitType() + ", getCourseUnitLevel()=" + getCourseUnitLevel() + ", getCredit()="
				+ getCredit() + ", getUrl()=" + getUrl() + ", getCourseUnitYearOfStudy()=" + getCourseUnitYearOfStudy()
				+ ", getCourseUnitContent()=" + getCourseUnitContent() + ", getCourseLocation()=" + getCourseLocation()
				+ ", getQualification()=" + getQualification() + ", getLecturer()=" + getLecturer()
				+ ", getLanguageOfInstruction()=" + getLanguageOfInstruction() + ", getPlaces()=" + getPlaces()
				+ ", getCourseUnitTermPattern()=" + getCourseUnitTermPattern() + ", getCourseUnitCompetence()="
				+ getCourseUnitCompetence() + ", getCourseUnitLearningOutcome()=" + getCourseUnitLearningOutcome()
				+ ", getPrerequisite()=" + getPrerequisite() + ", getCourseUnitRecommendedReading()="
				+ getCourseUnitRecommendedReading() + ", getCourseUnitTeachingMethods()="
				+ getCourseUnitTeachingMethods() + ", getCourseUnitAssessmentMethods()="
				+ getCourseUnitAssessmentMethods() + ", getStart()=" + getStart() + ", getDuration()=" + getDuration()
				+ ", getCost()=" + getCost() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
