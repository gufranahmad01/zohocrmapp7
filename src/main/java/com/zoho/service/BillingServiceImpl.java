package com.zoho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Billing;
import com.zoho.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepository billingRepo;
	
	@Override
	public void saveBill(Billing billing) {
		billingRepo.save(billing);

	}

	@Override
	public List<Billing> getAllBilling() {
    List<Billing> billings = billingRepo.findAll();
		return billings;
	}

}
