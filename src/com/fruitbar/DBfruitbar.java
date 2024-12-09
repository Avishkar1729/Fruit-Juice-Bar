package com.fruitbar;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class DBfruitbar {
	
	Connection con;

	public void getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitbar", "root", "");
																								

			System.out.println("Connection Established!!!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createDB() {

		try {
			

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");

			System.out.println("Connection Established!!!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// create database

		try {

			Statement st = con.createStatement();

			String query = "create database fruitbar";
			st.executeUpdate(query);
			System.out.println("Database create successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createTable() {

		try {
			// connection with database

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitbar", "root", "");

			System.out.println("Connection Established!!!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// create table

		try {

			Statement st = con.createStatement();

			String query = "create table userInfo(uname varchar(20), email varchar(20) primary key, mob varchar(20), addr varchar(20), pass varchar(20))";
			st.executeUpdate(query);
			System.out.println("Table create successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	ResultSet readUser(String email)
	{	
		ResultSet rs = null;
		getConnection();
		try
		{
			Statement st = con.createStatement();
			
			String sql = "select * from userinfo where email = '"+email+"'";
			
			rs = st.executeQuery(sql);
			
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	ResultSet readClient(String email)
	{	
		ResultSet rs = null;
		getConnection();
		try
		{
			Statement st = con.createStatement();
			
			String sql = "select * from clientinfo where cEmail = '"+email+"'";
			
			rs = st.executeQuery(sql);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	

	ResultSet readData(String email) {

		ResultSet rs = null;
		String id=null,uName=null,mob=null,addr=null,pass=null;

		
		try {
			
			getConnection();

			Statement st = con.createStatement();


			String query = "select * from userinfo where email = '"+email+"'";
			rs = st.executeQuery(query);
			email = "NA";

			while (rs.next()) {
				id = rs.getString(1);
				uName = rs.getString(2);
				email = rs.getString(3);
				mob = rs.getString(4);
				addr = rs.getString(5);
				pass = rs.getString(6);
				
			}
			
			Profile pf = new Profile();
			pf.setVisible(true);
			
			pf.txt0.setText(id);
			pf.txt1.setText(uName);
			pf.txt2.setText(email);
			pf.txt3.setText(mob);
			pf.txt4.setText(addr);
			pf.txt5.setText(pass);
			
			//pf.dispose();

			System.out.println("uName : " + uName);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;

	}



	public int insertData(String id, String uname, String email, String mob, String addr, String pass) {
		
		int res  = 0;
		try {
			getConnection();
			String query = "INSERT INTO userinfo VALUES (?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);
			ps.setString(2, uname);
			ps.setString(3, email);
			ps.setString(4, mob);
			ps.setString(5, addr);
			ps.setString(6, pass);


			res = ps.executeUpdate();

			System.out.println("Data insert successful");
			
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return res;
	}
	
	public void insertData(int oId,String pName, String pPrice, String tPrice, String tId, String cId) {
		
		try {
			getConnection();

			String query = "INSERT INTO payment VALUES (?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, oId);
			ps.setString(2, pName);
			ps.setString(3, pPrice);
			ps.setString(4, tPrice);
			ps.setString(5, tId);
			ps.setString(6, cId);
			
			
			if(tId != null) {
				ps.executeUpdate();
				System.out.println("Data insert successful");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

	public void deleteUser(int oId) {
		try {
			getConnection();
			Statement st = con.createStatement();

			String sql = "delete from payment where id = " + oId;

			st.executeUpdate(sql);
			System.out.println("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateUser(String uName, String email, String mob, String addr, String pass) {
		
		
		try {
			getConnection();

			String sql = "update userinfo set uname = ?, mob = ?, addr = ?, pass = ? where email = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, uName);
			ps.setString(2, mob);
			ps.setString(3, addr);
			ps.setString(4, pass);
			ps.setString(5, email);
			
			

			ps.executeUpdate();
			System.out.println("Update successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
