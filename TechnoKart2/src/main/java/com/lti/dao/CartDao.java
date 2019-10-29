package com.lti.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CartEntity;
import com.lti.entity.ProductEntity;

@Repository
public class CartDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	@Transactional
	public String addProd(int p_id, int u_id) {
		CartEntity cartEntity=new CartEntity();
		cartEntity.setP_id(p_id);
		 cartEntity.setU_id(u_id);
		 entityManager.persist(cartEntity);
		 System.out.println(cartEntity);
	return "donee";
}
	
	public List displayCart(int u_id) {
		ArrayList<ProductEntity> prod = new ArrayList<ProductEntity>();
		String ql = "select c.p_id from CartEntity c where c.u_id =:uid ";
		System.out.println("in display");
		Query q = entityManager.createQuery(ql);
		System.out.println("done done");
		q.setParameter("uid", u_id);
		List id=q.getResultList();
		Iterator i= id.iterator();
		System.out.println("list"+id);
		for(int j=0; i.hasNext(); j++)
		{
		String ql1 = "select c from ProductEntity c where c.p_id =:p_id ";
			Query q1 =entityManager.createQuery(ql1);
			q1.setParameter("p_id", i.next());
			List temp= q1.getResultList(); 
			prod.addAll(j, temp);
	}
		return prod;	
		}
}
