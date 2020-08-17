package com.example.springbootjavamail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/send")
	public void sendMail() {
		System.out.println("Test sendMail");
		emailService.sendSimpleMessage("riadh.bel.hadj2004@gmail.com", "Subject", "text");
	}

}
