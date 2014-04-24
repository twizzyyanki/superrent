package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import org.superrent.daos.ClerkDao;
import org.superrent.views.clerk.AddCM;
import org.superrent.views.clerk.ClerkHome;
import org.superrent.views.clerk.ManageReservation;
import org.superrent.views.clerk.MembershipNum;
import org.superrent.views.clerk.Rent;
import org.superrent.views.clerk.RentalAgreement;
import org.superrent.views.clerk.Return;
import org.superrent.views.clerk.UpdateProfile;

import net.proteanit.sql.DbUtils;

public class ClerkController implements ActionListener
{
	private final ClerkHome clerkFrame;
	private final Rent rent=new Rent();
	private final Return ret=new Return();
	private final AddCM cm=new AddCM();
	private final MembershipNum mem=new MembershipNum();
	private final UpdateProfile profile=new UpdateProfile();
 
	private ClerkDao dao=new ClerkDao();
	private RentalAgreement rental=new RentalAgreement(); 
	private ManageReservation manage=new ManageReservation();
	
	
	public ClerkController(ClerkHome k)
	{
		this.clerkFrame = k;
		clerkFrame.RefreshbtnActionListener(this);
		clerkFrame.RentbtnActionListener(this);
		clerkFrame.ReturnbtnActionListener(this);
		clerkFrame.AddClubMemberbtnActionListener(this);
		clerkFrame.SearchReservationbtnActionListener(this);
		clerkFrame.ViewRentalAgreemenetActionListener(this);
		rent.confirmationbtnActionListener(this);
		clerkFrame.AddClubMemberbtnActionListener(this);
		clerkFrame.UpdateProfileActionListener(this);
		clerkFrame.ViewRentalAgreementActionListener(this);
		profile.goBackHomeActionListener(this);
		rent.GoBackHomebtnActionListener(this);
		ret.goBackHomeAddActionListener(this);
		cm.addmemberActionListener(this);
		cm.GoBackHomActionListener(this);
		rent.CreateRentalbtnActionListener(this);
		rent.rdbtnActionListener(this);
		ret.checkDetailsActionListener(this);
		ret.rdbtnActionListener(this);
		clerkFrame.ManageReservationActionListener(this);
		rental.GoBackHomeActionListener(this);
		manage.GoBackHomeActionListener(this);
		manage.cancelReservActionListener(this);
		manage.changeDropdateActionListener(this);
		ret.odometerActionListener(this);
		ret.fuelPercentageActionListener(this);
		ret.insuranceActionListener(this);
		ret.taxActionListener(this);
		ret.calculateTotalCostActionListener(this);
		ret.redeemAdctionListener(this);
		ret.addPointsActionListener(this);
		ret.paymentActionListener(this);
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="Refresh")
		{
		try
		{	
		ResultSet rs=dao.displayReservation();
		clerkFrame.getTable().setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		
		if(ae.getActionCommand()=="Rent")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(rent);
			this.clerkFrame.setSize(rent.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		if(ae.getActionCommand()=="Return")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(ret);
			this.clerkFrame.setSize(ret.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		if(ae.getActionCommand()=="Add ClubMember")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(cm);
			this.clerkFrame.setSize(cm.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		
		if(ae.getActionCommand()=="Add Member")
		{
			String name=cm.getTextField().getText();
			mem.getTextField().setText(name);
			mem.setVisible(true);
		}
		if(ae.getActionCommand()=="Search Reservation")
		{
			try
			{
			int number=Integer.parseInt((clerkFrame.getTextField().getText()));
			if(number==0)
			{
				JOptionPane.showMessageDialog(clerkFrame, "Please provide a confirmation number");
			}
			else
			{
			ResultSet rs=dao.DisplayReserveWithConfirmation(number);
			clerkFrame.getTable().setModel(DbUtils.resultSetToTableModel(rs));
			if(!rs.first())
			{
				JOptionPane.showMessageDialog(clerkFrame, "No reservation exists..!!");
			}
			}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(clerkFrame, "Please provide an interger value...!!");
			}
		}
		
		if(ae.getActionCommand()=="Submit")
		{
			try
			{
			String[] values=new String[5];
			if(rent.getTextField().getText().isEmpty())
			{
				Long phnumber=new Long(rent.getTextField_1().getText());
				if(phnumber.equals(""))
				{
					JOptionPane.showMessageDialog(rent, "Please provide a Phone Number or the Confirmation Number");
				}
				else
				{
				values=dao.DisplayRentingDetailsWithPhNo(phnumber);
				if(values[3]==null)
				{
					JOptionPane.showMessageDialog(rent, "No Reservation Exists with the given Phone Number");
				}
				else
				{
				rent.getTextField_2().setText(values[0]);
				rent.getTextField_3().setText(values[1]);
				rent.getTextField_4().setText(values[2]);
				rent.getTextField_10().setText(values[3]);
				rent.getTextField_12().setText(values[4]);
				}
				}
			}
			else
			{
				int number=Integer.parseInt(rent.getTextField().getText());
				values=dao.DisplayRentingDetails(number);
				if(values[3]==null)
				{
					JOptionPane.showMessageDialog(rent, "No Reservation Exists with the given Confirmation Number");
				}
				else
				{
				rent.getTextField_2().setText(values[0]);
				rent.getTextField_3().setText(values[1]);
				rent.getTextField_4().setText(values[2]);
				rent.getTextField_10().setText(values[3]);
				rent.getTextField_12().setText(values[4]);
				}
			}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(ret, "Enter an integer Values");
			}
		}
		
		if(ae.getActionCommand()=="View Rental Agreement")
		{
			if(clerkFrame.getTextField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(clerkFrame, "Rental agreement Not Provided....!!!");
			}
			else
			{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(rental);
			this.clerkFrame.getContentPane().setVisible(true);
			String agreementNo=clerkFrame.getTextField().getText();
			String[] values;
			values=dao.displayRental(agreementNo);	
			rental.getTextField().setText(values[0]);
			rental.getTextField_1().setText(values[5]);
			rental.getTextField_2().setText(values[6]);
			rental.getTextField_3().setText(values[1]);
			rental.getTextField_4().setText(values[10]);
			rental.getTextField_5().setText(values[7]);
			rental.getTextField_6().setText(values[3]);
			rental.getTextField_7().setText(values[2]);
			rental.getTextField_8().setText(values[4]);
			rental.getTextField_9().setText(values[8]);
			rental.getTextField_10().setText(values[9]);
			}
		}
		
		if(ae.getActionCommand()=="Manage Reservation")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(manage);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		
		if(ae.getActionCommand()=="Update Profile")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(profile);
			this.clerkFrame.setSize(profile.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		
		if(ae.getActionCommand()=="GoBack to Home")
		{
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(LoginController.oldpanel);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		
		if(ae.getActionCommand()=="Create Rental Agreement")
		{
			try
			{
			int[] values=new int[4];
			int roadstar=0;
			String LicenseNo=rent.getTextField_5().getText();
			Long Creditcard=new Long(rent.getTextField_6().getText());
			String ExpiryMonth=rent.getTextField_7().getText();
			String ExpiryYear=rent.getTextField_11().getText();
			Double Odometer=Double.valueOf(rent.getTextField_8().getText());
			String Fuel=rent.getTextField_9().getText();
			String Expiry=ExpiryMonth+ExpiryYear;
			
			if(rent.rdbtnYes.isSelected())
			{
				roadstar=1;
			}
			else if(rent.rdbtnNo.isSelected())
			{
				roadstar=0;
			}
			String Description=rent.textArea.getText();
			int ConfirmNo=Integer.parseInt(rent.getTextField_10().getText());
			
			if(ExpiryYear.length()>2 || ExpiryYear.length()<2 ||ExpiryMonth.length()<2 || ExpiryMonth.length()>2)
			{
				JOptionPane.showMessageDialog(rent, "Invalid Month and year, Valid Pattern: 04/16");
			}
			else
			{
			values=dao.createRentalAgreement(LicenseNo,Creditcard,Expiry,Odometer,Fuel,roadstar,Description,ConfirmNo);
			}
			if(values[0]==1 && values[1]==1 &&values[2]==1)
			{
				JOptionPane.showMessageDialog(rent, "Rental agreement created...and the remianing tables updated...!! with rental agreement Number"+values[3]+"");
			}
			}
			catch(Exception e)
			{
				rent.getLblInvalidEntries().setVisible(true);
			}
		}
		
		if(ae.getActionCommand()=="Check Details")
		{
			String[] values;
			int agreementNo=Integer.parseInt(ret.getTextField().getText());
			values=dao.DisplayRentalAgreementwhileReturn(agreementNo);
			
			if(values[0].equals("1"))
			{
				ret.rdbtnYes.setSelected(true);
				ret.rdbtnNo.setSelected(false);
			}
			else
			{
				ret.rdbtnYes.setSelected(false);
				ret.rdbtnNo.setSelected(true);
			}
			
			ret.getTextField_5().setText(values[1]);
			ret.getTextField_6().setText(values[2]);
			ret.textArea.setText(values[3]);
			ret.getTextField_3().setText(values[4]);
			ret.getTextField_4().setText(values[5]);
			ret.getTextField_7().setText(values[6]);
			
			ret.getTextField_1().setText(values[7]);
			ret.getTextField_2().setText(values[8]);
			ret.getTextField_14().setText(values[9]);
		}
		
		if(ae.getActionCommand()=="Odometer Cost")
		{
			Double currentReading=Double.parseDouble(ret.textField_9.getText());
			String cost=null;
			int agreementNo=Integer.parseInt(ret.getTextField().getText());
			cost=String.valueOf(dao.calculateOdometerCost(currentReading,agreementNo));	
			ret.textField_8.setText(cost);
		}
		
		if(ae.getActionCommand()=="Fuel Cost")
		{
			int agreementNo=Integer.parseInt(ret.getTextField().getText());
			String cost=null;
			Double fuel=Double.parseDouble(ret.textField_10.getText());
			cost=String.valueOf(dao.displayFuelCost(fuel,agreementNo));
			ret.textField_19.setText(cost);
		}
		
		if(ae.getActionCommand()=="Update")
		{
			int confirmationNo=Integer.valueOf((manage.textField_2.getText()));
			int status=dao.extendRental(manage.dateField,confirmationNo);
			if(status==1)
			{
				JOptionPane.showMessageDialog(manage, "Date Updated...!!");
			}
			else
			{
				JOptionPane.showMessageDialog(manage, "Date could not be Updated...!!");
			}
		}
		
		if(ae.getActionCommand()=="Inc Cost")
		{
			String[] values;
			String agreementNo=ret.getTextField().getText();
			values=dao.displayInsuranceCost(agreementNo);
			Double cost=0.0;
			Double days=Double.parseDouble(values[3]);
			//Double hourlyrate=Double.parseDouble(values[0]);
			Double dailyrate=Double.parseDouble(values[1]);
			Double weeklyrate=Double.parseDouble(values[2]);
			int totalweeks=0;
			int totaldays=0;
			if(days>7)
			{
				totalweeks=(int) (days/7);
				totaldays=(int) (days%7);
				cost=totalweeks*weeklyrate;
				cost=cost+(totaldays*dailyrate);
			}
			else if(days<7 && days>1)
			{
				cost=days*dailyrate;
			}
			String finalCost=String.valueOf(cost);
			
			ret.getTextField_20().setText(finalCost);
		}
		
		if(ae.getActionCommand()=="Add Tax Cost")
		{
			String rate;
			rate=dao.displayTaxRate();
			Double tax=Double.parseDouble(rate);
			Double Cost= Double.parseDouble(ret.getTextField_15().getText())*(tax/100);
			Double totalcost= Cost+Double.parseDouble(ret.getTextField_15().getText());
			ret.textField_11.setText(String.valueOf((new DecimalFormat("#.##").format(totalcost))));
		}
		
		if(ae.getActionCommand()=="Proceed To Payment")
		{
			int agreementNo=Integer.parseInt(ret.getTextField().getText());
			Double totalCost=Double.valueOf(ret.getTextField_18().getText());
			String description=ret.textArea_1.getText();
			
			int[] status=dao.createPayment(agreementNo,description,totalCost);
			
			if(status[0] ==1)
			{
				JOptionPane.showMessageDialog(ret, "Payment done with ReceiptId"+status[1]);
			}
			else
			{
				JOptionPane.showMessageDialog(manage, "Payment could not be done");
			}
		}
		
		if(ae.getActionCommand()=="Cancel Reservation")
		{
			int status=0;
			int confirmationNo=Integer.parseInt(manage.textField_1.getText());
			status=dao.cancelReservation(confirmationNo);
			
			if(status==1)
			{
				JOptionPane.showMessageDialog(manage, "Reservation with reservation number "+confirmationNo+" is cancelled");
			}
			else
			{
				JOptionPane.showMessageDialog(manage, "Confirmation No not valid");
			}
		}
		
		if(ae.getActionCommand()=="Calculate Total Cost")
		{
			if(ret.getTextField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(ret, "Please provide a rental Agreement Number and calculate the Odometer cost and fuel Cost");
			}
			else
			{
				Double odometerCost=Double.parseDouble(ret.textField_8.getText());
				Double fuelCost=Double.parseDouble(ret.textField_19.getText());
				Double overdueCost=Double.parseDouble(ret.textField_12.getText());
				Double damageCost=Double.parseDouble(ret.textField_13.getText());
				Double insuranceCost=Double.parseDouble(ret.textField_20.getText());
				Double charges=Double.parseDouble(ret.getTextField_7().getText());
				String totalCost=String.valueOf(odometerCost+fuelCost+overdueCost+damageCost+insuranceCost+charges);
				ret.textField_15.setText(totalCost);
			}
		}
		
		if(ae.getActionCommand()=="Redeem")
		{
			if(ret.getTextField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(ret, "Please provide a rental Agreement Number and check the details first");
			}
			else
			{
				String agreementNo=ret.getTextField().getText();
				Double points=Double.valueOf(dao.DisplayPoints(agreementNo));
				Double discount=Double.parseDouble(dao.DisplayDiscountedCost());
				ret.textField_17.setText(String.valueOf(points));
				Double cost=Double.parseDouble(ret.getTextField_11().getText());
				int cost1=(int) Math.round(cost);
				int discountedcost=cost1-(Integer.valueOf((int) ((points/100)*discount)));
				ret.getTextField_18().setText(String.valueOf(discountedcost));
			}
		}
		
		if(ae.getActionCommand()=="Add Points")
		{
			if(ret.getTextField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(ret, "Please provide a rental Agreement Number and check the details first");
			}
			else
			{
				String agreementNo=ret.getTextField().getText();
				String cost=ret.getTextField_18().getText();
				int status=dao.UpdatePoints(agreementNo,cost);
				if(status==1)
				{
					JOptionPane.showMessageDialog(ret, "Points updated..!!");
				}
				else
				{
					JOptionPane.showMessageDialog(ret, "could not update the points");
				}
			}
		}
	}

	public void displayConnectionLost(Exception e) 
	{	
		JOptionPane.showMessageDialog(clerkFrame, e);
	}
}