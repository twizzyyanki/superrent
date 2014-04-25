package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.superrent.daos.ClerkDao;
import org.superrent.views.clerk.AddCM;
import org.superrent.views.clerk.ClerkHome;
import org.superrent.views.clerk.ManageReservation;
import org.superrent.views.clerk.MembershipNum;
import org.superrent.views.clerk.PayPal;
import org.superrent.views.clerk.Rent;
import org.superrent.views.clerk.RentalAgreement;
import org.superrent.views.clerk.Return;
import org.superrent.views.clerk.UpdateProfile;

import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;

import net.proteanit.sql.DbUtils;

public class ClerkController implements ActionListener {
	private final ClerkHome clerkFrame;
	private final Rent rent = new Rent();
	private final Return ret = new Return();
	private final AddCM cm = new AddCM();
	private final MembershipNum mem = new MembershipNum();
	private final UpdateProfile profile = new UpdateProfile();
	private final PayPal paypal = new PayPal();
	private ClerkDao dao = new ClerkDao();
	private RentalAgreement rental = new RentalAgreement();
	private ManageReservation manage = new ManageReservation();
	static JPanel oldreturn;

	public ClerkController(ClerkHome k) {
		this.clerkFrame = k;
		clerkFrame.RefreshbtnActionListener(this);
		clerkFrame.RentbtnActionListener(this);
		clerkFrame.ReturnbtnActionListener(this);
		clerkFrame.AddClubMemberbtnActionListener(this);
		clerkFrame.SearchReservationbtnActionListener(this);
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
		paypal.returnPageActionListener(this);
		paypal.processPaymentActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand() == "Refresh") {
			try {
				ResultSet rs = dao.displayReservation();
				clerkFrame.getTable().setModel(
						DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		if (ae.getActionCommand() == "Rent") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(rent);
			this.clerkFrame.setSize(rent.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
		if (ae.getActionCommand() == "Return") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(ret);
			this.clerkFrame.setSize(ret.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
			oldreturn = (JPanel) this.clerkFrame.getContentPane();
		}
		if (ae.getActionCommand() == "Add ClubMember") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(cm);
			this.clerkFrame.setSize(cm.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}

		if (ae.getActionCommand() == "Add Member") {
			String name = cm.getTextField().getText();
			mem.getTextField().setText(name);
			mem.setVisible(true);
		}
		if (ae.getActionCommand() == "Search Reservation") {
			try {
				if (clerkFrame.getTextField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(clerkFrame,
							"Please provide a confirmation Number");
				} else {
					int number = Integer.parseInt((clerkFrame.getTextField()
							.getText()));
					if (number == 0) {
						JOptionPane.showMessageDialog(clerkFrame,
								"Please provide a confirmation number");
					} else {
						ResultSet rs = dao
								.DisplayReserveWithConfirmation(number);
						clerkFrame.getTable().setModel(
								DbUtils.resultSetToTableModel(rs));
						if (!rs.first()) {
							JOptionPane.showMessageDialog(clerkFrame,
									"No reservation exists..!!");
						}
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(clerkFrame,
						"Please provide an interger value...!!");
			}
		}

		if (ae.getActionCommand() == "Submit") {
			try {
				String[] values = new String[5];
				if (rent.getTextField().getText().isEmpty()) {
					if (rent.getTextField_1().getText().isEmpty()) {
						JOptionPane
								.showMessageDialog(rent,
										"Please enter a confirmation Numeber or a Phone number");
					} else {
						Long phnumber = new Long(rent.getTextField_1()
								.getText());
						if (phnumber.equals("")) {
							JOptionPane
									.showMessageDialog(rent,
											"Please provide a Phone Number or the Confirmation Number");
						} else {
							values = dao
									.DisplayRentingDetailsWithPhNo(phnumber);
							if (values[3] == null) {
								JOptionPane
										.showMessageDialog(rent,
												"No Reservation Exists with the given Phone Number");
							} else {
								rent.getTextField_2().setText(values[0]);
								rent.getTextField_3().setText(values[1]);
								rent.getTextField_4().setText(values[2]);
								rent.getTextField_10().setText(values[3]);
								rent.getTextField_12().setText(values[4]);
							}
						}
					}
				} else {
					int number = Integer
							.parseInt(rent.getTextField().getText());
					values = dao.DisplayRentingDetails(number);
					if (values[3] == null) {
						JOptionPane
								.showMessageDialog(rent,
										"No Reservation Exists with the given Confirmation Number");
					} else {
						rent.getTextField_2().setText(values[0]);
						rent.getTextField_3().setText(values[1]);
						rent.getTextField_4().setText(values[2]);
						rent.getTextField_10().setText(values[3]);
						rent.getTextField_12().setText(values[4]);
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret, "Enter an integer Values");
			}
		}

		if (ae.getActionCommand() == "View Rental Agreement") {
			if (clerkFrame.getTextField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(clerkFrame,
						"Rental agreement Not Provided....!!!");
			} else {
				String agreementNo = clerkFrame.getTextField().getText();
				String[] values;
				values = dao.displayRental(agreementNo);
				if (values[0] == null) {
					JOptionPane.showMessageDialog(clerkFrame,
							"No rental Agreement available");
				} else {
					this.clerkFrame.getContentPane().setVisible(false);
					this.clerkFrame.setContentPane(rental);
					this.clerkFrame.getContentPane().setVisible(true);
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
		}

		if (ae.getActionCommand() == "Manage Reservation") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(manage);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}

		if (ae.getActionCommand() == "Update Profile") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(profile);
			this.clerkFrame.setSize(profile.getPreferredSize());
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}

		if (ae.getActionCommand() == "GoBack to Home") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(LoginController.oldpanel);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}

		if (ae.getActionCommand() == "Create Rental Agreement") {
			try {
				int[] values = new int[4];
				int roadstar = 0;
				String LicenseNo = rent.getTextField_5().getText();
				Long Creditcard = new Long(rent.getTextField_6().getText());
				String ExpiryMonth = rent.getTextField_7().getText();
				String ExpiryYear = rent.getTextField_11().getText();
				Double Odometer = Double.valueOf(rent.getTextField_8()
						.getText());
				String Fuel = rent.getTextField_9().getText();
				String Expiry = ExpiryMonth + ExpiryYear;

				if (rent.rdbtnYes.isSelected()) {
					roadstar = 1;
				} else if (rent.rdbtnNo.isSelected()) {
					roadstar = 0;
				}
				String Description = rent.textArea.getText();
				int ConfirmNo = Integer.parseInt(rent.getTextField_10()
						.getText());

				if (ExpiryYear.length() > 2 || ExpiryYear.length() < 2
						|| ExpiryMonth.length() < 2 || ExpiryMonth.length() > 2) {
					JOptionPane.showMessageDialog(rent,
							"Invalid Month and year, Valid Pattern: 04/16");
				} else {
					values = dao.createRentalAgreement(LicenseNo, Creditcard,
							Expiry, Odometer, Fuel, roadstar, Description,
							ConfirmNo);
				}
				if (values[0] == 1 && values[1] == 1 && values[2] == 1) {
					JOptionPane
							.showMessageDialog(
									rent,
									"Rental agreement created...and the remianing tables updated...!! with rental agreement Number"
											+ values[3] + "");
				}
			} catch (Exception e) {
				rent.getLblInvalidEntries().setVisible(true);
			}
		}

		if (ae.getActionCommand() == "Check Details") {
			try {
				String[] values;
				int agreementNo = Integer
						.parseInt(ret.getTextField().getText());
				values = dao.DisplayRentalAgreementwhileReturn(agreementNo);
				if (values[0] == null) {
					JOptionPane.showMessageDialog(ret,
							"agreement Number Does not exist");
				} else {
					if (values[0].equals("1")) {
						ret.rdbtnYes.setSelected(true);
						ret.rdbtnNo.setSelected(false);
					} else {
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
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret,
						"Enter Integer value for a rental agreement number");
			}
		}

		if (ae.getActionCommand() == "Odometer Cost") {
			try {
				if (ret.getTextField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please provide a rental agreement to proceed");
				} else if (ret.textField_9.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please provide the current reading");
				} else {
					int agreementNo = Integer.parseInt(ret.getTextField()
							.getText());
					Double currentReading = Double.parseDouble(ret.textField_9
							.getText());
					String cost = dao.calculateOdometerCost(currentReading,
							agreementNo);
					if (cost.length() > 10) {
						JOptionPane.showMessageDialog(ret, cost);
					} else {
						ret.textField_8.setText(cost);
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret, "enter valid values please");
			}
		}

		if (ae.getActionCommand() == "Fuel Cost") {
			try {
				if (ret.getTextField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please enter the agreement number to proceed");
				} else if (ret.getTextField_10().getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please enter the current fuel reading");
				} else {
					int agreementNo = Integer.parseInt(ret.getTextField()
							.getText());
					String cost = null;
					Double fuel = Double
							.parseDouble(ret.textField_10.getText());
					cost = String.valueOf(dao
							.displayFuelCost(fuel, agreementNo));
					ret.textField_19.setText(cost);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret,
						"Please enter the valid values");
			}
		}

		if (ae.getActionCommand() == "Update") {
			int confirmationNo = Integer
					.valueOf((manage.textField_2.getText()));
			int status = dao.extendRental(manage.dateField, confirmationNo);
			if (status == 1) {
				JOptionPane.showMessageDialog(manage, "Date Updated...!!");
			} else {
				JOptionPane.showMessageDialog(manage,
						"Date could not be Updated...!!");
			}
		}

		if (ae.getActionCommand() == "Inc Cost") {
			if (ret.getTextField().getText().equals("")) {
				JOptionPane
						.showMessageDialog(rent,
								"Please enter a rental agreement and check the details");
			} else {
				String[] values;
				String agreementNo = ret.getTextField().getText();
				values = dao.displayInsuranceCost(agreementNo);
				Double cost = 0.0;
				Double days = Double.parseDouble(values[3]);
				// Double hourlyrate=Double.parseDouble(values[0]);
				Double dailyrate = Double.parseDouble(values[1]);
				Double weeklyrate = Double.parseDouble(values[2]);
				int totalweeks = 0;
				int totaldays = 0;
				if (days > 7) {
					totalweeks = (int) (days / 7);
					totaldays = (int) (days % 7);
					cost = totalweeks * weeklyrate;
					cost = cost + (totaldays * dailyrate);
				} else if (days < 7 && days > 1) {
					cost = days * dailyrate;
				}
				String finalCost = String.valueOf(cost);
				ret.getTextField_20().setText(finalCost);
			}
		}

		if (ae.getActionCommand() == "Add Tax Cost") {
			try {
				if (ret.textField_15.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(ret,
									"Total cost is not calculated Please calculate it first!!");
				} else {
					String rate;
					rate = dao.displayTaxRate();
					Double tax = Double.parseDouble(rate);
					Double Cost = Double.parseDouble(ret.getTextField_15()
							.getText()) * (tax / 100);
					Double totalcost = Cost
							+ Double.parseDouble(ret.getTextField_15()
									.getText());
					ret.textField_11.setText(String.valueOf((new DecimalFormat(
							"#.##").format(totalcost))));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret,
						"Invalid entries are present ");
			}
		}

		if (ae.getActionCommand() == "Process Payment") {
			try {
				int agreementNo = Integer.parseInt(paypal.getTextField_9()
						.getText());
				Double totalCost = Double.valueOf(paypal.getTextField_8()
						.getText());
				System.out.println(totalCost);
				String description = ret.textArea_1.getText();
				int[] status = null;

				// Ifeanyi`s code starts here

				Payment createdPayment = null;

				OAuthTokenCredential tokenCredential = new OAuthTokenCredential(
						"AWuMcxD82z7Z3DjD662BrNOpBZvwtPgbnoPsW-0i1P7jsDtLqiKoZZc97Fby",
						"EO0o-xDbnXnOUSnwN6e89uJdA1-VAAqbhbjf02-wOyApJxYThwmvwjBAousq");

				String accessToken = null;
				try {
					accessToken = tokenCredential.getAccessToken();
				} catch (PayPalRESTException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}

				Address billingAddress = new Address();
				billingAddress.setLine1(paypal.getAddressLine1().getText());
				billingAddress.setCity(paypal.getCity().getText());
				billingAddress.setCountryCode(paypal.getCountry().getText());
				billingAddress.setPostalCode(paypal.getPostalcode().getText());
				billingAddress.setState(paypal.getProvince().getText());

				CreditCard creditCard = new CreditCard();
				creditCard.setNumber(new String(paypal.getCreditcardno()
						.getPassword()));
				creditCard.setType(getCreditCardType(paypal.getCardType()
						.getSelectedIndex()));
				creditCard.setExpireMonth(paypal.getExpiryMonth()
						.getSelectedIndex() + 1);
				creditCard.setExpireYear(Integer.valueOf(paypal.getExpiryYear()
						.getText()));
				creditCard.setCvv2(new String(paypal.getCvv().getPassword()));
				creditCard.setFirstName(paypal.getFirstname().getText());
				creditCard.setLastName(paypal.getLastname().getText());
				creditCard.setBillingAddress(billingAddress);

				// Details amountDetails = new Details();

				Amount amount = new Amount();
				amount.setTotal(String.format("%.2f", totalCost));
				amount.setCurrency("USD");
				// amount.setDetails(amountDetails);

				Transaction transaction = new Transaction();
				transaction.setAmount(amount);
				transaction.setDescription("Payment for " + description);

				List<Transaction> transactions = new ArrayList<Transaction>();
				transactions.add(transaction);

				FundingInstrument fundingInstrument = new FundingInstrument();
				fundingInstrument.setCreditCard(creditCard);

				List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
				fundingInstruments.add(fundingInstrument);

				Payer payer = new Payer();
				payer.setFundingInstruments(fundingInstruments);
				payer.setPaymentMethod("credit_card");

				Payment payment = new Payment();
				payment.setIntent("sale");
				payment.setPayer(payer);
				payment.setTransactions(transactions);

				try {
					System.out.println("Getting to payment");
					createdPayment = payment.create(accessToken);
					status = dao.createPayment(agreementNo, description,
							totalCost);
					System.out.println(getSuccessPaymentStatus(createdPayment
							.getLastResponse()));
					paypal.getPaymentMessage().setText(
							"Payment - "
									+ getSuccessPaymentStatus(createdPayment
											.getLastResponse()));
				} catch (PayPalRESTException et) { //
					paypal.getPaymentMessage().setText(et.getMessage());
					System.out.println(createdPayment.getLastResponse());
				}
				System.out.println("Getting here - after transaction");

				// Ifeanyi`s code ends here
				if (status[0] == 1) {
					JOptionPane.showMessageDialog(ret,
							"Payment done with ReceiptId" + status[1]);
				} else {
					JOptionPane.showMessageDialog(manage,
							"Payment could not be done");
				}
			} catch (Exception e) {
				// JOptionPane.showMessageDialog(ret,
				// "Please enter valid details");
				paypal.getPaymentMessage()
						.setText(
								e.getMessage()
										+ " .Please check all your fields and make sure you filled them in correctly");
				System.out.println(e.getMessage());
			}
		}

		if (ae.getActionCommand() == "Cancel Reservation") {
			int status = 0;
			int confirmationNo = Integer.parseInt(manage.textField_1.getText());
			status = dao.cancelReservation(confirmationNo);

			if (status == 1) {
				JOptionPane.showMessageDialog(manage,
						"Reservation with reservation number " + confirmationNo
								+ " is cancelled");
			} else {
				JOptionPane.showMessageDialog(manage,
						"Confirmation No not valid");
			}
		}

		if (ae.getActionCommand() == "Calculate Total Cost") {
			try {
				if (ret.textField_8.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please calculate the odometer cost first");
				} else if (ret.textField_19.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please calculate the fuel cost");
				} else if (ret.textField_20.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please calculate the insurance cost");
				} else if (ret.getTextField_7().getText().isEmpty()) {
					JOptionPane.showMessageDialog(ret,
							"Please calculate the total cost ");
				} else {
					if (ret.getTextField().getText().equals("")) {
						JOptionPane
								.showMessageDialog(
										ret,
										"Please provide a rental Agreement Number and calculate the Odometer cost and fuel Cost");
					} else {
						Double odometerCost = Double
								.parseDouble(ret.textField_8.getText());
						Double fuelCost = Double.parseDouble(ret.textField_19
								.getText());
						Double overdueCost = Double
								.parseDouble(ret.textField_12.getText());
						Double damageCost = Double.parseDouble(ret.textField_13
								.getText());
						Double insuranceCost = Double
								.parseDouble(ret.textField_20.getText());
						Double charges = Double.parseDouble(ret
								.getTextField_7().getText());
						String totalCost = String.valueOf(odometerCost
								+ fuelCost + overdueCost + damageCost
								+ insuranceCost + charges);
						ret.textField_15.setText(totalCost);
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ret, "please enter valid values");
			}
		}

		if (ae.getActionCommand() == "Redeem") {
			if (ret.getTextField().getText().equals("")) {
				JOptionPane
						.showMessageDialog(ret,
								"Please provide a rental Agreement Number and check the details first");
			} else {
				String agreementNo = ret.getTextField().getText();
				Double points = Double.valueOf(dao.DisplayPoints(agreementNo));
				Double discount = Double.parseDouble(dao
						.DisplayDiscountedCost());
				ret.textField_17.setText(String.valueOf(points));
				Double cost = Double.parseDouble(ret.getTextField_11()
						.getText());
				int cost1 = (int) Math.round(cost);
				int discountedcost = cost1
						- (Integer.valueOf((int) ((points / 100) * discount)));
				ret.getTextField_18().setText(String.valueOf(discountedcost));
			}
		}

		if (ae.getActionCommand() == "Add Points") {
			if (ret.getTextField().getText().equals("")) {
				JOptionPane
						.showMessageDialog(ret,
								"Please provide a rental Agreement Number and check the details first");
			} else {
				String agreementNo = ret.getTextField().getText();
				String cost = ret.getTextField_18().getText();
				int status = dao.UpdatePoints(agreementNo, cost);
				if (status == 1) {
					JOptionPane.showMessageDialog(ret, "Points updated..!!");
				} else {
					JOptionPane.showMessageDialog(ret,
							"could not update the points");
				}
			}
		}

		if (ae.getActionCommand() == "Proceed To PayPal") {
			String bill = ret.getTextField_18().getText();
			String agreementNo = ret.getTextField().getText();
			this.clerkFrame.getContentPane().setVisible(false);
			paypal.getTextField_8().setText(bill);
			paypal.getTextField_9().setText(agreementNo);
			this.clerkFrame.setContentPane(paypal);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}

		if (ae.getActionCommand() == "GoBack to ReturnPage") {
			this.clerkFrame.getContentPane().setVisible(false);
			this.clerkFrame.setContentPane(oldreturn);
			this.clerkFrame.getContentPane().setVisible(true);
			this.clerkFrame.revalidate();
			this.clerkFrame.repaint();
		}
	}

	public void displayConnectionLost(Exception e) {
		JOptionPane.showMessageDialog(clerkFrame, e);
	}

	private String getSuccessPaymentStatus(String status) {
		List<String> statusParams = Arrays.asList(status.split(","));
		String paymentStatus = statusParams.get(3);
		return paymentStatus;
	}

	private String getWrongPaymentStatus(String status) {
		List<String> statusParams = Arrays.asList(status.split(","));
		String paymentStatus = statusParams.get(4);
		return paymentStatus;
	}

	private String getCreditCardType(int index) {
		if (index == 0) {
			return "mastercard";
		}

		if (index == 1) {
			return "visa";
		}

		if (index == 2) {
			return "americanexpress";
		}
		return "mastercard";
	}
}