package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.DatabaseConnection;
	
	public class clubMemberDao {
	private Connection connection = null;
	private int uid;

	/**
	 * This is the constructor for this class
	 */
	public clubMemberDao(int uid) {
		try {
			this.uid = uid;
			
			double points = 0;
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			
			

		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
	}
	
	public double getPoints(){
		double points = 0;
		try{
			ResultSet rs;
			
			Statement st = connection.createStatement();
			String query = "SELECT points FROM ClubMember WHERE uid='" + uid +"'";
			System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			points = rs.getDouble("points");
			System.out.println("points:"+points);
			rs.close();
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return points;
		
	}
	
	public void connecToDatabase(int uid){
		
	
		
	}

}
