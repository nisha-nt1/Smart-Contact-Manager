package com.smart.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dao.ContactRepository;
import com.smart.dao.UserRepository;
import com.smart.entity.Contact;
import com.smart.entity.User;

/*
 * @RestController public class SearchController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private ContactRepository contactRepository;
 * 
 * //search handler
 * 
 * @GetMapping("/search/{query}") public ResponseEntity<?>
 * search(@PathVariable("query") String query, Principal principal){
 * 
 * System.err.println(query);
 * 
 * User user = this.userRepository.getUserByUserName(principal.getName());
 * 
 * List<Contact> contacts = ContactRepository.findByNameContainingAndUser(query,
 * user); return ResponseEntity.ok(contacts); }
 * 
 * }
 */

@RestController
public class SearchController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    // Search handler
    @GetMapping("/search/{query}")
    public ResponseEntity<?> search(@PathVariable("query") String query, Principal principal) {
        
       // System.err.println(query); // Log the query for debugging
        
        // Get the current logged-in user
        User user = this.userRepository.getUserByUserName(principal.getName());
        
        // Fetch contacts matching the query for the current user
        List<Contact> contacts = contactRepository.findByNameContainingAndUser(query, user);
        
        return ResponseEntity.ok(contacts);
        
        
    }
}

