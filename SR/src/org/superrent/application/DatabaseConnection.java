package org.superrent.application;

import java.sql.*;
import java.util.*;

public class DatabaseConnection {

	/*private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/SuperRent";
	private static final String DEFAULT_USERNAME = "root";
	private static final String DEFAULT_PASSWORD = "";*/
	
	private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DEFAULT_URL = "jdbc:mysql://superrent.c6stxmjzckce.us-west-2.rds.amazonaws.com:3306/superrent";
	private static final String DEFAULT_USERNAME = "superrent";
	private static final String DEFAULT_PASSWORD = "justdoit505";

	public static void main(String[] args) {
		long begTime = System.currentTimeMillis();

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://superrent.c6stxmjzckce.us-west-2.rds.amazonaws.com:3306/superrent";
		String username = "superrent";
		String password = "justdoit505";

		Connection connection = null;

		try {
			connection = createConnection(driver, url, username, password);
			connection.setAutoCommit(false);
			Statement st = connection.createStatement();
			st.executeUpdate("INSERT INTO USER(username, password) VALUES('Yankis','Twizzy')");

		} catch (Exception e) {
			rollback(connection);
			e.printStackTrace();
		} finally {
			close(connection);
			long endTime = System.currentTimeMillis();
			System.out.println("wall time: " + (endTime - begTime) + " ms");
		}
	}

	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(DEFAULT_DRIVER);

		return DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME,
				DEFAULT_PASSWORD);

	}

	public static Connection createConnection(String driver, String url,
			String username, String password) throws ClassNotFoundException,
			SQLException {
		Class.forName(driver);

		return DriverManager.getConnection(url, username, password);

	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> map(ResultSet rs)
			throws SQLException {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			if (rs != null) {
				ResultSetMetaData meta = rs.getMetaData();
				int numColumns = meta.getColumnCount();
				while (rs.next()) {
					Map<String, Object> row = new HashMap<String, Object>();
					for (int i = 1; i <= numColumns; ++i) {
						String name = meta.getColumnName(i);
						Object value = rs.getObject(i);
						row.put(name, value);
					}
					results.add(row);
				}
			}
		} finally {
			close(rs);
		}
		return results;
	}

	public static List<Map<String, Object>> query(Connection connection,
			String sql, List<Object> parameters) throws SQLException {
		List<Map<String, Object>> results = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);

			int i = 0;
			for (Object parameter : parameters) {
				ps.setObject(++i, parameter);
			}
			rs = ps.executeQuery();
			results = map(rs);
		} finally {
			close(rs);
			close(ps);
		}
		return results;
	}

	public static int update(Connection connection, String sql,
			List<Object> parameters) throws SQLException {
		int numRowsUpdated = 0;
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);

			int i = 0;
			for (Object parameter : parameters) {
				ps.setObject(++i, parameter);
			}
			numRowsUpdated = ps.executeUpdate();
		} finally {
			close(ps);
		}
		return numRowsUpdated;
	}
	
	
}
