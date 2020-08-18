package com.example.springbootjavamail.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

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
	
	@GetMapping("/send-attachment")
	public void sendMailWithAttachmentl() {
		System.out.println("Test sendMail");
		emailService.sendMessageWithAttachment("riadh.bel.hadj2004@gmail.com", "Subject", "text", "src/main/resources/static/iot.pdf");
	}
	
	
	@GetMapping("/send-template")
	public void sendMailWithThymeleaf() throws IOException, MessagingException{
		System.out.println("Test sendMail Thymeleaf");
		Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("recipientName", "Abdallah");
        templateModel.put("text", "Sujet de l'email");
        templateModel.put("senderName", "Riadh");
		emailService.sendMessageUsingThymeleafTemplate("riadh.bel.hadj2004@gmail.com", "Subject", templateModel);
	}
	
	
	
}
