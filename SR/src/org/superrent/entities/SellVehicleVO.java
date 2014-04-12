package org.superrent.entities;

import java.util.Date;

public class SellVehicleVO {
	
	private String regNo;
	private String price;
	private String soldPrice;
	private Date soldDate;
	private Date forSaleFrom;
	
	
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(String soldPrice) {
		this.soldPrice = soldPrice;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public Date getForSaleFrom() {
		return forSaleFrom;
	}
	public void setForSaleFrom(Date forSaleFrom) {
		this.forSaleFrom = forSaleFrom;
	}
	
	

}
