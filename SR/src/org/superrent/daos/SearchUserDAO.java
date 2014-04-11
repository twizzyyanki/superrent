package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.DatabaseConnection;


/**
 * 
 * This class is the DAO to load information for a system administrator 
 *
 */
public class SearchUserDAO {
	private Connection connection = null; 
	private int uid;
	private String name;
	private long phone;
	
	public SearchUserDAO (String name, String phone) {
		
		/* Get data to search from search user panel view */
		System.out.println("Now, you entered into search user DAO...");
		this.name = name;
		this.phone = Long.parseLong(phone);
		
		/* Connect to database */
		try {
			connection = DatabaseConnection.createConnection();
		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
		
		System.out.println("You are going to search "+ name + " with phone number"+ phone + " in the database");
		
		/* Create SQL query and perform the search */
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT * FROM User WHERE name='" + name +"'" + " AND phoneNumber='" + phone + "'";
			System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			if (rs.next()){
					System.out.println("There is a user in the database");
			}
			else {
				System.out.println("The user does not exist");
			}
				
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
	}
}
