package org.superrent.views.clerk;

import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;



import javax.swing.JRadioButton;

import org.superrent.controllers.ClerkController;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Rent extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_3;
	JButton btnSubmit;
	JButton btnGobackToHome;
	JButton btnCreateRentalAgreement;
	public ButtonGroup bG;
	public JTextArea textArea;
	private JTextField textField_10;
	public JRadioButton rdbtnYes;
	public JRadioButton rdbtnNo;
	public JFormattedTextField datefield=new JFormattedTextField(new SimpleDateFormat("yyyy/MM/dd"));
	private JTextField textField_11;
	private JTextField textField_12;
	
	/**
	 * Create the panel.
	 */
	
	public Rent() 
	{
		
		JLabel label = new JLabel("Confirmation Number");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		
		setTextField_1(new JTextField());
		getTextField_1().setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		btnSubmit = new JButton("Submit");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(datefield);
		datefield.computeVisibleRect(getBounds());
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		
		JLabel lblNewLabel = new JLabel("Driver's License Number");
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		
		setTextField_7(new JTextField());
		getTextField_7().setColumns(10);
		
		JLabel lblVehicleCondition = new JLabel("Vehicle Condition");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		
		textArea = new JTextArea();
		
		JLabel lblRoadStar = new JLabel("Road Star");
		
		rdbtnYes = new JRadioButton("yes");
		
		rdbtnNo = new JRadioButton("No");
		
		bG = new ButtonGroup();
	     bG.add(rdbtnYes);
	     bG.add(rdbtnNo);
		
		JLabel label_1 = new JLabel("/");
		
		setTextField_11(new JTextField());
		getTextField_11().setColumns(10);
		
		JLabel lblMonthyear = new JLabel("Month/year");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.CENTER)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterCurrentDetails))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVehicleCondition)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblOdometerReading)
												.addComponent(lblVehicleDescription))
											.addGap(27)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
													.addGap(59)
													.addComponent(lblFuelPercentage)
													.addGap(18)
													.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
												.addComponent(textArea)))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(25)
									.addComponent(lblNewLabel)
									.addGap(33)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCreditCardNumber)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
							.addGap(24)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblRoadStar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnYes)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnNo))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblMonthyear)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblExpiryDate)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
							.addGap(70)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterCurrentDetails)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblCreditCardNumber)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(lblExpiryDate)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMonthyear)
					.addGap(7)
					.addComponent(lblVehicleCondition)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOdometerReading)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFuelPercentage)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoadStar)
						.addComponent(rdbtnYes)
						.addComponent(rdbtnNo))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVehicleDescription))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnCreateRentalAgreement = new JButton("Create Rental Agreement");
		
		btnGobackToHome = new JButton("GoBack to Home");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap(143, Short.MAX_VALUE)
									.addComponent(btnCreateRentalAgreement)
									.addGap(86)
									.addComponent(btnGobackToHome)
									.addGap(132))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(lblOr)
									.addGap(56)
									.addComponent(lblPhoneNumber)
									.addGap(18)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(383)
									.addComponent(btnSubmit)))
							.addGap(372))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 834, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 835, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOr)
						.addComponent(lblPhoneNumber)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateRentalAgreement)
						.addComponent(btnGobackToHome))
					.addGap(173))
		);
		
		JLabel lblReservationDetails = new JLabel("Reservation Details");
		
		JLabel lblPickupDate = new JLabel("PickUp Date");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		
		JLabel lblDropDate = new JLabel("Drop Date");
		
		JLabel lblCharges = new JLabel("Charges");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		
		setTextField_3(new JTextField());
		getTextField_3().setColumns(10);
		
		JLabel lblConfirmationNumber = new JLabel("Confirmation Number");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		
		JLabel lblAdditionalEquipment = new JLabel("Additional Equipment");
		
		setTextField_12(new JTextField());
		getTextField_12().setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblReservationDetails))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(64)
									.addComponent(lblConfirmationNumber)
									.addGap(26)
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addComponent(lblAdditionalEquipment))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPickupDate, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblDropDate)
									.addGap(18)
									.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblCharges)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(getTextField_12(), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
					.addGap(126))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReservationDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmationNumber)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdditionalEquipment)
						.addComponent(getTextField_12(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCharges)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDropDate)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPickupDate))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
		textField.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}
	
	public void confirmationbtnActionListener(ClerkController clerk)
	{
		btnSubmit.addActionListener(clerk);
	}
	
	public void GoBackHomebtnActionListener(ClerkController clerk)
	{
		btnGobackToHome.addActionListener(clerk);
	}
	
	public void CreateRentalbtnActionListener(ClerkController clerk)
	{
		btnCreateRentalAgreement.addActionListener(clerk);
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}

	public JTextField getTextField_7() {
		return textField_7;
	}

	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
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

	public JTextField getTextField_10() {
		return textField_10;
	}

	public void setTextField_10(JTextField textField_10) {
		this.textField_10 = textField_10;
	}
	
	public void rdbtnActionListener(ClerkController clerk)
	{
		rdbtnYes.addActionListener(clerk);
		rdbtnNo.addActionListener(clerk);
		//bG.getSelection().addActionListener(clerk);
		
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public void setTextField_12(JTextField textField_12) {
		this.textField_12 = textField_12;
	}
}
