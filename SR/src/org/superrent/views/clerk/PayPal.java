package org.superrent.views.clerk;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.superrent.controllers.ClerkController;

public class PayPal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public JButton btnGobackToHome;
	public JButton btnProcessPayment;
	private JTextField textField_9;
	
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
				ColumnSpec.decode("max(153dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
		
		JLabel lblWelcomeToPaypal = new JLabel("WELCOME TO PAYPAL");
		add(lblWelcomeToPaypal, "6, 4, center, default");
		
		JLabel lblAgreementNumber = new JLabel("Agreement Number");
		add(lblAgreementNumber, "4, 6, right, default");
		
		setTextField_9(new JTextField());
		add(getTextField_9(), "6, 6, fill, default");
		getTextField_9().setColumns(10);
		
		JLabel lblYourTotalBill = new JLabel("Your Total Bill");
		add(lblYourTotalBill, "4, 8, right, default");
		
		setTextField_8(new JTextField());
		add(getTextField_8(), "6, 8, fill, default");
		getTextField_8().setColumns(10);
		
		JLabel lblPleaseProvideYour = new JLabel("Please provide Your Address");
		add(lblPleaseProvideYour, "4, 12");
		
		JLabel lblAdressLine = new JLabel("Adress Line 1");
		add(lblAdressLine, "4, 14, right, default");
		
		textField = new JTextField();
		add(textField, "6, 14, fill, default");
		textField.setColumns(10);
		
		JLabel lblAddressLine = new JLabel("Address line 2");
		add(lblAddressLine, "4, 16, right, default");
		
		textField_1 = new JTextField();
		add(textField_1, "6, 16, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		add(lblCity, "4, 18, right, default");
		
		textField_2 = new JTextField();
		add(textField_2, "6, 18, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblProvincestate = new JLabel("Province/state");
		add(lblProvincestate, "4, 20, right, default");
		
		textField_3 = new JTextField();
		add(textField_3, "6, 20, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		add(lblCountry, "4, 22, right, default");
		
		textField_4 = new JTextField();
		add(textField_4, "6, 22, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblPostalcode = new JLabel("PostalCode");
		add(lblPostalcode, "4, 24, right, default");
		
		textField_5 = new JTextField();
		add(textField_5, "6, 24, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblCreditCardDetails = new JLabel("Credit Card Details");
		add(lblCreditCardDetails, "4, 28");
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card number");
		add(lblCreditCardNumber, "4, 30, right, default");
		
		textField_6 = new JTextField();
		add(textField_6, "6, 30, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry date");
		add(lblExpiryDate, "4, 32, right, default");
		
		textField_7 = new JTextField();
		add(textField_7, "6, 32, fill, default");
		textField_7.setColumns(10);
		
		btnProcessPayment = new JButton("Process Payment");
		add(btnProcessPayment, "6, 36, center, default");
		
		btnGobackToHome = new JButton("GoBack to ReturnPage");
		add(btnGobackToHome, "8, 38, center, default");

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
}
