package com.ErasmusProject.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Institution {

	private String identifier;
	private String institutionName;
	private String institutionStatus;
	private String institutionType;
	private String institutionAddress;
	private String url;
	

	public Institution(String identifier, String institutionName, String institutionStatus, String institutionType,
			String institutionAddress, String url) {
		super();
		this.identifier = identifier;
		this.institutionName = institutionName;
		this.institutionStatus = institutionStatus;
		this.institutionType = institutionType;
		this.institutionAddress = institutionAddress;
		this.url = url;
	}
	
	
	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getInstitutionName() {
		return institutionName;
	}


	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}


	public String getInstitutionStatus() {
		return institutionStatus;
	}


	public void setInstitutionStatus(String institutionStatus) {
		this.institutionStatus = institutionStatus;
	}


	public String getInstitutionType() {
		return institutionType;
	}


	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}


	public String getInstitutionAddress() {
		return institutionAddress;
	}


	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Institution [identifier=" + identifier + ", institutionName=" + institutionName + ", institutionStatus="
				+ institutionStatus + ", institutionType=" + institutionType + ", institutionAddress="
				+ institutionAddress + ", url=" + url + "]";
	}

	public String toJson(){
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String retVal = "";
		try {
			retVal =  ow.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
