package com.ErasmusProject.model;

/**
 * 
 * @author Nina
 *
 */

public class DegreeProgramme {
	
	private String degreeUnitCode;
	private String degreeProgrammeTitle;
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
	private String duration;
	private String cost;
	private String degreeProgrammeAccessToFurtherStudies;
	private String degreeProgrammeEducationalAndProessionalGoals;
	private String degreeProgrammeStructureDiagram;
	
	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String language, String location,
			String qualification, Double credit, String url) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
		this.language = language;
		this.location = location;
		this.qualification = qualification;
		this.credit = credit;
		this.url = url;
	}

	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String language, String location,
			String qualification, Double credit, String url, String prerequisite, String departmentalECTScoordinator,
			String degreeProgrammeFinalExamination, String places,
			String degreeProgrammeExaminationAndAssessmentRegulations, String start, String duration, String cost,
			String degreeProgrammeAccessToFurtherStudies, String degreeProgrammeEducationalAndProessionalGoals,
			String degreeProgrammeStructureDiagram) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
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
		this.degreeProgrammeEducationalAndProessionalGoals = degreeProgrammeEducationalAndProessionalGoals;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
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
		return degreeProgrammeEducationalAndProessionalGoals;
	}

	public void setDegreeProgrammeEducationalAndProessionalGoals(String degreeProgrammeEducationalAndProessionalGoals) {
		this.degreeProgrammeEducationalAndProessionalGoals = degreeProgrammeEducationalAndProessionalGoals;
	}

	public String getDegreeProgrammeStructureDiagram() {
		return degreeProgrammeStructureDiagram;
	}

	public void setDegreeProgrammeStructureDiagram(String degreeProgrammeStructureDiagram) {
		this.degreeProgrammeStructureDiagram = degreeProgrammeStructureDiagram;
	}

	@Override
	public String toString() {
		return "DegreeProgramme [degreeUnitCode=" + degreeUnitCode + ", degreeProgrammeTitle=" + degreeProgrammeTitle
				+ ", language=" + language + ", location=" + location + ", qualification=" + qualification + ", credit="
				+ credit + ", url=" + url + ", prerequisite=" + prerequisite + ", departmentalECTScoordinator="
				+ departmentalECTScoordinator + ", degreeProgrammeFinalExamination=" + degreeProgrammeFinalExamination
				+ ", places=" + places + ", degreeProgrammeExaminationAndAssessmentRegulations="
				+ degreeProgrammeExaminationAndAssessmentRegulations + ", start=" + start + ", duration=" + duration
				+ ", cost=" + cost + ", degreeProgrammeAccessToFurtherStudies=" + degreeProgrammeAccessToFurtherStudies
				+ ", degreeProgrammeEducationalAndProessionalGoals=" + degreeProgrammeEducationalAndProessionalGoals
				+ ", degreeProgrammeStructureDiagram=" + degreeProgrammeStructureDiagram + ", getDegreeUnitCode()="
				+ getDegreeUnitCode() + ", getDegreeProgrammeTitle()=" + getDegreeProgrammeTitle() + ", getLanguage()="
				+ getLanguage() + ", getLocation()=" + getLocation() + ", getQualification()=" + getQualification()
				+ ", getCredit()=" + getCredit() + ", getUrl()=" + getUrl() + ", getPrerequisite()=" + getPrerequisite()
				+ ", getDepartmentalECTScoordinator()=" + getDepartmentalECTScoordinator()
				+ ", getDegreeProgrammeFinalExamination()=" + getDegreeProgrammeFinalExamination() + ", getPlaces()="
				+ getPlaces() + ", getDegreeProgrammeExaminationAndAssessmentRegulations()="
				+ getDegreeProgrammeExaminationAndAssessmentRegulations() + ", getStart()=" + getStart()
				+ ", getDuration()=" + getDuration() + ", getCost()=" + getCost()
				+ ", getDegreeProgrammeAccessToFurtherStudies()=" + getDegreeProgrammeAccessToFurtherStudies()
				+ ", getDegreeProgrammeEducationalAndProessionalGoals()="
				+ getDegreeProgrammeEducationalAndProessionalGoals() + ", getDegreeProgrammeStructureDiagram()="
				+ getDegreeProgrammeStructureDiagram() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
