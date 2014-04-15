package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.LoggedInUser;
import org.superrent.application.DatabaseConnection;

//import sun.security.util.BigInt;

import com.mysql.jdbc.PreparedStatement;


public class UpdateProfileDAO {

	private Connection connection = null;
	private int uid;
	private final LoggedInUser lc; 
	
	/**
	 * This is constructor of this class. It initializes the current uid.
	 */
	public UpdateProfileDAO(){
		this.lc = new LoggedInUser();
		try {
			String uidString;
			uidString = lc.getUserId();
			// uidString = "1"; is just for test can delete after testing
			uidString = "1";
			this.uid = Integer.parseInt(uidString);
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());

		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * This method is used to update user's name
	 * @param newName is the new name that the user wants to update
	 * @return true if update success
	 */
	public boolean updateName(String newName){
		boolean success = false;
		PreparedStatement  ps;
		
		try{
			String query = "UPDATE User SET name = ? WHERE uid = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(2, uid);
			ps.setString(1, newName);
			int rowCount = ps.executeUpdate();
			
			  if (rowCount == 1){
				  success = true ;
			  }
			  else {
				  success = false;
				  
			  }
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return success;	
	}
	/**
	 * This method is used to update user's phone number
	 * @param newPhoneNumber is the new phone number that the user wants to update
	 * @return true if update success
	 */
	public boolean updatePhoneNumber(int newPhoneNumber){
		boolean success = false;
		PreparedStatement  ps;
		try{
			String query = "UPDATE User SET phoneNumber = ? WHERE uid = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(2, uid);
			ps.setLong(1, (long)newPhoneNumber);
			int rowCount = ps.executeUpdate();
			  if (rowCount == 1){
				  success = true ;
				  
			  }
			  else {
				  success = false;
				  
				  
			  }
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		
		return success;	
	}
	/**
	 * This method is used to update user's address
	 * @param newAddress is the new address that the user wants to update
	 * @return true if update success
	 */
	
	public boolean updateAddress(String newAddress){
		boolean success = false;
		PreparedStatement  ps;
		
		try{
			String query = "UPDATE User SET address = ? WHERE uid = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(2, uid);
			ps.setString(1, newAddress);
			int rowCount = ps.executeUpdate();
			  if (rowCount == 1){
				  success = true ;
				  
			  }
			  else {
				  success = false;
				  
			  }
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return success;	
	}
	
	
}
