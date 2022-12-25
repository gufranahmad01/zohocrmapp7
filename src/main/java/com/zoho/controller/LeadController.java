package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.entities.Lead;
import com.zoho.service.ContactService;
import com.zoho.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String showCreatePageForm() {
		return "create_lead";
	}
	
	@RequestMapping("/save")
	public String saveLeadInfo(@ModelAttribute("lead") Lead lead,Model model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/compose")
	public String composeEmail(@RequestParam("email") String email,Model model) {
		model.addAttribute("email", email);
		return "compose";
	}
	
		@RequestMapping("/listLeads")
		public String listAllleads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	
	}
		@RequestMapping("/leadInfo")
		public String getOneLeadInfo(@RequestParam("id")long id,Model model) {
			Lead lead = leadService.findLeadById(id);
			model.addAttribute("lead", lead);
			return "lead_info";
	}
		@RequestMapping("/convertLead")
		public String convertLeadIntoContact(@RequestParam("id")Long id,Model model) {
			//find lead by Id
			Lead lead = leadService.findLeadById(id);
			//converts lead into contact
			Contact contact=new Contact();
			contact.setFirstName(lead.getFirstName());
			contact.setLastName(lead.getLastName());
			contact.setEmail(lead.getEmail());
			contact.setMobile(lead.getMobile());
			contact.setSource(lead.getSource());
			//save into contact
			contactService.saveContact(contact);
			//Delete lead by id
			leadService.deleteOneLeadById(id);
			//get All Contact
			List<Contact> contacts = contactService.getAllContacts();
			model.addAttribute("contacts", contacts);
			return "list_contacts";
		}
		
	
	
	
	
	
	
	
}
