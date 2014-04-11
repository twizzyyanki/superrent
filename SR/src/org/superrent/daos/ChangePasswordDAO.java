package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.superrent.application.LoggedInUser;
import org.superrent.application.DatabaseConnection;

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
			this.uid = Integer.parseInt("uidString");
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());

		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
		
	}
	
	public boolean checkOldPassword(String password){
		
		return true;
	}
	
	public boolean setNewPassword(String password){
		
		return true;
	}

}
