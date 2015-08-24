package jena;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class VeiculosSPARQL {

	  private static QueryExecution consulta;
      private static ResultSet results;

      public static ResultSet  sparql (VeiculosBean veiculos) throws IOException {

              InputStream input = new FileInputStream(new File("C:/Users/Thais/Downloads/IA - Final/dbrf2.owl"));
              Model model = ModelFactory.createDefaultModel();
              model.read(input,null,"RDF/XML");
              input.close();
              
              System.out.println("ANO = "+veiculos.getAno());
              System.out.println("COR = "+veiculos.getCor());
              System.out.println("MODELO = "+veiculos.getModelo());
              System.out.println("PORTAS = "+veiculos.getPortas());
              System.out.println("PRECO = "+veiculos.getPreco());
              System.out.println("MONTADORA = "+veiculos.getMontadora());
              
              String queryString3 = 
            		  "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
              		+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
              		+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
              		+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
              		+ "PREFIX ia: <http://www.semanticweb.org/gcarvalho/ontologies/2014/9/ia#>"
              		+ "SELECT  ?nome ?cor"
              		+ "WHERE { ?ia rdf:type ia:Veiculos."
              		+ "?ia    ia:ano   ?ano."
              		+ "?ia   ia:cor   ?cor."
              		+ "?ia   ia:nome  ?nome."
              		+ "?ia   ia:valor ?valor."
              		+ "?ia   ia:portas ?portas."
              		+ "?ia   ia:modelo ?modelo."
              		+ "?ia   ia:montadora ?montadora."
            	    +  "FILTER regex(?ano,'"+veiculos.getAno()+"')"
              		+ "FILTER regex(?cor,'"+veiculos.getCor()+"')"
              		+ "FILTER regex(?valor,'"+veiculos.getPreco()+"')"	
              		+ "FILTER regex(?montadora,'"+veiculos.getMontadora()+"')"
              		+ "FILTER regex(?modelo,'"+veiculos.getModelo()+"')"
              		+ "FILTER regex(?portas,'"+veiculos.getPortas()+"')" 
              		+ "}";
              		
              Query query = QueryFactory.create(queryString3);
              consulta = QueryExecutionFactory.create(query, model);
              results = consulta.execSelect();
              return results;
      }
      public static void close(){
          consulta.close();
      }
}
