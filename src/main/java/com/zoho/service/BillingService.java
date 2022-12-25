package com.zoho.service;

import java.util.List;

import com.zoho.entities.Billing;

public interface BillingService {

	public void saveBill(Billing billing);

	public List<Billing> getAllBilling();
}
