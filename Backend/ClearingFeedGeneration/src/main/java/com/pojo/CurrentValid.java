package com.pojo;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class CurrentValid {
	long trans_ref;
	Date date;
	String payerName;
	String payerAccount;
	String payeeName;
	String payeeAccount;
	double amount;
	
	public CurrentValid() {
		
	}
	public CurrentValid(long trans_ref, Date date, String payerName, String payerAccount, String payeeName,
			String payeeAccount, double amount) {
		super();
		this.trans_ref = trans_ref;
		this.date = date;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}
	public long getTrans_ref() {
		return trans_ref;
	}
	public void setTrans_ref(long trans_ref) {
		this.trans_ref = trans_ref;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CurrentValid [trans_ref=" + trans_ref + ", date=" + date + ", payerName=" + payerName
				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
				+ ", amount=" + amount + "]";
	}
	
	
	

}
