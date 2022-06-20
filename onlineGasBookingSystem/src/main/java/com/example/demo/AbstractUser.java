package com.example.demo;

import lombok.Data;

@Data
abstract public class AbstractUser {
	private String username;
	private String password;
	private String mobileNumber;
	private String amail;

}
