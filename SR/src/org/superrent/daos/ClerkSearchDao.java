package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;

public class ClerkSearchDao {
	
	Connection con;
	private static ResultSet resultSet = null;
	
	public void showAvailableVehicles(Date pickupDate, Date dropDate,
			String type, String category){
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			

			String query = "SELECT category as Category, type as Type, brand as Brand, regNo from Vehicle where status = 0 "
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
			
		System.out.println(query);
		
		resultSet = st.executeQuery(query);
		
		
		//table.setModel(DbUtils.resultSetToTableModel(resultSet));
		//scrollPane.setVisible(true);
		//table.setVisible(true);

		
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
	
	public void showOverdueVehicles(){
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			

			String query = "select" 
									+ "v.regNo as RegistrationNumber"
									+ ", v.category as Category"
									+ ", v.type as Type" 
									+ ", v.brand as brand"
									+ ", r.confirmationNo as ConfirmationNumber"
									+ ", r.pickDate as PickUpDate"
									+ ", r.creationDate as ReservedOn"
									+ ", ur.name as ReservedBy"
									+ ", ur.email as Email"
									+ ", ur.phoneNumber as PhoneNumber"
							+ "from" 
									+ "Vehicle v"
									+ "Inner join MakeReservation mr"
									+ "on mr.regNo = v.regNo"
									+ "Inner join Reservation r"
									+ "on r.confirmationNo = mr.confirmationNo"
									+ "Inner join User ur"
									+ "on ur.uid = mr.uid"
									+ "where"
									+ "r.pickDate < curdate() and r.status = 0"
									+ "and mr.status = 0 and v.status = 0";
			
		System.out.println(query);
		
		resultSet = st.executeQuery(query);
		
		//Map the resultset to the search table
		//table.setModel(DbUtils.resultSetToTableModel(resultSet));
		//scrollPane.setVisible(true);
		//table.setVisible(true);

		
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
	
	public void getForSaleVehicles(String category){
		try {
			
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "SELECT" 
								 + "v.regNo as RegisterNumber"
								 + ", v.category as Category"
								 + ", v.type as Type"
								 + ", v.brand as Brand" 
								 +",v.purchaseDate as PurchasedDate"
								 + ",fv.price as Price"
								 + ",fv.dateMadeAvailableForSale as OnSaleFrom"
								 + ", CASE" 
								 + "WHEN status = 0 THEN 'FOR-RENT'" 
								 + "WHEN status = 1 THEN 'FOR-SALE'" 
								 + "WHEN status = 2 THEN 'SOLD'"	
								 + "END AS Status" 
						    + "FROM" 
								  + " Vehicle v"
						  		  + "Inner join ForSaleVehicles fv"
						  		  + "on fv.regNo = v.regNo"
						  		  + "Where " 
						  		  + "v.status = 1"
						  		  +(category.equalsIgnoreCase("All") ?(""):("and category = " + "'" + category.toUpperCase())) ;  
			
			System.out.println(query);
			
			resultSet = st.executeQuery(query);
			
			//managerFrame.getSearchVehicleListPanel().getSearchtable().setModel(DbUtils.resultSetToTableModel(resultSet));
			System.out.println("Working");
			

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

}
