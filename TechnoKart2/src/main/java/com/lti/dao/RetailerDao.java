package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ProductEntity;

@Repository
public class RetailerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List fetch(String r_email) {
		 
		System.out.println("now im here");
		String ql = "select r.r_pass from RetailerEntity r where r.r_email =:em ";
		Query q = entityManager.createQuery(ql);
		System.out.println("now im here");
		q.setParameter("em", r_email);
		List c1 = q.getResultList();
		System.out.println(c1);
	     return c1;	
     }
	
	@Transactional
	public String reset(String oldPass,String newPass) {
		String s1=null;
		System.out.println("now im here");
		String ql = "update RetailerEntity set r_pass = :newPass where r_pass = :oldPass";
		Query q = entityManager.createQuery(ql);
		System.out.println("now im here");
		q.setParameter("newPass", newPass);
		q.setParameter("oldPass", oldPass);
		int result = q.executeUpdate();
		if( result==1)
		{
	      s1="SUCCESS";		
		}
		else
		{
	      s1="FAILURE";
		}
		return s1;
}

	@Transactional
	public void save(ProductEntity productEntity) {
		System.out.println("hii4");
		entityManager.persist(productEntity);
		//entityManager.merge(customerEntity);
		System.out.println("hi5");
	}
}
