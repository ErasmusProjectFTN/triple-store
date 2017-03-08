package com.ErasmusProject.util;

public class ResponseProgrammeSpecification {

	private String degreeUnitCode;
	private String degreeProgrammeTitle;
	
	public ResponseProgrammeSpecification(String degreeUnitCode, String degreeProgrammeTitle) {
		super();
		this.degreeUnitCode = degreeUnitCode;
		this.degreeProgrammeTitle = degreeProgrammeTitle;
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
}
