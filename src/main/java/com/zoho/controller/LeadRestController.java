package com.zoho.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoho.entities.Lead;
import com.zoho.repositories.LeadRepository;

@RestController
@RequestMapping("leads/api")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		 
		leadRepo.save(lead);
	}
	
	@GetMapping
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	

	@PutMapping
	public void updateLead(@RequestBody Lead lead) {
		 
		leadRepo.save(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable("id")long id) {
		 
		leadRepo.deleteById(id);
	}
	
	
	
	
}
