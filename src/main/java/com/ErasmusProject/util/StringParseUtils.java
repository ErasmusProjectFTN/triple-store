package com.ErasmusProject.util;

import org.apache.jena.rdf.model.RDFNode;
import java.util.ArrayList;

/**
 * Created by Komp on 13.2.2017.
 */
public class StringParseUtils {

    /**
     * Formats jena statements into SPARQL INSERT
     * @param template
     * @param statement - statement to be formated
     * @return
     */
    public static String createTripleFromStatement(String template, String statement)
    {
        String retVal = new String(template);
        String[] spo = statement.replace("[", "").replace("]","").replace(","," ").split("  ");
        for(String part: spo)
        {
            retVal += "<" + part + ">" + " ";
        }
        retVal += ".}";
        return retVal;
    }

    /**
     * Formats SPARQL query results by removing namespace
     * @param s - subject node
     * @param p - predicate node
     * @param o - object node
     * @return
     */
    public static QueryResult parseResult(RDFNode s, RDFNode p, RDFNode o, ArrayList<String> namespaces) {
        String subject = s.toString();
        String predicate = p.toString();
        String object = o.toString();

        for (String ns : namespaces)
        {
            subject = subject.replace(ns,"");
            predicate = predicate.replace(ns,"");
            object = object.replace(ns,"");
        }

        return new QueryResult(subject, predicate, object);
    }

}
