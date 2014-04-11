package org.superrent.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.views.manager.ManagerHome;

public class ManagerDaoImpl implements IManagerDao{
	
	
	private static Connection con = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private static List<Map<String, Object>> result;
	
	
	public void getAllVehicles(ManagerHome managerFrame) {

		try {
			Connection con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			System.out.println( "------" + managerFrame.getComboBox_1().getSelectedItem());
			String category =(String)managerFrame.getSearchVehicleListPanel().getCategoryCombox().getSelectedItem();
			String type =(String)managerFrame.getSearchVehicleListPanel().getTypeCombox().getSelectedItem();
			String query = "SELECT * FROM vehicle Where 1=1 " + (category.equalsIgnoreCase("All") ?(""):("and category = " + "'" + category.toUpperCase() + 
					"'"))	+ (type.equalsIgnoreCase("All") ?(""):("and vehicletype = " + "'" + type.toUpperCase() + "'"));  
			resultSet = st.executeQuery(query);
			System.out.println("In here");
			managerFrame.getSearchVehicleListPanel().getSearchtable().setModel(DbUtils.resultSetToTableModel(resultSet));
			System.out.println("Working");
			//result = DatabaseConnection.map(resultSet);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
		
	public void getVehiclesForSelling(ManagerHome managerFrame) {
		
		try {
			Connection con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			System.out.println( "------" + managerFrame.getComboBox_1().getSelectedItem());
			String query = "SELECT * FROM vehicleforsale";
			resultSet = st.executeQuery(query);
			System.out.println("In here");
			managerFrame.getSellVehicleListPanel().getSellTable().setModel(DbUtils.resultSetToTableModel(resultSet));
			System.out.println("Working");
			//result = DatabaseConnection.map(resultSet);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
