package com.ErasmusProject.rest;

import com.ErasmusProject.model.CourseUnit;
import com.ErasmusProject.model.DegreeProgramme;
import com.ErasmusProject.model.Institution;
import com.ErasmusProject.model.InstitutionSearch;
import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.QueryResult;
import com.ErasmusProject.util.QueryType;
import com.ErasmusProject.util.ResponseCourseInstance;
import com.ErasmusProject.util.ResponseCourseSpecification;
import com.ErasmusProject.util.ResponseInstitution;
import com.ErasmusProject.util.ResponseProgrammeInstance;
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
	 * Dodavanje nove institucije
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
	
	/*
	 * Modifikovanje institucije
	 * */
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
	 * Uklanjanje institucije
	 * @param id institucije
	 * @return status uspesnosti
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
	 * Dodavanje specifikacije programa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addProgrammeSpecification")
	public ResponseProgrammeSpecification addProgrammeSpecification(  @RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
																	  @RequestParam(value="degreeProgrammeTitle", required=true) String degreeProgrammeTitle,
																	  @RequestParam(value="location", required=false, defaultValue="") String location,
																	  @RequestParam(value="qualification", required=false, defaultValue="") String qualification,
																	  @RequestParam(value="url", required=false, defaultValue="") String url,
																	  @RequestParam(value="credit", required=false, defaultValue="") String credit,
																	  @RequestParam(value="degreeProgrammeAccessToFurtherStudies", required=false, defaultValue="") String degreeProgrammeAccessToFurtherStudies,
																	  @RequestParam(value="degreeProgrammeEducationalAndProfessionalGoals", required=false, defaultValue="") String degreeProgrammeEducationalAndProfessionalGoals,
																	  @RequestParam(value="degreeProgrammeStructureDiagram", required=false, defaultValue="") String degreeProgrammeStructureDiagram)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("DegreeProgrammeSpecification", model, StringUtils.namespaceEcts, degreeUnitCode);
			model = OntologyUtils.addDatatypeProperty("DegreeUnitCode", model, StringUtils.namespaceEcts, degreeUnitCode, degreeUnitCode);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeTitle", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeTitle);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, degreeUnitCode, location);
			model = OntologyUtils.addDatatypeProperty("Qualification", model, StringUtils.namespaceEcts, degreeUnitCode, qualification);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, degreeUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("Credit", model, StringUtils.namespaceEcts, degreeUnitCode, credit);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeAccessToFurtherStudies", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeAccessToFurtherStudies);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeEducationAndProfessionalGoals", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeEducationalAndProfessionalGoals);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeStructureDiagram", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeStructureDiagram);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeSpecification(degreeUnitCode, degreeProgrammeTitle);
	}
	

	/*
	 * Modifikovanje specifikacije programa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyProgrammeSpecification")
	public ResponseProgrammeSpecification modifyProgrammeSpecification(@RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
																	  @RequestParam(value="degreeProgrammeTitle", required=false, defaultValue="") String degreeProgrammeTitle,
																	  @RequestParam(value="location", required=false, defaultValue="") String location,
																	  @RequestParam(value="qualification", required=false, defaultValue="") String qualification,
																	  @RequestParam(value="url", required=false, defaultValue="") String url,
																	  @RequestParam(value="credit", required=false, defaultValue="") String credit,
																	  @RequestParam(value="degreeProgrammeAccessToFurtherStudies", required=false, defaultValue="") String degreeProgrammeAccessToFurtherStudies,
																	  @RequestParam(value="degreeProgrammeEducationalAndProfessionalGoals", required=false, defaultValue="") String degreeProgrammeEducationalAndProfessionalGoals,
																	  @RequestParam(value="degreeProgrammeStructureDiagram", required=false, defaultValue="") String degreeProgrammeStructureDiagram)
		{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			Individual ind = model.getIndividual(StringUtils.namespaceEcts + degreeUnitCode);
			HashMap<String, String> propertyValues = new HashMap<>();
			propertyValues.put("DegreeProgrammeTitle", degreeProgrammeTitle);
			propertyValues.put("Location", location);
			propertyValues.put("Qualification", qualification);
			propertyValues.put("Url", url);
			propertyValues.put("Credit", credit);
			propertyValues.put("DegreeProgrammeAccessToFurtherStudies", degreeProgrammeAccessToFurtherStudies);
			propertyValues.put("DegreeProgrammeEducationAndProfessionalGoals", degreeProgrammeEducationalAndProfessionalGoals);
			propertyValues.put("DegreeProgrammeStructureDiagram", degreeProgrammeStructureDiagram);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeSpecification(degreeUnitCode, degreeProgrammeTitle);
	}
	
	
	
	/**
	 * Uklanjanje specifikacije programa
	 * @param degreeUnitCode id specifikacije programa
	 * @return status uspesnosti
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeDegreeSpecification")
	public String removeDegreeSpecification(@RequestParam(value = "degreeUnitCode", required=true) String degreeUnitCode)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("DegreeProgrammeSpecification", model, StringUtils.namespaceEcts, degreeUnitCode);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Degree programme specification with id: " + degreeUnitCode + " is removed.";
	}
	
	/*
	 * Dodavanje instance programa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addProgrammeInstance")
	public ResponseProgrammeInstance addProgrammeInstance(  @RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
															@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
															@RequestParam(value="departmentalEctsCoordinator", required=false, defaultValue="") String departmentalEctsCoordinator,
															@RequestParam(value="degreeProgrammeFinalExamination", required=false, defaultValue="") String degreeProgrammeFinalExamination,
															@RequestParam(value="location", required=false, defaultValue="") String location,
															@RequestParam(value="url", required=false, defaultValue="") String url,
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
			model = OntologyUtils.addDatatypeProperty("Prerequisite", model, StringUtils.namespaceEcts, degreeUnitCode, prerequisite);
			model = OntologyUtils.addDatatypeProperty("DepartmentalEctsCoordinator", model, StringUtils.namespaceEcts, degreeUnitCode, departmentalEctsCoordinator);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeFinalExamination", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeFinalExamination);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, degreeUnitCode, location);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, degreeUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("Places", model, StringUtils.namespaceEcts, degreeUnitCode, places);
			model = OntologyUtils.addDatatypeProperty("DegreeProgrammeExaminationAndAssessmentRegulations", model, StringUtils.namespaceEcts, degreeUnitCode, degreeProgrammeExaminationAndAssessmentRegulations);
			model = OntologyUtils.addDatatypeProperty("Start", model, StringUtils.namespaceEcts, degreeUnitCode, start);
			model = OntologyUtils.addDatatypeProperty("Duration", model, StringUtils.namespaceEcts, degreeUnitCode, duration);
			model = OntologyUtils.addDatatypeProperty("Cost", model, StringUtils.namespaceEcts, degreeUnitCode, cost);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeInstance(degreeUnitCode);
	}
	
	/*
	 * Modifikovanje instance programa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyProgrammeInstance")
	public ResponseProgrammeInstance modifyProgrammeInstance(@RequestParam(value="degreeUnitCode", required=true) String degreeUnitCode,
															@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
															@RequestParam(value="departmentalEctsCoordinator", required=false, defaultValue="") String departmentalEctsCoordinator,
															@RequestParam(value="degreeProgrammeFinalExamination", required=false, defaultValue="") String degreeProgrammeFinalExamination,
															@RequestParam(value="location", required=false, defaultValue="") String location,
															@RequestParam(value="url", required=false, defaultValue="") String url,
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
			propertyValues.put("Prerequisite", prerequisite);
			propertyValues.put("DepartmentalEctsCoordinator", departmentalEctsCoordinator);
			propertyValues.put("DegreeProgrammeFinalExamination", degreeProgrammeFinalExamination);
			propertyValues.put("Location", location);
			propertyValues.put("Url", url);
			propertyValues.put("Places", places);
			propertyValues.put("LanguageOfInstruction", languageOfInstruction);
			propertyValues.put("DegreeProgrammeExaminationAndAssessmentRegulations", degreeProgrammeExaminationAndAssessmentRegulations);
			propertyValues.put("Start", start);
			propertyValues.put("Duration", duration);
			propertyValues.put("Cost", cost);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseProgrammeInstance(degreeUnitCode);
	}
	
	/**
	 * Uklanjanje instance programa
	 * @param degreeUnitCode id instance programa
	 * @return status uspesnosti
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeDegreeInstance")
	public String removeDegreeInstance(@RequestParam(value = "degreeUnitCode", required=true) String degreeUnitCode)
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
	 * Dodavanje specifikacije kursa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addCourseSpecification")
	public ResponseCourseSpecification addCourseSpecification(  @RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
															@RequestParam(value="courseUnitTitle", required=true) String courseUnitTitle,
															@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
															@RequestParam(value="courseUnitLevel", required=false, defaultValue="") String courseUnitLevel,
															@RequestParam(value="url", required=false, defaultValue="") String url,
															@RequestParam(value="courseUnitYearOfStudy", required=false, defaultValue="") String courseUnitYearOfStudy,
															@RequestParam(value="credit", required=false, defaultValue="") String credit,
															@RequestParam(value="courseUnitContent", required=false, defaultValue="") String courseUnitContent,
															@RequestParam(value="courseLocation", required=false, defaultValue="") String courseLocation,
															@RequestParam(value="qualification", required=false, defaultValue="") String qualification)
	
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("CourseUnitSpecification", model, StringUtils.namespaceEcts, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("CourseUnitCode", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTitle", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTitle);
			model = OntologyUtils.addDatatypeProperty("CourseUnitType", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitType);
			model = OntologyUtils.addDatatypeProperty("CourseUnitLevel", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitLevel);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, courseUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("Credit", model, StringUtils.namespaceEcts, courseUnitCode, credit);
			model = OntologyUtils.addDatatypeProperty("CourseUnitContent", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitContent);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, courseUnitCode, courseLocation);
			model = OntologyUtils.addDatatypeProperty("Qualification", model, StringUtils.namespaceEcts, courseUnitCode, qualification);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseSpecification(courseUnitCode, courseUnitTitle);
	}
	
	/*
	 * Modifikovanje specifikacije kursa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyCourseSpecification")
	public ResponseCourseSpecification modifyCourseSpecification(@RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
																@RequestParam(value="courseUnitTitle", required=false, defaultValue="") String courseUnitTitle,
																@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
																@RequestParam(value="courseUnitLevel", required=false, defaultValue="") String courseUnitLevel,
																@RequestParam(value="url", required=false, defaultValue="") String url,
																@RequestParam(value="courseUnitYearOfStudy", required=false, defaultValue="") String courseUnitYearOfStudy,
																@RequestParam(value="credit", required=false, defaultValue="") String credit,
																@RequestParam(value="courseUnitContent", required=false, defaultValue="") String courseUnitContent,
																@RequestParam(value="courseLocation", required=false, defaultValue="") String courseLocation,
																@RequestParam(value="qualification", required=false, defaultValue="") String qualification)

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
			propertyValues.put("Credit", credit);
			propertyValues.put("CourseUnitContent", courseUnitContent);
			propertyValues.put("Location", courseLocation);
			propertyValues.put("Qualification", qualification);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseSpecification(courseUnitCode, courseUnitTitle);
	}
	
	/**
	 * Uklanjanje specifikacije kursa
	 * @param courseUnitCode id specifikacije kursa
	 * @return status uspesnosti
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCourseSpecification")
	public String removeCourseSpecification(@RequestParam(value = "courseUnitCode", required=true) String courseUnitCode)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("CourseUnitSpecification", model, StringUtils.namespaceEcts, courseUnitCode);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Degree course specification with id: " + courseUnitCode + " is removed.";
	}
	
	/*
	 * Dodavanje instance kursa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/addCourseInstance")
	public ResponseCourseInstance addCourseSpecification(  @RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
															@RequestParam(value="lecturer", required=false, defaultValue="") String lecturer,
															@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
															@RequestParam(value="places", required=false, defaultValue="") String places,
															@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
															@RequestParam(value="url", required=false, defaultValue="") String url,
															@RequestParam(value="courseUnitTermPattern", required=true, defaultValue="Semester") String courseUnitTermPattern,
															@RequestParam(value="courseUnitCompetence", required=false, defaultValue="") String courseUnitCompetence,
															@RequestParam(value="courseUnitLearningOutcome", required=false, defaultValue="") String courseUnitLearningOutcome,
															@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
															@RequestParam(value="courseUnitRecommendedReading", required=false, defaultValue="") String courseUnitRecommendedReading,
															@RequestParam(value="courseUnitTeachingMethods", required=false, defaultValue="") String courseUnitTeachingMethods,
															@RequestParam(value="courseUnitAssessmentMethods", required=false, defaultValue="") String courseUnitAssessmentMethods,
															@RequestParam(value="location", required=false, defaultValue="") String location,
															@RequestParam(value="start", required=false, defaultValue="") String start,
															@RequestParam(value="duration", required=false, defaultValue="") String duration,
															@RequestParam(value="cost", required=false, defaultValue="") String cost)
	
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.addIndividual("CourseUnitInstance", model, StringUtils.namespaceEcts, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("CourseUnitCode", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitCode);
			model = OntologyUtils.addDatatypeProperty("Lecturer", model, StringUtils.namespaceEcts, courseUnitCode, lecturer);
			model = OntologyUtils.addDatatypeProperty("LanguageOfInstruction", model, StringUtils.namespaceEcts, courseUnitCode, languageOfInstruction);
			model = OntologyUtils.addDatatypeProperty("Places", model, StringUtils.namespaceEcts, courseUnitCode, places);
			model = OntologyUtils.addDatatypeProperty("CourseUnitType", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitType);
			model = OntologyUtils.addDatatypeProperty("Url", model, StringUtils.namespaceEcts, courseUnitCode, url);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTermPattern", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTermPattern);
			model = OntologyUtils.addDatatypeProperty("CourseUnitCompetence", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitCompetence);
			model = OntologyUtils.addDatatypeProperty("CourseUnitLearningOutcome", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitLearningOutcome);
			model = OntologyUtils.addDatatypeProperty("Prerequisite", model, StringUtils.namespaceEcts, courseUnitCode, prerequisite);
			model = OntologyUtils.addDatatypeProperty("CourseUnitRecommendedReading", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitRecommendedReading);
			model = OntologyUtils.addDatatypeProperty("CourseUnitTeachingMethods", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitTeachingMethods);
			model = OntologyUtils.addDatatypeProperty("CourseUnitAssessmentMethods", model, StringUtils.namespaceEcts, courseUnitCode, courseUnitAssessmentMethods);
			model = OntologyUtils.addDatatypeProperty("Location", model, StringUtils.namespaceEcts, courseUnitCode, location);
			model = OntologyUtils.addDatatypeProperty("Start", model, StringUtils.namespaceEcts, courseUnitCode, start);
			model = OntologyUtils.addDatatypeProperty("Duration", model, StringUtils.namespaceEcts, courseUnitCode, duration);
			model = OntologyUtils.addDatatypeProperty("Cost", model, StringUtils.namespaceEcts, courseUnitCode, cost);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseInstance(courseUnitCode);
	}
	
	/*
	 * Modifikovanje instance kursa
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/modifyCourseInstance")
	public ResponseCourseInstance modifyCourseInstance(@RequestParam(value="courseUnitCode", required=true) String courseUnitCode,
														@RequestParam(value="lecturer", required=false, defaultValue="") String lecturer,
														@RequestParam(value="languageOfInstruction", required=false, defaultValue="") String languageOfInstruction,
														@RequestParam(value="places", required=false, defaultValue="") String places,
														@RequestParam(value="courseUnitType", required=false, defaultValue="") String courseUnitType,
														@RequestParam(value="url", required=false, defaultValue="") String url,
														@RequestParam(value="courseUnitTermPattern", required=true, defaultValue="Semester") String courseUnitTermPattern,
														@RequestParam(value="courseUnitCompetence", required=false, defaultValue="") String courseUnitCompetence,
														@RequestParam(value="courseUnitLearningOutcome", required=false, defaultValue="") String courseUnitLearningOutcome,
														@RequestParam(value="prerequisite", required=false, defaultValue="") String prerequisite,
														@RequestParam(value="courseUnitRecommendedReading", required=false, defaultValue="") String courseUnitRecommendedReading,
														@RequestParam(value="courseUnitTeachingMethods", required=false, defaultValue="") String courseUnitTeachingMethods,
														@RequestParam(value="courseUnitAssessmentMethods", required=false, defaultValue="") String courseUnitAssessmentMethods,
														@RequestParam(value="location", required=false, defaultValue="") String location,
														@RequestParam(value="start", required=false, defaultValue="") String start,
														@RequestParam(value="duration", required=false, defaultValue="") String duration,
														@RequestParam(value="cost", required=false, defaultValue="") String cost)

		{	
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			Individual ind = model.getIndividual(StringUtils.namespaceEcts + courseUnitCode);
			HashMap<String, String> propertyValues = new HashMap<>();
			propertyValues.put("Lecturer", lecturer);
			propertyValues.put("LanguageOfInstruction", languageOfInstruction);
			propertyValues.put("Places", places);
			propertyValues.put("CourseUnitType", courseUnitType);
			propertyValues.put("Url", url);
			propertyValues.put("CourseUnitTermPattern", courseUnitTermPattern);
			propertyValues.put("CourseUnitCompetence", courseUnitCompetence);
			propertyValues.put("CourseUnitLearningOutcome", courseUnitLearningOutcome);
			propertyValues.put("Prerequisite", prerequisite);
			propertyValues.put("CourseUnitRecommendedReading", courseUnitRecommendedReading);
			propertyValues.put("CourseUnitTeachingMethods", courseUnitTeachingMethods);
			propertyValues.put("CourseUnitAssessmentMethods", courseUnitAssessmentMethods);
			propertyValues.put("Location", location);
			propertyValues.put("Start", start);
			propertyValues.put("Duration", duration);
			propertyValues.put("Cost", cost);
			model = OntologyUtils.modifyIndividual(ind, model, propertyValues);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ResponseCourseInstance(courseUnitCode);
	}
	
	/**
	 * Uklanjanje instance kursa
	 * @param courseUnitCode id instance kursa
	 * @return status uspesnosti
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCourseInstance")
	public String removeCourseInstance(@RequestParam(value = "courseUnitCode", required=true) String courseUnitCode)
	{
		try{
			OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset,  StringUtils.namespaceEcts);
			model = OntologyUtils.removeIndividual("CourseUnitSpecification", model, StringUtils.namespaceEcts, courseUnitCode);
			OntologyUtils.reloadModel(model, StringUtils.URL);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "Degree course instance with id: " + courseUnitCode + " is removed.";
	}
	

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
        
        // get programme specification ids
        String query = "SELECT * WHERE{?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <" + StringUtils.namespaceEcts + "DegreeProgrammeSpecification>}";
        ResultSet results = OntologyUtils.execSelect(StringUtils.URLquery, query);
                
        String degreeUnitCode="", degreeProgrammeTitle="", language="", location="", qualification="",url="";
        Double credit = -1.0;
        ArrayList<DegreeProgramme> degreeProgrammes = new ArrayList<DegreeProgramme>();
        ArrayList<String> degreeProgrammeInstances = new ArrayList<>();
        // get programme specification data
        // get programme instance data
        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            String degreeProgramme = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
            retVal = query(degreeProgramme, QueryType.SUBJECT);
            degreeProgrammeInstances = new ArrayList<>();
            for (QueryResult queryResult2 : retVal) {
            	if (queryResult2.getPredicate().equals("DegreeUnitCode"))
					degreeUnitCode = queryResult2.getObject();
            	else if (queryResult2.getPredicate().equals("DegreeProgrammeTitle"))
					degreeProgrammeTitle = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Qualification"))
					qualification = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Credit") && !queryResult2.getObject().equals(""))
					credit = queryResult2.getObject().equals("")?-1:Double.parseDouble(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("specifies")){
					degreeProgrammeInstances.add(queryResult2.getObject());
				}
			}
            for (String degreeProgrammeInstanceName : degreeProgrammeInstances){
                retVal = query(degreeProgrammeInstanceName, QueryType.SUBJECT);
                for(QueryResult queryResult2 : retVal){
                	if (queryResult2.getPredicate().equals("DegreeUnitCode"))
    					degreeUnitCode = queryResult2.getObject();
    				else if (queryResult2.getPredicate().equals("LanguageOfInstruction"))
    					language = queryResult2.getObject();
    				else if (queryResult2.getPredicate().equals("Location"))
    					location = queryResult2.getObject();
    				else if (queryResult2.getPredicate().equals("Url")){
    					url = queryResult2.getObject();
    				}
                }
            	degreeProgrammes.add(new DegreeProgramme(degreeUnitCode, degreeProgrammeTitle, language, location, qualification, credit, url));	
    		}
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
    	ArrayList<String> namespaces = new ArrayList<String>();
        ArrayList<QueryResult> retVal = null;
        namespaces.add(StringUtils.namespaceEcts);
        namespaces.add(StringUtils.namespaceW3c);
        
        // get programme specification ids
        String query = "SELECT ?s WHERE {?s <" + StringUtils.namespaceEcts + "DegreeUnitCode> \""+programmeCode+"\"}";
        System.out.println(query);
        ResultSet result = OntologyUtils.execSelect(StringUtils.URLquery, query);
        System.out.println(result.hasNext());

        QuerySolution soln = result.next();
        System.out.println("-------------");
        System.out.println(soln.toString());
        System.out.println(soln.get("s").toString());
        System.out.println("-------------");
        String identifier = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
        
        String degreeUnitCode=programmeCode, degreeProgrammeTitle="", language="", location="", qualification="",url="",
	        	prerequisite="", departmentalECTScoordinator="",degreeProgrammeFinalExamination="", places="",
	        	degreeProgrammeExaminationAndAssessmentRegulations="",start="",duration="", cost="",
	        	degreeProgrammeAccessToFurtherStudies="",degreeProgrammeEducationalAndProessionalGoals="", degreeProgrammeStructureDiagram="";
        Double credit = -1.0;
        // get programme instance data
        retVal = query(identifier, QueryType.SUBJECT);
        for (QueryResult queryResult2 : retVal) {
        	System.out.println(queryResult2.getPredicate());
        	if (queryResult2.getPredicate().equals("DegreeProgrammeExaminationAndAssessmentRegulations"))
    			degreeProgrammeExaminationAndAssessmentRegulations = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("DegreeProgrammeFinalExamination"))
    			degreeProgrammeFinalExamination = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Cost"))
    			cost = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Duration"))
    			duration = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Start"))
    			start = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Location"))
    			location = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("DepartmentalEctsCoordinator"))
    			departmentalECTScoordinator = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Url"))
    			url = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("LanguageOfInstruction"))
    			language = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Places"))
    			places = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Prerequisite"))
    			prerequisite = queryResult2.getObject();
        }
        // get programme specification data
        String query2 = "SELECT ?s WHERE {?s <" + StringUtils.namespaceEcts + "specifies> <"+ StringUtils.namespaceEcts + identifier +">}";
        ResultSet result2 = OntologyUtils.execSelect(StringUtils.URLquery, query2);

        QuerySolution soln2 = result2.nextSolution();
        String programmeSpecificationIdentifier = soln2.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
        System.out.println(programmeSpecificationIdentifier);
        retVal = query(programmeSpecificationIdentifier, QueryType.SUBJECT);
        
        for (QueryResult queryResult2 : retVal) {
        	System.out.println(queryResult2.getPredicate());
        	if (queryResult2.getPredicate().equals("Credit"))
    			credit = queryResult2.getObject().equals("")?-1:Double.valueOf(queryResult2.getObject());
    		else if (queryResult2.getPredicate().equals("DegreeProgrammeAcccessToFurtherStudies"))
    			degreeProgrammeAccessToFurtherStudies = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("DegreeProgrammeEducationAndProfessionalGoals"))
    			degreeProgrammeEducationalAndProessionalGoals = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("DegreeProgrammeStructureDiagram"))
    			degreeProgrammeStructureDiagram = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("DegreeProgrammeTitle"))
    			degreeProgrammeTitle = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Location"))
    			location = location.equals("")?queryResult2.getObject():location;
    		else if (queryResult2.getPredicate().equals("Qualification"))
    			qualification = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Url"))
    			url = url.equals("")?queryResult2.getObject():url;
        }
        return new DegreeProgramme(degreeUnitCode, degreeProgrammeTitle, language, location,
					    			qualification, credit, url, prerequisite, departmentalECTScoordinator,
					    			degreeProgrammeFinalExamination, places,
					    			degreeProgrammeExaminationAndAssessmentRegulations, start, duration, cost,
					    			degreeProgrammeAccessToFurtherStudies, degreeProgrammeEducationalAndProessionalGoals,
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
        
        // get programme specification ids
        String query = "SELECT * WHERE{?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <" + StringUtils.namespaceEcts + "CourseUnitSpecification>}";
        ResultSet results = OntologyUtils.execSelect(StringUtils.URLquery, query);
                
        String courseUnitCode="", courseUnitTitle="", courseUnitType="", courseUnitLevel="", url="";
        Double credit = -1.0;
        ArrayList<CourseUnit> courseUnits = new ArrayList<CourseUnit>();
        ArrayList<String> courseUnitInstances = new ArrayList<>();
        // get course specification data
        // get course instance data
        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            String courseUnit = soln.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
            System.out.println(courseUnit);
            retVal = query(courseUnit, QueryType.SUBJECT);
            courseUnitInstances = new ArrayList<>();
            for (QueryResult queryResult2 : retVal) {
            	System.out.println(queryResult2.getSubject());
            	System.out.println(queryResult2.getPredicate());
            	System.out.println(queryResult2.getObject());
            	if (queryResult2.getPredicate().equals("CourseUnitTitle"))
					courseUnitTitle = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("CourseUnitLevel"))
					courseUnitLevel = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Credit") && !queryResult2.getObject().equals(""))
					credit = queryResult2.getObject().equals("")?-1:Double.parseDouble(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("specifies")){
					courseUnitInstances.add(queryResult2.getObject());
				}
			}
            for (String courseUnitInstanceName : courseUnitInstances){
                retVal = query(courseUnitInstanceName, QueryType.SUBJECT);
                for(QueryResult queryResult2 : retVal){

                	System.out.println(queryResult2.getSubject());
                	System.out.println(queryResult2.getPredicate());
                	System.out.println(queryResult2.getObject());
                	if (queryResult2.getPredicate().equals("CourseUnitCode"))
    					courseUnitCode = queryResult2.getObject();
    				else if (queryResult2.getPredicate().equals("CourseUnitType"))
    					courseUnitType = queryResult2.getObject();
    				else if (queryResult2.getPredicate().equals("Url")){
    					url = queryResult2.getObject();
    				}
                }
            	courseUnits.add(new CourseUnit(courseUnitCode, courseUnitTitle, courseUnitType, courseUnitLevel, credit, url));	
    		}
        }
        return courseUnits;
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
        System.out.println("-------------");
        System.out.println(soln.toString());
        System.out.println(soln.get("s").toString());
        System.out.println("-------------");
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
    	String duration = "";
    	String cost = "";
        Double credit = -1.0;
        
        // get programme instance data
        retVal = query(identifier, QueryType.SUBJECT);
        for (QueryResult queryResult2 : retVal) {
        	System.out.println(queryResult2.getPredicate());
        	if (queryResult2.getPredicate().equals("CourseUnitAssessmentMethods"))
    			courseUnitAssessmentMethods = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Cost"))
    			cost = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitRecommendedReading"))
    			courseUnitRecommendedReading = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitTeachingMethods"))
    			courseUnitTeachingMethods = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Start"))
    			start = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Duration"))
    			duration = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitTermPattern"))
    			courseUnitTermPattern = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("LanguageOfInstruction"))
    			languageOfInstruction = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Lecturer"))
    			lecturer = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Location"))
    			courseLocation = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitCompetence"))
    			courseUnitCompetence = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitLearningOutcome"))
    			courseUnitLearningOutcome = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Places"))
    			places = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Prerequisite"))
    			prerequisite = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitType"))
    			courseUnitType = queryResult2.getObject();
        }
        // get programme specification data
        String query2 = "SELECT ?s WHERE {?s <" + StringUtils.namespaceEcts + "specifies> <"+ StringUtils.namespaceEcts + identifier +">}";
        ResultSet result2 = OntologyUtils.execSelect(StringUtils.URLquery, query2);

        QuerySolution soln2 = result2.nextSolution();
        String courseSpecificationIdentifier = soln2.get("s").toString().replaceAll(StringUtils.namespaceEcts, "");
        System.out.println(courseSpecificationIdentifier);
        retVal = query(courseSpecificationIdentifier, QueryType.SUBJECT);
        
        for (QueryResult queryResult2 : retVal) {
        	System.out.println(queryResult2.getPredicate());
        	if (queryResult2.getPredicate().equals("CourseUnitTitle"))
    			courseUnitTitle = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Credit"))
    			credit = queryResult2.getObject().equals("")?-1:Double.valueOf(queryResult2.getObject());
    		else if (queryResult2.getPredicate().equals("CourseUnitLevel"))
    			courseUnitLevel = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitYearOfStudy"))
    			courseUnitYearOfStudy = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("Location"))
    			courseLocation = courseLocation.equals("")?queryResult2.getObject():courseLocation;
    		else if (queryResult2.getPredicate().equals("Qualification"))
    			qualification = queryResult2.getObject();
    		else if (queryResult2.getPredicate().equals("CourseUnitType"))
    			courseUnitType = courseUnitType.equals("")?queryResult2.getObject():courseUnitType;
    		else if (queryResult2.getPredicate().equals("Url"))
    			url = url.equals("")?queryResult2.getObject():url;
        }
        return new CourseUnit(courseUnitCode, courseUnitTitle, courseUnitType, courseUnitLevel,
    			credit, url, courseUnitYearOfStudy, courseUnitContent, courseLocation,
    			qualification, lecturer, languageOfInstruction, places,
    			courseUnitTermPattern, courseUnitCompetence, courseUnitLearningOutcome,
    			prerequisite, courseUnitRecommendedReading, courseUnitTeachingMethods,
    			courseUnitAssessmentMethods, start, duration, cost);
    }
    
    // search
    
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
    	String conditionAddress = insS.getLocation().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "InstitutionAddress> ?address.";
    	String conditionType = insS.getType().equals("")?"":" ?s <" + StringUtils.namespaceEcts + "InstitutionType> ?type.";
    	
    	String status = insS.getStatus().equals("")?"":"&& 		   CONTAINS(?status, \""+ insS.getStatus().toLowerCase() +"\")";
    	String address = insS.getLocation().equals("")?"":"&& 		   CONTAINS(?address, \""+ insS.getLocation().toLowerCase() +"\")";
    	String type = insS.getType().equals("")?"":"&& 		   CONTAINS(?type, \""+ insS.getType().toLowerCase() +"\")";
    	
        String query = "SELECT DISTINCT ?s" 
        		+" WHERE {"
        		+" ?s <" + StringUtils.namespaceEcts + "InstitutionCode> ?id."
        		+" ?s <" + StringUtils.namespaceEcts + "InstitutionName> ?name."
        		+ conditionStatus
        		+ conditionAddress
        		+ conditionType
        		+" FILTER (CONTAINS(LCASE(STR(?id)), \"" + insS.getId().toLowerCase() + "\") &&"
        		+" 		   CONTAINS(?name, \""+ insS.getName().toLowerCase() +"\")"
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
				else if (queryResult2.getPredicate().equals("InstitutionAddress"))
					institutionAddress = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("Url"))
					url = queryResult2.getObject();
			}
        	institutions.add(new Institution(identifier, institutionName, institutionStatus, institutionType, institutionAddress, url));
		}
    	
    	return institutions;
    }
}
