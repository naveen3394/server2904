package com.app.dao;

import com.app.pojos.Vendor;

public interface IVendorDao {

	Vendor validateUser(String email,String password);
	
}
