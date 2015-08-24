package jena;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
	 /**
     * 
     */
    private static final long serialVersionUID = 1L;


    
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException { }
  

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	
	out.println("<b>[1] Carregando dados da ontologia...</b></br>");
    response.setContentType("text/html");
    out.println("<b>[2] Carregando dados do usuário...</b></br>");
    VeiculosBean model = new VeiculosBean();
    
    model.setAno( request.getParameter("txtAno") );
    model.setCor( request.getParameter("txtCor"));
    model.setModelo(request.getParameter("txtModelo"));
    model.setMontadora(request.getParameter("txtMontadora"));
    model.setPortas(request.getParameter("txtPortas"));
    model.setPreco(request.getParameter("txtPreco"));
    
   ResultSet result = jena.VeiculosSPARQL.sparql( model );
   out.println("<b>[3] Obtendo resposta da consulta SPARQL... </b></br>");
   String s = null;
   
   s = ResultSetFormatter.asXMLString(result);
   out.println("<b>[4] VEICULOS RECOMENDÁVEL : \n<b><br>"+ s +"<br>");
   jena.VeiculosSPARQL.close();
   response.setContentType("text/html");
    }
}
