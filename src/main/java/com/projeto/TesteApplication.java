package com.projeto;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lowagie.text.pdf.codec.Base64.InputStream;


@SpringBootApplication
public class TesteApplication {

    public static void main(String[] args ){
        SpringApplication.run(TesteApplication.class, args);
        
          
        
        
        /*
        Class.forName("com.mysql.jdbc.Driver"); 
		Connection banco=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud/root/1234");
	   
	    
		
		InputStream relatorio=(InputStream) TesteApplication.class.getResourceAsStream("cliente.jasper");
		
		Map<String,Object> parametro=new LinkedHashMap<>();
		JasperPrint impressao = JasperFillManager.fillReport(relatorio,parametro,banco); 
		JRExporter exportar= new JRPdfExporter();
		exportar.setParameter(JRExporterParameter.JASPER_PRINT, impressao);
		exportar.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "relatorioClientes.pdf");
        exportar.exportReport();
        */
    }
}
