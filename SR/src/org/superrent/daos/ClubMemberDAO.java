package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
	
public class ClubMemberDAO {
	private Connection connection = null;
	private int uid;
	private final LoggedInUser lc; 

	/**
	 * This is the constructor for this class
	 */		
	public ClubMemberDAO() {
		this.lc = new LoggedInUser();
		try {
				String uidString;
				uidString = lc.getUserId();
				// uidString = "1"; is just for test can delete after testing
				//uidString ="5";
				this.uid = Integer.parseInt(uidString);
				connection = DatabaseConnection.createConnection();
				
			
			
	
		} catch (Exception e) {
			DatabaseConnection.rollback(connection);
			DatabaseConnection.close(connection);
			e.printStackTrace();
		} 
	}

	public double getPoints(){
		double points = 0;
		try{
			ResultSet rs;
			
			Statement st = connection.createStatement();
			String query = "SELECT points FROM ClubMember WHERE uid='" + uid +"'";
			//System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			if(rs.next())
			{
				points = rs.getDouble("points");
			}
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return points;
	
	}
	
	public boolean getReservation(java.sql.Date fromDate, java.sql.Date toDate, JTable table, JScrollPane scrollPane){
		
		boolean success = false;
		
		try{
			ResultSet rs;
			connection.setAutoCommit(false);
			Statement st = connection.createStatement();
			String query = "SELECT MakeReservation.confirmationNo ,pickDate,dropDate FROM MakeReservation ,Reservation WHERE uid='" 
							+ uid +"'" + "AND MakeReservation.confirmationNo = Reservation.confirmationNo AND Reservation.pickDate BETWEEN '"
							+fromDate +"' AND '"+toDate+"'"  ;
			//System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			scrollPane.setVisible(true);
			table.setVisible(true);
			success = true;
			connection.commit(); 
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			return success;
		}
		
		
		
	}



}
