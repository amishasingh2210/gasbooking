package com.example.demo;

	import java.util.List;

import lombok.Data;

	@Data
	public class Response<T> {
		private T data;
		private String status;
		private AppError error;

		public String getStatus() {
			return error != null ? "ERROR" : "SUCCESS";
		}
		public void setData(Customer c) {
			
		}

		public void setData(boolean b) {
			// TODO Auto-generated method stub
			
		}

		public void setError(AppError error2) {
			// TODO Auto-generated method stub
			
		}
		public void setData(List<Customer> customer) {
			// TODO Auto-generated method stub
			
		}
}
