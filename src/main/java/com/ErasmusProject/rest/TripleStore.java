package com.ErasmusProject.rest;
import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.Response;
import com.ErasmusProject.util.StringUtils;
import org.apache.jena.ontology.OntModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Created by Komp on 13.2.2017.
 */

@RestController
@RequestMapping("/add")
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

    @RequestMapping(method = RequestMethod.POST, value = "/student")
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
            model = OntologyUtils.addIndividual("Student", model, StringUtils.namespace);
            model = OntologyUtils.addDatatypeProperty("birthday", model, StringUtils.namespace, indName, dob);
            model = OntologyUtils.addDatatypeProperty("countryofBirth", model, StringUtils.namespace, indName, cob);
            model = OntologyUtils.addDatatypeProperty("placeOfBirth", model, StringUtils.namespace, indName, pob);
            model = OntologyUtils.addDatatypeProperty("gender", model, StringUtils.namespace, indName, gender);
            model = OntologyUtils.addDatatypeProperty("citizenchip", model, StringUtils.namespace, indName, nat);
            model = OntologyUtils.addDatatypeProperty("streetAddress", model, StringUtils.namespace, indName, san);
            model = OntologyUtils.addDatatypeProperty("postalCode", model, StringUtils.namespace, indName, pcode);
            model = OntologyUtils.addDatatypeProperty("city", model, StringUtils.namespace, indName, city);
            model = OntologyUtils.addDatatypeProperty("country", model, StringUtils.namespace, indName, cor);
            model = OntologyUtils.addDatatypeProperty("telephone", model, StringUtils.namespace, indName, tel);
            model = OntologyUtils.addDatatypeProperty("email", model, StringUtils.namespace, indName, email);
            ArrayList<String> individualsForInsert = OntologyUtils.getIndividualsForInsert(model, OntologyUtils.createOntModel(StringUtils.ontFile), StringUtils.namespace);
            OntologyUtils.execMassUpdate(StringUtils.URLupdate, individualsForInsert);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response("Hello", "World");
    }

}
