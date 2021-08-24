package com.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class CurrentInvalid {
	int id;
	String itrans_ref;
	String idate;
	String ipayerName;
	String ipayerAccount;
	String ipayeeName;
	String ipayeeAccount;
	String iamount;
	
	public CurrentInvalid() {
		
	}
	public CurrentInvalid(int id, String itrans_ref, String idate, String ipayerName, String ipayerAccount,
			String ipayeeName, String ipayeeAccount, String iamount) {
		super();
		this.id = id;
		this.itrans_ref = itrans_ref;
		this.idate = idate;
		this.ipayerName = ipayerName;
		this.ipayerAccount = ipayerAccount;
		this.ipayeeName = ipayeeName;
		this.ipayeeAccount = ipayeeAccount;
		this.iamount = iamount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItrans_ref() {
		return itrans_ref;
	}

	public void setItrans_ref(String itrans_ref) {
		this.itrans_ref = itrans_ref;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getIpayerName() {
		return ipayerName;
	}

	public void setIpayerName(String ipayerName) {
		this.ipayerName = ipayerName;
	}

	public String getIpayerAccount() {
		return ipayerAccount;
	}

	public void setIpayerAccount(String ipayerAccount) {
		this.ipayerAccount = ipayerAccount;
	}

	public String getIpayeeName() {
		return ipayeeName;
	}

	public void setIpayeeName(String ipayeeName) {
		this.ipayeeName = ipayeeName;
	}

	public String getIpayeeAccount() {
		return ipayeeAccount;
	}

	public void setIpayeeAccount(String ipayeeAccount) {
		this.ipayeeAccount = ipayeeAccount;
	}

	public String getIamount() {
		return iamount;
	}

	public void setIamount(String iamount) {
		this.iamount = iamount;
	}

	@Override
	public String toString() {
		return "CurrentInvalid [id=" + id + ", itrans_ref=" + itrans_ref + ", idate=" + idate + ", ipayerName="
				+ ipayerName + ", ipayerAccount=" + ipayerAccount + ", ipayeeName=" + ipayeeName + ", ipayeeAccount="
				+ ipayeeAccount + ", iamount=" + iamount + "]";
	}
	

}
