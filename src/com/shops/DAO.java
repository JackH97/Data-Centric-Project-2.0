package com.shops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DAO {

	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	public ArrayList<Product> loadProducts() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from product";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Product> products = new ArrayList<Product>();

		// process result set
		while (myRs.next()) {
			Product p = new Product();
			p.setPID(myRs.getInt("PID"));
			p.setSID(myRs.getInt("SID"));
			p.setPrice(myRs.getDouble("PRICE"));
			p.setProdName(myRs.getString("ProdName"));
			products.add(p);
		}
		return products;
	}
	
public ArrayList<Store> loadStores() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from store";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Store> stores = new ArrayList<Store>();

		// process result set
		while (myRs.next()) {
			Store s = new Store();
			s.setId(myRs.getInt("id"));
			s.setName(myRs.getString("name"));
			s.setFounded(myRs.getString("founded"));
			stores.add(s);
		}
		return stores;
	}

public ArrayList<StoreProduct> loadStoreProducts(int Sp) throws Exception 
{
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	
	myConn = mysqlDS.getConnection();
	
	String sql = "select s.*,p.* from store as s left join product as p on p.sid=s.id where id=" + Sp;
	
	myStmt = myConn.createStatement();

	myRs = myStmt.executeQuery(sql);
	
	ArrayList<StoreProduct> storeProducts = new ArrayList<StoreProduct>();
	
	while (myRs.next()) {
		StoreProduct SP = new StoreProduct();
		SP.setId(myRs.getInt("id"));
		SP.setName(myRs.getString("name"));
		SP.setFounded(myRs.getString("founded"));
		SP.setPID(myRs.getInt("pid"));
		SP.setProdName(myRs.getString("prodName"));
		SP.setPrice(myRs.getDouble("price"));
		System.out.println(SP.name);
		storeProducts.add(SP);
	}
	return storeProducts;
	
}
	
	public void addProduct(Product product) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "Insert into Product value (?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, product.getPID());
		myStmt.setInt(2, product.getSID());
		myStmt.setDouble(3, product.getPrice());
		myStmt.setString(4, product.getProdName());
		myStmt.execute();
		
	}
	
	public void addStore(Store store) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "Insert into store value (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, store.getId());
		myStmt.setString(2, store.getName());
		myStmt.setString(3, store.getFounded());
		myStmt.execute();
		
	}
	
	public void deleteProduct(int PID) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "Delete from product where pid = " + PID;
		myStmt = myConn.prepareStatement(sql);
		myStmt.execute(sql);
	}
	
	public void deleteStore(int id) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "Delete from store where id = " + id;
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}

}
