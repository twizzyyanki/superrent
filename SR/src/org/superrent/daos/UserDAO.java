package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.entities.RegUser;
import org.superrent.entities.User;

public class UserDAO {

	public static List<Map<String, String>> loginUser(String username,
			String password) {
		Connection connection = null;
		ResultSet regUser, user = null;
		User u = new User();
		RegUser ru = new RegUser();
		int uid = 0;
		List<Map<String, String>> mm = null;
		try {
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			Statement st = connection.createStatement();
			String query = "SELECT * FROM RegUser WHERE username='" + username
					+ "' AND password='" + password + "'";
			System.out.println("query is: " + query);
			regUser = st.executeQuery(query);

			if (regUser != null) {
				while (regUser.next()) {

					uid = regUser.getInt("uid");
					System.out.println("Setting uid to " + uid);
					// user = st.executeQuery("SELECT * FROM User WHERE uid = "
					// + uid);
				}
				LoggedInUser.setUserId(String.valueOf(uid));
				System.out.println("User id is now set to"
						+ LoggedInUser.getUserId());
			} else {
				System.out
						.println("Resultset is null and this is how you want fddfd it");
			}

			System.out.println("User id is " + uid);

		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}

		if (uid > 0) {
			try {
				connection = DatabaseConnection.createConnection();
				System.out.println(connection.toString());
				Statement st = connection.createStatement();
				String query = "SELECT * FROM User WHERE uid = " + uid;
				System.out.println("query is: " + query);
				user = st.executeQuery(query);
				user = st.executeQuery("SELECT * FROM User WHERE uid = " + uid);
				mm = DatabaseConnection.map(user);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.close(connection);
			}
		} else {
			return null;
		}
		return mm;
	}

	public static User findUserByEmail(String email) {
		Connection connection = null;
		ResultSet user = null;
		User u = new User();
		try {
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			Statement st = connection.createStatement();
			String query = "SELECT * FROM User WHERE email='" + email + "'";
			System.out.println("query is: " + query);
			user = st.executeQuery(query);

			if (user != null) {
				while (user.next()) {
					u.setUid(user.getInt("uid"));
					u.setEmail(user.getString("email"));
					u.setName(user.getString("name"));
					u.setRegUser(findRegUserByUid(u.getUid()));
					// user = st.executeQuery("SELECT * FROM User WHERE uid = "
					// + uid);
				}
			} else {
				System.out
						.println("Resultset is null and this is how you want fddfd it");
			}
		} catch (Exception e) {
			// DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
		if (user != null) {
			return u;
		} else {
			return null;
		}
	}

	public static String changePassword(User u) {
		Connection connection = null;
		String pass = UUID.randomUUID().toString().substring(0,5);
		System.out.println("uuid = " + pass);
		String newPass = org.apache.commons.codec.digest.DigestUtils
				.md5Hex(pass);
		try {
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			Statement st = connection.createStatement();
			String query = "UPDATE RegUser SET password = '" + newPass
					+ "' WHERE uid = " + u.getUid();
			System.out.println("query is: " + query);
			int affectedRow = st.executeUpdate(query);

			if (affectedRow != 1) {
				System.out
						.println("Resultset is null and this is how you want fddfd it");
				newPass = null;
			}
		} catch (Exception e) {
			// DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
		return pass;
	}
	
	public static RegUser findRegUserByUid(int uid) {
		Connection connection = null;
		ResultSet user = null;
		RegUser u = new RegUser();
		try {
			connection = DatabaseConnection.createConnection();
			System.out.println(connection.toString());
			Statement st = connection.createStatement();
			String query = "SELECT * FROM RegUser WHERE uid=" + uid;
			System.out.println("query is: " + query);
			user = st.executeQuery(query);

			if (user != null) {
				while (user.next()) {
				//	u.setUid(user.getInt("uid"));
					u.setUsername(user.getString("username"));
					u.setPassword(user.getString("password"));
					u.setDatecreated(user.getDate("datecreated"));
					// user = st.executeQuery("SELECT * FROM User WHERE uid = "
					// + uid);
				}
			} else {
				System.out
						.println("Resultset is null and this is how you want fddfd it");
			}
		} catch (Exception e) {
			// DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(connection);
		}
		if (user != null) {
			return u;
		} else {
			return null;
		}
	}
}
