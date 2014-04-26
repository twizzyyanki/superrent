package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.superrent.application.DatabaseConnection;
import org.superrent.entities.MakeReservation;
import org.superrent.entities.Reservation;

public class ReservationDao {

	Connection con;
	private static ResultSet resultSet = null;

	public boolean makeReservation(Reservation reservation,
			MakeReservation makeReservation) {
		boolean result = true;
		try {

			Date date = new Date();
			reservation.setCreatedDate(new java.sql.Date(date.getTime()));
			makeReservation
					.setLastUpdatedDate(new java.sql.Date(date.getTime()));
			insertIntoReservation(reservation);
			insertIntoMakeReservation(makeReservation);

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

	private void insertIntoMakeReservation(MakeReservation makeReservation)
			throws ClassNotFoundException, SQLException {

		con = DatabaseConnection.createConnection();
		con.setAutoCommit(false);
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
		con.commit();
	}

	private void insertIntoReservation(Reservation reservation)
			throws ClassNotFoundException, SQLException {

		con = DatabaseConnection.createConnection();
		con.setAutoCommit(false);
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
		con.commit();
	}

	public boolean cancelReservation(Integer confirmationNo) {
		
		boolean result = true;

		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			changeReservationStatus(con,confirmationNo);
			changeMakeReservationStatus(con,confirmationNo);			
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
	
	public boolean cancelReservation(String phoneNumber, java.util.Date reservedDate ) {
		
		boolean result = true;

		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Integer confirmationNo = getConfirmationNumber(con,phoneNumber,reservedDate);
			changeReservationStatus(con,confirmationNo);
			changeMakeReservationStatus(con,confirmationNo);
			
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

	private Integer getConfirmationNumber(Connection con, String phoneNumber, Date reservedDate) throws SQLException {
		Integer confirmationNo = null;
		
		Statement st = con.createStatement();
		String query = "select confirmationNo from MakeReservation where status = 0 and date = '" + 
				new java.sql.Date(reservedDate.getTime()) + "' and uid = (select uid from User where phoneNumber = " + phoneNumber + ")";
		System.out.println(query);			
		resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			confirmationNo = resultSet.getInt("confirmationNo");
        }
		return confirmationNo;
	}

	private void changeMakeReservationStatus(Connection con, Integer confirmationNo) throws ClassNotFoundException, SQLException {
		
		
		Statement st = con.createStatement();
		String query1 = "UPDATE Reservation SET  MakeReservation =" + 3
				+ " where confirmationNo = '" + confirmationNo;
		System.out.println(query1);			
		st.executeUpdate(query1);
		
		
	}

	private void changeReservationStatus(Connection con, Integer confirmationNo) throws ClassNotFoundException, SQLException {
		
		Statement st = con.createStatement();
		// change status in reservation table and make reservation table
		String query = "UPDATE Reservation SET  status =" + 1
				+ " where confirmationNo = " + confirmationNo;
		System.out.println(query);			
		st.executeUpdate(query);
		
	}
}
