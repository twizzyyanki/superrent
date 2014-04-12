package org.superrent.entities;

import java.util.Date;

public class SellVehicleVO {
	
	private int regNo;
	private double price;
	private double soldPrice;
	private Date soldDate;
	private Date forSaleFrom;
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(double soldPrice) {
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
