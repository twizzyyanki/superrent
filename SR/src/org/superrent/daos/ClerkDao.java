package org.superrent.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import javax.swing.JFormattedTextField;

import org.superrent.application.DatabaseConnection;

public class ClerkDao 
{
	Connection con;
	public ClerkDao()
	{
		try
		{
		con=DatabaseConnection.createConnection();
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
			DatabaseConnection.close(con);
		}
	}
	
	public ResultSet displayReservation()
	{
		ResultSet rs = null;
		try
		{
		PreparedStatement ps=con.prepareStatement("select * from Reservation");
		rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return rs;
	}
	
	public ResultSet DisplayReserveWithConfirmation(int number)
	{
		ResultSet rs=null;
		int confirmationno=number;
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Reservation where confirmationNo=? and status =?");
			ps.setInt(1, confirmationno);
			ps.setString(2, "0");
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return rs;
	}
	
	public String[] DisplayRentingDetails(int number)
	{
		ResultSet rs=null;
		ResultSet rs1=null;
		String[] values=null;
		try
		{
		values=new String[5];
		PreparedStatement ps=con.prepareStatement("select * from Reservation where confirmationNo=? and status=?");
		ps.setInt(1, number);
		ps.setString(2,"0");
		rs=ps.executeQuery();
		
		while(rs.next())
		{
			values[0]=rs.getString(2);
			values[1]=rs.getString(3);
			values[2]=rs.getString(5);
			values[3]=rs.getString("confirmationNo");
		}
		
		PreparedStatement ps2=con.prepareStatement("select equipmentName from RequireAdditionalEquipment where category="
				+ "(select category from Vehicle where regNo=(select regNo from MakeReservation where confirmationNo="
				+ "(select confirmationNo from Reservation where confirmationNo=? and status=?)))");
		ps2.setInt(1,number);
		ps2.setString(2, "0");
		rs1=ps2.executeQuery();
		while(rs1.next())
		{
			values[4]=rs1.getString("equipmentName");
		}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return values;
	}
	
	public String[] DisplayRentingDetailsWithPhNo(long phNum)
	{
		ResultSet rs=null;
		ResultSet rs1=null;
		String[] values=new String[5];
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT dropDate, pickDate, charges,confirmationNo FROM Reservation r where confirmationNo="
					+ "(select confirmationNo from MakeReservation WHERE uid="
					+ "(select uid from User where PhoneNumber=?)) and status=?");
			ps.setLong(1,phNum);
			ps.setString(2, "0");
			rs=ps.executeQuery();
			while(rs.next())
			{
				values[0]=rs.getString("pickDate");
				values[1]=rs.getString("dropDate");
				values[2]=rs.getString("charges");
				values[3]=rs.getString("confirmationNo");
			}
			
			PreparedStatement ps1=con.prepareStatement("select equipmentName from RequireAdditionalEquipment where category="
					+ "(select category from Vehicle where regNo="
					+ "(select regNo from MakeReservation where confirmationNo="
					+ "(select confirmationNo from Reservation where confirmationNo=? and status=?)))");
			ps1.setString(1,values[3]);
			ps1.setString(2, "0");
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				values[4]=rs1.getString("equipmentName");
			}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return values;
	}

	public int[] createRentalAgreement(String licenseNo, Long creditcard, String expiry, Double odometer, String fuel, int roadstar,String description, int confirmNo)
	{
		int[] values=new int[4];
		int number=0;
		try
		{
			PreparedStatement ps1=con.prepareStatement("INSERT INTO RentAgreement(`driverLicenseNo`, `odometer`, `fuelLevel`, `roadstar`, `vehicleDescription`, `dateCreated`, `confirmationNo`) VALUES ( ?,?,?,?,?,?,?)");
			ps1.setString(1,licenseNo);
			ps1.setDouble(2,odometer);
			ps1.setString(3,fuel);
			ps1.setInt(4,roadstar);
			ps1.setString(5,description);
			java.sql.Timestamp current_timestamp =new java.sql.Timestamp(new java.util.Date().getTime());
			ps1.setTimestamp(6,current_timestamp);
			ps1.setInt(7,confirmNo);
			
			values[0]=ps1.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("INSERT INTO GeneratedAgreements VALUES (?,?)");
			ps2.setInt(1,confirmNo);
			String sql="SELECT max(agreementNo) FROM RentAgreement";
			PreparedStatement agreement=con.prepareStatement(sql);
			ResultSet no=agreement.executeQuery();
			
			while(no.next())
			{
				number=no.getInt(1);
			}
			ps2.setInt(2,number);
			values[1]=ps2.executeUpdate();
			PreparedStatement carddetails=con.prepareStatement("insert into CreditCard values(?,?,?)");
			carddetails.setInt(1,number);
			carddetails.setLong(2,creditcard);
			carddetails.setString(3,expiry);	
			values[2]=carddetails.executeUpdate();
			values[3]=number;	
			PreparedStatement ps=con.prepareStatement("UPDATE MakeReservation SET status=? WHERE confirmationNo=?");
			ps.setString(1, "1");
			ps.setInt(2,confirmNo);	
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		
		return values;
	}

	public String[] DisplayRentalAgreementwhileReturn(int agreementNo)
	{
		String[] values=new String[10];
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		
		int ConfNo=0;
		try
		{
		PreparedStatement ps=con.prepareStatement("select * from RentAgreement where agreementNo="+"'"+agreementNo+"'");
		rs=ps.executeQuery();
		while(rs.next())
		{
			values[0]=rs.getString("roadstar");
			values[1]=rs.getString("odometer");
			values[2]=rs.getString("fuelLevel");
			values[3]=rs.getString("vehicleDescription");
			ConfNo=rs.getInt("confirmationNo");
		}
		if(rs!=null)
		{
		PreparedStatement ps1=con.prepareStatement("select dropDate,pickDate,charges from Reservation where confirmationNo=? and status =?");
		ps1.setInt(1, ConfNo);
		ps1.setString(2,"0");
		rs1=ps1.executeQuery();
		while(rs1.next())
		{
			values[4]=rs1.getString(1);
			values[5]=rs1.getString(2);
			values[6]=rs1.getString(3);
		}
		
		PreparedStatement ps2=con.prepareStatement("select name,phoneNumber from User where uid="
				+ "(select uid from MakeReservation where confirmationNo="
				+ "(select confirmationNo from Reservation where confirmationNo=? and status=?))");
		ps2.setInt(1, ConfNo);
		ps2.setString(2,"0");
		rs2=ps2.executeQuery();
		
		while(rs2.next())
		{
			values[7]=rs2.getString("name");
			values[8]=rs2.getString("phoneNumber");
		}
		
		PreparedStatement ps3=con.prepareStatement("Select equipmentName from RequireAdditionalEquipment where confirmationNo="
				+ "(select confirmationNo from Reservation where confirmationNo=? and status=?)");
		ps3.setInt(1,ConfNo);
		ps3.setString(2, "0");
		rs3=ps3.executeQuery();
		while(rs3.next())
		{
			values[9]=rs3.getString("equipmentName");
		}
		}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return values;
	}

	public String calculateOdometerCost(Double currentReading,int agreementNo) 
	{
		ResultSet rs=null;
		ResultSet rs2=null;
		Double  limit=0.0;
		String cost=null;
		double cost1=0.0;
		String type=null;
		String category=null;
		Double reading=0.0;
		double rate=0.0;
		try
		{	
		PreparedStatement ps=con.prepareStatement("select * from RentAgreement where agreementNo=?");
		ps.setInt(1,agreementNo);
		rs=ps.executeQuery();
		
		while(rs.next())
		{
			reading=Double.valueOf(rs.getString("odometer"));
			
		}
		if(reading!=0)
		{
			System.out.println(reading);
			PreparedStatement Vehicletype=con.prepareStatement("select category,type from Vehicle where regNo="
					+ "(select regNo from MakeReservation where confirmationNo="
					+ "(select confirmationNo from RentAgreement where agreementNo=?))");
			Vehicletype.setInt(1,agreementNo);
			ResultSet Vehtype=Vehicletype.executeQuery();
			while(Vehtype.next())
			{
				type=Vehtype.getString("type");
				category=Vehtype.getString("category");
			}
			
		PreparedStatement ps1=con.prepareStatement("select MileageLimit,perKMRate from SuperRentRentalRate where category=? and type=?");
			ps1.setString(1, category);
			ps1.setString(2, type);
			rs2=ps1.executeQuery();
			while(rs2.next())
			{
				limit=rs2.getDouble("MileageLimit");
				rate=rs2.getDouble("perKMRate");
			}
		if((currentReading-reading)>limit)
		{
			cost1=(currentReading-reading)*rate;
			cost=String.valueOf(cost1);
		}
		else
		{
			cost1=(double) 0;
			cost=String.valueOf(cost1);
		}
		}
		else
		{
			cost="Rental agreement is not valid, odometer cannot be calculated!!";
		}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return cost;
	}
	
	public int displayFuelCost(Double currentfuel,int agreementNo)
	{
		int cost=0;
		double rate=0.0;
		double fuel=0.0;
		ResultSet rs=null;
		ResultSet rs1=null;
		try
		{
		PreparedStatement ps=con.prepareStatement("select fuelLevel from RentAgreement where agreementNo=?");
		ps.setInt(1, agreementNo);
		rs=ps.executeQuery();
		while(rs.next())
		{
			fuel=Double.parseDouble(rs.getString("fuelLevel"));
		}
		if(currentfuel<fuel)
		{
			PreparedStatement ps1=con.prepareStatement("Select fuelRate from SuperRent");
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				rate=rs1.getDouble("fuelRate");
			}
			cost=(int) (((fuel-currentfuel)/10)*rate);
		}
		else
		{
			cost=0;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return cost;
	}
	
	public String[] displayInsuranceCost(String agreementNo) 
	{
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String values[]=new String[4];
		String type=null;
		String category=null;
		Timestamp pickdate=null;
		Timestamp dropdate=null;
		try
		{
		PreparedStatement ps=con.prepareStatement("Select type,category from Vehicle where regno="
				+ "(select regNo from MakeReservation where confirmationNo="
				+ "(select confirmationNo from GeneratedAgreements where agreementNo=?))");	
		ps.setString(1, agreementNo);
		rs=ps.executeQuery();
		while(rs.next())
		{
			type=rs.getString(1);
			category=rs.getString(2);
		}
		
		PreparedStatement ps1=con.prepareStatement("select hourlyRate,dailyRate,weeklyRate from SuperRentInsuranceRate where type=? and category=?");
		ps1.setString(1, type);
		ps1.setString(2, category);
		rs1=ps1.executeQuery();
		while(rs1.next())
		{
			values[0]=rs1.getString("hourlyRate");
			values[1]=rs1.getString("dailyRate");
			values[2]=rs1.getString("weeklyRate");
		}
		
		
		PreparedStatement ps2=con.prepareStatement("select pickDate,dropDate from Reservation where confirmationNo="
				+ "(select confirmationNo from GeneratedAgreements where agreementNo=?)");
		ps2.setString(1,agreementNo);
		rs2=ps2.executeQuery();
		while(rs2.next())
		{
			pickdate=rs2.getTimestamp("pickDate");
			dropdate=rs2.getTimestamp("dropDate");
		}
		
		long difference= (dropdate.getTime()-pickdate.getTime());
		long seconds=TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);    
		long hours = TimeUnit.SECONDS.toHours(seconds) - TimeUnit.SECONDS.toHours(TimeUnit.SECONDS.toDays(seconds));
        
		values[3]=String.valueOf(hours);
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return values;
	}

	public String displayTaxRate() 
	{
		ResultSet rs=null;
		String tax=null;
		try
		{
		PreparedStatement ps=con.prepareStatement("select tax from SuperRent");
		rs=ps.executeQuery();
		while(rs.next())
		{
			tax=rs.getString(1);
		}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		return tax;
	}

	public int[] cancelReservation(int confirmationNo) 
	{
		int status[]=new int[2];
		try
		{
			PreparedStatement ps=con.prepareStatement("UPDATE Reservation SET status=? WHERE confirmationNo=? and "
					+ "confirmationNo not in(select confirmationNo from GeneratedAgreements)");
			ps.setString(1,"1");
			ps.setInt(2, confirmationNo);
			status[0]=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("UPDATE MakeReservation SET status=? WHERE confirmationNo=?");
			ps1.setInt(1,3);
			ps1.setInt(2,confirmationNo);
			status[1]=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	public String[] displayRental(int agreementNo) 
	{
		String[] values=new String[11];
		int confirmnum=0;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		try
		{
			PreparedStatement ps=con.prepareStatement("select agreementNo,confirmationNo from RentAgreement where agreementNo="+"'"+agreementNo+"'");
			rs=ps.executeQuery();
			while(rs.next())
			{
				values[0]=rs.getString("agreementNo");
				confirmnum=rs.getInt("confirmationNo");
			}
			
			if(values[0]==null)
			{
				;
			}
			else
			{
			PreparedStatement ps1=con.prepareStatement("Select * from MakeReservation where confirmationno="
					+ "(select confirmationNo from Reservation where confirmationNo=? and status=?)");
			ps1.setInt(1,confirmnum);
			ps1.setString(2,"0");
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				values[1]=rs1.getString("regNo");
				values[2]=rs1.getString("uid");
			}
			
			PreparedStatement ps2=con.prepareStatement("select * from User where uid=?");
			ps2.setString(1, values[2]);
			rs2=ps2.executeQuery();
			while(rs2.next())
			{
				values[3]=rs2.getString("name");
				values[4]=rs2.getString("phoneNumber");
			}
			
			PreparedStatement ps3=con.prepareStatement("Select type,category from Vehicle where regNo=?");
			ps3.setString(1,values[1]);
			rs3=ps3.executeQuery();
			while(rs3.next())
			{
				values[5]=rs3.getString("type");
				values[6]=rs3.getString("category");
			}
		
			PreparedStatement ps4=con.prepareStatement("select charges,pickDate,dropDate from Reservation where confirmationNo=? and status=?");
			ps4.setInt(1,confirmnum);
			ps4.setString(2,"0");
			rs4=ps4.executeQuery();
			while(rs4.next())
			{
				values[7]=rs4.getString("charges");
				values[8]=rs4.getString("pickDate");
				values[9]=rs4.getString("dropDate");
			}
			PreparedStatement ps5=con.prepareStatement("select equipmentName from RequireAdditionalEquipment where confirmationNo="
					+ "(select confirmationNo from Reservation where confirmationNo=? and status=?)");
			ps5.setInt(1,confirmnum);
			ps5.setString(2,"0");
			rs5=ps5.executeQuery();
			while(rs5.next())
			{
				values[10]=rs5.getString("equipmentName");
			}
			}
		}
		catch(Exception e)
		{
			DatabaseConnection.rollback(con);
		}
		
		return values;
	}

	public String DisplayPoints(String agreementNo) 
	{
		ResultSet rs=null;
		ResultSet rs1=null;
		String points=null;
		String uid=null;
		try
		{
			PreparedStatement ps=con.prepareStatement("select uid from MakeReservation where confirmationNo="
					+ "(select confirmationNo from GeneratedAgreements where agreementNo=?)");
			ps.setString(1,agreementNo);
			rs=ps.executeQuery();
			while(rs.next())
			{
				uid=rs.getString("uid");
			}
			
			PreparedStatement ps1=con.prepareStatement("select points from ClubMember where uid=?");
			ps1.setString(1, uid);
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				points=rs1.getString("points");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return points;
	}

	public Double DisplayDiscountedCost(int agreementNo, Double points) 
	{
		double charges=0.0;
		int bonusdays=0;
		ResultSet rs=null;
		Timestamp pickdate=null;
		Timestamp dropdate=null;
		String type=null,category=null;
		double hourlyrate=0.0,dailyrate=0.0,weeklyrate=0.0;
		double minimum=0.0;
		long hours=0;
		try
		{
		PreparedStatement ps1=con.prepareStatement("select minRedeemablePoints from SuperRent");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			minimum=rs1.getDouble(1);
		}
		if(points>=minimum)
		{
			bonusdays=Integer.valueOf((int) (points/minimum));
			
			PreparedStatement ps=con.prepareStatement("select pickDate,dropDate from Reservation where confirmationNo="
					+ "(select confirmationNo from GeneratedAgreements where agreementNo=?)");
			ps.setInt(1,agreementNo);
			rs=ps.executeQuery();
			while(rs.next())
			{
				pickdate=rs.getTimestamp("pickDate");
				dropdate=rs.getTimestamp("dropDate");
			}
			
			System.out.println(pickdate);
			System.out.println(dropdate);
			
			long difference= (dropdate.getTime()-pickdate.getTime());
			long seconds=TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);    
			hours = TimeUnit.SECONDS.toHours(seconds) - TimeUnit.SECONDS.toHours(TimeUnit.SECONDS.toDays(seconds));
			
			PreparedStatement ps2=con.prepareStatement("Select type,category from Vehicle where regno="
					+ "(select regNo from MakeReservation where confirmationNo="
					+ "(select confirmationNo from GeneratedAgreements where agreementNo=?))");
			
			ps2.setInt(1, agreementNo);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				type=rs2.getString(1);
				category=rs2.getString(2);
			}
			
			PreparedStatement ps3=con.prepareStatement("select hourlyRate,dailyRate,weeklyRate from SuperRentRentalRate where type=? and category=?");
			ps3.setString(1, type);
			ps3.setString(2, category);
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next())
			{
				hourlyrate=rs3.getDouble("hourlyRate");
				dailyrate=rs3.getDouble("dailyRate");
				weeklyrate=rs3.getDouble("weeklyRate");
			}
			
			if(hours<=24)
			{
				charges=0.0;
			}
			else
			{
				int days = (int) (Math.ceil(hours/24));
				days=days-bonusdays;
				if(days<=5)
				{
					charges=days*dailyrate;
				}
				else
				{
					charges=days*weeklyrate;
				}
			}
		}
		else
		{
			if(hours<=24)
			{
				charges=hours*hourlyrate;
			}
			else
			{
				int days = (int) (Math.ceil(hours/24));
				if(days<=5)
				{
					charges=days*dailyrate;
				}
				else
				{
					charges=days*weeklyrate;
				}
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return charges;
	}

	public int UpdatePoints(String agreementNo,String cost) 
	{
		int status=0;
		double points=0.0;
		String disc=null;
		String uid=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try
		{
			PreparedStatement ps=con.prepareStatement("select uid from MakeReservation where confirmationNo=(select confirmationNo from GeneratedAgreements where agreementNo=?)");
			ps.setString(1,agreementNo);
			rs=ps.executeQuery();
			while(rs.next())
			{
				uid=rs.getString("uid");
			}
			
			PreparedStatement discount=con.prepareStatement("Select discountPerPoints from SuperRent");
			rs1=discount.executeQuery();
			while(rs1.next())
			{
				disc=rs1.getString("discountPerPoints");
			}
			
			PreparedStatement ps2= con.prepareStatement("select points from ClubMember where uid=?");
			ps2.setString(1, uid);
			ResultSet rs2=ps2.executeQuery();
			
			while(rs2.next())
			{
				points=rs2.getDouble("points");
			}
			
			Double discountpoints=Double.valueOf(disc);
			int cost1=Integer.valueOf(cost);
			int cost2=(int) Math.round(cost1/discountpoints) * 100;
			
			double addedpoints=points+cost2;
			PreparedStatement ps1=con.prepareStatement("Update ClubMember set points=? where uid=?");
			ps1.setDouble(1,addedpoints);
			ps1.setString(2, uid);
			status=ps1.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	public int extendRental(JFormattedTextField date,int confirmationNo) 
	{
		int status=0;
		try
		{
			System.out.println(date.getValue());
			java.util.Date theDate = (java.util.Date)date.getValue();
			PreparedStatement ps = con.prepareStatement("update Reservation set dropDate=?,extendedDate=? where confirmationNo=?");
			ps.setDate(1, new java.sql.Date(theDate.getTime()));
			java.sql.Timestamp current_timestamp =new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setTimestamp(2,current_timestamp);
			ps.setInt(3, confirmationNo);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public int updateCharges(int confirmationNo)
	{
		Timestamp pickdate=null,dropdate=null;
		String type=null,category=null;
		Double hourlyrate=0.0;
		Double dailyrate=0.0;
		Double weeklyrate=0.0;
		double cost=0.0;
		int i=0;
		try
		{
		PreparedStatement ps=con.prepareStatement("select pickDate,dropDate from Reservation where confirmationNo=?");
		ps.setInt(1, confirmationNo);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			pickdate=rs.getTimestamp("pickDate");
			dropdate=rs.getTimestamp("dropDate");
		}
		
		long difference= (dropdate.getTime()-pickdate.getTime());
		long seconds=TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);    
		long hours = TimeUnit.SECONDS.toHours(seconds) - TimeUnit.SECONDS.toHours(TimeUnit.SECONDS.toDays(seconds));
		
		
		PreparedStatement ps2=con.prepareStatement("Select type,category from Vehicle where regno="
				+ "(select regNo from MakeReservation where confirmationNo=(select confirmationNo from Reservation where confirmationNo=?))");
		
		ps2.setInt(1, confirmationNo);
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			type=rs2.getString("type");
			category=rs2.getString("category");
		}
		
		PreparedStatement ps3=con.prepareStatement("select hourlyRate,dailyRate,weeklyRate from SuperRentRentalRate where type=? and category=?");
		ps3.setString(1, type);
		ps3.setString(2, category);
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
			hourlyrate=rs3.getDouble("hourlyRate");
			dailyrate=rs3.getDouble("dailyRate");
			weeklyrate=rs3.getDouble("weeklyRate");
		}
	
		if(hours<24)
		{
			cost=hours * hourlyrate;
		}
		else
		{
			int days = (int) (Math.ceil(hours/24));
			if(days<5 || days==5)
			{
				cost=days*dailyrate;
			}
			else
			{
				cost=days*weeklyrate;
			}
		}
		
		System.out.println(cost);
		PreparedStatement ps4=con.prepareStatement("update Reservation set charges=? where confirmationNo=?");
		ps4.setDouble(1,cost);
		ps4.setInt(2,confirmationNo);
		i=ps4.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	public int[] createPayment(int agreementNo, String description, Double totalCost) 
	{
		int[] status=new int[2];
		String uid=null;
		try
		{
		PreparedStatement ps=con.prepareStatement("select uid from MakeReservation where confirmationNo="
				+ "(select confirmationNo from GeneratedAgreements where agreementNo=?)");
		ps.setInt(1,agreementNo);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			uid=rs.getString("uid");
		}
		
		PreparedStatement ps1=con.prepareStatement("insert into Payments values(?,?,?,?,?,?) ");
		ps1.setString(1, "321");
		ps1.setString(2, uid);
		ps1.setString(3,description);
		java.sql.Timestamp current_timestamp =new java.sql.Timestamp(new java.util.Date().getTime());
		ps1.setTimestamp(4, current_timestamp);
		ps1.setDouble(5, totalCost);
		ps1.setString(6,"0");		
		status[0]= ps1.executeUpdate();
		
		PreparedStatement ps2=con.prepareStatement("select receiptID from Payments where uid=?");
		ps2.setString(1,uid);
		ResultSet rs2=ps2.executeQuery();
		
		while(rs2.next())
		{
			status[1]= rs2.getInt("receiptID");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
}
