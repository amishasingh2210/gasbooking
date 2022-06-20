package com.example.demo.dao;

	import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;

	@Repository
	public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {
	 

	}

