package com.ecommerce.main.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.itextpdf.html2pdf.HtmlConverter;

@Component("factura")
public class InvoicePDF {
	
	private final TemplateEngine templateEngine;

	
	public InvoicePDF(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	public InputStreamResource html2PdfGenerator(Map<String, Object> data, String fileName) {

	Context context = new Context();
	context.setVariables(data);
	final String html = templateEngine.process("Invoice", context);


	FileOutputStream os = null;

	try {

	final File outputFile = File.createTempFile(fileName, ".pdf");
	os = new FileOutputStream(outputFile);

	HtmlConverter.convertToPdf(html, new FileOutputStream(outputFile));
	return new InputStreamResource(new FileInputStream(outputFile));

	} catch (IOException e) {

	return null;
	}
	}
}
