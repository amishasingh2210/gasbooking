package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.AppError;
import com.example.demo.Customer;
import com.example.demo.Response;
import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.service.ICustomerService;
import com.example.demo.transformer.CustomerTransformer;


@Service
public class ServiceImplementation implements ICustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Response<Customer> updateCustomer(Customer customer) {
		Response<Customer> response = new Response<>();
		try {
			CustomerEntity entity = CustomerTransformer.transformCustomer(customer);

			customerDao.save(entity);

			Customer newCate = CustomerTransformer.transformCustomer(entity);
			response.setData(newCate);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_UPDATING_Customer");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
		
	}



	@Override
	public Response<Customer> addCustomer(Customer customer) {
		Response<Customer> response = new Response<>();
		System.out.println(customer);
			
			if (customerDao.findById(customer.getBankId()).isPresent()) {
				System.out.println("If block execute");
				AppError error = new AppError();
				error.setCode("ERR_ADD_CYLINDER");
				error.setMessage("Cylinder already exists " + customer.getCustomerId());
				response.setError(error);
			} else {
				System.out.println("Else block execute");
				CustomerEntity entity= CustomerTransformer.transformCustomer(customer);
				System.out.println(entity);
				customerDao.save(entity);
				Customer newCate = CustomerTransformer.transformCustomer(entity);
				response.setData(newCate);
			}
	return response;
	}



	@Override
	public Response<Boolean> deleteCustomer(int customerId) {
		Response<Boolean> response = new Response<>();
		try {
			customerDao.deleteById(customerId);
			response.setData(true);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CYLINDER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;	
	}



	@Override
	public Response<List<Customer>> getAllCustomer() {
		Response<List<Customer>> response = new Response<>();
		try {
			List<CustomerEntity> entities = customerDao.findAll();
			List<Customer> customer = new ArrayList<Customer>();
			if (entities != null) {
				for (CustomerEntity entity : entities) {
					customer.add(CustomerTransformer.transformCustomerEntity(entity));
				}
			}
			response.setData(customer);

		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CUSTOMER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}



	@Override
	public Response<Customer> getCustomerById(Integer customerId) {
		Response<Customer> response = new Response<>();
		try {
			Optional<CustomerEntity> opEntity=customerDao.findById(customerId);
					if (opEntity.isPresent()) {
				response.setData(CustomerTransformer.transformCustomerEntity(opEntity.get()));
			}
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CYLINDER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}



	@Override
	public Response<Boolean> deleteCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
