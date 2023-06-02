package com.example.apmcProject.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class mailService {
		
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to,String subject,String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("mohammadarqham182002@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		
		
		mailSender.send(message);
		
		
		System.out.println("mail sent to "+ to + "successfully..!");
	}
	
	public void sendMailWithAttachments(String to,String subject,String text,String pathToAttachment) throws MessagingException, IOException {

	    MimeMessage message = mailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom("noreply@baeldung.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	        
	    FileSystemResource file 
	      = new FileSystemResource(new File(pathToAttachment));
	    
	    
	    String fileType = pathToAttachment.substring(pathToAttachment.lastIndexOf("."));
	    
	    
	    helper.addAttachment("Invoice"+fileType, file);

	    mailSender.send(message);
	}

	
	
	
}
