package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.superrent.application.DatabaseConnection;
import org.superrent.entities.RegUser;
import org.superrent.entities.User;

public class UserDAO {

	public static List loginUser(String username, String password) {
		Connection connection = null;
		ResultSet regUser, user = null;
		User u = new User();
		RegUser ru = new RegUser();
		int uid = 0;
		try {
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			Statement st = connection.createStatement();
			String query = "SELECT * FROM RegUser WHERE username='" + username + "' AND password='" + password + "'";
			System.out.println("query is: " + query);
			regUser = st.executeQuery(query);

			System.out.println("Size of result set is " + regUser.getFetchSize());
			
			if (regUser != null) {
				while (regUser.next()) {
					uid = regUser.getInt(1);
				//	user = st.executeQuery("SELECT * FROM User WHERE uid = " + uid);
				}
			} else {
				System.out.println("Resultset is null");
			}

			System.out.println("User id is" + uid);

		} catch (Exception e) {
			// DatabaseConnection.rollback(connection);
			e.printStackTrace();
		}

		if (uid > 0) {
			try {
				return DatabaseConnection.map(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// DatabaseConnection.close(connection);
			}
		} else {
			return null;
		}
		return null;
	}
}
