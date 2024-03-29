package org.superrent.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import org.apache.commons.collections.functors.WhileClosure;
import org.superrent.application.DatabaseConnection;
import org.superrent.entities.MakeReservation;
import org.superrent.entities.RequireAdditionalEquipment;
import org.superrent.entities.Reservation;
import org.superrent.entities.User;

public class ReservationDao {

	Connection con;
	private static ResultSet resultSet = null;

	/**
	 * Search available vehicle
	 * @param pickupDate
	 * @param dropDate
	 * @param type
	 * @param category
	 * @param table
	 * @param scrollPane
	 */
	public void searchVehiclesForReservation(Date pickupDate, Date dropDate,
			String type, String category, JTable table, JScrollPane scrollPane) {
		
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
		

		String query = "SELECT category as Category, type as Type, brand as Brand, regNo from Vehicle where status = 0 "
				+ (category.equalsIgnoreCase("All") ? ("")
						: (" and UPPER(category) = " + "'" + category.toUpperCase() + "'"))
				+ (type.equalsIgnoreCase("All") ? ("") : (" and UPPER(type) = " + "'"
						+ type.toUpperCase() + "'"))
				+ " and regNo not in (select regNo from MakeReservation where confirmationNo in (select confirmationNo from"
				+ " Reservation where status = 0 and pickDate between '"
				+ new java.sql.Timestamp(pickupDate.getTime())
				+ "'"
				+ " and '"
				+ new java.sql.Timestamp(dropDate.getTime())
				+ " '  or dropDate between ' "
				+ new java.sql.Timestamp(pickupDate.getTime())
				+ "' and ' "
				+ new java.sql.Timestamp(dropDate.getTime()) + "'))";
		
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

	/**
	 * Get user's UID
	 * @param user
	 * @return
	 */
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

	/**
	 * add user if not exist
	 * @param user
	 * @throws SQLException
	 */
	private void addUser(User user) throws SQLException {

		Date date = new Date();
		Statement st = con.createStatement();
		String query = "INSERT INTO User (name,email,phoneNumber,dateCreated,type,address) VALUES ('"
				+ user.getName()
				+ " ', '"
				+ user.getEmail()
				+ " ','"
				+ user.getPhoneNumber()
				+ " ', '"
				+ new java.sql.Timestamp(date.getTime())
				+ " ', '"
				+ user.getType() + "' , '" + user.getAddress() + "')";
		//System.out.println(query);
		st.executeUpdate(query);

	}

	/**
	 * Check if user exist
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	private Integer userExists(User user) throws SQLException {
		Integer uid = null;
		Statement st = con.createStatement();

		String query = "select uid from User where phoneNumber = "
				+ user.getPhoneNumber();
		//System.out.println(query);
		resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			uid = resultSet.getInt("uid");
		}

		return uid;
	}


	/**
	 * Insert into reservation table in the database
	 * @param reservation
	 * @return
	 */
	public boolean makeReservation(Reservation reservation) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);

			Date date = new Date();
			reservation.setCreatedDate(new java.sql.Timestamp(date.getTime()));
			insertIntoReservation(con, reservation);
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
	
	
	/**
	 * Insert into makeReservation table in the database
	 * @param makeReservation
	 * @return
	 */
	public boolean makeReservation(MakeReservation makeReservation) {
		boolean result = true;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);

			Date date = new Date();
			makeReservation
					.setLastUpdatedDate(new java.sql.Timestamp(date.getTime()));
			
			
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
		//System.out.println(query);
		st.executeUpdate(query);

	}

	private void insertIntoReservation(Connection con, Reservation reservation)
			throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		// change status in reservation table and make reservation table
		String query = "INSERT INTO Reservation (pickDate, dropDate, creationDate,charges,status) values "
				+ "('"
				+ new java.sql.Timestamp(reservation.getPickDate().getTime())
				+ "',"
				+ "'"
				+ new java.sql.Timestamp(reservation.getDropDate().getTime())
				+ "',"
				+ "'"
				+ reservation.getCreatedDate()
				+ "',"
				+ reservation.getCharges() + "," + 0 + ")";
		//System.out.println(query);
		st.executeUpdate(query);

	}

	/**
	 * Delete reservation from the database
	 * @param confirmationNo
	 * @return
	 */
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

	/**
	 * check if confirmation No. exist
	 * @param confirmatioNo
	 * @return
	 */
	public boolean checkExistConfirmatioNo(int confirmatioNo){
		boolean exist = false;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			String query = "select confirmationNo from Reservation WHERE confirmationNo ='"
					+ confirmatioNo+"'";	 
			resultSet = st.executeQuery(query);
			if(resultSet.next()){
				exist = true;

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(con);
		}
		
		return exist;
	}
	
	/**
	 * Delete reservation from the database
	 * @param phoneNumber
	 * @param reservedDate
	 * @return
	 */
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

	/**
	 * Get confirmation number
	 * @param con
	 * @param phoneNumber
	 * @param reservedDate
	 * @return
	 * @throws SQLException
	 */
	private Integer getConfirmationNumber(Connection con, String phoneNumber,
			Date reservedDate) throws SQLException {
		Integer confirmationNo = null;

		Statement st = con.createStatement();
		String query = "select confirmationNo from MakeReservation where status = 0 and date = '"
				+ new java.sql.Timestamp(reservedDate.getTime())
				+ "' and uid = (select uid from User where phoneNumber = "
				+ phoneNumber + ")";
		//System.out.println(query);
		resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			confirmationNo = resultSet.getInt("confirmationNo");
		}
		return confirmationNo;
	}

	/**
	 * change reservation status to be cancel in makeReservation table
	 * @param con
	 * @param confirmationNo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void changeMakeReservationStatus(Connection con,
			Integer confirmationNo) throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		String query1 = "UPDATE MakeReservation SET  status = '" + 3
				+ "' where confirmationNo = '" + confirmationNo + "'";
		//System.out.println(query1);
		st.executeUpdate(query1);

	}

	/**
	 * change reservation status to be cancel in Reservation table
	 * @param con
	 * @param confirmationNo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void changeReservationStatus(Connection con, Integer confirmationNo)
			throws ClassNotFoundException, SQLException {

		Statement st = con.createStatement();
		String query = "UPDATE Reservation SET  status = '" + 1
				+ "' where confirmationNo = '" + confirmationNo+"'";
		//System.out.println(query);
		st.executeUpdate(query);

	}

	public long getConfirmationFromReservation(){
		Long confirmationNo = null;
		try {

			con = DatabaseConnection.createConnection();
			String sql="SELECT confirmationNo FROM Reservation";
			PreparedStatement maxcon=con.prepareStatement(sql);
			ResultSet rs =maxcon.executeQuery(); 
			long max = 0;
			while(rs.next()){
				confirmationNo = rs.getLong("confirmationNo");
				if(confirmationNo > max){
					max = confirmationNo;
				}
				
			}
			confirmationNo = max;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();


		} finally {
			DatabaseConnection.close(con);
		}

	return confirmationNo;
	}
	
	public Integer getUid(String username, String password){
		Integer uid = null;
		password = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			String query = "select uid from RegUser where username = '" + username + "' "
									+ "	and password = '" + password + "' ";	 
			resultSet = st.executeQuery(query);
			if(resultSet.next()){
				uid = resultSet.getInt("uid");

			}

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
	
	/**
	 * Calculate the charge for the vehicle
	 * @param regNo
	 * @param pick
	 * @param drop
	 * @return
	 */
	public double calculateCharges(String regNo, Date pick, Date drop){
		int d_month = drop.getMonth(), p_month = pick.getMonth(); //return 0 to 11
		int d_date = drop.getDate(), p_date = pick.getDate();//return 1 to 31
		int d_year = drop.getYear()+1900, p_year = pick.getYear()+1900;
		int d_hour = drop.getHours(), p_hour = pick.getHours();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, p_year);
		calendar.set(Calendar.MONTH, p_month);
		int numDays = calendar.getActualMaximum(Calendar.DATE);
		double total = 0.0;
		double dailyR =0.0, weeklyR=0.0, hourlyR=0.0;
		/*
		 * retrieve the rental rates from database
		 */
		String sql;
		sql = "SELECT dailyRate, weeklyRate, hourlyRate FROM SuperRentRentalRate "
				+ "WHERE category IN(Select category FROM Vehicle WHERE regNo=?)"
				+ " AND type IN(Select type FROM Vehicle WHERE regNo=?)";
		try {
			con = DatabaseConnection.createConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, regNo);
			preparedStatement.setString(2, regNo);
			ResultSet rs = preparedStatement.executeQuery();
		
			//put the rates in local variable
			while(rs != null && rs.next()){
				dailyR = rs.getDouble("dailyRate");
				weeklyR = rs.getDouble("weeklyRate");
				hourlyR = rs.getDouble("hourlyRate");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(con);
		}
		/*
		 * computation
		 */
		
		if (drop.compareTo(pick)<=0){
			//System.out.println("Conflict in pickup and drop dates");
			return -1;
		}
		
		if(((d_date - p_date) == 0)&&((d_hour - p_hour)<=24)){ //for same day return
			//System.out.println("hourly entry");
				//impose hourly rates
				total = (d_hour - p_hour) * hourlyR;
		}else {	//1
				if(d_month == p_month){	//2 for same month
					if((d_date - p_date) > 5){ //3 
						//impose weekly rates
						//System.out.println("3.weekly entry");
						total = ((d_date - p_date)) * weeklyR;
						}else if((d_date - p_date) < 7){
							//impose daily rates
							//System.out.println("3.daily entry");
							total = ((d_date - p_date)) * dailyR;
						}//3
					}//2
					else{ //for different months
						if((d_date + (numDays-p_date)) > 5){
							//impose weekly rates
							//System.out.println("L.weekly entry");
							total = (d_date + (numDays-p_date)) * weeklyR;
						}else if((d_date + (numDays-p_date)) < 7){
							//impose daily rates
							//System.out.println("L.daily entry");
							total = (d_date + (numDays-p_date)) * dailyR;
						}
					}
				}//1
		//System.out.println("d_date|month|year:"+d_date+"/"+d_month+"/"+d_year);
		//System.out.println("p_date|month|year:"+p_date+"/"+p_month+"/"+p_year);
		//System.out.println("rates_daily|weekly|hourly:"+dailyR+"/"+weeklyR+"/"+hourlyR);
		//System.out.println("regno="+regNo);
		//System.out.println("total="+total);
		return total;
	}
	
	/**
	 * Search the type for the car
	 * @return
	 */
	public DefaultComboBoxModel searchCarType(){
		DefaultComboBoxModel model=null;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
		

			String query = "SELECT DISTINCT type from Vehicle WHERE category = 'Car'";
			ResultSet rs = st.executeQuery(query);
			model = new DefaultComboBoxModel();
			model.addElement("ALL");
			while(rs.next()){
				
				model.addElement(rs.getString("type"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
			return model;
		}
		
		
	}
	
	/**
	 * Search the type for the truck
	 * @return
	 */
	public DefaultComboBoxModel searchTruckType(){
		DefaultComboBoxModel model = null;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
		

		String query = "SELECT DISTINCT type from Vehicle WHERE category = 'Truck'";
		
		resultSet = st.executeQuery(query);
		model = new DefaultComboBoxModel();
		model.addElement("ALL");
		while(resultSet.next()){
			
			model.addElement(resultSet.getString("type"));
		}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
			return model;
		}
		
		
	}
	
	/**
	 * Search the type for all the vehicle
	 * @return
	 */
	public DefaultComboBoxModel searchAllType(){
		DefaultComboBoxModel model = null;
		try {
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
		

		String query = "SELECT DISTINCT type from Vehicle";
		
		resultSet = st.executeQuery(query);
		model = new DefaultComboBoxModel();
		model.addElement("ALL");
		while(resultSet.next()){
			
			model.addElement(resultSet.getString("type"));
		}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.close(con);
			return model;
		}
		
		
	}
	
	
	/**
	 * Insert requireAdditionalEquipment table into database t
	 * @param requireAdditionalEquipment
	 * @return
	 */
	public boolean makeReservation(RequireAdditionalEquipment requireAdditionalEquipment) {

		boolean result = true;

		try {

		con = DatabaseConnection.createConnection();

		con.setAutoCommit(false);

		insertIntoAdditionEquip(con, requireAdditionalEquipment);

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


	
	/**
	 * Insert into AdditionEquip table
	 * @param con
	 * @param requireAdditionalEquipment
	 * @throws SQLException
	 */
	public void insertIntoAdditionEquip(Connection con, RequireAdditionalEquipment requireAdditionalEquipment) throws SQLException{

		Statement st = con.createStatement();

		String query = "Insert into RequireAdditionalEquipment (confirmationNo, branchID, equipmentName, category, quantity) "

		+ "values (" + requireAdditionalEquipment.getConfirmationNo()

		+ ", 1"

		+ ",'" + requireAdditionalEquipment.getEquipmentName() + "'"

		+ ",'" + requireAdditionalEquipment.getCategory() + "'"

		+ ", " + requireAdditionalEquipment.getQuantity()+")";

		//System.out.println(query);

		st.executeUpdate(query);

		}
		
		
	/**
	 * Search additional equipment for the vehicle
	 * @param branchID
	 * @param category
	 * @param table
	 * @param scrollPane
	 */
	public void searchEquipCar(int branchID, String category, JTable table, JScrollPane scrollPane){
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			try {
				con = DatabaseConnection.createConnection();
				con.setAutoCommit(false);
				Statement st = con.createStatement();
				
				
				String query = "SELECT equipmentName from AdditionalEquipment WHERE UPPER(category) = UPPER('"
							 	+ category+"')"
								+" AND branchID = '"
							 	+ branchID +"'";
				
				resultSet = st.executeQuery(query);
				
				while(resultSet.next()){
					 model.addRow(new Object[] { resultSet.getString("equipmentName"), "0" });
				}
/*				table.setModel(DbUtils.resultSetToTableModel(resultSet));*/
				scrollPane.setVisible(true);
				table.setVisible(true);
					
			}
			catch (ClassNotFoundException e) {
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
		
	public double calculateEquip(String equipName, String category, Date pick, Date drop){
		int d_month = drop.getMonth(), p_month = pick.getMonth(); //return 0 to 11
		int d_date = drop.getDate(), p_date = pick.getDate();//return 1 to 31
		int d_year = drop.getYear()+1900, p_year = pick.getYear()+1900;
		int d_hour = drop.getHours(), p_hour = pick.getHours();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, p_year);
		calendar.set(Calendar.MONTH, p_month);
		int numDays = calendar.getActualMaximum(Calendar.DATE);
		double total = 0.0;
		double dailyR =0.0, weeklyR=0.0, hourlyR=0.0;
		/*
		 * retrieve the rental rates from database
		 */
		String sql;
		sql = "SELECT dailyRate, hourlyRate FROM AdditionalEquipment "
				+ "WHERE UPPER(equipmentName) =?"
				+ " AND UPPER(category)=?";
		try {
			con = DatabaseConnection.createConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, equipName.toUpperCase());
			preparedStatement.setString(2, category.toUpperCase());
			ResultSet rs = preparedStatement.executeQuery();
		
			//put the rates in local variable
			while(rs != null && rs.next()){
				dailyR = rs.getDouble("dailyRate");
				hourlyR = rs.getDouble("hourlyRate");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(con);
		}
		/*
		 * computation
		 */
		
		if (drop.compareTo(pick)<=0){
			//System.out.println("Conflict in pickup and drop dates");
			return -1;
		}
		
		if(((d_date - p_date) == 0)&&((d_hour - p_hour)<=24)){ //for same day return
			//System.out.println("hourly entry");
			//System.out.println(d_hour);
			//System.out.println(p_hour);
				//impose hourly rates
				total = (d_hour - p_hour) * hourlyR;
		}else {	//1
				if(d_month == p_month){	//2 for same month
					
							//System.out.println("3.daily entry");
							total = ((d_date - p_date)) * dailyR;
						
				}//2
				else{ //for different months
						
							
							//System.out.println("L.daily entry");
							total = (d_date + (numDays-p_date)) * dailyR;
						
					}
				}//1
		//System.out.println("d_date|month|year:"+d_date+"/"+d_month+"/"+d_year);
		//System.out.println("p_date|month|year:"+p_date+"/"+p_month+"/"+p_year);
		//System.out.println("rates_daily|weekly|hourly:"+dailyR+"/"+"/"+hourlyR);
		
		//System.out.println("total="+total);
		return total;
	}
	
	public String getEmail(int uid){
		String email="";
		
		
		try{
			con = DatabaseConnection.createConnection();
			con.setAutoCommit(false);
			ResultSet rs;
			Statement st = con.createStatement();
			String query = "SELECT email FROM User WHERE uid='" + uid+ "'";
			
			rs = st.executeQuery(query);
			if(rs.next()){
				email = rs.getString("email");
				//System.out.println("email"+email);
			}
			
			con.commit(); 
		}

		catch (Exception e) {
			DatabaseConnection.rollback(con);
			e.printStackTrace();
		} finally {
			
			DatabaseConnection.close(con);
			return email;
		}
	}
}

