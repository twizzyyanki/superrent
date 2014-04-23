package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.LoggedInUser;
import org.superrent.application.DatabaseConnection;

import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orb.StringPair;

public class ChangePasswordDAO {
	
	private Connection connection = null;
	private int uid;
	private String currentPassword;
	private String changePasswordDAO;
	private final LoggedInUser lc; 
	
	public ChangePasswordDAO(){
		this.lc = new LoggedInUser();
		try {
			String uidString;
			uidString = lc.getUserId();
			// uidString = "1"; is just for test can delete after testing
			//uidString = "1";
			this.uid = Integer.parseInt(uidString);
			connection = DatabaseConnection.createConnection();

		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
		
	}
	/**
	 * This method is used to validate user's current password
	 * @param password is user's current password 
	 * @return true if the password match the currentPassword in the database
	 */
	public boolean checkOldPassword(String password){
		
		boolean exist = false;
		String currentPassword;
		
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT password FROM RegUser WHERE uid='" + uid +"'";
			//System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			rs.next();
			currentPassword = rs.getString("password");
			if(currentPassword.equals(password)){
				exist = true;
			}
			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
	
		return exist;
	}
	
	/**
	 * This method is used to set new password
	 * @param newPassword is the new password that the user wants to update
	 * @return true if the update successes
	 */
	public boolean setNewPassword(String newPassword){
		
		boolean success = false;
		PreparedStatement  ps;
		
		try{
			
			String query = "UPDATE RegUser SET password = ? WHERE uid = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(2, uid);
			ps.setString(1, newPassword);
			int rowCount = ps.executeUpdate();
			  if (rowCount == 0){
				  success = false ;
			  }
			  else{
				  success = true;
			  }
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
	
		return success;
	}

	
	
/*	*//**
	 * test main
	 * @param args
	 *//*
	public static void main(String[] args){
		ChangePasswordDAO changePasswordDAO = new ChangePasswordDAO();
		if(changePasswordDAO.setNewPassword("newPassword")){
			System.out.println("correct!");
		}
		
	}
*/
}
