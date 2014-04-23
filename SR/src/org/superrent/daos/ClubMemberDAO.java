package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.entities.Reservation;
	
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
			rs.next();
			points = rs.getDouble("points");
			
			
			
			
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		return points;
	
	}
	
	public ArrayList<Vector> getReservation(){
		ArrayList <Vector> reseratvionRecords = new ArrayList<Vector>();
		
		
		try{
			ResultSet rs;
			connection.setAutoCommit(false);
			Statement st = connection.createStatement();
			String query = "SELECT MakeReservation.confirmationNo ,pickDate,dropDate FROM MakeReservation ,Reservation WHERE uid='" 
							+ uid +"'" + "AND MakeReservation.confirmationNo = Reservation.confirmationNo";
			//System.out.println("query is: " + query);
			rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Vector recordsPerRow = new Vector();
				
				recordsPerRow.add(rs.getInt("MakeReservation.confirmationNo"));
				recordsPerRow.add(rs.getDate("pickDate"));
				recordsPerRow.add(rs.getDate("dropDate"));
				reseratvionRecords.add(recordsPerRow);
			
				
			}
			connection.commit(); 
			
		}catch (Exception e) {
			DatabaseConnection.rollback(connection);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(connection);
			
		}
		
		
		return reseratvionRecords;
	}
	/**
	 * test main
	 * @param args
	 */
	public static void main(String[] args){
		ClubMemberDAO cDao = new ClubMemberDAO();
		ArrayList testV = cDao.getReservation();
		System.out.println("size"+testV.size());
	
			System.out.println(testV.get(0));


		
	}


}
