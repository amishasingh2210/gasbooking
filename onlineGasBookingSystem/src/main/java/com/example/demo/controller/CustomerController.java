package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Customer;
import com.example.demo.Response;
import com.example.demo.service.ICustomerService;


@Controller
@RequestMapping("customer")
public class CustomerController{
	
	@Autowired
	private ICustomerService customerService;

	@PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Customer> addCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<Customer>> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Customer> updateCustomer(@RequestBody Customer customer){
		return customerService.updateCustomer(customer);
	}
	
		
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> deleteCustomer() {
		return customerService.deleteCustomer();
	}
	
	@GetMapping(value="/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Response<Customer> getCustomerById(@PathVariable("customerId") Integer customerId){
			return customerService.getCustomerById(customerId);
		}
}

