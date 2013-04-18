package com.dss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAOImpl implements ProductDAO {

Connection con;
Statement st;
ResultSet rs;
String status;
	
	public ProductDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			st = con.createStatement();
			System.out.println("Connected To Database....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getProduct(String pid) {
		
			try {
				rs = st.executeQuery("select * from productinfo where pid = '"+pid+"'");
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		
		return rs;
	}

	@Override
	public String delete(String pid) {
		try {
			rs = getProduct(pid);
			boolean b = rs.next();
			if (b == true) {
				int rowCount = st.executeUpdate("delete from productinfo where pid='"+pid+"'" );
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "notexisted";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ResultSet search(String pid) {
		
		return getProduct(pid);
	}

	@Override
	public String add(String pid, String pname, String pcost) {
		try {
			rs = getProduct(pid);
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				int rowCount = st.executeUpdate("insert into productinfo values('"+pid+"','"+pname+"','"+pcost+"')");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public void closeConnection(){
		try {
			con.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
}
