package org.superrent.daos;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.views.superadmin.AddUserPanel;

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
	private AddUserPanel aup;
	boolean isValid;
	private int uid;

	
	
	public AddUserDAO (AddUserPanel aup) {
		this.aup = aup;
		isValid = true;
		/* Get data to search from search user panel view */
		System.out.println("Now, you entered into add user DAO...");
		type = aup.getInputType();
		name = aup.getInputName();
		phone = Long.parseLong(aup.getInputPhone());
		address = aup.getInputAddress();
		email = aup.getInputEmail();
		
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
			ResultSet rs,rs2;
			Statement st = connection.createStatement();
			connection.setAutoCommit(false);
			String query = "INSERT INTO `superrent`.`User` (`name`, `email`, `phoneNumber`, `type`, `address`) VALUES ('" 
					+ name + "', '"+email+"', '"+phone+"', '"+type+"', '"+address+"');";
			System.out.println("query is: " + query);
			st.executeUpdate(query);
			String query2 = "SELECT MAX(uid) FROM User";
			rs2 = st.executeQuery(query2);
			while(rs2.next())
				uid = rs2.getInt("MAX(uid)");
			
			
			if (type != 0){
				
				String query3 = "INSERT INTO `superrent`.`RegUser` (`uid`, `username`) VALUES ('" 
						+ uid + "', '"+aup.getTextFieldUserName().getText()+"');";
				System.out.println("query is: " + query3);
				st.executeUpdate(query3);
				
				if (type == 1) {
					System.out.println("You are adding a clubmember");
					/* Insert it to club member table */
					String query4 = "INSERT INTO `superrent`.`ClubMember` (`uid`, `membershipNo`) VALUES ('" 
							+ uid + "', '"+Integer.parseInt(aup.getMembershipNo())+"');";
					System.out.println("query is: " + query4);
					st.executeUpdate(query4);
					/* Insert it to Reg User table */
				}
				else {
					System.out.println("You are adding a registered User that is not a clubmember");
					/* Insert it to Reg User table */
					
				
				}
			}
			
			connection.commit();
		}catch (Exception e) {
			isValid = false;
			DatabaseConnection.rollback(connection);
			System.out.println(e.getMessage());
			aup.getAddUserMessage().setForeground(Color.red);
			aup.getAddUserMessage().setText(
					"Operation failed.  "+e.getMessage());
		} finally {
			DatabaseConnection.close(connection);
		}
		if (isValid) {
			System.out.println("Successful");
			aup.getAddUserMessage().setForeground(Color.black);
			aup.getAddUserMessage().setText(
				"You successfully add a user.");
		}
	}
}
