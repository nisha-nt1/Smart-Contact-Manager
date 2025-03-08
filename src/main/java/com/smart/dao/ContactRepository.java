package com.smart.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.smart.entity.Contact;
import com.smart.entity.User;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	//pagination...
	
	
	/*
	 * @Query("from Contact as c where c.user.id = :userId") public Page<Contact>
	 * findContactsByUser(@Param("userId") int userId, Pageable pageable);
	 */
	  
	
	  @Query("from Contact as c where c.user.id =:userId")
	    Page<Contact> findContactsByUser(@Param("userId") int userId, Pageable pageable);
	  
	  
		/* this method for search bar */
	/*public static List<Contact> findByNameContainingAndUser(String name, User user){
		return null;*/
		
	  List<Contact> findByNameContainingAndUser(String name, User user);
	}

	


