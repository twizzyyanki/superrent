package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.entities.RegUser;
import org.superrent.entities.User;

import java.sql.PreparedStatement;

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
			PreparedStatement st = connection
					.prepareStatement("SELECT * FROM RegUser WHERE username = ? AND password= ?");
			st.setString(1, username);
			st.setString(2, password);
			regUser = st.executeQuery();

			if (regUser != null) {
				while (regUser.next()) {

					uid = regUser.getInt("uid");
					System.out.println("Setting uid to " + uid);
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
				PreparedStatement st = connection
						.prepareStatement("SELECT * FROM User WHERE uid = ?");
				st.setInt(1, uid);
				user = st.executeQuery();
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
			PreparedStatement st = connection
					.prepareStatement("SELECT * FROM User WHERE email= ?");
			st.setString(1, email);
			user = st.executeQuery();

			if (user != null) {
				while (user.next()) {
					u.setUid(user.getInt("uid"));
					u.setEmail(user.getString("email"));
					u.setName(user.getString("name"));
					u.setRegUser(findRegUserByUid(u.getUid()));
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
		String pass = UUID.randomUUID().toString().substring(0, 5);
		System.out.println("uuid = " + pass);
		String newPass = org.apache.commons.codec.digest.DigestUtils
				.md5Hex(pass);
		try {
			connection = DatabaseConnection.createConnection();
			PreparedStatement st = connection
					.prepareStatement("UPDATE RegUser SET password = ? WHERE uid = ?");
			st.setString(1, newPass);
			st.setInt(2, u.getUid());
			int affectedRow = st.executeUpdate();

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
			PreparedStatement st = connection
					.prepareStatement("SELECT * FROM RegUser WHERE uid=?");
			st.setInt(1, uid);
			user = st.executeQuery();

			if (user != null) {
				while (user.next()) {
					u.setUsername(user.getString("username"));
					u.setPassword(user.getString("password"));
					u.setDatecreated(user.getDate("datecreated"));
				}
			} else {
				System.out
						.println("Resultset is null and this is how you want fddfd it");
			}
		} catch (Exception e) {
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
