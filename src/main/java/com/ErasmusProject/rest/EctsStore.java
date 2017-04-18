package com.ErasmusProject.rest;

import com.ErasmusProject.model.CourseSearch;
import com.ErasmusProject.model.CourseUnit;
import com.ErasmusProject.model.DegreeProgramme;
import com.ErasmusProject.model.Institution;
import com.ErasmusProject.model.InstitutionSearch;
import com.ErasmusProject.model.ProgrammeSearch;
import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.QueryResult;
import com.ErasmusProject.util.QueryType;
import com.ErasmusProject.util.ResponseCourseSpecification;
import com.ErasmusProject.util.ResponseInstitution;
import com.ErasmusProject.util.ResponseProgrammeSpecification;
import com.ErasmusProject.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Komp on 21.2.2017.
 */
/**
 * 
 * @author Nina
 *
 */
@RestController
@RequestMapping("/ects")
public class EctsStore {


	/*
	 * Add institution
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addInstitution")
	public ResponseInstitution addInstitution(@RequestParam(value="identifier", required=true) String identifier,
			@RequestParam(value="institutionName", required=true) String institutionName,
			@RequestParam(value="institutionalECTScoordinator", required=false, defaultValue="") String institutionalECTScoordinator,
			@RequestParam(value="institutionStatus", required=false, defaultValue="") String institutionStatus,
			@RequestParam(value="institutionType", required=false, defaultValue="") String institutionType,
			@RequestParam(value="institutionAddress", required=false, defaultValue="") String institutionAddress,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="institutionMainUniversityRegulations", required=false, defaultValue="") String institutionMainUniversityRegulations,
			@RequestParam(value="institutionGeneralDescription", required=false, defaultValue="") String institutionGeneralDescription,
			@RequestParam(value="institutionAcademicAuthorities", required=false, defaultValue="") String institutionAcademicAuthorities,
			@RequestParam(value="institutionAcademicCalendar", required=false, defaultValue="") String institutionAcademicCalendar,
			@RequestParam(value="institutionAdmissionProcedures", required=false, defaultValue="") String institutionAdmissionProcedures,
			@RequestParam(value="generalInformationForStudents", required=false, defaultValue="") String generalInformationForStudents,
			@RequestParam(value="generalInformationForMobileStudents", required=false, defaultValue="") String generalInformationForMobileStudents,
			@RequestParam(value="generalInformationOnAccommodation", required=false, defaultValue="") String generalInformationOnAccommodation,
			@RequestParam(value="generalInformationOnCostOfLiving", required=false, defaultValue="") String generalInformationOnCostOfLiving,
			@RequestParam(value="generalInformationOnExtramuralAndLeisureFacilities", required=false, defaultValue="") String generalInformationOnExtramuralAndLeisureFacilities,
			@RequestParam(value="generalInformationOnFacilitiesForStudentsWithSpecialNeeds", required=false, defaultValue="") String generalInformationOnFacilitiesForStudentsWithSpecialNeeds,
			@RequestParam(value="generalInformationOnFinancialSupport", required=false, defaultValue="") String generalInformationOnFinancialSupport,
			@RequestParam(value="generalInformationOnInsurance", required=false, defaultValue="") String generalInformationOnInsurance,
			@RequestParam(value="generalInformationOnInternationalProgrammes", required=false, defaultValue="") String generalInformationOnInternationalProgrammes,
			@RequestParam(value="generalInformationOnInternships", required=false, defaultValue="") String generalInformationOnInternships,
			@RequestParam(value="generalInformationOnLanguageCourses", required=false, defaultValue="") String generalInformationOnLanguageCourses,
			@RequestParam(value="generalInformationOnMeals", required=false, defaultValue="") String generalInformationOnMeals,
			@RequestParam(value="generalInformationOnMedicalFacilities", required=false, defaultValue="") String generalInformationOnMedicalFacilities,
			@RequestParam(value="generalInformationOnSportsFacilities", required=false, defaultValue="") String generalInformationOnSportsFacilities,
			@RequestParam(value="generalInformationOnStudentAffairsOffice", required=false, defaultValue="") String generalInformationOnStudentAffairsOffice,
			@RequestParam(value="generalInformationOnStudentAssociations", required=false, defaultValue="") String generalInformationOnStudentAssociations,
			@RequestParam(value="generalInformationOnStudyFacilities", required=false, defaultValue="") String generalInformationOnStudyFacilities)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("LearningOpportunityProvider", model, StringUtils.namespaceEcts, identifier);
			model = OntologyUtils.addDatatypeProperty("InstitutionCode", model, StringUtils.namespaceEcts, identifier, identifier);
			model = OntologyUtils.addDatatypeProperty("InstitutionName", model, StringUtils.namespaceEcts, identifier, institutionName);
			model = OntologyUtils.addDatatypeProperty("InstitutionalEctsCoordinator", model, StringUtils.namespaceEcts, identifier, institutionalECTScoordinator);
			model = OntologyUtils.addDatatypeProperty("InstitutionStatus", model, StringUtils.namespaceEcts, identifier, institutionStatus);
			model = OntologyUtils.addDatatypeProperty("InstitutionType", model, StringUtils.namespaceEcts, identifier, institutionType);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, identifier, url);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, identifier, institutionAddress);
			model = OntologyUtils.addDatatypeProperty("InstitutionMainUniversityRegulations", model, StringUtils.namespaceEcts, identifier, institutionMainUniversityRegulations);
			model = OntologyUtils.addDatatypeProperty("InstitutionGeneralDescription", model, StringUtils.namespaceEcts, identifier, institutionGeneralDescription);
			model = OntologyUtils.addDatatypeProperty("InstitutionAcademicAuthorities", model, StringUtils.namespaceEcts, identifier, institutionAcademicAuthorities);
			model = OntologyUtils.addDatatypeProperty("InstitutionAcademicCalendar", model, StringUtils.namespaceEcts, identifier, institutionAcademicCalendar);
			model = OntologyUtils.addDatatypeProperty("InstitutionAdmissionProcedures", model, StringUtils.namespaceEcts, identifier, institutionAdmissionProcedures);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationForStudents", model, StringUtils.namespaceEcts, identifier, generalInformationForStudents);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationForMobileStudents", model, StringUtils.namespaceEcts, identifier, generalInformationForMobileStudents);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnAccommodation", model, StringUtils.namespaceEcts, identifier, generalInformationOnAccommodation);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnCostOfLiving", model, StringUtils.namespaceEcts, identifier, generalInformationOnCostOfLiving);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnExtraMuralAndLeisureFacilities", model, StringUtils.namespaceEcts, identifier, generalInformationOnExtramuralAndLeisureFacilities);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnFacilitiesForStudentsWithSpecialNeeds", model, StringUtils.namespaceEcts, identifier, generalInformationOnFacilitiesForStudentsWithSpecialNeeds);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnFinancialSupport", model, StringUtils.namespaceEcts, identifier, generalInformationOnFinancialSupport);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnInsurance", model, StringUtils.namespaceEcts, identifier, generalInformationOnInsurance);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnInternationalProgrammes", model, StringUtils.namespaceEcts, identifier, generalInformationOnInternationalProgrammes);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnInternships", model, StringUtils.namespaceEcts, identifier, generalInformationOnInternships);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnLanguageCourses", model, StringUtils.namespaceEcts, identifier, generalInformationOnLanguageCourses);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnMeals", model, StringUtils.namespaceEcts, identifier, generalInformationOnMeals);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnMedicalFacilities", model, StringUtils.namespaceEcts, identifier, generalInformationOnMedicalFacilities);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnSportsFacilities", model, StringUtils.namespaceEcts, identifier, generalInformationOnSportsFacilities);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnStudentAffairsOffice", model, StringUtils.namespaceEcts, identifier, generalInformationOnStudentAffairsOffice);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnStudentAssociations", model, StringUtils.namespaceEcts, identifier, generalInformationOnStudentAssociations);
			model = OntologyUtils.addDatatypeProperty("GeneralInformationOnStudyFacilities", model, StringUtils.namespaceEcts, identifier, generalInformationOnStudyFacilities);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseInstitution(identifier, institutionName);
	}

	/**
	 * Modify institution
	 * @param identifier
	 * @param institutionName
	 * @param institutionalECTScoordinator
	 * @param institutionStatus
	 * @param institutionType
	 * @param institutionAddress
	 * @param url
	 * @param institutionMainUniversityRegulations
	 * @param institutionGeneralDescription
	 * @param institutionAcademicAuthorities
	 * @param institutionAcademicCalendar
	 * @param institutionAdmissionProcedures
	 * @param generalInformationForStudents
	 * @param generalInformationForMobileStudents
	 * @param generalInformationOnAccommodation
	 * @param generalInformationOnCostOfLiving
	 * @param generalInformationOnExtramuralAndLeisureFacilities
	 * @param generalInformationOnFacilitiesForStudentsWithSpecialNeeds
	 * @param generalInformationOnFinancialSupport
	 * @param generalInformationOnInsurance
	 * @param generalInformationOnInternationalProgrammes
	 * @param generalInformationOnInternships
	 * @param generalInformationOnLanguageCourses
	 * @param generalInformationOnMeals
	 * @param generalInformationOnMedicalFacilities
	 * @param generalInformationOnSportsFacilities
	 * @param generalInformationOnStudentAffairsOffice
	 * @param generalInformationOnStudentAssociations
	 * @param generalInformationOnStudyFacilities
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value="/modifyInstitution")
	public ResponseInstitution modifyInstitution(@RequestParam(value="identifier", required=true) String identifier,
			@RequestParam(value="institutionName", required=false, defaultValue="") String institutionName,
			@RequestParam(value="institutionalECTScoordinator", required=false, defaultValue="") String institutionalECTScoordinator,
			@RequestParam(value="institutionStatus", required=false, defaultValue="") String institutionStatus,
			@RequestParam(value="institutionType", required=false, defaultValue="") String institutionType,
			@RequestParam(value="institutionAddress", required=false, defaultValue="") String institutionAddress,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="institutionMainUniversityRegulations", required=false, defaultValue="") String institutionMainUniversityRegulations,
			@RequestParam(value="institutionGeneralDescription", required=false, defaultValue="") String institutionGeneralDescription,
			@RequestParam(value="institutionAcademicAuthorities", required=false, defaultValue="") String institutionAcademicAuthorities,
			@RequestParam(value="institutionAcademicCalendar", required=false, defaultValue="") String institutionAcademicCalendar,
			@RequestParam(value="institutionAdmissionProcedures", required=false, defaultValue="") String institutionAdmissionProcedures,
			@RequestParam(value="generalInformationForStudents", required=false, defaultValue="") String generalInformationForStudents,
			@RequestParam(value="generalInformationForMobileStudents", required=false, defaultValue="") String generalInformationForMobileStudents,
			@RequestParam(value="generalInformationOnAccommodation", required=false, defaultValue="") String generalInformationOnAccommodation,
			@RequestParam(value="generalInformationOnCostOfLiving", required=false, defaultValue="") String generalInformationOnCostOfLiving,
			@RequestParam(value="generalInformationOnExtramuralAndLeisureFacilities", required=false, defaultValue="") String generalInformationOnExtramuralAndLeisureFacilities,
			@RequestParam(value="generalInformationOnFacilitiesForStudentsWithSpecialNeeds", required=false, defaultValue="") String generalInformationOnFacilitiesForStudentsWithSpecialNeeds,
			@RequestParam(value="generalInformationOnFinancialSupport", required=false, defaultValue="") String generalInformationOnFinancialSupport,
			@RequestParam(value="generalInformationOnInsurance", required=false, defaultValue="") String generalInformationOnInsurance,
			@RequestParam(value="generalInformationOnInternationalProgrammes", required=false, defaultValue="") String generalInformationOnInternationalProgrammes,
			@RequestParam(value="generalInformationOnInternships", required=false, defaultValue="") String generalInformationOnInternships,
			@RequestParam(value="generalInformationOnLanguageCourses", required=false, defaultValue="") String generalInformationOnLanguageCourses,
			@RequestParam(value="generalInformationOnMeals", required=false, defaultValue="") String generalInformationOnMeals,
			@RequestParam(value="generalInformationOnMedicalFacilities", required=false, defaultValue="") String generalInformationOnMedicalFacilities,
			@RequestParam(value="generalInformationOnSportsFacilities", required=false, defaultValue="") String generalInformationOnSportsFacilities,
			@RequestParam(value="generalInformationOnStudentAffairsOffice", required=false, defaultValue="") String generalInformationOnStudentAffairsOffice,
			@RequestParam(value="generalInformationOnStudentAssociations", required=false, defaultValue="") String generalInformationOnStudentAssociations,
			@RequestParam(value="generalInformationOnStudyFacilities", required=false, defaultValue="") String generalInformationOnStudyFacilities)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			Individual ind = model.getIndividual(StringUtils.namespaceEcts + identifier);
			HashMap<String, String> propertyValues = new HashMap<>();
			propertyValues.put("InstitutionName", institutionName);
			propertyValues.put("InstitutionalEctsCoordinator", institutionalECTScoordinator);
			propertyValues.put("InstitutionStatus", institutionStatus);
			propertyValues.put("InstitutionType", institutionType);
			propertyValues.put("Url", url);
			propertyValues.put("Location", institutionAddress);
			propertyValues.put("InstitutionMainUniversityRegulations", institutionMainUniversityRegulations);
			propertyValues.put("InstitutionGeneralDescription", institutionGeneralDescription);
			propertyValues.put("InstitutionAcademicAuthorities", institutionAcademicAuthorities);
			propertyValues.put("InstitutionAcademicCalendar", institutionAcademicCalendar);
			propertyValues.put("InstitutionAdmissionProcedures", institutionAdmissionProcedures);
			propertyValues.put("GeneralInformationForStudents", generalInformationForStudents);
			propertyValues.put("GeneralInformationForMobileStudents", generalInformationForMobileStudents);
			propertyValues.put("GeneralInformationOnAccommodation", generalInformationOnAccommodation);
			propertyValues.put("GeneralInformationOnCostOfLiving", generalInformationOnCostOfLiving);
			propertyValues.put("GeneralInformationOnExtraMuralAndLeisureFacilities", generalInformationOnExtramuralAndLeisureFacilities);
			propertyValues.put("GeneralInformationOnFacilitiesForStudentsWithSpecialNeeds", generalInformationOnFacilitiesForStudentsWithSpecialNeeds);
			propertyValues.put("GeneralInformationOnFinancialSupport", generalInformationOnFinancialSupport);
			propertyValues.put("GeneralInformationOnInsurance", generalInformationOnInsurance);
			propertyValues.put("GeneralInformationOnInternationalProgrammes", generalInformationOnInternationalProgrammes);
			propertyValues.put("GeneralInformationOnInternships", generalInformationOnInternships);
			propertyValues.put("GeneralInformationOnLanguageCourses", generalInformationOnLanguageCourses);
			propertyValues.put("GeneralInformationOnMeals", generalInformationOnMeals);
			propertyValues.put("GeneralInformationOnMedicalFacilities", generalInformationOnMedicalFacilities);
			propertyValues.put("GeneralInformationOnSportsFacilities", generalInformationOnSportsFacilities);
			propertyValues.put("GeneralInformationOnStudentAffairsOffice", generalInformationOnStudentAffairsOffice);
			propertyValues.put("GeneralInformationOnStudentAssociations", generalInformationOnStudentAssociations);
			propertyValues.put("GeneralInformationOnStudyFacilities", generalInformationOnStudyFacilities);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseInstitution(identifier, institutionName);
	}

	/**
	 * Remove institution
	 * @param institution id
	 * @return status
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeInstitution")
	public String removeInstitution(@RequestParam(value = "identifier", required=true) String id)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("LearningOpportunityProvider", model, StringUtils.namespaceEcts, id);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Learning Opportunity Provider with id: " + id + " is removed.";
	}

	/*
	 * Add degree programme
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addDegreeProgramme")
	public ResponseProgrammeSpecification addDegreeProgramme(  @RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
			@RequestParam(value="degreeProgrammeTitle", required=true) String degreeProgrammeTitle,
			@RequestParam(value="location", required=false, defaultValue="") String location,
			@RequestParam(value="qualification", required=false, defaultValue="") String qualification,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="credit", required=false, defaultValue="") String credit,
			@RequestParam(value="degreeProgrammeAccessToFurtherStudies", required=false, defaultValue="") String degreeProgrammeAccessToFurtherStudies,
			@RequestParam(value="degreeProgrammeEducationalAndProfessionalGoals", required=false, defaultValue="") String degreeProgrammeEducationalAndProfessionalGoals,
			@RequestParam(value="degreeProgrammeStructureDiagram", required=false, defaultValue="") String degreeProgrammeStructureDiagram,
			@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
			@RequestParam(value="departmentalEctsCoordinator", required=false, defaultValue="") String departmentalEctsCoordinator,
			@RequestParam(value="degreeProgrammeFinalExamination", required=false, defaultValue="") String degreeProgrammeFinalExamination,
			@RequestParam(value="places", required=false, defaultValue="") String places,
			@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
			@RequestParam(value="degreeProgrammeExaminationAndAssessmentRegulations", required=false, defaultValue="") String degreeProgrammeExaminationAndAssessmentRegulations,
			@RequestParam(value="start", required=false, defaultValue="") String start,
			@RequestParam(value="duration", required=false, defaultValue="") String duration,
			@RequestParam(value="cost", required=false, defaultValue="") String cost)
	
	
	
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("DegreeProgrammeInstance", model, StringUtils.namespaceEcts, degreeUnitCode);
			model = OntologyUtils.addDatatypeProperty("DegreeUnitCode", model, StringUtils.namespaceEcts, degreeUnitCode, degreeUnitCode);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeTitle", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeTitle);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, degreeUnitCode, location);
			model = OntologyUtils.addDatatypeProperty("Qualification", model, StringUtils.namespaceEcts, degreeUnitCode, qualification);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, degreeUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeCredit", model, StringUtils.namespaceEcts, degreeUnitCode, credit);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeAccessToFurtherStudies", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeAccessToFurtherStudies);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeEducationAndProfessionalGoals", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeEducationalAndProfessionalGoals);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeStructureDiagram", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeStructureDiagram);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammePrerequisite", model, StringUtils.namespaceEcts, degreeUnitCode, prerequisite);
			model = OntologyUtils.addDatatypeProperty("DepartmentalEctsCoordinator", model, StringUtils.namespaceEcts, degreeUnitCode, departmentalEctsCoordinator);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeFinalExamination", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeFinalExamination);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammePlaces", model, StringUtils.namespaceEcts, degreeUnitCode, places);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeLanguageOfInstruction", model, StringUtils.namespaceEcts, degreeUnitCode, languageOfInstruction);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeExaminationAndAssessmentRegulations", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeExaminationAndAssessmentRegulations);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeStart", model, StringUtils.namespaceEcts, degreeUnitCode, start);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeDuration", model, StringUtils.namespaceEcts, degreeUnitCode, duration);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeCost", model, StringUtils.namespaceEcts, degreeUnitCode, cost);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeSpecification(degreeUnitCode, degreeProgrammeTitle);
	}


	/*
	 * modify degree programme
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyDegreeProgramme")
	public ResponseProgrammeSpecification modifyDegreeProgramme(@RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
			@RequestParam(value="degreeProgrammeTitle", required=false, defaultValue="") String degreeProgrammeTitle,
			@RequestParam(value="location", required=false, defaultValue="") String location,
			@RequestParam(value="qualification", required=false, defaultValue="") String qualification,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="credit", required=false, defaultValue="") String credit,
			@RequestParam(value="degreeProgrammeAccessToFurtherStudies", required=false, defaultValue="") String degreeProgrammeAccessToFurtherStudies,
			@RequestParam(value="degreeProgrammeEducationalAndProfessionalGoals", required=false, defaultValue="") String degreeProgrammeEducationalAndProfessionalGoals,
			@RequestParam(value="degreeProgrammeStructureDiagram", required=false, defaultValue="") String degreeProgrammeStructureDiagram,
			@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
			@RequestParam(value="departmentalEctsCoordinator", required=false, defaultValue="") String departmentalEctsCoordinator,
			@RequestParam(value="degreeProgrammeFinalExamination", required=false, defaultValue="") String degreeProgrammeFinalExamination,
			@RequestParam(value="places", required=false, defaultValue="") String places,
			@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
			@RequestParam(value="degreeProgrammeExaminationAndAssessmentRegulations", required=false, defaultValue="") String degreeProgrammeExaminationAndAssessmentRegulations,
			@RequestParam(value="start", required=false, defaultValue="") String start,
			@RequestParam(value="duration", required=false, defaultValue="") String duration,
			@RequestParam(value="cost", required=false, defaultValue="") String cost)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			Individual ind = model.getIndividual(StringUtils.namespaceEcts + degreeUnitCode);
			HashMap<String, String> propertyValues = new HashMap<>();
			propertyValues.put("DegreeProgrammeTitle", degreeProgrammeTitle);
			propertyValues.put("Location", location);
			propertyValues.put("Qualification", qualification);
			propertyValues.put("Url", url);
			propertyValues.put("DegreeProgrammeCredit", credit);
			propertyValues.put("DegreeProgrammeAccessToFurtherStudies", degreeProgrammeAccessToFurtherStudies);
			propertyValues.put("DegreeProgrammeEducationAndProfessionalGoals", degreeProgrammeEducationalAndProfessionalGoals);
			propertyValues.put("DegreeProgrammeStructureDiagram", degreeProgrammeStructureDiagram);
			propertyValues.put("DegreeProgrammePrerequisite", prerequisite);
			propertyValues.put("DepartmentalEctsCoordinator", departmentalEctsCoordinator);
			propertyValues.put("DegreeProgrammeFinalExamination", degreeProgrammeFinalExamination);
			propertyValues.put("DegreeProgrammePlaces", places);
			propertyValues.put("DegreeProgrammeLanguageOfInstruction", languageOfInstruction);
			propertyValues.put("DegreeProgrammeExaminationAndAssessmentRegulations", degreeProgrammeExaminationAndAssessmentRegulations);
			propertyValues.put("DegreeProgrammeStart", start);
			propertyValues.put("DegreeProgrammeDuration", duration);
			propertyValues.put("DegreeProgrammeCost", cost);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeSpecification(degreeUnitCode, degreeProgrammeTitle);
	}



	/**
	 * Remove degree programme
	 * @param degreeUnitCode degree programme id
	 * @return status 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeDegreeProgramme")
	public String removeDegreeProgramme(@RequestParam(value = "degreeUnitCode", required=true) String degreeUnitCode)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("DegreeProgrammeInstance", model, StringUtils.namespaceEcts, degreeUnitCode);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Degree programme instance with id: " + degreeUnitCode + " is removed.";
	}

	/*
	 * Add course unit
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addCourseUnit")
	public ResponseCourseSpecification addCourseUnit(  @RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
			@RequestParam(value="courseUnitTitle", required=true) String courseUnitTitle,
			@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
			@RequestParam(value="courseUnitLevel", required=false, defaultValue="") String courseUnitLevel,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="courseUnitYearOfStudy", required=false, defaultValue="") String courseUnitYearOfStudy,
			@RequestParam(value="credit", required=false, defaultValue="") String credit,
			@RequestParam(value="courseUnitContent", required=false, defaultValue="") String courseUnitContent,
			@RequestParam(value="courseLocation", required=false, defaultValue="") String courseLocation,
			@RequestParam(value="lecturer", required=false, defaultValue="") String lecturer,
			@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
			@RequestParam(value="places", required=false, defaultValue="") String places,
			@RequestParam(value="courseUnitTermPattern", required=true, defaultValue="Semester") String courseUnitTermPattern,
			@RequestParam(value="courseUnitCompetence", required=false, defaultValue="") String courseUnitCompetence,
			@RequestParam(value="courseUnitLearningOutcome", required=false, defaultValue="") String courseUnitLearningOutcome,
			@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
			@RequestParam(value="courseUnitRecommendedReading", required=false, defaultValue="") String courseUnitRecommendedReading,
			@RequestParam(value="courseUnitTeachingMethods", required=false, defaultValue="") String courseUnitTeachingMethods,
			@RequestParam(value="courseUnitAssessmentMethods", required=false, defaultValue="") String courseUnitAssessmentMethods,
			@RequestParam(value="start", required=false, defaultValue="") String start,
			@RequestParam(value="duration", required=false, defaultValue="") String duration,
			@RequestParam(value="cost", required=false, defaultValue="") String cost)

	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("CourseUnitInstance", model, StringUtils.namespaceEcts, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("CourseUnitCode", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTitle", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTitle);
			model = OntologyUtils.addDatatypeProperty("CourseUnitType", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitType);
			model = OntologyUtils.addDatatypeProperty("CourseUnitLevel", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitLevel);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, courseUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("CourseUnitYearOfStudy", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitYearOfStudy);
			model = OntologyUtils.addDatatypeProperty("CourseCredit", model, StringUtils.namespaceEcts, courseUnitCode, credit);
			model = OntologyUtils.addDatatypeProperty("CourseUnitContent", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitContent);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, courseUnitCode, courseLocation);
			model = OntologyUtils.addDatatypeProperty("Lecturer", model, StringUtils.namespaceEcts, courseUnitCode, lecturer);
			model = OntologyUtils.addDatatypeProperty("CourseUnitLanguageOfInstruction", model, StringUtils.namespaceEcts, courseUnitCode, languageOfInstruction);
			model = OntologyUtils.addDatatypeProperty("CourseUnitPlaces", model, StringUtils.namespaceEcts, courseUnitCode, places);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTermPattern", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTermPattern);
			model = OntologyUtils.addDatatypeProperty("CourseUnitCompetence", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitCompetence);
			model = OntologyUtils.addDatatypeProperty("CourseUnitLearningOutcome", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitLearningOutcome);
			model = OntologyUtils.addDatatypeProperty("CourseUnitPrerequisite", model, StringUtils.namespaceEcts, courseUnitCode, prerequisite);
			model = OntologyUtils.addDatatypeProperty("CourseUnitRecommendedReading", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitRecommendedReading);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTeachingMethods", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTeachingMethods);
			model = OntologyUtils.addDatatypeProperty("CourseUnitAssessmentMethods", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitAssessmentMethods);
			model = OntologyUtils.addDatatypeProperty("CourseUnitStart", model, StringUtils.namespaceEcts, courseUnitCode, start);
			model = OntologyUtils.addDatatypeProperty("CourseUnitDuration", model, StringUtils.namespaceEcts, courseUnitCode, duration);
			model = OntologyUtils.addDatatypeProperty("CourseCost", model, StringUtils.namespaceEcts, courseUnitCode, cost);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseSpecification(courseUnitCode, courseUnitTitle);
	}

	/*
	 * Modify course unit
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyCourseUnit")
	public ResponseCourseSpecification modifyCourseUnit(@RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
			@RequestParam(value="courseUnitTitle", required=false, defaultValue="") String courseUnitTitle,
			@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
			@RequestParam(value="courseUnitLevel", required=false, defaultValue="") String courseUnitLevel,
			@RequestParam(value="url", required=false, defaultValue="") String url,
			@RequestParam(value="courseUnitYearOfStudy", required=false, defaultValue="") String courseUnitYearOfStudy,
			@RequestParam(value="credit", required=false, defaultValue="") String credit,
			@RequestParam(value="courseUnitContent", required=false, defaultValue="") String courseUnitContent,
			@RequestParam(value="courseLocation", required=false, defaultValue="") String courseLocation,
			@RequestParam(value="lecturer", required=false, defaultValue="") String lecturer,
			@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
			@RequestParam(value="places", required=false, defaultValue="") String places,
			@RequestParam(value="courseUnitTermPattern", required=true, defaultValue="Semester") String courseUnitTermPattern,
			@RequestParam(value="courseUnitCompetence", required=false, defaultValue="") String courseUnitCompetence,
			@RequestParam(value="courseUnitLearningOutcome", required=false, defaultValue="") String courseUnitLearningOutcome,
			@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
			@RequestParam(value="courseUnitRecommendedReading", required=false, defaultValue="") String courseUnitRecommendedReading,
			@RequestParam(value="courseUnitTeachingMethods", required=false, defaultValue="") String courseUnitTeachingMethods,
			@RequestParam(value="courseUnitAssessmentMethods", required=false, defaultValue="") String courseUnitAssessmentMethods,
			@RequestParam(value="start", required=false, defaultValue="") String start,
			@RequestParam(value="duration", required=false, defaultValue="") String duration,
			@RequestParam(value="cost", required=false, defaultValue="") String cost)

	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			Individual ind = model.getIndividual(StringUtils.namespaceEcts + courseUnitCode);
			HashMap<String, String> propertyValues = new HashMap<>();
			propertyValues.put("CourseUnitTitle", courseUnitTitle);
			propertyValues.put("CourseUnitType", courseUnitType);
			propertyValues.put("CourseUnitLevel", courseUnitLevel);
			propertyValues.put("Url", url);
			propertyValues.put("CourseUnitYearOfStudy", courseUnitYearOfStudy);
			propertyValues.put("CourseCredit", credit);
			propertyValues.put("CourseUnitContent", courseUnitContent);
			propertyValues.put("Location", courseLocation);
			propertyValues.put("Lecturer", lecturer);
			propertyValues.put("CourseUnitLanguageOfInstruction", languageOfInstruction);
			propertyValues.put("CourseUnitPlaces", places);
			propertyValues.put("CourseUnitTermPattern", courseUnitTermPattern);
			propertyValues.put("CourseUnitCompetence", courseUnitCompetence);
			propertyValues.put("CourseUnitLearningOutcome", courseUnitLearningOutcome);
			propertyValues.put("CourseUnitPrerequisite", prerequisite);
			propertyValues.put("CourseUnitRecommendedReading", courseUnitRecommendedReading);
			propertyValues.put("CourseUnitTeachingMethods", courseUnitTeachingMethods);
			propertyValues.put("CourseUnitAssessmentMethods", courseUnitAssessmentMethods);
			propertyValues.put("CourseUnitStart", start);
			propertyValues.put("CourseUnitDuration", duration);
			propertyValues.put("CourseCost", cost);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseSpecification(courseUnitCode, courseUnitTitle);
	}

	/**
	 * Remove course unit
	 * @param courseUnitCode course unit id
	 * @return status
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCourseUnit")
	public String removeCourseUnit(@RequestParam(value = "courseUnitCode", required=true) String courseUnitCode)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("CourseUnitInstance", model, StringUtils.namespaceEcts, courseUnitCode);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Degree course specification with id: " + courseUnitCode + " is removed.";
	}


	// generic query
	@RequestMapping(method = RequestMethod.GET, value = "/query")
	public ArrayList<QueryResult> query(@RequestParam("value") String val,
			@RequestParam("type") QueryType type)
	{

		ArrayList<String> namespaces = new ArrayList<String>();
		ArrayList<QueryResult> retVal = null;
		namespaces.add(StringUtils.namespaceEcts);
		namespaces.add(StringUtils.namespaceW3c);


		switch(type)
		{
		case SUBJECT:
			String subject = "<" + StringUtils.namespaceEcts + val + ">";
			retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,subject,"?p","?o","?p","\""+StringUtils.namespaceEcts +"\""), namespaces, type, val);
			break;
		case PREDICATE:
			String predicate = "<" + StringUtils.namespaceEcts + val + ">";
			retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s",predicate,"?o","?s","\""+StringUtils.namespaceEcts +"\""), namespaces, type, val);
			break;
		case OBJECT:
			retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s","?p","\"" + val + "\"","?p","\""+StringUtils.namespaceEcts +"\""), namespaces, type, val);
			break;
		}

		return retVal;
	}

	/**
	 * Get institutions
	 * @return institutions from db
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getInstitutions")
	public ArrayList<Institution> getInstitutions()
	{
		ArrayList<String> namespaces = new ArrayList<String>();
		ArrayList<QueryResult> retVal = null;
		namespaces.add(StringUtils.namespaceEcts);
		namespaces.add(StringUtils.namespaceW3c);

		retVal = query("InstitutionCode", QueryType.PREDICATE);

		ArrayList<Institution> institutions = new ArrayList<>();

		String identifier="", institutionName="", institutionStatus="", institutionType="", institutionAddress="", url=""; 
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();


		for (QueryResult queryResult : retVal) {
			identifier = queryResult.getSubject();
			results = query(identifier, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("InstitutionCode"))
					identifier = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionName"))
					institutionName = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionStatus"))
					institutionStatus = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionType"))
					institutionType = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionAddress"))
					institutionAddress = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
			}
			institutions.add(new Institution(identifier, institutionName, institutionStatus, institutionType, institutionAddress, url));
		}

		return institutions;
	}

	/**
	 * Get institution by institution code
	 * @param institutionCode
	 * @return institution
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getInstitution")
	public Institution getInstitution(@RequestParam("identifier")String institutionCode){
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();

		String query = "SELECT * WHERE{?s <" + StringUtils.namespaceEcts + "InstitutionCode> \"" + institutionCode + "\"}";
		ResultSet result = OntologyUtils.execSelect(StringUtils.URLquery, query);
		QuerySolution soln = result.nextSolution();
		String identifier = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
		String institutionName = "";
		String institutionStatus= "";
		String institutionType= "";
		String institutionAddress= "";
		String url= "";
		String institutionalECTScoordinator= "";
		String mainUniversityRegulations= "";
		String institutionGeneralDescription= "";
		String institutionAcademicAuthorities= "";
		String institutionAcademicCalendar= "";
		String institutionAdmissionProcedures= "";
		String generalInformationForStudents= "";
		String generalInformationForMobileStudetns= "";
		String generalInformationOnAccommodation= "";
		String generalInformationOnCostOfLiving= "";
		String generalInformationOnExtramuralAndLeisureFacilities= "";
		String generalInformationOnFacilitiesForStudentsWithSpecialNeeds= "";
		String generalInformationOnFinancialSupport= "";
		String generalInformationOnInsturance= "";
		String generalInformationOnInternationalProgrammes= "";
		String generalInformationOnInternships= "";
		String generalInformationonLanguageCourses= "";
		String generalInformationOnMeals= "";
		String generalInformationOnMedicalFacilities= "";
		String generalInformationOnSportsFacilities= "";
		String generalInformationOnStudentAffairsOffice= "";
		String generalInformationOnStudentAssociations= "";
		String generalInformationOnStudyFacilities= "";

		results = query(identifier, QueryType.SUBJECT);
		for (QueryResult queryResult2 : results) {
			if (queryResult2.getPredicate().equals("InstitutionName"))
				institutionName = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionStatus"))
				institutionStatus = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionType"))
				institutionType = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionAddress"))
				institutionAddress = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Url"))
				url = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionalEctsCoordinator"))
				institutionalECTScoordinator = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionMainUniversityRegulations"))
				mainUniversityRegulations = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionGeneralDescription"))
				institutionGeneralDescription = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionAcademicAuthorities"))
				institutionAcademicAuthorities = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionAcademicCalendar"))
				institutionAcademicCalendar = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("InstitutionAdmissionProcedures"))
				institutionAdmissionProcedures = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationForStudents"))
				generalInformationForStudents = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationForMobileStudetns"))
				generalInformationForMobileStudetns = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnAccommodation"))
				generalInformationOnAccommodation = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnCostOfLiving"))
				generalInformationOnCostOfLiving = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnExtraMuralAndLeisureFacilities"))
				generalInformationOnExtramuralAndLeisureFacilities = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnFacilitiesForStudentsWithSpecialNeeds"))
				generalInformationOnFacilitiesForStudentsWithSpecialNeeds = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnFinancialSupport"))
				generalInformationOnFinancialSupport = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnInsturance"))
				generalInformationOnInsturance = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnInternationalProgrammes"))
				generalInformationOnInternationalProgrammes = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnInternships"))
				generalInformationOnInternships = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationonLanguageCourses"))
				generalInformationonLanguageCourses = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnMeals"))
				generalInformationOnMeals = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnMedicalFacilities"))
				generalInformationOnMedicalFacilities = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnSportsFacilities"))
				generalInformationOnSportsFacilities = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnStudentAffairsOffice"))
				generalInformationOnStudentAffairsOffice = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("generalInformationOnStudentAssociations"))
				generalInformationOnStudentAssociations = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("GeneralInformationOnStudyFacilities"))
				generalInformationOnStudyFacilities = queryResult2.getObject();
		}
		return new Institution(institutionCode, institutionName, institutionStatus, institutionType,
				institutionAddress, url, institutionalECTScoordinator,
				mainUniversityRegulations, institutionGeneralDescription,
				institutionAcademicAuthorities, institutionAcademicCalendar,
				institutionAdmissionProcedures, generalInformationForStudents,
				generalInformationForMobileStudetns, generalInformationOnAccommodation,
				generalInformationOnCostOfLiving, generalInformationOnExtramuralAndLeisureFacilities,
				generalInformationOnFacilitiesForStudentsWithSpecialNeeds,
				generalInformationOnFinancialSupport, generalInformationOnInsturance,
				generalInformationOnInternationalProgrammes, generalInformationOnInternships,
				generalInformationonLanguageCourses, generalInformationOnMeals,
				generalInformationOnMedicalFacilities, generalInformationOnSportsFacilities,
				generalInformationOnStudentAffairsOffice, generalInformationOnStudentAssociations,
				generalInformationOnStudyFacilities);
	}

	/**
	 * Get programmes
	 * @return programmes from db
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getProgrammes")
	public ArrayList<DegreeProgramme> getProgrammes()
	{
		ArrayList<String> namespaces = new ArrayList<String>();
		ArrayList<QueryResult> retVal = null;
		namespaces.add(StringUtils.namespaceEcts);
		namespaces.add(StringUtils.namespaceW3c);

		retVal = query("DegreeUnitCode", QueryType.PREDICATE);

		ArrayList<DegreeProgramme> degreeProgrammes = new ArrayList<>();

		String identifier="", title="", language="", location="", qualification="", url="";
		Double credits = -1.0;
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();


		for (QueryResult queryResult : retVal) {
			identifier = queryResult.getSubject();
			results = query(identifier, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("DegreeUnitCode"))
					identifier = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("DegreeProgrammeTitle"))
					title = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("DegreeProgrammeLanguageOfInstruction"))
					language = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Location"))
					location = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Qualification"))
					qualification = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("DegreeProgrammeCredit"))
					credits = queryResult2.getObject().equals("")?-1.0:Double.valueOf(queryResult2.getObject());
			}
			degreeProgrammes.add(new DegreeProgramme(identifier, title, language, location, qualification, credits, url));
		}

		return degreeProgrammes;
	}

	/**
	 * Get programme
	 * @return programme from db
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getProgramme")
	public DegreeProgramme getProgramme(@RequestParam("identifier")String programmeCode)
	{
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();

		String query = "SELECT * WHERE{?s <" + StringUtils.namespaceEcts + "DegreeUnitCode> \"" + programmeCode + "\"}";
		ResultSet result = OntologyUtils.execSelect(StringUtils.URLquery, query);
		QuerySolution soln = result.nextSolution();
		String degreeUnitCode = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
		String degreeProgrammeTitle = "";
		String language = "";
		String location = "";
		String qualification = "";
		Double credit = -1.0;
		String url = "";
		
		String prerequisite = "";
		String departmentalECTScoordinator = "";
		String degreeProgrammeFinalExamination = "";
		String places = "";
		String degreeProgrammeExaminationAndAssessmentRegulations = "";
		String start = "";
		Integer duration = -1;
		String cost = "";
		String degreeProgrammeAccessToFurtherStudies = "";
		String degreeProgrammeEducationalAndProfessionalGoals = "";
		String degreeProgrammeStructureDiagram = "";

		results = query(degreeUnitCode, QueryType.SUBJECT);
		for (QueryResult queryResult2 : results) {
			if (queryResult2.getPredicate().equals("DegreeUnitCode"))
				degreeUnitCode = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeTitle"))
				degreeProgrammeTitle = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeLanguageOfInstruction"))
				language = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Location"))
				location = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Qualification"))
				qualification = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeCredit"))
				credit = queryResult2.getObject().equals("")?-1.0:Double.valueOf(queryResult2.getObject());
			else if (queryResult2.getPredicate().equals("Url"))
				url = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammePrerequisite"))
				prerequisite = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DepartmentalEctsCoordinator"))
				departmentalECTScoordinator = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeFinalExamination"))
				degreeProgrammeFinalExamination = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammePlaces"))
				places = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeExaminationAndAssessmentRegulations"))
				degreeProgrammeExaminationAndAssessmentRegulations = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeStart"))
				start = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeDuration"))
				duration = queryResult2.getObject().equals("")?-1:Integer.valueOf(queryResult2.getObject());
			else if (queryResult2.getPredicate().equals("DegreeProgrammeCost"))
				cost = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeAccessToFurtherStudies"))
				degreeProgrammeAccessToFurtherStudies = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeEducationalAndProfessionalGoals"))
				degreeProgrammeEducationalAndProfessionalGoals = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("DegreeProgrammeStructureDiagram"))
				degreeProgrammeStructureDiagram = queryResult2.getObject();
		}
		return new DegreeProgramme(degreeUnitCode, degreeProgrammeTitle, language, location,
				qualification, credit, url, prerequisite, departmentalECTScoordinator,
				degreeProgrammeFinalExamination, places,
				degreeProgrammeExaminationAndAssessmentRegulations, start, duration, cost,
				degreeProgrammeAccessToFurtherStudies, degreeProgrammeEducationalAndProfessionalGoals,
				degreeProgrammeStructureDiagram);
	}

	/**
	 * Get courses
	 * @return courses from db
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getCourses")
	public ArrayList<CourseUnit> getCourses()
	{
		ArrayList<String> namespaces = new ArrayList<String>();
		ArrayList<QueryResult> retVal = null;
		namespaces.add(StringUtils.namespaceEcts);
		namespaces.add(StringUtils.namespaceW3c);

		retVal = query("CourseUnitCode", QueryType.PREDICATE);

		ArrayList<CourseUnit> courses = new ArrayList<>();

		String identifier="", title="", type="", level="", url="";
		Double credits = -1.0;
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();


		for (QueryResult queryResult : retVal) {
			identifier = queryResult.getSubject();
			results = query(identifier, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("CourseUnitCode"))
					identifier = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitTitle"))
					title = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitType"))
					type = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitLevel"))
					level = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseCredit"))
					credits = queryResult2.getObject().equals("")?-1.0:Double.valueOf(queryResult2.getObject());
			}
			courses.add(new CourseUnit(identifier, title, type, level, credits, url));
		}

		return courses;
	}

	/**
	 * Get course
	 * @return course from db
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getCourse")
	public CourseUnit getCourse(@RequestParam("identifier")String courseCode)
	{
		ArrayList<String> namespaces = new ArrayList<String>();
		ArrayList<QueryResult> retVal = null;
		namespaces.add(StringUtils.namespaceEcts);
		namespaces.add(StringUtils.namespaceW3c);

		// get programme specification ids
		String query = "SELECT ?s WHERE {?s <" + StringUtils.namespaceEcts + "CourseUnitCode> \""+courseCode+"\"}";
		System.out.println(query);
		ResultSet result = OntologyUtils.execSelect(StringUtils.URLquery, query);
		System.out.println(result.hasNext());

		QuerySolution soln = result.next();
		String identifier = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");

		String courseUnitCode = courseCode;
		String courseUnitTitle = "";
		String courseUnitType = "";
		String courseUnitLevel = "";
		String url = "";
		String courseUnitYearOfStudy = "";
		String courseUnitContent = "";
		String courseLocation = "";
		String qualification = "";
		String lecturer = "";
		String languageOfInstruction = "";
		String places = "";
		String courseUnitTermPattern = "";
		String courseUnitCompetence = "";
		String courseUnitLearningOutcome = "";
		String prerequisite = "";
		String courseUnitRecommendedReading = "";
		String courseUnitTeachingMethods = "";
		String courseUnitAssessmentMethods = "";
		String start = "";
		Integer duration = -1;
		Double cost = -1.0;
		Double credit = -1.0;

		// get programme instance data
		retVal = query(identifier, QueryType.SUBJECT);
		for (QueryResult queryResult2 : retVal) {
			if (queryResult2.getPredicate().equals("CourseUnitAssessmentMethods"))
				courseUnitAssessmentMethods = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseCost"))
				cost = queryResult2.getObject().equals("")?-1.0:Double.valueOf(queryResult2.getObject());
			else if (queryResult2.getPredicate().equals("CourseUnitRecommendedReading"))
				courseUnitRecommendedReading = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitTeachingMethods"))
				courseUnitTeachingMethods = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitStart"))
				start = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitDuration"))
				duration = queryResult2.getObject().equals("")?-1:Integer.valueOf(queryResult2.getObject());
			else if (queryResult2.getPredicate().equals("CourseUnitTermPattern"))
				courseUnitTermPattern = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitLanguageOfInstruction"))
				languageOfInstruction = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Lecturer"))
				lecturer = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Location"))
				courseLocation = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitCompetence"))
				courseUnitCompetence = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitLearningOutcome"))
				courseUnitLearningOutcome = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitPlaces"))
				places = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitPrerequisite"))
				prerequisite = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitType"))
				courseUnitType = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitTitle"))
				courseUnitTitle = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseCredit"))
				credit = queryResult2.getObject().equals("")?-1:Double.valueOf(queryResult2.getObject());
			else if (queryResult2.getPredicate().equals("CourseUnitLevel"))
				courseUnitLevel = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitYearOfStudy"))
				courseUnitYearOfStudy = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Qualification"))
				qualification = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("Url"))
				url = queryResult2.getObject();
			else if (queryResult2.getPredicate().equals("CourseUnitContent"))
				courseUnitContent = queryResult2.getObject();
		}
		return new CourseUnit(courseUnitCode, courseUnitTitle, courseUnitType, courseUnitLevel,
				credit, url, courseUnitYearOfStudy, courseUnitContent, courseLocation,
				qualification, lecturer, languageOfInstruction, places,
				courseUnitTermPattern, courseUnitCompetence, courseUnitLearningOutcome,
				prerequisite, courseUnitRecommendedReading, courseUnitTeachingMethods,
				courseUnitAssessmentMethods, start, duration, cost);
	}

	// search
	//institutions
	@RequestMapping(method = RequestMethod.GET, value="/searchInstitutions")
	public ArrayList<Institution> searchInstitutions(@RequestParam("institution") String institution){
		ArrayList<Institution> institutions = new ArrayList<Institution>();
		System.out.println(institution);
		ObjectMapper mapper = new ObjectMapper();
		InstitutionSearch insS = new InstitutionSearch();
		try {
			insS = mapper.readValue(institution, InstitutionSearch.class);
		} catch (IOException e) {
			e.printStackTrace();
		}


		String conditionStatus = insS.getStatus().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "InstitutionStatus> ?status.";
		String conditionAddress = insS.getLocation().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "Location> ?address.";
		String conditionType = insS.getType().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "InstitutionType> ?type.";

		String status = insS.getStatus().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?status)), \""+ insS.getStatus().toLowerCase() +"\")";
		String address = insS.getLocation().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?address)), \""+ insS.getLocation().toLowerCase() +"\")";
		String type = insS.getType().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?type)), \""+ insS.getType().toLowerCase() +"\")";

		String query = "SELECT DISTINCT ?s" 
				+" WHERE {"
				+" ?s <" + StringUtils.namespaceEcts + "InstitutionCode> ?id."
				+" ?s <" + StringUtils.namespaceEcts + "InstitutionName> ?name."
				+ conditionStatus
				+ conditionAddress
				+ conditionType
				+" FILTER (CONTAINS(LCASE(STR(?id)), \"" + insS.getId().toLowerCase() + "\") &&"
				+" 		   CONTAINS(LCASE(STR(?name)), \""+ insS.getName().toLowerCase() +"\")"
				+ status
				+ address
				+ type
				+ ")}";
		System.out.println(query);
		ResultSet retVal = OntologyUtils.execSelect(StringUtils.URLquery, query);

		String identifier="", institutionName="", institutionStatus="", institutionType="", institutionAddress="", url=""; 
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();
		QuerySolution soln = null;


		while (retVal.hasNext()) {
			soln = retVal.next();
			identifier = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
			results = query(identifier, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("InstitutionCode"))
					identifier = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionName"))
					institutionName = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionStatus"))
					institutionStatus = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("InstitutionType"))
					institutionType = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Location"))
					institutionAddress = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
			}
			institutions.add(new Institution(identifier, institutionName, institutionStatus, institutionType, institutionAddress, url));
		}

		return institutions;
	}

	//programmes
	@RequestMapping(method = RequestMethod.GET, value="/searchProgrammes")
	public ArrayList<DegreeProgramme> searchProgrammes(@RequestParam("programme") String programme){
		ArrayList<DegreeProgramme> degreeProgrammes = new ArrayList<DegreeProgramme>();
		System.out.println(programme);
		ObjectMapper mapper = new ObjectMapper();
		ProgrammeSearch ps = new ProgrammeSearch();
		try {
			ps = mapper.readValue(programme, ProgrammeSearch.class);
		} catch (IOException e) {
			e.printStackTrace();
		}


		String subQuery = "{SELECT distinct ?id1 ?title ?s"
				+	" WHERE {"
				+	  " ?course <"+StringUtils.namespaceEcts+"isContained> ?s."
				+	  " {SELECT ?course ?title ?id1"
				+	    " WHERE {"
				+	     " ?course <"+StringUtils.namespaceEcts+"CourseUnitTitle> ?title."
				+	      " ?course <"+StringUtils.namespaceEcts+"CourseUnitCode> ?id1."
				+	      " FILTER" 
				+	        " (CONTAINS(lcase(str(?title)), \"" + ps.getContainsCourse() +"\"))"
				+	    " }}}}";

		String conditionQualification = ps.getQualification().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "Qualification> ?qualification.";
		String conditionLocation = ps.getLocation().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "Location> ?location.";
		String conditionCost = ps.getCost().equals(-1.0)?"":" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammeCost> ?cost.";
		String conditionCredits = ps.getCredits().equals(-1.0)?"":" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammeCredit> ?credit.";
		String conditionDuration = ps.getDuration().equals(-1)?"":" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammeDuration> ?duration.";
		String conditionLanguage = ps.getLanguage().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammeLanguageOfInstruction> ?language.";
		String conditionPrerequisite = ps.getPrerequisite().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammePrerequisite> ?prerequisite.";
		String conditionContains = ps.getContainsCourse().equals("")?"":subQuery;


		String qualification = ps.getQualification().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?qualification)), \""+ ps.getQualification().toLowerCase() +"\")";
		String location = ps.getLocation().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?location)), \""+ ps.getLocation().toLowerCase() +"\")";
		String cost = ps.getCost().equals(-1.0)?"":"&& 		   CONTAINS(LCASE(STR(?cost)), \""+ ps.getCost().toString().toLowerCase() +"\")";
		String credits = ps.getCredits().equals(-1.0)?"":"&& 		   CONTAINS(LCASE(STR(?credit)), \""+ ps.getCredits().toString().toLowerCase() +"\")";
		String duration = ps.getDuration().equals(-1)?"":"&& 		   CONTAINS(LCASE(STR(?duration)), \""+ ps.getDuration().toString().toLowerCase() +"\")";
		String language = ps.getLanguage().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?language)), \""+ ps.getLanguage().toLowerCase() +"\")";
		String prerequisite = ps.getPrerequisite().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?prerequisite)), \""+ ps.getPrerequisite().toLowerCase() +"\")";


		String query = "SELECT DISTINCT ?s" 
				+" WHERE {"
				+" ?s <" + StringUtils.namespaceEcts + "DegreeUnitCode> ?id."
				+" ?s <" + StringUtils.namespaceEcts + "DegreeProgrammeTitle> ?name."
				+ conditionQualification
				+ conditionLocation
				+ conditionCost
				+ conditionCredits
				+ conditionDuration
				+ conditionLanguage
				+ conditionPrerequisite
				+ conditionContains
				+" FILTER (CONTAINS(LCASE(STR(?id)), \"" + ps.getId().toLowerCase() + "\") &&"
				+" 		   CONTAINS(LCASE(STR(?name)), \""+ ps.getTitle().toLowerCase() +"\")"
				+ qualification
				+ location
				+ cost
				+ credits
				+ duration
				+ language
				+ prerequisite
				+ ")}";
		System.out.println(query);
		ResultSet retVal = OntologyUtils.execSelect(StringUtils.URLquery, query);

		String degreeUnitCode="", degreeProgrammeTitle="", language1="", location1="", qualification1="",url="";
		Double credit = -1.0;
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();
		QuerySolution soln = null;


		while (retVal.hasNext()) {
			soln = retVal.next();
			degreeUnitCode = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
			results = query(degreeUnitCode, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("DegreeUnitCode"))
					degreeUnitCode = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("DegreeProgrammeTitle"))
					degreeProgrammeTitle = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("LanguageOfInstruction"))
					language1 = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Location"))
					location1 = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Qualification"))
					qualification1 = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
			}
			degreeProgrammes.add(new DegreeProgramme(degreeUnitCode, degreeProgrammeTitle, language1, location1, qualification1, credit, url));
		}
		return degreeProgrammes;
	}

	//courses
	@RequestMapping(method = RequestMethod.GET, value = "/searchCourses")
	public ArrayList<CourseUnit> searchCourses(@RequestParam("course") String course) {


		ArrayList<CourseUnit> courses = new ArrayList<CourseUnit>();
		System.out.println(course);
		ObjectMapper mapper = new ObjectMapper();
		CourseSearch cs = new CourseSearch();
		try {
			cs = mapper.readValue(course, CourseSearch.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String condititonType = cs.getType().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitType> ?type.";
		String conditionUnitLevel = cs.getUnitLevel().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitLevel> ?level.";
		String conditionYearOfStudy = cs.getYearOfStudy().equals(-1)?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitYearOfStudy> ?yearOfStudy.";
		String conditionCredits = cs.getCredits().equals(-1.0)?"":" ?s <" + StringUtils.namespaceEcts + "CourseCredit> ?credit.";
		String conditionDuration = cs.getDuration().equals(-1.0)?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitDuration> ?duration.";
		String conditionLanguage = cs.getLanguage().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitLanguageOfInstruction> ?language.";
		String conditionCost = cs.getCost().equals(-1.0)?"":" ?s <" + StringUtils.namespaceEcts + "CourseCost> ?cost.";
		String conditionTermPattern = cs.getTermPattern().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "CourseUnitTermPattern> ?termPattern.";

		String type = cs.getType().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?type)), \""+ cs.getType().toLowerCase() +"\")";
		String unitLevel = cs.getUnitLevel().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?level)), \""+ cs.getUnitLevel().toLowerCase() +"\")";
		String yearOfStudy = cs.getYearOfStudy().equals(-1)?"":"&& 		   CONTAINS(LCASE(STR(?yearOfStudy)), \""+ cs.getYearOfStudy().toString().toLowerCase() +"\")";
		String credits = cs.getCredits().equals(-1.0)?"":"&& 		   CONTAINS(LCASE(STR(?credit)), \""+ cs.getCredits().toString().toLowerCase() +"\")";
		String duration = cs.getDuration().equals(-1.0)?"":"&& 		   CONTAINS(LCASE(STR(?duration)), \""+ cs.getDuration().toString().toLowerCase() +"\")";
		String language = cs.getLanguage().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?language)), \""+ cs.getLanguage().toLowerCase() +"\")";
		String cost = cs.getCost().equals(-1.0)?"":"&& 		   CONTAINS(LCASE(STR(?cost)), \""+ cs.getCost().toString().toLowerCase() +"\")";
		String termPattern = cs.getTermPattern().equals("")?"":"&& 		   CONTAINS(LCASE(STR(?termPattern)), \""+ cs.getTermPattern().toLowerCase() +"\")";

	
		String query = "SELECT DISTINCT ?s" 
				+" WHERE {"
				+" ?s <" + StringUtils.namespaceEcts + "CourseUnitCode> ?id."
				+" ?s <" + StringUtils.namespaceEcts + "CourseUnitTitle> ?title."
				+ condititonType
				+ conditionUnitLevel
				+ conditionYearOfStudy
				+ conditionCredits
				+ conditionDuration
				+ conditionLanguage
				+ conditionCost
				+ conditionTermPattern
				+" FILTER (CONTAINS(LCASE(STR(?id)), \"" + cs.getId().toLowerCase() + "\") &&"
				+" 		   CONTAINS(LCASE(STR(?title)), \""+ cs.getTitle().toLowerCase() +"\")"
				+ type
				+ unitLevel
				+ yearOfStudy
				+ credits
				+ duration
				+ language
				+ cost
				+ termPattern
				+ ")}";
		System.out.println(query);
		ResultSet retVal = OntologyUtils.execSelect(StringUtils.URLquery, query);

		String courseUnitCode = "", courseUnitTitle = "", courseUnitType = "", courseUnitLevel = "", url = "";
		Double credit = -1.0;
		
		
		ArrayList<QueryResult> results = new ArrayList<QueryResult>();
		QuerySolution soln = null;		
		
		while (retVal.hasNext()) {
			soln = retVal.next();
			courseUnitCode = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
			results = query(courseUnitCode, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				if (queryResult2.getPredicate().equals("CourseUnitCode"))
					courseUnitCode = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitTitle"))
					courseUnitTitle = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitType"))
					courseUnitType = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitLevel"))
					courseUnitLevel = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseCredit"))
					credit = queryResult2.getObject().equals("")?-1.0:Double.valueOf(queryResult2.getObject());
			}
			courses.add(new CourseUnit(courseUnitCode, courseUnitTitle, courseUnitType, courseUnitLevel, credit, url));
		}
		return courses;
	}
}
