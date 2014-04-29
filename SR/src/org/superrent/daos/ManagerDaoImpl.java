package org.superrent.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import net.proteanit.sql.DbUtils;

import org.superrent.application.DatabaseConnection;
import org.superrent.entities.AdditionalEquipment;
import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.SuperRent;
import org.superrent.entities.SuperRentInsuranceRate;
import org.superrent.entities.SuperRentRentalRate;
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
								+ year + " "+ (category.equalsIgnoreCase("All") ?(""):("and upper(category) = " + "'" + category.toUpperCase() + 
								"'"))	+ (type.equalsIgnoreCase("All") ?(""):("and upper(type) = " + "'" + type.toUpperCase() + "'")) + (inputStatus == 3 ? "" : (" and status = " + inputStatus));  
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
	
	// @Override
	public void getVehiclesForSelling(ManagerHome managerFrame) {
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			System.out.println( "------" + managerFrame.getComboBox_1().getSelectedItem());
			String query = "SELECT" 
							+ " f.regNo as RegisterNumber"
							+ ", f.price as Price_in_cad"
							+ ", f.dateMadeAvailableForSale as ForSaleFrom" 
							+ ", v.category as Category"
							+ ", v.type as Type"
							+ ", v.brand as Brand"
							+ " FROM"
							+ " ForSaleVehicles f"
							+ " INNER JOIN Vehicle v"
								+ " on v.regNo = f.regNo"
								+ " where soldDate is null";
			
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

	// @Override
	public boolean addVehicle(VehicleVO vehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "INSERT INTO Vehicle values ('" + vehicleVO.getRegNo() +"','" + vehicleVO.getCategory() + "','"
													+ vehicleVO.getType() +"','"+ vehicleVO.getBrand()+"','"+
													vehicleVO.getPurchaseDate() + "'," + "0)";
			System.out.println(query);
			st.executeUpdate(query);
			con.commit();
			System.out.println("In here");
			
			System.out.println("Working");
			

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

	// @Override
	public boolean updateVehicle(VehicleVO vehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE Vehicle SET category = '" + vehicleVO.getCategory() + "', type ='"
													+ vehicleVO.getType() +"',brand = '"+ vehicleVO.getBrand()+"', purchaseDate= '"+
													vehicleVO.getPurchaseDate() + "' WHERE regNo = '" + vehicleVO.getRegNo() + "'";
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

	// @Override
	public boolean sellVehicle(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "INSERT INTO ForSaleVehicles values ('" + sellVehicleVO.getRegNo() +"'," + sellVehicleVO.getPrice() + ","
													+ null +",'"+
													sellVehicleVO.getForSaleFrom()+ "')";
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 1 where regNo = '" + sellVehicleVO.getRegNo() + "'";
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

	// @Override
	public boolean vehicleSold(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE ForSaleVehicles SET soldDate = CURDATE() where regNo ='" + sellVehicleVO.getRegNo() + "'";
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 2 where regNo ='" + sellVehicleVO.getRegNo() + "'";
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

	// @Override
	public boolean updateSellingPrice(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE ForSaleVehicles SET price = " + sellVehicleVO.getPrice() + " where regNo ='" + sellVehicleVO.getRegNo() +"'";
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
	
	// @Override
	public boolean moveForRent(SellVehicleVO sellVehicleVO) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "DELETE FROM ForSaleVehicles where regNo ='" + sellVehicleVO.getRegNo() + "'";
			System.out.println(query);
			st.executeUpdate(query);
			String changeStatus = "UPDATE Vehicle SET status = 0 where regNo ='" + sellVehicleVO.getRegNo() + "'";
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

	// @Override
	public void getRentalRate(ManagerHome managerFrame) {
		// TODO Auto-generated method stub
	try{	
		con = DatabaseConnection.createConnection();
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		System.out.println( "------" + managerFrame.getComboBox_1().getSelectedItem());
		String query = "SELECT * FROM SuperRentRentalRate";
		resultSet = st.executeQuery(query);
		System.out.println("In here");
		managerFrame.getManageRatesPanel().getRentalRateTable().setModel(DbUtils.resultSetToTableModel(resultSet));
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

	// @Override
	public void getInsuranceRates(ManagerHome managerFrame) {
		
		try{	
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM SuperRentInsuranceRate";
			resultSet = st.executeQuery(query);
			System.out.println("In here");
			managerFrame.getManageRatesPanel().getInsuranceTable().setModel(DbUtils.resultSetToTableModel(resultSet));
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

	// @Override
	public boolean otherRates() {
		// TODO Auto-generated method stub
		return false;
	}

	// @Override
	public SuperRent getOtherRates() {
		// TODO Auto-generated method stub
		SuperRent superRent = new SuperRent();
		try{	
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM SuperRent";
			resultSet = st.executeQuery(query);
			System.out.println("In here");
			while (resultSet.next()) {
	           
	            superRent.setMembershipFees(resultSet.getDouble("membershipFees"));
				superRent.setTax(resultSet.getDouble("tax"));
				superRent.setFuelRate(resultSet.getDouble(("fuelRate")));
				superRent.setMembershipPoints(resultSet.getInt("MembershipPoint"));
				superRent.setReedemablePoints(resultSet.getString("minRedeemablePoints"));
				superRent.setOneClubPoint(resultSet.getDouble("perPointPayment"));
	        }
			
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
		
		
		return superRent;
		
		
	}

	@Override
	public boolean saveOtherRates(SuperRent superRent) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();

			String query = "UPDATE SuperRent SET tax = " + superRent.getTax()
					+ ", membershipFees = " + superRent.getMembershipFees()
					+ ", fuelRate = " + superRent.getFuelRate()
					+ ", minRedeemablePoints = " + superRent.getReedemablePoints()
					+ ", perPointPayment = " + superRent.getOneClubPoint()
					+ ", MembershipPoint = " + superRent.getMembershipPoints()
					+ " where branchId =" + 1;
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
		} finally {
			DatabaseConnection.close(con);
		}
		return result;

	}

	@Override
	public boolean updateRentalRate(SuperRentRentalRate superRentRentalRate) {
		boolean result = true;
		Date date = new Date();
		superRentRentalRate.setUpdateData(new java.sql.Date(date.getTime()));
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();

			String query = "UPDATE SuperRentRentalRate SET dailyRate = " + superRentRentalRate.getDailyRate()
					+ ", weeklyRate = " + superRentRentalRate.getWeeklyRate()
					+ ", hourlyRate = " + superRentRentalRate.getHourlyRate()
					+ ", perKMRate = " + superRentRentalRate.getPerKMRate()
					+ ", MileageLimit = " + superRentRentalRate.getHourlyRate()
					+ ", lastUpdatedDate = '" + superRentRentalRate.getUpdateData() + " ' "
					+ " where category = '" + superRentRentalRate.getCategory() + "'"
					+ " and type = '" + superRentRentalRate.getType() + "'";
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
		} finally {
			DatabaseConnection.close(con);
		}
		return result;
	}

	@Override
	public boolean updateInsuranceRate(
			SuperRentInsuranceRate superRentInsuranceRate) {
		boolean result = true;
		Date date = new Date();
		superRentInsuranceRate.setUpdateData(new java.sql.Date(date.getTime()));
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE SuperRentInsuranceRate SET dailyRate = " + superRentInsuranceRate.getDailyRate()
					+ ", weeklyRate = " + superRentInsuranceRate.getWeeklyRate()
					+ ", hourlyRate = " + superRentInsuranceRate.getHourlyRate()
					+ ", lastUpdatedDate = '" + superRentInsuranceRate.getUpdateData() + " ' "
					+ " where category = '" + superRentInsuranceRate.getCategory() + "'"
					+ " and type = '" + superRentInsuranceRate.getType() + "'";
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
		} finally {
			DatabaseConnection.close(con);
		}
		return result;
	}

	@Override
	public void getAddnEquipRates(ManagerHome managerFrame) {
		// TODO Auto-generated method stub
		
		try{	
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM AdditionalEquipment";
			resultSet = st.executeQuery(query);
			managerFrame.getManageRatesPanel().getAdditionalEquipmentTable().setModel(DbUtils.resultSetToTableModel(resultSet));
			
			
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

	 @Override
	public boolean updateAddnEquipRate(AdditionalEquipment additionalEquipment) {
		boolean result = true;
		Date date = new Date();
		additionalEquipment.setUpdateData(new java.sql.Date(date.getTime()));
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			
			String query = "UPDATE AdditionalEquipment SET dailyRate = " + additionalEquipment.getDailyRate()					
					+ ", hourlyRate = " + additionalEquipment.getHourlyRate()					
					+ ", lastUpdatedDate = '" + additionalEquipment.getUpdateData() + " ' "
					+ " where category = '" + additionalEquipment.getCategory() + "'";
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
		} finally {
			DatabaseConnection.close(con);
		}
		return result;

	}
}
