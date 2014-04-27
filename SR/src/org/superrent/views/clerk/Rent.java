package org.superrent.views.clerk;

import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JComboBox;

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
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_3;
	JButton btnSubmit;
	JButton btnCreateRentalAgreement;
	public ButtonGroup bG;
	public JTextArea textArea;
	private JTextField textField_10;
	public JRadioButton rdbtnYes;
	public JRadioButton rdbtnNo;
	private JTextField textField_12;
	private JLabel lblInvalidEntries;
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JComboBox<String> comboBox_1 = new JComboBox<String>();
	
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
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		
		JLabel lblNewLabel = new JLabel("Driver's License Number");
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		
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
		
		bG = new ButtonGroup();
	     bG.add(rdbtnYes);
		
		JLabel lblMonthyear = new JLabel("Month/year");
		
		setLblInvalidEntries(new JLabel("Invalid Entries"));
		getLblInvalidEntries().setForeground(Color.RED);
		getLblInvalidEntries().setVisible(false);
		
		btnCreateRentalAgreement = new JButton("Create Rental Agreement");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 842, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOr)
								.addComponent(btnCreateRentalAgreement)
								.addComponent(btnSubmit)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(119)
							.addComponent(lblPhoneNumber)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneNumber)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOr))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreateRentalAgreement)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("27px"),
				ColumnSpec.decode("12px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("33px"),
				ColumnSpec.decode("50px"),
				ColumnSpec.decode("59px"),
				ColumnSpec.decode("31px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("35px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("48px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("159px"),
				ColumnSpec.decode("24px"),
				ColumnSpec.decode("48px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("2px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("35px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(6dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default):grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("62px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("0px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("24px"),},
			new RowSpec[] {
				RowSpec.decode("1px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				RowSpec.decode("25px"),
				RowSpec.decode("14px"),}));
		panel_1.add(lblEnterCurrentDetails, "15, 3, 3, 1, left, top");
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		panel_1.add(textField_5, "5, 5, 7, 1, fill, fill");
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		panel_1.add(lblCreditCardNumber, "13, 5, 4, 1, right, center");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		panel_1.add(textField_6, "17, 5, 3, 1, fill, fill");
		
		
		panel_1.add(getComboBox(), "24, 5, 2, 1, fill, default");
		
		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1, "27, 5, right, center");
		
		
		panel_1.add(getComboBox_1(), "29, 5, fill, default");
		panel_1.add(lblVehicleCondition, "3, 9, left, top");
		panel_1.add(lblOdometerReading, "3, 11, left, center");
		
		String[] Month={"00","01","02","03","04","05","06","07","08","09","10","11","12"};
		getComboBox().setModel(new DefaultComboBoxModel<String>(Month));
		
		String[] year={"00","16","17","18","19","20","21","22","23","24","25","26","28","29","30","31",
				"32","33","34","35","36"};
		getComboBox_1().setModel(new DefaultComboBoxModel<String>(year));
		
		rdbtnNo = new JRadioButton("No");
		bG.add(rdbtnNo);
		panel_1.add(rdbtnNo, "29, 11, left, top");
		panel_1.add(lblVehicleDescription, "3, 13, left, bottom");
		panel_1.add(textField_8, "5, 11, 7, 1, fill, fill");
		panel_1.add(lblFuelPercentage, "13, 11, 3, 1, left, center");
		panel_1.add(textField_9, "17, 11, 3, 1, left, fill");
		panel_1.add(textArea, "5, 13, 15, 3, fill, fill");
		panel_1.add(lblNewLabel, "3, 5, 2, 1, left, center");
		panel_1.add(lblRoadStar, "21, 11, left, center");
		panel_1.add(rdbtnYes, "23, 11, 4, 1, left, top");
		panel_1.add(lblMonthyear, "25, 7, 6, 1, center, top");
		panel_1.add(lblExpiryDate, "21, 5, 3, 1, left, center");
		panel_1.add(lblInvalidEntries, "25, 15, 11, 1, left, top");
		
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
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("33px"),
				ColumnSpec.decode("58px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("55px"),
				ColumnSpec.decode("26px"),
				ColumnSpec.decode("51px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("17px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("22px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("66px"),
				ColumnSpec.decode("42px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("119px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("31px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),}));
		panel.add(lblReservationDetails, "10, 2, 3, 1, left, top");
		
		JLabel lblConfirmationNumber = new JLabel("Confirmation Number");
		panel.add(lblConfirmationNumber, "2, 4, 2, 1, left, center");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		panel.add(textField_10, "5, 4, 5, 1, fill, top");
		
		JLabel lblAdditionalEquipment = new JLabel("Additional Equipment");
		panel.add(lblAdditionalEquipment, "12, 4, 2, 1, left, center");
		
		setTextField_12(new JTextField());
		getTextField_12().setColumns(10);
		panel.add(textField_12, "14, 4, 4, 1, fill, top");
		panel.add(lblPickupDate, "2, 6, fill, center");
		panel.add(textField_2, "4, 6, 3, 1, fill, top");
		panel.add(lblDropDate, "8, 6, 3, 1, left, center");
		panel.add(textField_3, "12, 6, 3, 1, fill, top");
		panel.add(lblCharges, "16, 6, left, center");
		panel.add(textField_4, "18, 6, fill, top");
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

	public void setTextField_7(JTextField textField_7) {
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
	}
	public void setTextField_11(JTextField textField_11) {
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public void setTextField_12(JTextField textField_12) {
		this.textField_12 = textField_12;
	}

	public JLabel getLblInvalidEntries() {
		return lblInvalidEntries;
	}

	public void setLblInvalidEntries(JLabel lblInvalidEntries) {
		this.lblInvalidEntries = lblInvalidEntries;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox<String> getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox<String> comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
}
