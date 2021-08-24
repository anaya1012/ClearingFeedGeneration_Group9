package com.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Archive {
	int aid;
	String atrans_ref;
	String adate;
	String apayerName;
	String apayerAccount;
	String apayeeName;
	String apayeeAccount;
	String aamount;
	int valid;
	int fileNo;
	
	public Archive() {
		
	}
	public Archive( int aid, String atrans_ref, String adate, String apayerName, String apayerAccount, String apayeeName,
			String apayeeAccount, String aamount, int valid, int fileNo) {
		super();
		this.aid = aid;
		this.atrans_ref = atrans_ref;
		this.adate = adate;
		this.apayerName = apayerName;
		this.apayerAccount = apayerAccount;
		this.apayeeName = apayeeName;
		this.apayeeAccount = apayeeAccount;
		this.aamount = aamount;
		this.valid = valid;
		this.fileNo = fileNo;
	}
	public String getAtrans_ref() {
		return atrans_ref;
	}
	public void setAtrans_ref(String atrans_ref) {
		this.atrans_ref = atrans_ref;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getApayerName() {
		return apayerName;
	}
	public void setApayerName(String apayerName) {
		this.apayerName = apayerName;
	}
	public String getApayerAccount() {
		return apayerAccount;
	}
	public void setApayerAccount(String apayerAccount) {
		this.apayerAccount = apayerAccount;
	}
	public String getApayeeName() {
		return apayeeName;
	}
	public void setApayeeName(String apayeeName) {
		this.apayeeName = apayeeName;
	}
	public String getApayeeAccount() {
		return apayeeAccount;
	}
	public void setApayeeAccount(String apayeeAccount) {
		this.apayeeAccount = apayeeAccount;
	}
	public String getAamount() {
		return aamount;
	}
	public void setAamount(String aamount) {
		this.aamount = aamount;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "Archive [atrans_ref=" + atrans_ref + ", adate=" + adate + ", apayerName=" + apayerName
				+ ", apayerAccount=" + apayerAccount + ", apayeeName=" + apayeeName + ", apayeeAccount=" + apayeeAccount
				+ ", aamount=" + aamount + ", valid=" + valid + ", fileNo=" + fileNo + ", aid=" + aid + "]";
	}
	

}
