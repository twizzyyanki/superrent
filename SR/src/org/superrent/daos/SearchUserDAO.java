package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.views.superadmin.SearchUserPanel;

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
	private JTable table;
	private JScrollPane scrollPane;
	private SearchUserPanel sup;
	
	public SearchUserDAO (SearchUserPanel sup) {
		this.sup = sup;
		/* Get data to search from search user panel view */
		System.out.println("Now, you entered into search user DAO...");
		name = sup.getInputName();
		if (isInteger(sup.getInputPhone())) {
			phone = Long.parseLong(sup.getInputPhone());
			/* How about the size of phone number */
		}
		else {
			System.out.println("The phone number is not valid. Please try again");
		}
		table = sup.getTable();
		scrollPane = sup.getScrollPane();
		
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
			String query = "SELECT name,email,phoneNumber,CASE "
								+ " WHEN type = 0 THEN 'Customer' WHEN type = 1 THEN 'ClubMember' WHEN type = 2 THEN 'Clerk' WHEN type = 3 THEN 'Manager' WHEN type = 4 THEN 'SystemAdmin'	END as type,address FROM User WHERE name='" + name +"'" + " AND phoneNumber='" + phone + "'";
			System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			scrollPane.setVisible(true);
			table.setVisible(true);
	
			
			if (table.getModel().getRowCount()!= 0){
				System.out.println("Successful");
				sup.getSearchUserMessage().setText(
						"User information is shown below:\n"
						);
			}
			else {
				System.out.println("The user does not exist");
				sup.getSearchUserMessage().setText(
						"Search failed, wrong user name or phone number");
				scrollPane.setVisible(false);
				table.setVisible(false);
			}
			
			
		}catch (Exception e) {
			//DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
	}
	
	
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
