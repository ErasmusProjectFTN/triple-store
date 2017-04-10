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
	private String institutionalECTScoordinator;
	private String mainUniversityRegulations;
	private String institutionGeneralDescription;
	private String institutionAcademicAuthorities;
	private String institutionAcademicCalendar;
	private String institutionAdmissionProcedures;
	private String generalInformationForStudents;
	private String generalInformationForMobileStudetns;
	private String generalInformationOnAccommodation;
	private String generalInformationOnCostOfLiving;
	private String generalInformationOnExtramuralAndLeisureFacilities;
	private String generalInformationOnFacilitiesForStudentsWithSpecialNeeds;
	private String generalInformationOnFinancialSupport;
	private String generalInformationOnInsturance;
	private String generalInformationOnInternationalProgrammes;
	private String generalInformationOnInternships;
	private String generalInformationonLanguageCourses;
	private String generalInformationOnMeals;
	private String generalInformationOnMedicalFacilities;
	private String generalInformationOnSportsFacilities;
	private String generalInformationOnStudentAffairsOffice;
	private String generalInformationOnStudentAssociations;
	private String generalInformationOnStudyFacilities;
	
	
	

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




	public Institution(String identifier, String institutionName, String institutionStatus, String institutionType,
			String institutionAddress, String url, String institutionalECTScoordinator,
			String mainUniversityRegulations, String institutionGeneralDescription,
			String institutionAcademicAuthorities, String institutionacademicCalendar,
			String institutionAdmissionProcedures, String generalInformationForStudents,
			String generalInformationForMobileStudetns, String generalInformationOnAccommodation,
			String generalInformationOnCostOfLiving, String generalInformationOnExtramuralAndLeisureFacilities,
			String generalInformationOnFacilitiesForStudentsWithSpecialNeeds,
			String generalInformationOnFinancialSupport, String generalInformationOnInsturance,
			String generalInformationOnInternationalProgrammes, String generalInformationOnInternships,
			String generalInformationonLanguageCourses, String generalInformationOnMeals,
			String generalInformationOnMedicalFacilities, String generalInformationOnSportsFacilities,
			String generalInformationOnStudentAffairsOffice, String generalInformationOnStudentAssociations,
			String generalInformationOnStudyFacilities) {
		super();
		this.identifier = identifier;
		this.institutionName = institutionName;
		this.institutionStatus = institutionStatus;
		this.institutionType = institutionType;
		this.institutionAddress = institutionAddress;
		this.url = url;
		this.institutionalECTScoordinator = institutionalECTScoordinator;
		this.mainUniversityRegulations = mainUniversityRegulations;
		this.institutionGeneralDescription = institutionGeneralDescription;
		this.institutionAcademicAuthorities = institutionAcademicAuthorities;
		this.institutionAcademicCalendar = institutionacademicCalendar;
		this.institutionAdmissionProcedures = institutionAdmissionProcedures;
		this.generalInformationForStudents = generalInformationForStudents;
		this.generalInformationForMobileStudetns = generalInformationForMobileStudetns;
		this.generalInformationOnAccommodation = generalInformationOnAccommodation;
		this.generalInformationOnCostOfLiving = generalInformationOnCostOfLiving;
		this.generalInformationOnExtramuralAndLeisureFacilities = generalInformationOnExtramuralAndLeisureFacilities;
		this.generalInformationOnFacilitiesForStudentsWithSpecialNeeds = generalInformationOnFacilitiesForStudentsWithSpecialNeeds;
		this.generalInformationOnFinancialSupport = generalInformationOnFinancialSupport;
		this.generalInformationOnInsturance = generalInformationOnInsturance;
		this.generalInformationOnInternationalProgrammes = generalInformationOnInternationalProgrammes;
		this.generalInformationOnInternships = generalInformationOnInternships;
		this.generalInformationonLanguageCourses = generalInformationonLanguageCourses;
		this.generalInformationOnMeals = generalInformationOnMeals;
		this.generalInformationOnMedicalFacilities = generalInformationOnMedicalFacilities;
		this.generalInformationOnSportsFacilities = generalInformationOnSportsFacilities;
		this.generalInformationOnStudentAffairsOffice = generalInformationOnStudentAffairsOffice;
		this.generalInformationOnStudentAssociations = generalInformationOnStudentAssociations;
		this.generalInformationOnStudyFacilities = generalInformationOnStudyFacilities;
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




	public String getInstitutionalECTScoordinator() {
		return institutionalECTScoordinator;
	}




	public void setInstitutionalECTScoordinator(String institutionalECTScoordinator) {
		this.institutionalECTScoordinator = institutionalECTScoordinator;
	}




	public String getMainUniversityRegulations() {
		return mainUniversityRegulations;
	}




	public void setMainUniversityRegulations(String mainUniversityRegulations) {
		this.mainUniversityRegulations = mainUniversityRegulations;
	}




	public String getInstitutionGeneralDescription() {
		return institutionGeneralDescription;
	}




	public void setInstitutionGeneralDescription(String institutionGeneralDescription) {
		this.institutionGeneralDescription = institutionGeneralDescription;
	}




	public String getInstitutionAcademicAuthorities() {
		return institutionAcademicAuthorities;
	}




	public void setInstitutionAcademicAuthorities(String institutionAcademicAuthorities) {
		this.institutionAcademicAuthorities = institutionAcademicAuthorities;
	}




	public String getInstitutionacademicCalendar() {
		return institutionAcademicCalendar;
	}




	public void setInstitutionacademicCalendar(String institutionacademicCalendar) {
		this.institutionAcademicCalendar = institutionacademicCalendar;
	}




	public String getInstitutionAdmissionProcedures() {
		return institutionAdmissionProcedures;
	}




	public void setInstitutionAdmissionProcedures(String institutionAdmissionProcedures) {
		this.institutionAdmissionProcedures = institutionAdmissionProcedures;
	}




	public String getGeneralInformationForStudents() {
		return generalInformationForStudents;
	}




	public void setGeneralInformationForStudents(String generalInformationForStudents) {
		this.generalInformationForStudents = generalInformationForStudents;
	}




	public String getGeneralInformationForMobileStudetns() {
		return generalInformationForMobileStudetns;
	}




	public void setGeneralInformationForMobileStudetns(String generalInformationForMobileStudetns) {
		this.generalInformationForMobileStudetns = generalInformationForMobileStudetns;
	}




	public String getGeneralInformationOnAccommodation() {
		return generalInformationOnAccommodation;
	}




	public void setGeneralInformationOnAccommodation(String generalInformationOnAccommodation) {
		this.generalInformationOnAccommodation = generalInformationOnAccommodation;
	}




	public String getGeneralInformationOnCostOfLiving() {
		return generalInformationOnCostOfLiving;
	}




	public void setGeneralInformationOnCostOfLiving(String generalInformationOnCostOfLiving) {
		this.generalInformationOnCostOfLiving = generalInformationOnCostOfLiving;
	}




	public String getGeneralInformationOnExtramuralAndLeisureFacilities() {
		return generalInformationOnExtramuralAndLeisureFacilities;
	}




	public void setGeneralInformationOnExtramuralAndLeisureFacilities(
			String generalInformationOnExtramuralAndLeisureFacilities) {
		this.generalInformationOnExtramuralAndLeisureFacilities = generalInformationOnExtramuralAndLeisureFacilities;
	}




	public String getGeneralInformationOnFacilitiesForStudentsWithSpecialNeeds() {
		return generalInformationOnFacilitiesForStudentsWithSpecialNeeds;
	}




	public void setGeneralInformationOnFacilitiesForStudentsWithSpecialNeeds(
			String generalInformationOnFacilitiesForStudentsWithSpecialNeeds) {
		this.generalInformationOnFacilitiesForStudentsWithSpecialNeeds = generalInformationOnFacilitiesForStudentsWithSpecialNeeds;
	}




	public String getGeneralInformationOnFinancialSupport() {
		return generalInformationOnFinancialSupport;
	}




	public void setGeneralInformationOnFinancialSupport(String generalInformationOnFinancialSupport) {
		this.generalInformationOnFinancialSupport = generalInformationOnFinancialSupport;
	}




	public String getGeneralInformationOnInsturance() {
		return generalInformationOnInsturance;
	}




	public void setGeneralInformationOnInsturance(String generalInformationOnInsturance) {
		this.generalInformationOnInsturance = generalInformationOnInsturance;
	}




	public String getGeneralInformationOnInternationalProgrammes() {
		return generalInformationOnInternationalProgrammes;
	}




	public void setGeneralInformationOnInternationalProgrammes(String generalInformationOnInternationalProgrammes) {
		this.generalInformationOnInternationalProgrammes = generalInformationOnInternationalProgrammes;
	}




	public String getGeneralInformationOnInternships() {
		return generalInformationOnInternships;
	}




	public void setGeneralInformationOnInternships(String generalInformationOnInternships) {
		this.generalInformationOnInternships = generalInformationOnInternships;
	}




	public String getGeneralInformationonLanguageCourses() {
		return generalInformationonLanguageCourses;
	}




	public void setGeneralInformationonLanguageCourses(String generalInformationonLanguageCourses) {
		this.generalInformationonLanguageCourses = generalInformationonLanguageCourses;
	}




	public String getGeneralInformationOnMeals() {
		return generalInformationOnMeals;
	}




	public void setGeneralInformationOnMeals(String generalInformationOnMeals) {
		this.generalInformationOnMeals = generalInformationOnMeals;
	}




	public String getGeneralInformationOnMedicalFacilities() {
		return generalInformationOnMedicalFacilities;
	}




	public void setGeneralInformationOnMedicalFacilities(String generalInformationOnMedicalFacilities) {
		this.generalInformationOnMedicalFacilities = generalInformationOnMedicalFacilities;
	}




	public String getGeneralInformationOnSportsFacilities() {
		return generalInformationOnSportsFacilities;
	}




	public void setGeneralInformationOnSportsFacilities(String generalInformationOnSportsFacilities) {
		this.generalInformationOnSportsFacilities = generalInformationOnSportsFacilities;
	}




	public String getGeneralInformationOnStudentAffairsOffice() {
		return generalInformationOnStudentAffairsOffice;
	}




	public void setGeneralInformationOnStudentAffairsOffice(String generalInformationOnStudentAffairsOffice) {
		this.generalInformationOnStudentAffairsOffice = generalInformationOnStudentAffairsOffice;
	}




	public String getGeneralInformationOnStudentAssociations() {
		return generalInformationOnStudentAssociations;
	}




	public void setGeneralInformationOnStudentAssociations(String generalInformationOnStudentAssociations) {
		this.generalInformationOnStudentAssociations = generalInformationOnStudentAssociations;
	}




	public String getGeneralInformationOnStudyFacilities() {
		return generalInformationOnStudyFacilities;
	}




	public void setGeneralInformationOnStudyFacilities(String generalInformationOnStudyFacilities) {
		this.generalInformationOnStudyFacilities = generalInformationOnStudyFacilities;
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
