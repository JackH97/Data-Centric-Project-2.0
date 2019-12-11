package com.shops;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Product {

	int SID;
	int PID;
	String prodName;
	double price;
	
	public int getPID() {
		return PID;
	}
	public void setPID(int PID) {
		this.PID = PID;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int SID) {
		this.SID = SID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
