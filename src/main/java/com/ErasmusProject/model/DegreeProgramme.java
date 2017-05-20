package com.ErasmusProject.model;

/**
 * 
 * @author Nina
 *
 */

public class DegreeProgramme {
	
	private String degreeUnitCode;
	private String degreeProgrammeTitle;
	private String information;
	private String language;
	private String location;
	private String qualification;
	private Double credit;
	private String url;
	
	private String prerequisite;
	private String departmentalECTScoordinator;
	private String degreeProgrammeFinalExamination;
	private String places;
	private String degreeProgrammeExaminationAndAssessmentRegulations;
	private String start;
	private Integer duration;
	private String cost;
	private String degreeProgrammeAccessToFurtherStudies;
	private String degreeProgrammeEducationalAndProfessionalGoals;
	private String degreeProgrammeStructureDiagram;
	
	private String recommendationCode1;
	private String recommendationCode2;
	private String recommendationCode3;
	
	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String information, String language,
			String location, String qualification, Double credit, String url, String prerequisite,
			String departmentalECTScoordinator, String degreeProgrammeFinalExamination, String places,
			String degreeProgrammeExaminationAndAssessmentRegulations, String start, Integer duration, String cost,
			String degreeProgrammeAccessToFurtherStudies, String degreeProgrammeEducationalAndProfessionalGoals,
			String degreeProgrammeStructureDiagram, String recommendationCode1, String recommendationCode2,
			String recommendationCode3) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
		this.information = information;
		this.language = language;
		this.location = location;
		this.qualification = qualification;
		this.credit = credit;
		this.url = url;
		this.prerequisite = prerequisite;
		this.departmentalECTScoordinator = departmentalECTScoordinator;
		this.degreeProgrammeFinalExamination = degreeProgrammeFinalExamination;
		this.places = places;
		this.degreeProgrammeExaminationAndAssessmentRegulations = degreeProgrammeExaminationAndAssessmentRegulations;
		this.start = start;
		this.duration = duration;
		this.cost = cost;
		this.degreeProgrammeAccessToFurtherStudies = degreeProgrammeAccessToFurtherStudies;
		this.degreeProgrammeEducationalAndProfessionalGoals = degreeProgrammeEducationalAndProfessionalGoals;
		this.degreeProgrammeStructureDiagram = degreeProgrammeStructureDiagram;
		this.recommendationCode1 = recommendationCode1;
		this.recommendationCode2 = recommendationCode2;
		this.recommendationCode3 = recommendationCode3;
	}

	public String getDegreeProgrammeEducationalAndProfessionalGoals() {
		return degreeProgrammeEducationalAndProfessionalGoals;
	}

	public void setDegreeProgrammeEducationalAndProfessionalGoals(String degreeProgrammeEducationalAndProfessionalGoals) {
		this.degreeProgrammeEducationalAndProfessionalGoals = degreeProgrammeEducationalAndProfessionalGoals;
	}

	public String getRecommendationCode1() {
		return recommendationCode1;
	}

	public void setRecommendationCode1(String recommendationCode1) {
		this.recommendationCode1 = recommendationCode1;
	}

	public String getRecommendationCode2() {
		return recommendationCode2;
	}

	public void setRecommendationCode2(String recommendationCode2) {
		this.recommendationCode2 = recommendationCode2;
	}

	public String getRecommendationCode3() {
		return recommendationCode3;
	}

	public void setRecommendationCode3(String recommendationCode3) {
		this.recommendationCode3 = recommendationCode3;
	}

	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String information, String language, String location,
			String qualification, Double credit, String url) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
		this.setInformation(information);
		this.language = language;
		this.location = location;
		this.qualification = qualification;
		this.credit = credit;
		this.url = url;
	}

	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String information, String language, String location,
			String qualification, Double credit, String url, String prerequisite, String departmentalECTScoordinator,
			String degreeProgrammeFinalExamination, String places,
			String degreeProgrammeExaminationAndAssessmentRegulations, String start, Integer duration, String cost,
			String degreeProgrammeAccessToFurtherStudies, String degreeProgrammeEducationalAndProfessionalGoals,
			String degreeProgrammeStructureDiagram) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
		this.setInformation(information);
		this.language = language;
		this.location = location;
		this.qualification = qualification;
		this.credit = credit;
		this.url = url;
		this.prerequisite = prerequisite;
		this.departmentalECTScoordinator = departmentalECTScoordinator;
		this.degreeProgrammeFinalExamination = degreeProgrammeFinalExamination;
		this.places = places;
		this.degreeProgrammeExaminationAndAssessmentRegulations = degreeProgrammeExaminationAndAssessmentRegulations;
		this.start = start;
		this.duration = duration;
		this.cost = cost;
		this.degreeProgrammeAccessToFurtherStudies = degreeProgrammeAccessToFurtherStudies;
		this.degreeProgrammeEducationalAndProfessionalGoals = degreeProgrammeEducationalAndProfessionalGoals;
		this.degreeProgrammeStructureDiagram = degreeProgrammeStructureDiagram;
	}



	public String getDegreeUnitCode() {
		return degreeUnitCode;
	}


	public void setDegreeUnitCode(String degreeUnitCode) {
		this.degreeUnitCode = degreeUnitCode;
	}


	public String getDegreeProgrammeTitle() {
		return degreeProgrammeTitle;
	}


	public void setDegreeProgrammeTitle(String degreeProgrammeTitle) {
		this.degreeProgrammeTitle = degreeProgrammeTitle;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public String getDepartmentalECTScoordinator() {
		return departmentalECTScoordinator;
	}

	public void setDepartmentalECTScoordinator(String departmentalECTScoordinator) {
		this.departmentalECTScoordinator = departmentalECTScoordinator;
	}

	public String getDegreeProgrammeFinalExamination() {
		return degreeProgrammeFinalExamination;
	}

	public void setDegreeProgrammeFinalExamination(String degreeProgrammeFinalExamination) {
		this.degreeProgrammeFinalExamination = degreeProgrammeFinalExamination;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	public String getDegreeProgrammeExaminationAndAssessmentRegulations() {
		return degreeProgrammeExaminationAndAssessmentRegulations;
	}

	public void setDegreeProgrammeExaminationAndAssessmentRegulations(
			String degreeProgrammeExaminationAndAssessmentRegulations) {
		this.degreeProgrammeExaminationAndAssessmentRegulations = degreeProgrammeExaminationAndAssessmentRegulations;
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDegreeProgrammeAccessToFurtherStudies() {
		return degreeProgrammeAccessToFurtherStudies;
	}

	public void setDegreeProgrammeAccessToFurtherStudies(String degreeProgrammeAccessToFurtherStudies) {
		this.degreeProgrammeAccessToFurtherStudies = degreeProgrammeAccessToFurtherStudies;
	}

	public String getDegreeProgrammeEducationalAndProessionalGoals() {
		return degreeProgrammeEducationalAndProfessionalGoals;
	}

	public void setDegreeProgrammeEducationalAndProessionalGoals(String degreeProgrammeEducationalAndProessionalGoals) {
		this.degreeProgrammeEducationalAndProfessionalGoals = degreeProgrammeEducationalAndProessionalGoals;
	}

	public String getDegreeProgrammeStructureDiagram() {
		return degreeProgrammeStructureDiagram;
	}

	public void setDegreeProgrammeStructureDiagram(String degreeProgrammeStructureDiagram) {
		this.degreeProgrammeStructureDiagram = degreeProgrammeStructureDiagram;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "DegreeProgramme [degreeUnitCode=" + degreeUnitCode + ", degreeProgrammeTitle=" + degreeProgrammeTitle
				+ ", information=" + information + ", language=" + language + ", location=" + location
				+ ", qualification=" + qualification + ", credit=" + credit + ", url=" + url + ", prerequisite="
				+ prerequisite + ", departmentalECTScoordinator=" + departmentalECTScoordinator
				+ ", degreeProgrammeFinalExamination=" + degreeProgrammeFinalExamination + ", places=" + places
				+ ", degreeProgrammeExaminationAndAssessmentRegulations="
				+ degreeProgrammeExaminationAndAssessmentRegulations + ", start=" + start + ", duration=" + duration
				+ ", cost=" + cost + ", degreeProgrammeAccessToFurtherStudies=" + degreeProgrammeAccessToFurtherStudies
				+ ", degreeProgrammeEducationalAndProfessionalGoals=" + degreeProgrammeEducationalAndProfessionalGoals
				+ ", degreeProgrammeStructureDiagram=" + degreeProgrammeStructureDiagram + ", recommendationCode1="
				+ recommendationCode1 + ", recommendationCode2=" + recommendationCode2 + ", recommendationCode3="
				+ recommendationCode3 + "]";
	}
}
