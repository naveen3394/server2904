package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;


@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao{

	@Autowired(required = true)
	private SessionFactory sf;
	
	@Override
	public Vendor validateUser(String email, String password) {
String jpql="select v from Vendor v where v.email=:em and v.password=:pa";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class).setParameter("em",email).setParameter("pa",password).getSingleResult();
	}

}
