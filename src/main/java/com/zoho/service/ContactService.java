package com.zoho.service;

import java.util.List;

import com.zoho.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);
	
	public List<Contact> getAllContacts();

	public Contact findContactById(long id);

}
