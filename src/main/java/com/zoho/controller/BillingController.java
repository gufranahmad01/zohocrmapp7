package com.zoho.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.DocumentException;
import com.zoho.entities.Billing;
import com.zoho.entities.Contact;
import com.zoho.pdf.PDFGenerate;
import com.zoho.pdf.UserPDFExporter;
import com.zoho.service.BillingService;
import com.zoho.service.ContactService;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	 @Autowired
	 private PDFGenerate service;
	
	@RequestMapping("/billingForm")
	public String showCreateBillForm(@RequestParam("contactId") long id,Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "create_bill";
	}
	
	@RequestMapping("/generateBill")
	public String generateBillInfo(@ModelAttribute("billing") Billing billing,Model model) {
		billingService.saveBill(billing);
		List<Billing> billings = billingService.getAllBilling();
		model.addAttribute("billings", billings);
		return "list_bills";
	}
	
	@RequestMapping("/listBillings")
	public String getAllBillings(Model model) {
		List<Billing> billings = billingService.getAllBilling();
		model.addAttribute("billings", billings);
		return "list_bills";
	}

	//PDF METHOD
    @GetMapping("/generatePdf")
    public void exportToPDF(@RequestParam("invoiceId") long invoiceId,HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        Billing listUsers = service.listAll(invoiceId);
         
        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);
	         
	    }
		
	
	
	
	
}
