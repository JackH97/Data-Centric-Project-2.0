package com.shops;

import javax.annotation.ManagedBean;

@ManagedBean
public class StoreProduct {

	int id;
	String name;
	String founded;
	int PID;
	String prodName;
	double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int PID) {
		this.PID = PID;
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
