package com.ErasmusProject.rest;

import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.QueryResult;
import com.ErasmusProject.util.QueryType;
import com.ErasmusProject.util.ResponseCourseInstance;
import com.ErasmusProject.util.ResponseCourseSpecification;
import com.ErasmusProject.util.ResponseInstitution;
import com.ErasmusProject.util.ResponseProgrammeInstance;
import com.ErasmusProject.util.ResponseProgrammeSpecification;
import com.ErasmusProject.util.StringUtils;

import org.apache.jena.ontology.OntModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

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
	

    @RequestMapping(method = RequestMethod.GET, value = "/query")
    public ArrayList<QueryResult> queryStudents(@RequestParam("value") String val,
                                                @RequestParam("type") QueryType type)
    {

        ArrayList<String> namespaces = new ArrayList<String>();
        ArrayList<QueryResult> retVal = null;
        namespaces.add(StringUtils.namespaceEcts);
        namespaces.add(StringUtils.namespaceStudent);
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
}
