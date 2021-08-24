package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Archive;
import com.pojo.CurrentInvalid;
import com.pojo.CurrentValid;

@Repository
public class FeedFileJdbcTemplate{
	@Autowired
	JdbcTemplate template;

	public void addcurrent_valid(CurrentValid curr) {
		// TODO Auto-generated method stub
		try {
			template.update("insert into current_valid values(?,?,?,?,?,?,?)",
			curr.getTrans_ref(), curr.getDate(), curr.getPayerName(),
			curr.getPayerAccount(),curr.getPayeeName(),curr.getPayeeAccount(),curr.getAmount());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addcurrent_invalid(CurrentInvalid icurr) {
		// TODO Auto-generated method stub
		try {
			template.update("insert into current_invalid(transaction_ref,value_date, payername, payer_accno, payeename , payee_accno , amount) values(?,?,?,?,?,?,?)",
					icurr.getItrans_ref(), icurr.getIdate(), icurr.getIpayerName(),
					icurr.getIpayerAccount(),icurr.getIpayeeName(),icurr.getIpayeeAccount(),icurr.getIamount());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addarchive(Archive arch) {
		// TODO Auto-generated method stub
		try {
			template.update("insert into archive(transaction_ref,value_date, payername, payer_accno, payeename , payee_accno , amount, valid_check, file_no) values(?,?,?,?,?,?,?,?,?)",
					arch.getAtrans_ref(), arch.getAdate(), arch.getApayerName(),
					arch.getApayerAccount(),arch.getApayeeName(),arch.getApayeeAccount(),arch.getAamount(),arch.getValid(), arch.getFileNo());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



}
