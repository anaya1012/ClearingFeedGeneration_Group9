package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Validation {
	
	@Autowired
	JdbcTemplate template;
	int validate(String obj[]) {
		if(validate_Transref(obj[0]) && validate_Date(obj[1]) && validate_Name(obj[2]) && validate_Account(obj[3]) && validate_Name(obj[4]) && validate_Account(obj[5]) && validate_Amount(obj[6])) {
			return 1;
		}
		else
			return 0;
	
	}

	public boolean validate_Transref(String obj)
	{
		String sql = "select count(*) from archive where transaction_ref=?";
		int count = template.queryForObject(sql, new Object[] {obj},Integer.class);
		if(count>0)
		{
			return false;
		}
		return true;
	}


	boolean validate_Date(String obj) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	try { 
		    Date txn_date = new SimpleDateFormat("dd/MM/yyyy").parse(obj);
		    Date currentDate = new Date();
		    
		    if(sdf.format(currentDate).equals(sdf.format(txn_date))) {
		    	return true;
		    }
		    else {
		    	return false;
		    }
		    
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
		
	}
	
	boolean validate_Name(String obj) {
		if(obj != null && obj.matches("^[a-zA-Z0-9]*$") && obj.length()<=35)
			return true;
		else
			return false;
	}
	boolean validate_Account(String obj) {
		if(obj != null && obj.matches("^[a-zA-Z0-9]*$") && obj.length()<=12)
			return true;
		else
			return false;
	}
	boolean validate_Amount(String obj) {
		if(obj.matches("^(([0-9]*)|(([0-9]*)\\.([0-9]*)))$"))
			return true;
		else
			return false;
	}
}
