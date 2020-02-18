package com.ecommerce.main.business;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.antlr.stringtemplate.StringTemplate;
//import org.antlr.stringtemplate.StringTemplateGroup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//import org.xhtmlrenderer.pdf.ITextRenderer;

import com.ecommerce.main.dao.PdfBillData;
import com.ecommerce.main.dao.PdfBillDetail;
import com.ecommerce.main.entities.Detallefactura;
import com.ecommerce.main.entities.Factura;

import static org.thymeleaf.templatemode.TemplateMode.HTML;



public class BillToPdf {
	
	@Autowired
	InvoicePDF invoice;
	
	private static final String FILE_NAME = "invoice"; 
	
	public ResponseEntity<InputStreamResource> generateBillPDF(Factura fact, Collection<Detallefactura> detail) {
		
		PdfBillData data = getData(fact, detail);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", data);
		
		try {
			InputStreamResource resource = invoice.html2PdfGenerator(dataMap, "Invoice");
			if(resource != null) {
				MediaType mediaType = MediaType.parseMediaType("application/pdf");
				return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + FILE_NAME)
				// Content-Type
				.contentType(mediaType)
				.body(resource);
			} else {
				return new ResponseEntity(HttpStatus.CREATED);
			}
		} catch(NullPointerException nullExc) {
			System.out.println(nullExc);
			return new ResponseEntity(HttpStatus.CREATED);
		}
	
		/*ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(HTML);
		
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		
		Context context = new Context();
		context.setVariable("data", data);
		
		// Get the plain HTML with the resolved ${name} variable!
		String html = templateEngine.process("Invoice", context);
		*/
		
		/*try {
			OutputStream outputStream = new FileOutputStream("message.pdf");
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public PdfBillData getData(Factura fact, Collection<Detallefactura> detail) {
		PdfBillData bill = 
				new PdfBillData(fact.getFactId().toString(), fact.getFactFecha().toString(), 
							fact.getFactEstado(), fact.getUserId().getUserNombre(), "");
		List<PdfBillDetail> det = getBillDetail(detail);
		bill.setDet(det);
		bill.setTotal( calculateTotal(fact.getDetallefacturaCollection()).toString() ); 
		
		return bill;
	}
	
	private List<PdfBillDetail> getBillDetail(Collection<Detallefactura> collection) {
		List<PdfBillDetail> details = new ArrayList<PdfBillDetail>();
		for(Detallefactura det: collection) {
			
			PdfBillDetail pdfDet = 
					new PdfBillDetail(det.getProdId().getProdId().toString(), det.getProdId().getProdNombre(), 
								det.getDetfactCantidad().toString(), det.getProdId().getProdPrecio().toString(), det.getDetfactValor().toString());
			details.add(pdfDet);
		}
		return details;
	}
	
	private Double calculateTotal(Collection<Detallefactura> detail) {
		if (detail != null && !detail.isEmpty()) {
			Double tot = detail.stream().mapToDouble(Detallefactura::getDetfactValor).sum();
			return tot;
		}
		return 0D;
	}
	
	/*private StringTemplate getStringTemplate() {
		final StringTemplateGroup group = new StringTemplateGroup("Generators");
		return group.getInstanceOf("Invoice");
	}*/
}
