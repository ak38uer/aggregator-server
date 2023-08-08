package edu.itu.aggregator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static String ontFile = "C:\\Users\\Invest Service\\Documents\\AVK\\TEACH\\Magistr\\My_Mag\\Smnt_Web\\transport1.owl";
    public static String outFile = "C:\\Users\\Invest Service\\Documents\\AVK\\TEACH\\Magistr\\My_Mag\\Smnt_Web\\transport-out.owl";
    public static void main( String[] args ) throws FileNotFoundException
    {
        System.out.println( "Ontology modifier!" );
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        model.read(ontFile);
        for (ExtendedIterator<OntClass> i = model.listClasses(); i.hasNext();) {
            OntClass c = i.next();
            System.out.println(c.getLocalName());
        };
        FileOutputStream out = new FileOutputStream(outFile);
        model.write(out);
    }
}
