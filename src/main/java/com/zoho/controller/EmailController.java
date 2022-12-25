package com.zoho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.util.EmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/sendEmail")
	public String  sendEmail(@RequestParam("to")String to,@RequestParam("subject")String subject,@RequestParam("message")String message,Model model) {
		emailService.sendEmail(to, subject, message);
		model.addAttribute("msg", "Email Sent!!");
		return "compose";
	}
}
