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

	public boolean cancelReservation(Reservation reservation) {
		
		boolean result = true;

		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			// change status in reservation table and make reservation table
			String query = "UPDATE Reservation SET  status =" + 1
					+ " where confirmationNo = '" + reservation.getConfirmationNo() + "'";
			System.out.println(query);			
			st.executeUpdate(query);
			
			String query1 = "UPDATE Reservation SET  MakeReservation =" + 3
					+ " where confirmationNo = '" + reservation.getConfirmationNo() + "'";
			System.out.println(query1);			
			st.executeUpdate(query1);
			
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
}
