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
			int year = managerFrame.getSearchVehicleListPanel().getYearChooser().getValue();
			String status = (String)managerFrame.getSearchVehicleListPanel().getStatusCombox().getSelectedItem();
			int inputStatus = 3;
			
			if(status.equalsIgnoreCase("Sold")){
				inputStatus = 2;
			}else if(status.equalsIgnoreCase("For-Rent")){
				inputStatus = 0;
			}else if(status.equalsIgnoreCase("For-Sale")){
				inputStatus = 1;
			}

			System.out.println("inputStatus " + inputStatus + "status " + status);
			String query = "SELECT regNo as RegisterNumber, category as Category, type as Type, brand as Brand,purchaseDate as PurchasedDate, CASE "
								+ " WHEN status = 0 THEN 'FOR-RENT' WHEN status = 1 THEN 'FOR-SALE' WHEN status = 2 THEN 'SOLD'	END AS Status FROM Vehicle Where year(purchaseDate) <= " 
								+ year + " "+ (category.equalsIgnoreCase("All") ?(""):("and category = " + "'" + category.toUpperCase() + 
								"'"))	+ (type.equalsIgnoreCase("All") ?(""):("and type = " + "'" + type.toUpperCase() + "'" + status.equalsIgnoreCase("All"))) + (inputStatus == 3 ? "" : " and status = " + inputStatus);  
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
			String query = "SELECT regNo as RegisterNumber, price as Price, dateMadeAvailableForSale as ForSaleFrom FROM ForSaleVehicles where soldDate is null";
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

	//@Override
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

	//@Override
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
	//have to add one more error message dialog 
	//@Override
	public boolean sellVehicle(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "INSERT INTO ForSaleVehicles values (" + sellVehicleVO.getRegNo() +"," + sellVehicleVO.getPrice() + ","
													+ null +",'"+
													sellVehicleVO.getForSaleFrom()+ "')";
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 1 where regNo =" + sellVehicleVO.getRegNo();
			st.executeUpdate(changeStatus);
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

	//@Override
	public boolean vehicleSold(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE ForSaleVehicles SET soldDate = CURDATE() where regNo =" + sellVehicleVO.getRegNo();
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 2 where regNo =" + sellVehicleVO.getRegNo();
			st.executeUpdate(changeStatus);
			con.commit();
			
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

	//@Override
	public boolean updateSellingPrice(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE ForSaleVehicles SET price = " + sellVehicleVO.getPrice() + " where regNo =" + sellVehicleVO.getRegNo();
			System.out.println(query);
			
			st.executeUpdate(query);
			con.commit();

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
	
	//@Override
	public boolean moveForRent(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "DELETE FROM ForSaleVehicles where regNo =" + sellVehicleVO.getRegNo();
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 0 where regNo =" + sellVehicleVO.getRegNo();
			st.executeUpdate(changeStatus);
			con.commit();

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
