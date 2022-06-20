package com.example.demo;

import lombok.Data;

	@Data
	public class Customer extends AbstractUser {
		private int customerId;
		private int cylinderId;
		private int bankId;
		private int accountNo;
		private String ifscNo;
		private String pan;

	}


