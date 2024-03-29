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
import javax.swing.JScrollPane;
import java.awt.Font;

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
	public JTextArea textArea_1 = new JTextArea();
	private JTextField textField_10;
	public JRadioButton rdbtnYes;
	public JRadioButton rdbtnNo;
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
		
		btnSubmit = new JButton("Submit");
		
		bG = new ButtonGroup();
		
		btnCreateRentalAgreement = new JButton("Create Rental Agreement");
		
		String[] Month={"00","01","02","03","04","05","06","07","08","09","10","11","12"};
		
		String[] year={"00","16","17","18","19","20","21","22","23","24","25","26","28","29","30","31",
				"32","33","34","35","36"};
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("129px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("109px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("85px"),
				ColumnSpec.decode("70px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("127px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("max(35dlu;default)"),
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
				RowSpec.decode("max(22dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(41dlu;default)"),
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
				RowSpec.decode("49px"),}));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "3, 6, 16, 11, fill, fill");
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPickupDate = new JLabel("PickUp Date");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		
		JLabel lblDropDate = new JLabel("Drop Date");
		
		setTextField_3(new JTextField());
		getTextField_3().setColumns(10);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("58px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("55px"),
				ColumnSpec.decode("26px"),
				ColumnSpec.decode("61px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				ColumnSpec.decode("116px"),
				ColumnSpec.decode("67px"),
				ColumnSpec.decode("left:71px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblReservationDetails = new JLabel("Reservation Details");
		lblReservationDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblReservationDetails, "7, 2, 4, 1, center, top");
		
		JLabel lblConfirmationNumber = new JLabel("Confirmation Number");
		panel.add(lblConfirmationNumber, "3, 4, 2, 1, left, center");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		panel.add(textField_10, "6, 4, 2, 1, fill, center");
		
		JLabel lblAdditionalEquipment = new JLabel("Additional Equipment");
		panel.add(lblAdditionalEquipment, "9, 4, right, center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "10, 4, fill, fill");
		textArea_1.setLineWrap(true);
		
		textArea_1.setRows(2);
		textArea_1.setColumns(1);
		
		scrollPane.setViewportView(textArea_1);
		panel.add(lblPickupDate, "3, 6, 2, 1, fill, center");
		panel.add(textField_2, "5, 6, 4, 1, fill, center");
		panel.add(lblDropDate, "9, 6, right, center");
		panel.add(textField_3, "10, 6, fill, center");
		
		JLabel lblCharges = new JLabel("Charges");
		panel.add(lblCharges, "11, 6, right, center");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		panel.add(textField_4, "12, 6, fill, center");
		add(lblOr, "7, 2, center, center");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "3, 20, 16, 17, fill, fill");
		
		JPanel panel_1 = new JPanel();
		scrollPane_3.setViewportView(panel_1);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Driver's License Number");
		
		JLabel lblVehicleCondition = new JLabel("Vehicle Condition");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		
		JLabel lblMonthyear = new JLabel("Month/year");
		
		setLblInvalidEntries(new JLabel("Invalid Entries"));
		getLblInvalidEntries().setForeground(Color.RED);
		getLblInvalidEntries().setVisible(false);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("114px"),
				ColumnSpec.decode("12px"),
				ColumnSpec.decode("31px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("47px"),
				ColumnSpec.decode("124px"),
				ColumnSpec.decode("186px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("115px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("29px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(11dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(17dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				RowSpec.decode("14px"),}));
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		panel_1.add(lblEnterCurrentDetails, "3, 3, left, top");
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		panel_1.add(textField_5, "4, 5, 4, 1, fill, fill");
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		panel_1.add(lblCreditCardNumber, "8, 5, right, center");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		panel_1.add(textField_6, "9, 5, fill, fill");
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		panel_1.add(lblExpiryDate, "11, 5, right, center");
		
		
		panel_1.add(getComboBox(), "12, 5, 3, 1, fill, default");
		
		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1, "15, 5, center, center");
		
		
		panel_1.add(getComboBox_1(), "17, 5, fill, default");
		
		panel_1.add(lblVehicleCondition, "3, 9, left, top");
		panel_1.add(lblOdometerReading, "3, 11, left, center");
		getComboBox().setModel(new DefaultComboBoxModel<String>(Month));
		getComboBox_1().setModel(new DefaultComboBoxModel<String>(year));
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		panel_1.add(lblFuelPercentage, "8, 11, right, center");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		panel_1.add(textField_9, "9, 11, fill, fill");
		
		JLabel lblRoadStar = new JLabel("Road Star");
		panel_1.add(lblRoadStar, "11, 11, right, center");
		
		rdbtnYes = new JRadioButton("yes");
		bG.add(rdbtnYes);
		panel_1.add(rdbtnYes, "13, 11, 3, 1, left, top");
		panel_1.add(textField_8, "4, 11, 4, 1, fill, fill");
		
		rdbtnNo = new JRadioButton("No");
		bG.add(rdbtnNo);
		panel_1.add(rdbtnNo, "17, 11, default, top");
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		panel_1.add(lblVehicleDescription, "3, 15, left, bottom");
		panel_1.add(lblNewLabel, "3, 5, left, center");
		panel_1.add(lblMonthyear, "13, 7, 5, 1, center, top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "5, 15, 4, 2, fill, fill");
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		textArea.setRows(2);
		textArea.setColumns(1);
		panel_1.add(lblInvalidEntries, "13, 18, 7, 1, left, top");
		add(btnCreateRentalAgreement, "7, 38, 2, 1, left, top");
		add(btnSubmit, "7, 4, 2, 1, center, top");
		add(label, "3, 2, right, center");
		add(textField, "5, 2, fill, top");
		add(lblPhoneNumber, "8, 2, left, center");
		add(textField_1, "10, 2, fill, top");
		
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
	
	public void setTextField_12(JTextField textField_12) {
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
