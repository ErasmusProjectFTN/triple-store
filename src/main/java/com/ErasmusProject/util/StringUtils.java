package com.ErasmusProject.util;

import org.apache.jena.rdf.model.RDFNode;
import java.util.ArrayList;

/**
 * Created by Komp on 13.2.2017.
 */
public class StringUtils {

    public static String URL = "http://localhost:3030/ds";
    public static String URLdataset = "http://localhost:3030/ds/data";
    public static String URLupdate = "http://localhost:3030/ds/update";
    public static String URLquery = "http://localhost:3030/ds/query";
    public static String namespace = "http://www.semanticweb.org/banevezilic/ontologies/2017/0/student#";
    public static String ontFile = "student.owl";
    public static String sparqlTemplate = "SELECT * WHERE{%s %s  %s FILTER(STRSTARTS(STR(%s), %s))}";

    public static String[] formFieldsShort = {"birthday", "countryOfBirth", "placeOfBirth",
                                         "gender", "citizenship", "streetAddress", "postalCode", "city",
                                         "country", "telephone", "email"};
    public static String[] formFieldsLong = {"surname", "firstName", "birthday", "countryOfBirth", "placeOfBirth",
            "gender", "citizenship", "streetAddress", "postalCode", "city",
            "country", "telephone", "email"};
    /**
     * Formats jena statements into SPARQL INSERT
     * @param template
     * @param statement - statement to be formated
     * @return
     */
    public static String createTripleFromStatement(String template, String statement)
    {
        String retVal = new String(template);
        String[] spo = statement.replace("[", "").replace("]","").replace(","," ").replace("\"","").split("  ");
        for(String part: spo)
        {
            retVal += "<" + part + ">" + " ";
        }
        retVal += ".}";
        return retVal;
    }

    /**
     * Formats SPARQL query results by removing namespace
     * @param x
     * @param y
     * @return
     */
    public static QueryResult parseResult(RDFNode x, RDFNode y, String parameter, QueryType qt, ArrayList<String> namespaces) {
        String strX = x.toString();
        String strY = y.toString();

        for (String ns : namespaces)
        {
            strX = strX.replace(ns,"");
            strY = strY.replace(ns,"");
        }

        QueryResult retVal = null;

        switch(qt)
        {
            case SUBJECT:
                retVal = new QueryResult(parameter, strX, strY);
                break;
            case PREDICATE:
                retVal = new QueryResult(strX, parameter, strY);
                break;
            case OBJECT:
                retVal = new QueryResult(strX, strY, parameter);
                break;
        }

        return retVal;
    }

}
