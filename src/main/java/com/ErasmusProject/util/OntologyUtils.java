package com.ErasmusProject.util;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Komp on 13.2.2017.
 */
public class OntologyUtils {

    /**
     * Creates OntModel from file
     *
     * @param file - ontology file
     * @return - returns the newly created OntModel
     */
    public static OntModel createOntModel(String file) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
        model.read(file);
        return model;
    }

    /**
     * Accesses Model in a dataset
     *
     * @param serviceURI - dataset location
     * @return - returns the deployed ontology model
     */
    public static Model getModel(String serviceURI) {
        DatasetAccessor accessor = DatasetAccessorFactory
                .createHTTP(serviceURI);
        return accessor.getModel();
    }

    /**
     * Transformes Model into OntModel
     *
     * @param serviceURI - dataset location
     * @param namespace  - ontology namespace
     * @return - returns OntModel
     * @throws IOException
     */
    public static OntModel loadOntModel(String serviceURI, String namespace) throws IOException {
        Model dm = getModel(serviceURI);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        dm.write(bos);
        ByteArrayInputStream ios = new ByteArrayInputStream(bos.toByteArray());
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
        model.read(ios, namespace);
        return model;
    }

    /**
     * Changes dataset model
     *
     * @param model
     * @param serviceURI
     * @throws IOException
     */
    public static void reloadModel(Model model, String serviceURI)
            throws IOException {
        DatasetAccessor accessor = DatasetAccessorFactory
                .createHTTP(serviceURI);
        accessor.putModel(model);
    }

    /**
     * Executes SPARQL update
     *
     * @param serviceURI
     * @param update     - update string
     */
    public static void execUpdate(String serviceURI, String update) {
        UpdateProcessor upp = UpdateExecutionFactory.createRemote(
                UpdateFactory.create(update),
                serviceURI);
        upp.execute();
    }

    /**
     * Creates a list of SPARQL insert statements, for each individual
     * @param m1 - OntModel with added individuals
     * @param m2 - default OntModel
     * @param namespace - ontology namespace
     * @return - returns a list of SPARQL insert statements
     */
    public static ArrayList<String> getIndividualsForInsert(OntModel m1, OntModel m2, String namespace)
    {
        String insert_template = "INSERT DATA"
                + "{ ";
        ArrayList<String> retVal = new ArrayList<String>();
        Model om2 = m1.difference(m2);
        StmtIterator it = om2.listStatements();
        while(it.hasNext())
        {
            retVal.add(StringParseUtils.createTripleFromStatement(insert_template,it.next().toString()));
        }
        return retVal;
    }

    /**
     * Executes SPARQL query and formats results, by removing namespaces
     * @param serviceURI
     * @param query
     * @param namespaces - list of namespaces used by the ontology
     * @return
     */
    public static ArrayList<QueryResult> execSelectAndReturn(String serviceURI, String query, ArrayList<String> namespaces) {
        QueryExecution q = QueryExecutionFactory.sparqlService(serviceURI,
                query);
        ResultSet results = q.execSelect();

        ArrayList<QueryResult> retVal = new ArrayList<QueryResult>();

        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            RDFNode x = soln.get("x");
            RDFNode r = soln.get("r");
            RDFNode y = soln.get("y");
            retVal.add(StringParseUtils.parseResult(x,r,x,namespaces));

        }

        return retVal;
    }


}
