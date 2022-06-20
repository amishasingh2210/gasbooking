package com.example.demo.transformer;

import com.example.demo.Customer;
import com.example.demo.entity.CustomerEntity;

public class CustomerTransformer {
		public static CustomerEntity transformCustomer(Customer customer) {
			if(customer != null) {
				CustomerEntity entity = new CustomerEntity();
				entity.setCustomerId(customer.getCustomerId());
				entity.setCylinderId(customer.getCylinderId());
				entity.setBankId(customer.getBankId());
				entity.setAccountNo(customer.getAccountNo());
				entity.setIfscNo(customer.getIfscNo());
				entity.setPan(customer.getPan());
				return entity;
			}
			return null;
		}
		
		
		public static CustomerEntity transformCylinderEntity(CylinderEntity entity) {
			if(entity != null) {
				CustomerEntity entity1 = new CustomerEntity();
				entity1.setCustomerId(entity1.getCustomerId());
				entity1.setCylinderId(entity1.getCylinderId());
				entity1.setBankId(entity1.getBankID());
				entity1.setAccountNo(entity1.getAccountNo());
				entity1.setIfscNo(entity1.getIfscNo());
				
				return entity1;
			}
			return null;
		}


		public static Customer transformCustomer(CustomerEntity entity) {
			// TODO Auto-generated method stub
			return null;
		}


		public static Customer transformCustomerEntity(CustomerEntity customerEntity) {
			// TODO Auto-generated method stub
			return null;
		}
}
