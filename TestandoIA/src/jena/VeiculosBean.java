package jena;

public class VeiculosBean {
		private String	ano;
		private String  cor;
		private String  modelo;
		private String  montadora;
		private String  portas;
		private String  preco;
		
		
		public String getAno()
		{
			return ano;
		} 

		public void setAno(String valor)
		{
			int ano;
			System.out.println(valor);
			ano = Integer.parseInt(valor);
			 if(ano>=1990 && ano<=1999)
				 this.ano = "noventa";
				else if(ano>=1980 && ano<=1989)
					 this.ano = "oitenta";
				else if(ano>=1970 && ano<=1979)
					 this.ano = "setenta";
				else if(ano>=1960 && ano<=1969)
				 this.ano = "sessenta";
				else if(ano<1968)
					 this.ano ="antigo";
				else if(ano>=2000 && ano<=2014)
					 this.ano = "doismil";
			
		}
		
		public String getCor()
		{
			return cor;
		} 

		public void setCor(String cor)
		{
			 this.cor = cor;
		}
		
		public String getModelo() {
	        return modelo;
	    }

	    public void setModelo(String modelo) {
	        this.modelo = modelo;
	    }
	    
		public String getMontadora() {
	        return montadora;
	    }

	    public void setMontadora(String montadora) {
	        this.montadora = montadora;
	    }
	    
	    public String getPortas() {
	        return portas;
	    }

	    public void setPortas(String portas)
	    {
	    	int valor;
	    	valor = Integer.parseInt(portas);
	    	if( valor <= 2)
	          this.portas = "duas";
	    	else if( valor >= 4)
	    	  this.portas = "quatro";	
	    }
	    
	    public String getPreco() {
	        return preco;
	    }

	    public void setPreco(String preco) 
	    {	
	    	int valor;
	    	valor = Integer.parseInt(preco);
	    	System.out.println("valor"+valor);
	        if(valor < 20000)
	        		this.preco = "baixo";
	        else if ( valor >= 20000 && valor < 60000)
	        		this.preco = "medio";
	        else if ( valor >= 60000 && valor < 100000)
	        	   this.preco = "alto";
   	
	    }




}
