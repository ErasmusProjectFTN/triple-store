package com.ErasmusProject.rest;
import com.ErasmusProject.util.*;
import org.apache.jena.ontology.OntModel;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Created by Komp on 13.2.2017.
 */

@RestController
@RequestMapping("/student")
public class TripleStore {

    @PostConstruct
    public void initFuseki()
    {
        try {
            OntologyUtils.reloadModel(OntologyUtils.createOntModel(StringUtils.ontFile),StringUtils.URL);
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
                               @RequestParam("countryofBirth") String cob,
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
        try {
            String indName = name + surname;
            OntModel model = OntologyUtils.loadOntModel(StringUtils.URLdataset, StringUtils.namespace);
            model = OntologyUtils.addIndividual("Student", model, StringUtils.namespace, indName);
            model = OntologyUtils.addDatatypeProperty("birthday", model, StringUtils.namespace, indName, dob);
            model = OntologyUtils.addDatatypeProperty("countryOfBirth", model, StringUtils.namespace, indName, cob);
            model = OntologyUtils.addDatatypeProperty("placeOfBirth", model, StringUtils.namespace, indName, pob);
            model = OntologyUtils.addDatatypeProperty("gender", model, StringUtils.namespace, indName, gender);
            model = OntologyUtils.addDatatypeProperty("citizenship", model, StringUtils.namespace, indName, nat);
            model = OntologyUtils.addDatatypeProperty("streetAddress", model, StringUtils.namespace, indName, san);
            model = OntologyUtils.addDatatypeProperty("postalCode", model, StringUtils.namespace, indName, pcode);
            model = OntologyUtils.addDatatypeProperty("city", model, StringUtils.namespace, indName, city);
            model = OntologyUtils.addDatatypeProperty("country", model, StringUtils.namespace, indName, cor);
            model = OntologyUtils.addDatatypeProperty("telephone", model, StringUtils.namespace, indName, tel);
            model = OntologyUtils.addDatatypeProperty("email", model, StringUtils.namespace, indName, email);
            OntologyUtils.reloadModel(model, StringUtils.URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response("Hello", "World");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query")
    public ArrayList<QueryResult> queryStudents(@RequestParam("value") String val,
                              @RequestParam("type") QueryType type)
    {

        ArrayList<String> namespaces = new ArrayList<String>();
        ArrayList<QueryResult> retVal = null;
        namespaces.add(StringUtils.namespace);

        switch(type)
        {
            case SUBJECT:
                String subject = "<" + StringUtils.namespace + val + ">";
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,subject,"?p","?o","?p","\""+StringUtils.namespace+"\""), namespaces, type, val);
                break;
            case PREDICATE:
                String predicate = "<" + StringUtils.namespace + val + ">";
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s",predicate,"?o","?s","\""+StringUtils.namespace+"\""), namespaces, type, val);
                break;
            case OBJECT:
                retVal = OntologyUtils.formatedSelect(StringUtils.URLquery, String.format(StringUtils.sparqlTemplate,"?s","?p","\"" + val + "\"","?p","\""+StringUtils.namespace+"\""), namespaces, type, val);
                break;
        }

        return retVal;
    }

}
