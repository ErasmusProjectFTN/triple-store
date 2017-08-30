package com.ErasmusProject.rest;
import com.ErasmusProject.model.Institution;
import com.ErasmusProject.model.Student;
import com.ErasmusProject.recommendation.DegreeProgrammeRecommendation;
import com.ErasmusProject.recommendation.DegreeProgrammeRecommendation.SimilarityValue;
import com.ErasmusProject.util.*;
import com.ErasmusProject.util.ResponseSignInFlag.Flag;

import org.apache.jena.base.Sys;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.engine.QueryEngineRegistry;
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
            Model application = OntologyUtils.createOntModel(StringUtils.applicationFile);
            ects.add(student);
            ects.add(application);
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
                               @RequestParam("email") String email,
    						   @RequestParam("password") String password)
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
				+ "						  student:password \"" + password + "\" ;"
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
        return new Response(token, name + " " + surname);
    }
    
    // TODO: check if password and username are correct
    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public ResponseSignInFlag signIn(@RequestParam("username") String username,
	                      			@RequestParam("password") String password) throws Exception
    {
    	String query = 
    			"PREFIX student: <" + StringUtils.namespaceStudent + "> "
    		+	"SELECT ?subject ?predicate ?object "
    		+	"WHERE {"
    		+	"  ?subject student:email \"" + username + "\""
    		+	"}";
    	
    	System.out.println(query);
    	
		ResultSet retVal = OntologyUtils.execSelect(StringUtils.URLquery, query);

    	System.out.println(retVal);
    	ArrayList<QueryResult> results = new ArrayList<QueryResult>();
		QuerySolution soln = null;
		String studentId = "";
		String pass = "";
		Student student = new Student();
		while (retVal.hasNext()) {
			soln = retVal.next();
			studentId = soln.get("subject").toString().replaceAll(StringUtils.namespaceStudent, "");
			student.setId(studentId);    	
			results = queryStudents(studentId, QueryType.SUBJECT);
			for (QueryResult queryResult2 : results) {
				System.out.println(queryResult2.getPredicate());
				if (queryResult2.getPredicate().equals("password"))
					pass = queryResult2.getObject();
				else if (queryResult2.getPredicate().equals("surname"))
					student.setSurname(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("name"))
					student.setName(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("gender"))
					student.setGender(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("country"))
					student.setCountry(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("placeOfBirth"))
					student.setPlaceOfBirth(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("countryOfBirth"))
					student.setCountryOfBirth(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("city"))
					student.setCity(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("telephone"))
					student.setTelephoneNumber(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("email"))
					student.setEmail(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("postalCode"))
					student.setPostalCode(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("birthday"))
					student.setDateOfBirth(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("streetAddress"))
					student.setStreet(queryResult2.getObject());
				else if (queryResult2.getPredicate().equals("citizenship"))
					student.setNationality(queryResult2.getObject());
			}
		}
		
    	if (username.equals("admin"))
    		return new ResponseSignInFlag(Flag.ADMIN);
    	else if (pass.equals(password)){
    		ResponseSignInFlag rsf = new ResponseSignInFlag(Flag.STUDENT);
    		rsf.setStudent(student);
    		return rsf;
    	}
    	else throw new Exception("User does not exist");
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
