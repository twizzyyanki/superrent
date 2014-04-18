package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

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
	
	public SearchUserDAO (String name, String phone, JTable table) {
		
		/* Get data to search from search user panel view */
		System.out.println("Now, you entered into search user DAO...");
		this.name = name;
		this.phone = Long.parseLong(phone);
		
		/* Connect to database */
		try {
			connection = DatabaseConnection.createConnection();
		} catch (Exception e) {
			//DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
		
		System.out.println("You are going to search "+ name + " with phone number"+ phone + " in the database");
		
		/* Create SQL query and perform the search */
		try{
			ResultSet rs;
			Statement st = connection.createStatement();
			String query = "SELECT name,email,phoneNumber,type,address FROM User WHERE name='" + name +"'" + " AND phoneNumber='" + phone + "'";
			System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));

			if (rs.next()){
				System.out.println("In the database, the data associated wiht "+ name + " is as follows:");
				System.out.print(rs.getString("name") + " "); 
				System.out.print(rs.getString("email") + " "); 
				System.out.print(rs.getString("phoneNumber") + " "); 
				System.out.print(rs.getString("address") + " "); 
				//System.out.print(rs.getString("type") + " "); 
				//System.out.println(rs.getString("dateCreated"));
			}
			else {
				System.out.println("The user does not exist");
			}
			
			table.setVisible(true);
		}catch (Exception e) {
			//DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
	}
}
