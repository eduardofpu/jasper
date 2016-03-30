package com.projeto.Controle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.projeto.TesteApplication;
import com.projeto.Entity.Cidade;
import com.projeto.Repositorio.RepositorioCidade;
import com.projeto.Repositorio.RepositorioEstado;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperDesignViewer;
@Controller
public class ControlerCidade {
	@Autowired
	RepositorioCidade repositorioCidade;
	
	@Autowired
	RepositorioEstado repositorioEstado;
	
	
	@RequestMapping(value="/cidade")
	public String listarCidades(Cidade cidade,Model model){
		
		model.addAttribute("cidades",repositorioCidade.findAll());
		model.addAttribute("estados",repositorioEstado.findAllOrderByNome());
		
		if(cidade.getIdCidade()!=null){
			
			model.addAttribute("cidade",repositorioCidade.findOne(cidade.getIdCidade()));
			
			
		}else{
			model.addAttribute("cidade",new Cidade());
			
		}
		
		return "cidade";
	}
	
	
	@RequestMapping(value="/cidade/salve")
	public String salvarCidade(Cidade cidade){
		repositorioCidade.save(cidade);
		return "redirect:/cidade";
	}
	
	
	@RequestMapping(value="/cidade/del")
	public String deletarCidade(Cidade cidade){
		repositorioCidade.delete(cidade);
		return "redirect:/cidade";
	}
	
	/*
	
	@RequestMapping(value="/jrreport",method = RequestMethod.GET)
	public void relatorio() throws Exception{ 
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection banco=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","1234");
	   
	    
		
		InputStream relatorio=(InputStream) TesteApplication.class.getResourceAsStream("cliente.jrxml");
		
		ByteArrayOutputStream relatorioOutputCompilar=new ByteArrayOutputStream();
		JasperCompileManager.compileReportToStream(relatorio,relatorioOutputCompilar);
		byte[] compilarData=relatorioOutputCompilar.toByteArray();
		relatorioOutputCompilar.close();
		
		Map<String,Object> parametro=new LinkedHashMap<>();
		JasperPrint impressao = JasperFillManager.fillReport(new ByteArrayInputStream(compilarData),parametro,banco); 
		JRExporter exportar= new JRPdfExporter();
		exportar.setParameter(JRExporterParameter.JASPER_PRINT, impressao);
		exportar.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "relatorioClientes.pdf");
        exportar.exportReport();
        	
		
	}
		
	*/
	
		
	
	
	/*
	@RequestMapping(value="/jrreport")
	public void relatorio() throws SQLException{
		ConectaBanco conex=new ConectaBanco();
		Connection resp;
		
		 resp=(Connection) conex.conectaMysql("crud"); 
		 conex.ExecutaSql("select * from cidade");
		 
		// boolean rs = agendaRepositorio.equals(agenda);
		 try{
			  
		        JRResultSetDataSource relatResult = new JRResultSetDataSource(conex.resultset);
		        JasperPrint jpPrint = JasperFillManager.fillReport("D:/Guilherme/teste/teste/cidade.jasper",new HashMap(),relatResult);
		        JasperViewer jv = new JasperViewer(jpPrint,false);
		        jv.setVisible(true);
		        jv.toFront();
		        }catch(JRException ex){
		            
		            JOptionPane.showMessageDialog(null,"Erro ao chamar o relatório!Erro:"+ex);
		        } 


	    	
		}
	*/

}
