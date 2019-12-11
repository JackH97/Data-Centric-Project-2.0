package com.shops;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StoreProductController {

	DAO dao;
	ArrayList<StoreProduct> storeProduct;
	
	public StoreProductController()
	{
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String loadStoreProducts(int SP) {
		System.out.println("In loadStoreProducts()");
		try {
			storeProduct  = dao.loadStoreProducts(SP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "StoreProduct";
		
	}
	
	public ArrayList<StoreProduct> getStoreProduct() {
		return storeProduct;
	}
}
