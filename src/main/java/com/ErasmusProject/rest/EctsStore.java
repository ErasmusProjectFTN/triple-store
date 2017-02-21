package com.ErasmusProject.rest;

import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.QueryResult;
import com.ErasmusProject.util.QueryType;
import com.ErasmusProject.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Komp on 21.2.2017.
 */
@RestController
@RequestMapping("/ects")
public class EctsStore {

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
