package com.smart.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotController {
	
	Random random = new Random(1000);
	
	@Autowired
	private EmailService emailService;
	
	//email id form open handler
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "forgot_email_form";
	}
	
	/*
	 * @PostMapping("/send-otp") public String sendOTP(@RequestParam("email") String
	 * email, HttpSession session) {
	 * 
	 * System.err.println("Email: " + email);
	 * 
	 * //generating OTP of 4 digit
	 * 
	 * int otp = random.nextInt(999999);
	 * 
	 * System.err.println("OTP " + otp);
	 * 
	 * //write code for send OTP String subject = "OTP From SCM"; String message =
	 * "OTP = "+otp+" "; String to=email;
	 * 
	 * boolean flag = this.emailService.sendEmail(subject, message, to);
	 * 
	 * if(flag) { return "varify_otp"; }else {
	 * 
	 * session.setAttribute("message", "Check your email id");
	 * 
	 * return "forgot_email_form"; }
	 * 
	 * 
	 * }
	 */
	
	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) {

	    System.err.println("Email: " + email);

	    // Generate OTP of 4 digits
	    int otp = random.nextInt(9999); // 4-digit OTP
	    System.err.println("OTP: " + otp);

	    // Write code to send OTP
	    String subject = "OTP From SCM";
	    String message = "Your OTP is: " + otp;
	    String to = email;

	    boolean flag = emailService.sendEmail(subject, message, to);

	    if (flag) {
	        session.setAttribute("myOTP", otp); // Store OTP in session
	        session.setAttribute("email", email); // Store email for reference during OTP verification
	        session.setAttribute("message", "We have sent an OTP to your email."); // Success message

	        // Redirect to OTP verification page
	        return "redirect:/verify-otp";
	    } else {
			/*
			 * session.setAttribute("message",
			 * "Check your email ID. OTP could not be sent.");
			 */
	        return "forgot_email_form"; // Stay on the email form if sending fails
	    }
	}


}
