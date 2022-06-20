package com.example.demo.service;

import java.util.List;

import com.example.demo.Customer;
import com.example.demo.Response;

public interface ICustomerService {

	public Response<Customer> updateCustomer(Customer customer);

	public Response<Customer> addCustomer(Customer customer);

	public Response<Boolean> deleteCustomer();

	public Response<List<Customer>> getAllCustomer();

	public Response<Customer> getCustomerById(Integer customerId);

	Response<Boolean> deleteCustomer(int customerId);

}
