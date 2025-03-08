package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.dao.ContactDtoRepo;
import com.smart.entity.Contact;
import com.smart.entity.ContactDTO;

@Controller
public class ContactController {

	@Autowired
    private ContactDtoRepo contactDtoRepository;

    // Load Contact Form
    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact"; 
    }

    // Handle Form Submission
    @PostMapping("/submit-contact")
    public String submitContact(@ModelAttribute ContactDTO contactDto, Model model) {
    	
    	contactDtoRepository.save(contactDto); // Save Contact entity to the database
    	model.addAttribute("success", "Success"); // Set success message

        System.out.println("Name: " + contactDto.getName());
        System.out.println("Email: " + contactDto.getEmail());
        System.out.println("Message: " + contactDto.getMessage());

        return "redirect:/contact?success"; 
    }
}
