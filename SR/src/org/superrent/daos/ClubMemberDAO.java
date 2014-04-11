package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
	
public class ClubMemberDAO {
private Connection connection = null;
private int uid;
private final LoggedInUser lc; 

	/**
	 * This is the constructor for this class
	 */		
	public ClubMemberDAO() {
		this.lc = new LoggedInUser();
		try {
				String uidString;
				uidString = lc.getUserId();
				// uidString = "1"; is just for test can delete after testing
				//uidString ="1";
				this.uid = Integer.parseInt(uidString);
				connection = DatabaseConnection.createConnection();
				
			
			
	
		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
	}

	public double getPoints(){
		double points = 0;
		try{
			ResultSet rs;
			
			Statement st = connection.createStatement();
			String query = "SELECT points FROM ClubMember WHERE uid='" + uid +"'";
			//System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			while(rs.next()){
				points = rs.getDouble("points");
			}
			
			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return points;
	
	}
	
/*	*//**
	 * test main
	 * @param args
	 *//*
	public static void main(String[] args){
		ClubMemberDAO cDao = new ClubMemberDAO();
		double points = cDao.getPoints();
		System.out.println("points"+points);
		
	}*/


}
