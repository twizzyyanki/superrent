package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.entities.MakeReservation;
import org.superrent.entities.Reservation;
import org.superrent.entities.User;

public class ReservationDao {

	Connection con;
	private static ResultSet resultSet = null;

	public void searchVehiclesForReservation(Date pickupDate, Date dropDate,
			String type, String category, JTable table, JScrollPane scrollPane) {
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
		

		String query = "SELECT Distinct category as Category, type as Type, brand as Brand from Vehicle where status = 0 "
				+ (category.equalsIgnoreCase("All") ? ("")
						: (" and category = " + "'" + category.toUpperCase() + "'"))
				+ (type.equalsIgnoreCase("All") ? ("") : (" and type = " + "'"
						+ type.toUpperCase() + "'"))
				+ " and regNo not in (select regNo from MakeReservation where confirmationNo in (select confirmationNo from"
				+ " Reservation where status = 0 and pickDate between '"
				+ new java.sql.Date(pickupDate.getTime())
				+ "'"
				+ " and '"
				+ new java.sql.Date(dropDate.getTime())
				+ " '  or dropDate between ' "
				+ new java.sql.Date(pickupDate.getTime())
				+ "' and ' "
				+ new java.sql.Date(dropDate.getTime()) + "'))";
		
		resultSet = st.executeQuery(query);
		//Map the resultset to the search table
		table.setModel(DbUtils.resultSetToTableModel(resultSet));
		scrollPane.setVisible(true);
		table.setVisible(true);

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
		}
	}

	public Integer getUid(User user) {

		Integer uid = null;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			uid = userExists(user);

			if (null == uid) {
				addUser(user);
				uid = userExists(user);
			}

			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DatabaseConnection.close(con);
		}

		return uid;
	}

	private void addUser(User user) throws SQLException {

		Statement st = con.createStatement();
		String query = "INSERT INTO User (name,email,phoneNumber,dateCreated,type,address) VALUES ('"
				+ user.getName()
				+ " ', '"
				+ user.getEmail()
				+ " ',"
				+ user.getPhoneNumber()
				+ " ', '"
				+ new java.sql.Date(user.getDateCreated().getTime())
				+ " ', "
				+ user.getType() + " , '" + user.getAddress() + "')";
		System.out.println(query);
		st.executeUpdate(query);

	}

	private Integer userExists(User user) throws SQLException {
		Integer uid = null;
		Statement st = con.createStatement();

		String query = "select uid from User where phoneNumber = "
				+ user.getPhoneNumber();
		System.out.println(query);
		resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			uid = resultSet.getInt("uid");
		}

		return uid;
	}

	public boolean makeReservation(Reservation reservation,
			MakeReservation makeReservation) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);

			Date date = new Date();
			reservation.setCreatedDate(new java.sql.Date(date.getTime()));
			makeReservation
					.setLastUpdatedDate(new java.sql.Date(date.getTime()));
			insertIntoReservation(con, reservation);
			insertIntoMakeReservation(con, makeReservation);
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(con);
		}
		return result;

	}

	private void insertIntoMakeReservation(Connection con,
			MakeReservation makeReservation) throws ClassNotFoundException,
			SQLException {

		Statement st = con.createStatement();
		// change status in reservation table and make reservation table
		String query = "Insert into MakeReservation (uid, confirmationNo, date, regNo, status) values "
				+ "("
				+ makeReservation.getUid()
				+ ","
				+ makeReservation.getConfirmationNo()
				+ ","
				+ "'"
				+ makeReservation.getLastUpdatedDate()
				+ "',"
				+ "'"
				+ makeReservation.getRegNo() + "'," + 0 + ")";
		System.out.println(query);
		st.executeUpdate(query);

	}

	private void insertIntoReservation(Connection con, Reservation reservation)
			throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		// change status in reservation table and make reservation table
		String query = "INSERT INTO Reservation (pickDate, dropDate, creationDate,charges,status) values "
				+ "('"
				+ new java.sql.Date(reservation.getPickDate().getTime())
				+ "',"
				+ "'"
				+ new java.sql.Date(reservation.getDropDate().getTime())
				+ "',"
				+ "'"
				+ reservation.getCreatedDate()
				+ "',"
				+ reservation.getCharges() + "," + 0 + ")";
		System.out.println(query);
		st.executeUpdate(query);

	}

	public boolean cancelReservation(Integer confirmationNo) {

		boolean result = true;

		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			changeReservationStatus(con, confirmationNo);
			changeMakeReservationStatus(con, confirmationNo);
			con.commit();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(con);
		}
		return result;

	}

	public boolean cancelReservation(String phoneNumber,
			java.util.Date reservedDate) {

		boolean result = true;

		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Integer confirmationNo = getConfirmationNumber(con, phoneNumber,
					reservedDate);
			changeReservationStatus(con, confirmationNo);
			changeMakeReservationStatus(con, confirmationNo);

			con.commit();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(con);
		}
		return result;

	}

	private Integer getConfirmationNumber(Connection con, String phoneNumber,
			Date reservedDate) throws SQLException {
		Integer confirmationNo = null;

		Statement st = con.createStatement();
		String query = "select confirmationNo from MakeReservation where status = 0 and date = '"
				+ new java.sql.Date(reservedDate.getTime())
				+ "' and uid = (select uid from User where phoneNumber = "
				+ phoneNumber + ")";
		System.out.println(query);
		resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			confirmationNo = resultSet.getInt("confirmationNo");
		}
		return confirmationNo;
	}

	private void changeMakeReservationStatus(Connection con,
			Integer confirmationNo) throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		String query1 = "UPDATE Reservation SET  MakeReservation =" + 3
				+ " where confirmationNo = '" + confirmationNo;
		System.out.println(query1);
		st.executeUpdate(query1);

	}

	private void changeReservationStatus(Connection con, Integer confirmationNo)
			throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		String query = "UPDATE Reservation SET  status =" + 1
				+ " where confirmationNo = " + confirmationNo;
		System.out.println(query);
		st.executeUpdate(query);

	}
}
