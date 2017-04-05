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
	private Integer credit;
	private String url;
	
	
	public DegreeProgramme(String degreeUnitCode, String degreeProgrammeTitle, String language, String location,
			String qualification, Integer credit, String url) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
		this.language = language;
		this.location = location;
		this.qualification = qualification;
		this.credit = credit;
		this.url = url;
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


	public Integer getCredit() {
		return credit;
	}


	public void setCredit(Integer credit) {
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
		return "DegreeProgramme [degreeUnitCode=" + degreeUnitCode + ", degreeProgrammeTitle=" + degreeProgrammeTitle
				+ ", language=" + language + ", location=" + location + ", qualification=" + qualification + ", credit="
				+ credit + ", url=" + url + "]";
	}
	
}
