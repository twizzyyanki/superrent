package org.superrent.views.clerk;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JButton;


import javax.swing.JRadioButton;

import org.superrent.controllers.ClerkController;

public class Return extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public JTextField textField_9;
	public JTextField textField_10;
	public JTextField textField_12;
	public JTextField textField_13;
	public JTextField textField_15;
	public JTextField textField_17;
	private JTextField textField_18;
	JButton btnGoBackToHome;
	private JTextField textField_4;
	public JTextArea textArea;
	public JButton btnCheckDetails;
	public JRadioButton rdbtnYes;
	public JRadioButton rdbtnNo;
	public JTextField textField_8;
	public JTextField textField_19;
	public JTextField textField_20;
	public JTextField textField_11;
	JButton btnCost = new JButton("Odometer Cost");
	
	JButton btnCost_1 = new JButton("Fuel Cost");
	
	JButton btnIncCost = new JButton("Inc Cost");
	
	JButton btnTaxCost = new JButton("Add Tax Cost");
	
	JButton btnRedeem = new JButton("Redeem");
	
	JLabel lblCostAfterRedeeming = new JLabel("Cost After Redeeming");
	
	JButton btnCalculateTotalCost = new JButton("Calculate Total Cost");
	
	JButton btnAddPoints;
	
	JButton btnProceedToPayment;
	
	private JLabel lblAdditionEquipement;
	
	private JTextField textField_14;
	public JTextArea textArea_1;
	
	/**
	 * Create the panel.
	 */
	public Return()
	{
		
		JLabel lblRentalAgreementNumber = new JLabel("Rental Agreement Number");
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel Customername = new JLabel("CustomerName");
		
		setTextField_1(new JTextField());
		getTextField_1().setColumns(10);
		
		JLabel Phonenum = new JLabel("Phone Number");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		
		JLabel label_2 = new JLabel("Charges");
		
		JLabel label_3 = new JLabel("Vehicle Description");
		
		JLabel label_4 = new JLabel("Odometer Reading");
		
		JLabel label_5 = new JLabel("DropDate");
		
		setTextField_3(new JTextField());
		getTextField_3().setColumns(10);
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		
		JLabel label_7 = new JLabel("Fuel Percentage");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		
		setTextField_7(new JTextField());
		getTextField_7().setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JLabel RoadStar = new JLabel("Roadstar");
		
		rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setEnabled(false);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setEnabled(false);
		
		ButtonGroup bG=new ButtonGroup();
		bG.add(rdbtnYes);
		bG.add(rdbtnNo);
		
		JLabel lblPickupdate = new JLabel("PickUpdate");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		
		lblAdditionEquipement = new JLabel("Addition Equipement");
		
		setTextField_14(new JTextField());
		getTextField_14().setEditable(false);
		getTextField_14().setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(17)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
										.addComponent(label_5)
										.addComponent(RoadStar))
									.addComponent(Phonenum)
									.addComponent(Customername)))
							.addComponent(label_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(rdbtnYes)
											.addGap(18)
											.addComponent(rdbtnNo))
										.addComponent(label_2)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblAdditionEquipement, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(17)
													.addComponent(lblPickupdate)
													.addGap(18)
													.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
											.addGap(88))
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(17)
											.addComponent(label_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_1, Alignment.LEADING)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addGap(4)))
					.addGap(53))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
						.addComponent(Customername)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Phonenum)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
						.addComponent(rdbtnYes)
						.addComponent(rdbtnNo)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(RoadStar)
						.addComponent(lblAdditionEquipement))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPickupdate))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(164))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		
		textArea_1 = new JTextArea();
		
		JLabel lblNewLabel = new JLabel("OverDue Cost");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		JLabel lblDamgeCost = new JLabel("Damge Cost");
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		
		setTextField_15(new JTextField());
		getTextField_15().setColumns(10);
		
		btnCalculateTotalCost = new JButton("Calculate Total Cost");
		
		JLabel lblRedeemPoints = new JLabel("Redeem Points");
		
		textField_17 = new JTextField();
		textField_17.setText("0");
		textField_17.setColumns(10);
		
		
		
		setTextField_18(new JTextField());
		getTextField_18().setColumns(10);
		
		btnGoBackToHome = new JButton("GoBack to Home");
		
		btnCheckDetails = new JButton("Check Details");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		
		setTextField_19(new JTextField());
		getTextField_19().setColumns(10);
		
		setTextField_20(new JTextField());
		getTextField_20().setColumns(10);
		
		setTextField_11(new JTextField());
		getTextField_11().setColumns(10);
		
		
		
		btnProceedToPayment = new JButton("Proceed To Payment");
		btnProceedToPayment.setBackground(Color.GRAY);
		
		btnAddPoints = new JButton("Add Points");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterCurrentDetails)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRentalAgreementNumber)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCheckDetails))
						.addComponent(lblFuelPercentage)
						.addComponent(lblDamgeCost)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblOdometerReading)
											.addComponent(lblNewLabel))
										.addGap(21))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblTotalCost)
											.addComponent(btnIncCost))
										.addGap(18)))
								.addComponent(lblVehicleDescription))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textField_10, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(textField_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(27)
												.addComponent(btnCost_1)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addComponent(btnCost)
												.addGap(18)
												.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
									.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
									.addComponent(textField_13)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textArea_1)
										.addGap(4)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCalculateTotalCost)
										.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCostAfterRedeeming)
								.addComponent(lblRedeemPoints)
								.addComponent(btnTaxCost)
								.addComponent(btnProceedToPayment))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(btnRedeem))
								.addComponent(btnAddPoints))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(btnGoBackToHome))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRentalAgreementNumber)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheckDetails))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEnterCurrentDetails)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOdometerReading)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCost)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFuelPercentage)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCost_1)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVehicleDescription)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDamgeCost)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIncCost))
							.addGap(18)
							.addComponent(btnCalculateTotalCost)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalCost)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTaxCost))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRedeem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRedeemPoints))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCostAfterRedeeming))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnProceedToPayment)
										.addComponent(btnAddPoints))))))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(486, Short.MAX_VALUE)
					.addComponent(btnGoBackToHome)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
	
	public void goBackHomeAddActionListener(ClerkController clerk)
	{
		btnGoBackToHome.addActionListener(clerk);
	}
	
	public void rdbtnActionListener(ClerkController clerk)
	{
		rdbtnYes.addActionListener(clerk);
		rdbtnNo.addActionListener(clerk);
	}
	
	public void addPointsActionListener(ClerkController clerk)
	{
		btnAddPoints.addActionListener(clerk);
	}
	
	public void paymentActionListener(ClerkController clerk)
	{
		btnProceedToPayment.addActionListener(clerk);
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
		textField_5.setEditable(false);
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
		textField_6.setEditable(false);
	}

	public JTextField getTextField_7() {
		return textField_7;
	}

	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
		textField_7.setEditable(false);
	}
	
	public void checkDetailsActionListener(ClerkController clerk)
	{
		btnCheckDetails.addActionListener(clerk);
	}
	
	public void odometerActionListener(ClerkController clerk)
	{
		btnCost.addActionListener(clerk);
	}
	
	public void fuelPercentageActionListener(ClerkController clerk)
	{
		btnCost_1.addActionListener(clerk);
	}

	public void insuranceActionListener(ClerkController clerk)
	{
		btnIncCost.addActionListener(clerk);
	}
	
	public void taxActionListener(ClerkController clerk)
	{
		btnTaxCost.addActionListener(clerk);
	}
	
	public void calculateTotalCostActionListener(ClerkController clerk)
	{
		btnCalculateTotalCost.addActionListener(clerk);
	}
	
	public void redeemAdctionListener(ClerkController clerk)
	{
		btnRedeem.addActionListener(clerk);
	}
	
	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
		textField_3.setEditable(false);
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
		textField_4.setEditable(false);
	}

	public JTextField getTextField_10() {
		return textField_10;
	}

	public void setTextField_10(JTextField textField_10) {
		this.textField_10 = textField_10;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
		textField_1.setEditable(false);
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
		textField_2.setEditable(false);
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

	public void setTextField_16(JTextField textField_16) {
	}

	public JTextField getTextField_19() {
		return textField_19;
	}

	public void setTextField_19(JTextField textField_19) {
		this.textField_19 = textField_19;
	}

	public JTextField getTextField_20() {
		return textField_20;
	}

	public void setTextField_20(JTextField textField_20) {
		this.textField_20 = textField_20;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
	}

	public JTextField getTextField_15() {
		return textField_15;
	}

	public void setTextField_15(JTextField textField_15) {
		this.textField_15 = textField_15;
	}

	public JTextField getTextField_14() {
		return textField_14;
	}

	public void setTextField_14(JTextField textField_14) {
		this.textField_14 = textField_14;
	}

	public JTextField getTextField_18() {
		return textField_18;
	}

	public void setTextField_18(JTextField textField_18) {
		this.textField_18 = textField_18;
	}
}
