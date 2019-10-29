package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.CartDao;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public String addProd(int p_id, int u_id)
	{
		String s1= cartDao.addProd(p_id,u_id);
		return s1;
	}
	
	public List showCart(int u_id)
	{
		List pl=cartDao.displayCart(u_id);
		return pl;
	}
}
