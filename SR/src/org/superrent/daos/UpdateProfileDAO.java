package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.LoggedInUser;
import org.superrent.application.DatabaseConnection;

import sun.applet.Main;
//import sun.security.util.BigInt;


import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.recompile;


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
			//uidString = "2";
			this.uid = Integer.parseInt(uidString);
			connection = DatabaseConnection.createConnection();
			

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
	public boolean updatePhoneNumber(String phoneNumber){
		boolean success = false;
		PreparedStatement  ps;
		try{
			int newPhoneNumber = Integer.parseInt(phoneNumber);
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
			
			
		}
		catch(NumberFormatException e){
			success = false;
			return success;
		}
		catch (Exception e) {
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
	
	public boolean updatemail(String email){
		boolean success = false;
		PreparedStatement  ps;
		
		try{
			String query = "UPDATE User SET email = ? WHERE uid = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(2, uid);
			ps.setString(1, email);
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
	 * This method is used to get user's current name
	 * @return user's name
	 */
	public String getName(){
		String name ="";
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT name FROM User WHERE uid='" + uid +"'";
			rs = st.executeQuery(query);
			rs.next();
			name = rs.getString("name");			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return name;
	}
	
	/**
	 * This method is used to get user's phone number
	 * @return user's phone number
	 */
	public long getPhoneNumber(){
		long phoneNumber=0;
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT phoneNumber FROM User WHERE uid='" + uid +"'";
			rs = st.executeQuery(query);
			rs.next();
			phoneNumber = rs.getLong("phoneNumber");			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return phoneNumber;
	}
	
	
	/**
	 * This method is used to get user'saddress
	 * @return user's address
	 */
	public String getAddress(){
		String address ="";
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT address FROM User WHERE uid='" + uid+ "'";
			rs = st.executeQuery(query);
			rs.next();
			address = rs.getString("address");			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return address;
	}
	
	public String getEmail(){
		String email="";
		
		
		try{
			
			connection.setAutoCommit(false);
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT email FROM User WHERE uid='" + uid+ "'";
			
			rs = st.executeQuery(query);
			if(rs.next()){
				email = rs.getString("email");
				System.out.println("email"+email);
			}
			
			connection.commit(); 
		}

		catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			return email;
		}
		
		
		
		
	}
	
}
