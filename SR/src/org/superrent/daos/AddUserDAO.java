package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;

/**
 * 
 * This class is the DAO to load information for a system administrator 
 *
 */
public class AddUserDAO {
	private Connection connection = null; 
	private int type;
	private String name;
	private long phone;
	private String address;
	private String email;
	boolean isValid = true;
	
	public AddUserDAO (int type, String name, String phone, String address, String email) {
		
		/* Get data to search from search user panel view */
		System.out.println("Now, you entered into add user DAO...");
		this.type = type;
		this.name = name;
		this.phone = Long.parseLong(phone);
		this.address = address;
		this.email = email;
		
		/* Connect to database */
		try {
			connection = DatabaseConnection.createConnection();
		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
		
		System.out.println("You are going to add a user with following information: ");
		System.out.print("User type: "+type+" ");
		System.out.print("User Name: "+name+" ");
		System.out.print("Phone Number: "+phone+" ");
		System.out.print("Address: "+address+" ");
		System.out.println("Email: "+email+" ");
		
		/* Create SQL query and perform the add */
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			connection.setAutoCommit(false);
			String query = "INSERT INTO `superrent`.`User` (`name`, `email`, `phoneNumber`, `type`, `address`) VALUES ('" 
					+ name + "', '"+email+"', '"+phone+"', '"+type+"', '"+address+"');";
			System.out.println("query is: " + query);
			st.executeUpdate(query);
			connection.commit();
		}catch (Exception e) {
			isValid = false;
			DatabaseConnection.rollback(connection);
			System.out.println(e.getMessage());
		} finally {
			DatabaseConnection.close(connection);
		}
		if (isValid)
			System.out.println("Successful");
	}
}
