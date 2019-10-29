package com.lti.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.CustomerEntity;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public Object get(String u_email) {
		return customerDao.fetch(u_email);
	}
	
	public String reset(String oldPass,String newPass) {
		 System.out.println("now im here");
	   String s1= customerDao.reset(oldPass,newPass);
		return s1;
	}
	
	public void register(CustomerEntity customerEntity) {
		customerDao.save(customerEntity);
		}

	public String change(String u_add, String u_pass) {
		return customerDao.change(u_add,u_pass);
	}
}
