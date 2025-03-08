package com.smart.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class EmailService {

	public boolean sendEmail(String subject, String message, String to) {
		
		//rest of the code
		
		boolean f = false;
		String from = "nishant@gmail.com";
		
		//variable for gmail
		String host = "smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.err.println("Properties " + properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.stmp.host", host);
		properties.put("mail.stmp.port", "465");
		properties.put("mail.stmp.ssl.enable", "true");
		
		
		//Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rkumar.mahuani@gmail.com", "Raushan@123");
			}
		});
		
		session.setDebug(true);
		
		//step 2 : compose the message [text, multi media]
		MimeMessage m = new MimeMessage(session);
		try {
			
			//from email
			
			
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
				
		
		return false;
	}

	
	
}
