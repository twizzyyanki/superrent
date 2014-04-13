package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.ManagerHome;

public class ManagerDaoImpl implements IManagerDao{
	
	
	Connection con;
	private static ResultSet resultSet = null;
	
	
	
	public void getAllVehicles(ManagerHome managerFrame) {
      
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			String category =(String)managerFrame.getSearchVehicleListPanel().getCategoryCombox().getSelectedItem();
			String type =(String)managerFrame.getSearchVehicleListPanel().getTypeCombox().getSelectedItem();
			String query = "SELECT * FROM Vehicle Where 1=1 " + (category.equalsIgnoreCase("All") ?(""):("and category = " + "'" + category.toUpperCase() + 
					"'"))	+ (type.equalsIgnoreCase("All") ?(""):("and type = " + "'" + type.toUpperCase() + "'"));  
			System.out.println(query);
			
			resultSet = st.executeQuery(query);
			
			managerFrame.getSearchVehicleListPanel().getSearchtable().setModel(DbUtils.resultSetToTableModel(resultSet));
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
		
	public void getVehiclesForSelling(ManagerHome managerFrame) {
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			System.out.println( "------" + managerFrame.getComboBox_1().getSelectedItem());
			String query = "SELECT * FROM ForSaleVehicles";
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
		finally {
			DatabaseConnection.close(con);
		}
		
	}

	@Override
	public boolean addVehicle(VehicleVO vehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "INSERT INTO Vehicle values (" + vehicleVO.getRegNo() +",'" + vehicleVO.getCategory() + "','"
													+ vehicleVO.getType() +"','"+ vehicleVO.getBrand()+"','"+
													vehicleVO.getPurchaseDate() + "'," + "0)";
			System.out.println(query);
			st.executeUpdate(query);
			con.commit();
			System.out.println("In here");
			
			System.out.println("Working");
			//result = DatabaseConnection.map(resultSet);

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
		}
		return result;
	}

	@Override
	public boolean updateVehicle(VehicleVO vehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE Vehicle SET category = '" + vehicleVO.getCategory() + "', type ='"
													+ vehicleVO.getType() +"',brand = '"+ vehicleVO.getBrand()+"', purchaseDate= '"+
													vehicleVO.getPurchaseDate() + "' WHERE regNo = " + vehicleVO.getRegNo();
			System.out.println(query);
			st.executeUpdate(query);
			con.commit();
			System.out.println("In here");
			
			System.out.println("Working");
			//result = DatabaseConnection.map(resultSet);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
		}
		return result;
		
	}

	@Override
	public boolean sellVehicle(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "INSERT INTO ForSaleVehicles values (" + sellVehicleVO.getRegNo() +"," + sellVehicleVO.getPrice() + ","
													+ null +","+ null +",'"+
													sellVehicleVO.getForSaleFrom()+ "')";
			System.out.println(query);
			st.executeUpdate(query);
			con.commit();
			System.out.println("In here");
			
			System.out.println("Working");
			//result = DatabaseConnection.map(resultSet);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
		}
		return result;
	}
}
