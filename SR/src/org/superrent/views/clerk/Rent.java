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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		btnSubmit = new JButton("Submit");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Driver's License Number");
		
		JLabel lblVehicleCondition = new JLabel("Vehicle Condition");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		
		bG = new ButtonGroup();
		
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
				ColumnSpec.decode("max(17dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(67dlu;default)"),},
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
		panel_1.add(lblEnterCurrentDetails, "1, 3, left, top");
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		panel_1.add(textField_5, "2, 5, 4, 1, fill, fill");
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		panel_1.add(lblCreditCardNumber, "6, 5, right, center");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		panel_1.add(textField_6, "7, 5, fill, fill");
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		panel_1.add(lblExpiryDate, "9, 5, right, center");
		
		
		panel_1.add(getComboBox(), "10, 5, 3, 1, fill, default");
		
		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1, "13, 5, center, center");
		
		
		panel_1.add(getComboBox_1(), "15, 5, fill, default");
		
		panel_1.add(lblVehicleCondition, "1, 9, left, top");
		panel_1.add(lblOdometerReading, "1, 11, left, center");
		
		String[] Month={"00","01","02","03","04","05","06","07","08","09","10","11","12"};
		getComboBox().setModel(new DefaultComboBoxModel<String>(Month));
		
		String[] year={"00","16","17","18","19","20","21","22","23","24","25","26","28","29","30","31",
				"32","33","34","35","36"};
		getComboBox_1().setModel(new DefaultComboBoxModel<String>(year));
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		panel_1.add(lblFuelPercentage, "6, 11, right, center");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		panel_1.add(textField_9, "7, 11, fill, fill");
		
		JLabel lblRoadStar = new JLabel("Road Star");
		panel_1.add(lblRoadStar, "9, 11, right, center");
		
		rdbtnYes = new JRadioButton("yes");
		bG.add(rdbtnYes);
		panel_1.add(rdbtnYes, "11, 11, 3, 1, left, top");
		panel_1.add(textField_8, "2, 11, 4, 1, fill, fill");
		
		rdbtnNo = new JRadioButton("No");
		bG.add(rdbtnNo);
		panel_1.add(rdbtnNo, "15, 11, default, top");
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		panel_1.add(lblVehicleDescription, "1, 15, left, bottom");
		panel_1.add(lblNewLabel, "1, 5, left, center");
		panel_1.add(lblMonthyear, "11, 7, 5, 1, center, top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "3, 15, 4, 2, fill, fill");
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		textArea.setRows(2);
		textArea.setColumns(1);
		panel_1.add(lblInvalidEntries, "11, 18, 7, 1, left, top");
		
		JLabel lblPickupDate = new JLabel("PickUp Date");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		
		JLabel lblDropDate = new JLabel("Drop Date");
		
		setTextField_3(new JTextField());
		getTextField_3().setColumns(10);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("58px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("55px"),
				ColumnSpec.decode("26px"),
				ColumnSpec.decode("61px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("95px"),
				ColumnSpec.decode("206px"),
				ColumnSpec.decode("138px:grow"),
				ColumnSpec.decode("71px"),
				ColumnSpec.decode("68px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("31px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),}));
		
		JLabel lblReservationDetails = new JLabel("Reservation Details");
		panel.add(lblReservationDetails, "8, 2, left, top");
		
		JLabel lblConfirmationNumber = new JLabel("Confirmation Number");
		panel.add(lblConfirmationNumber, "1, 4, 2, 1, left, center");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		panel.add(textField_10, "4, 4, 4, 1, fill, center");
		
		JLabel lblAdditionalEquipment = new JLabel("Additional Equipment");
		panel.add(lblAdditionalEquipment, "8, 4, right, center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "9, 4, 2, 1, fill, fill");
		textArea_1.setLineWrap(true);
		
		textArea_1.setRows(2);
		textArea_1.setColumns(1);
		
		scrollPane.setViewportView(textArea_1);
		panel.add(lblPickupDate, "1, 6, 2, 1, fill, center");
		panel.add(textField_2, "3, 6, 4, 1, fill, center");
		panel.add(lblDropDate, "7, 6, right, center");
		panel.add(textField_3, "8, 6, fill, center");
		
		JLabel lblCharges = new JLabel("Charges");
		panel.add(lblCharges, "9, 6, right, center");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		panel.add(textField_4, "10, 6, fill, center");
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
