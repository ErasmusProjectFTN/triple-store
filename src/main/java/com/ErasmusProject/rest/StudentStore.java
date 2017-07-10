package com.ErasmusProject.rest;
import com.ErasmusProject.recommendation.DegreeProgrammeRecommendation;
import com.ErasmusProject.recommendation.DegreeProgrammeRecommendation.SimilarityValue;
import com.ErasmusProject.util.*;
import org.apache.jena.base.Sys;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.UUID;


/**
 * Created by Komp on 13.2.2017.
 */

@RestController
@RequestMapping("/student")
public class StudentStore {

    @Autowired
    private Conf conf;
    
    public static HashMap<String, SimilarityValue> similarityMatrix = new HashMap<>();


    @PostConstruct
    public void initFuseki()
    {
        System.out.println("\n\n"+conf.getInitialize()+"\n\n");
        if(!conf.getInitialize()) return;
        System.out.println("\n\nPROSAO\n\n");
        try {
            Model student = OntologyUtils.createOntModel(StringUtils.studentFile);
            Model ects = OntologyUtils.createOntModel(StringUtils.ectsFile);
            ects.add(student);
            OntologyUtils.reloadModel(ects,StringUtils.URL);
            
            // create similarity matrix
            
            DegreeProgrammeRecommendation dpr = new DegreeProgrammeRecommendation();
            similarityMatrix = dpr.generateSimilarityMatrix();
            System.out.println(similarityMatrix);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(QueryType.class, new QueryTypeConverter());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Response addStudent(@RequestParam("surname") String surname,
                               @RequestParam("name") String name,
                               @RequestParam("dateOfBirth") String dob,
                               @RequestParam("countryOfBirth") String cob,
                               @RequestParam("placeOfBirth") String pob,
                               @RequestParam("gender") String gender,
                               @RequestParam("nationality") String nat,
                               @RequestParam("streetAndNumber") String san,
                               @RequestParam("postalCode") String pcode,
                               @RequestParam("city") String city,
                               @RequestParam("country") String cor,
                               @RequestParam("telephone") String tel,
                               @RequestParam("email") String email)
    {
    	String token = UUID.randomUUID().toString();
		String query = "PREFIX student: <" + StringUtils.namespaceStudent + ">"
				+ "INSERT DATA"
				+ "{"
				+ " student:" + token + " student:birthday \"" + dob + "\" ;"
				+ "						  student:countryOfBirth \"" + cob + "\" ;"
				+ "						  student:placeOfBirth \"" + pob + "\" ;"
				+ "						  student:gender \"" + gender + "\" ;"
				+ "						  student:citizenship \"" + nat + "\" ;"
				+ "						  student:streetAddress \"" + san + "\" ;"
				+ "						  student:postalCode \"" + pcode + "\" ;"
				+ "						  student:city \"" + city + "\" ;"
				+ "						  student:country \"" + cor + "\" ;"
				+ "						  student:telephone \"" + tel + "\" ;"
				+ "						  student:email \"" + email + "\" ;"
				+ "						  student:name \"" + name + "\" ;"
				+ "						  student:surname \"" + surname + "\" ."
				+ "}";

		System.out.println(query);
		try{
			OntologyUtils.execUpdate(StringUtils.URLupdate, query);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		/*
		String indName = name + surname;
		OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset, StringUtils.namespaceStudent);
		model = OntologyUtils.addIndividual("Student", model, StringUtils.namespaceStudent, indName);
		model = OntologyUtils.addDatatypeProperty("birthday", model, StringUtils.namespaceStudent, indName, dob);
		model = OntologyUtils.addDatatypeProperty("countryOfBirth", model, StringUtils.namespaceStudent, indName, cob);
		model = OntologyUtils.addDatatypeProperty("placeOfBirth", model, StringUtils.namespaceStudent, indName, pob);
		model = OntologyUtils.addDatatypeProperty("gender", model, StringUtils.namespaceStudent, indName, gender);
		model = OntologyUtils.addDatatypeProperty("citizenship", model, StringUtils.namespaceStudent, indName, nat);
		model = OntologyUtils.addDatatypeProperty("streetAddress", model, StringUtils.namespaceStudent, indName, san);
		model = OntologyUtils.addDatatypeProperty("postalCode", model, StringUtils.namespaceStudent, indName, pcode);
		model = OntologyUtils.addDatatypeProperty("city", model, StringUtils.namespaceStudent, indName, city);
		model = OntologyUtils.addDatatypeProperty("country", model, StringUtils.namespaceStudent, indName, cor);
		model = OntologyUtils.addDatatypeProperty("telephone", model, StringUtils.namespaceStudent, indName, tel);
		model = OntologyUtils.addDatatypeProperty("email", model, StringUtils.namespaceStudent, indName, email);
		OntologyUtils.reloadModel(model, StringUtils.URL);
		**/
        return new Response(token, name + " " + surname);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query")
    public ArrayList<QueryResult> queryStudents(@RequestParam("value") String val,
                              @RequestParam("type") QueryType type)
    {

        ArrayList<String> namespaces = new ArrayList<String>();
        ArrayList<QueryResult> retVal = null;
        namespaces.add(StringUtils.namespaceStudent);

        switch(type)
        {
            case SUBJECT:
                String subject = "<" + StringUtils.namespaceStudent + val + ">";
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,subject,"?p","?o","?p","\""+StringUtils.namespaceStudent +"\""), namespaces, type, val);
                break;
            case PREDICATE:
                String predicate = "<" + StringUtils.namespaceStudent + val + ">";
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s",predicate,"?o","?s","\""+StringUtils.namespaceStudent +"\""), namespaces, type, val);
                break;
            case OBJECT:
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s","?p","\"" + val + "\"","?p","\""+StringUtils.namespaceStudent +"\""), namespaces, type, val);
                break;
        }

        return retVal;
    }

}
