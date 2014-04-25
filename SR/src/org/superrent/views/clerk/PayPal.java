package org.superrent.views.clerk;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.superrent.controllers.ClerkController;
import java.awt.Font;
import java.text.DateFormatSymbols;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PayPal extends JPanel {
	private JTextField addressLine1;
	private JTextField addressLine2;
	private JPasswordField creditcardno;
	private JTextField textField_8;
	public JButton btnGobackToHome;
	public JButton btnProcessPayment;
	private JTextField textField_9;
	private JTextField city;
	private JTextField province;
	private JTextField country;
	private JTextField postalcode;
	private JTextField expiryYear;
	private JPasswordField cvv;
	private JComboBox expiryMonth;
	private JComboBox cardType;
	private JTextField firstname;
	private JTextField lastname;
	private JLabel paymentMessage;
	
	/**
	 * Create the panel.
	 */
	public PayPal() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(78dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(27dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblWelcomeToPaypal = new JLabel("ENTER PAYMENT DETAILS ");
		lblWelcomeToPaypal.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblWelcomeToPaypal, "6, 4, 5, 1, center, default");
		
		paymentMessage = new JLabel("");
		add(paymentMessage, "6, 6, 5, 1");
		
		JLabel lblAgreementNumber = new JLabel("Agreement Number");
		add(lblAgreementNumber, "4, 8, right, default");
		
		setTextField_9(new JTextField());
		add(getTextField_9(), "6, 8, fill, default");
		getTextField_9().setColumns(10);
		
		JLabel lblYourTotalBill = new JLabel("Your Total Bill");
		add(lblYourTotalBill, "10, 8, right, default");
		
		setTextField_8(new JTextField());
		add(getTextField_8(), "12, 8, fill, default");
		getTextField_8().setColumns(10);
		
		JLabel lblPleaseProvideYour = new JLabel("BILLING ADDRESS");
		lblPleaseProvideYour.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblPleaseProvideYour, "6, 12, 5, 1, center, default");
		
		JLabel lblAdressLine = new JLabel("Adress Line 1");
		add(lblAdressLine, "4, 14, right, default");
		
		addressLine1 = new JTextField();
		add(addressLine1, "6, 14, fill, default");
		addressLine1.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		add(lblCity, "10, 14, right, default");
		
		city = new JTextField();
		city.setColumns(10);
		add(city, "12, 14, fill, default");
		
		JLabel lblAddressLine = new JLabel("Address line 2");
		add(lblAddressLine, "4, 16, right, default");
		
		addressLine2 = new JTextField();
		add(addressLine2, "6, 16, fill, default");
		addressLine2.setColumns(10);
		
		JLabel lblProvincestate = new JLabel("Province/State Code");
		add(lblProvincestate, "10, 16, right, default");
		
		province = new JTextField();
		province.setColumns(10);
		add(province, "12, 16, fill, default");
		
		JLabel lblPostalcode = new JLabel("PostalCode");
		add(lblPostalcode, "4, 18, right, default");
		
		postalcode = new JTextField();
		postalcode.setColumns(10);
		add(postalcode, "6, 18, fill, default");
		
		JLabel lblCountry = new JLabel("Country Code");
		add(lblCountry, "10, 18, right, default");
		
		country = new JTextField();
		country.setColumns(10);
		add(country, "12, 18, fill, default");
		
		JLabel lblCreditCardDetails = new JLabel("CREDIT CARD DETAILS");
		lblCreditCardDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCreditCardDetails, "6, 22, 5, 1, center, default");
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card number");
		add(lblCreditCardNumber, "4, 24, right, default");
		
		creditcardno = new JPasswordField();
		add(creditcardno, "6, 24, fill, default");
		creditcardno.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Month");
		add(lblExpiryDate, "10, 24, right, default");
		
		expiryMonth = new JComboBox();
		String months[]=(new DateFormatSymbols()).getMonths();
		expiryMonth.setModel(new DefaultComboBoxModel(months));
		add(expiryMonth, "12, 24, fill, default");
		
		JLabel lblCardType = new JLabel("Card Type");
		add(lblCardType, "4, 26, right, default");
		
		cardType = new JComboBox();
		cardType.setModel(new DefaultComboBoxModel(new String[] {"Mastercard", "Visa", "American Express"}));
		add(cardType, "6, 26, fill, default");
		
		JLabel lblExpiryYear = new JLabel("Expiry Year (e.g. 2014)");
		add(lblExpiryYear, "10, 26, right, default");
		
		expiryYear = new JTextField();
		add(expiryYear, "12, 26, fill, default");
		expiryYear.setColumns(10);
		
		JLabel lblCvv = new JLabel("CVV");
		add(lblCvv, "4, 28, right, default");
		
		cvv = new JPasswordField();
		add(cvv, "6, 28, fill, default");
		cvv.setColumns(10);
		
		JLabel lblNameOnCard = new JLabel("Name on Card (Firstname)");
		add(lblNameOnCard, "10, 28, right, default");
		
		firstname = new JTextField();
		add(firstname, "12, 28, fill, default");
		firstname.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname");
		add(lblLastname, "10, 30, right, default");
		
		lastname = new JTextField();
		add(lastname, "12, 30, fill, default");
		lastname.setColumns(10);
		
		btnProcessPayment = new JButton("Process Payment");
		add(btnProcessPayment, "6, 32, center, default");
		
		btnGobackToHome = new JButton("GoBack to ReturnPage");
		add(btnGobackToHome, "10, 32, center, default");

	}

	public void returnPageActionListener(ClerkController clerk)
	{	
		btnGobackToHome.addActionListener(clerk);
	}
	
	public void processPaymentActionListener(ClerkController clerk)
	{
		btnProcessPayment.addActionListener(clerk);
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}
	public JTextField getAddressLine1() {
		return addressLine1;
	}
	public JTextField getAddressLine2() {
		return addressLine2;
	}
	public JTextField getCity() {
		return city;
	}
	public JTextField getProvince() {
		return province;
	}
	public JTextField getCountry() {
		return country;
	}
	public JTextField getPostalcode() {
		return postalcode;
	}
	public JPasswordField getCreditcardno() {
		return creditcardno;
	}
	
	public JComboBox getExpiryMonth() {
		return expiryMonth;
	}
	public JComboBox getCardType() {
		return cardType;
	}
	public JTextField getExpiryYear() {
		return expiryYear;
	}
	public JPasswordField getCvv() {
		return cvv;
	}
	public JTextField getFirstname() {
		return firstname;
	}
	public JTextField getLastname() {
		return lastname;
	}
	public JLabel getPaymentMessage() {
		return paymentMessage;
	}
}
