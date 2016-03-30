package com.projeto.jasper;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsxView;

@Controller
public class JasperController {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext appContext;

	@RequestMapping("/excel/clientes")
	public ModelAndView generateXlsxfReport() {	
		
		final JasperReportsXlsxView view = new JasperReportsXlsxView();
		view.setUrl("classpath:clientes.jrxml");
		view.setJdbcDataSource(dataSource);
		view.setApplicationContext(appContext);
		Map<String, Object> params = new HashMap<>();
		return new ModelAndView(view, params);
	}
	
	
	
	
	
	
	@RequestMapping("/clientes")
	public ModelAndView generateReport() {	
		
		final JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:clientes.jrxml");
		view.setJdbcDataSource(dataSource);
		view.setApplicationContext(appContext);
		Map<String, Object> params = new HashMap<>();
		return new ModelAndView(view, params);
	}
	
	
}
