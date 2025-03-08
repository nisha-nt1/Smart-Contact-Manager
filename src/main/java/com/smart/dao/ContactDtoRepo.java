package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.ContactDTO;

public interface ContactDtoRepo extends JpaRepository<ContactDTO, Integer>{


}
