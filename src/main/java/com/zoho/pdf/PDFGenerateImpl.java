package com.zoho.pdf;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Billing;
import com.zoho.repositories.BillingRepository;
@Service
@Transactional
public class PDFGenerateImpl implements PDFGenerate {

    @Autowired
	private BillingRepository billingRepo;
	
	@Override
	public Billing listAll(long id) {
		 Optional<Billing> findById = billingRepo.findById(id);
		 Billing billing = findById.get();
		 return billing;
	}

}
