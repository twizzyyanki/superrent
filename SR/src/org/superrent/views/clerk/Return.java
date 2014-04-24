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
	public JTextArea textArea;
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
		
		JLabel RoadStar = new JLabel("Roadstar");
		
		rdbtnYes = new JRadioButton("Yes");
		
		rdbtnNo = new JRadioButton("No");
		
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
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		
		textArea = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAdditionEquipement)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Customername)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(237)
									.addComponent(Phonenum)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(RoadStar)
							.addGap(30)
							.addComponent(rdbtnYes)
							.addGap(18)
							.addComponent(rdbtnNo))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPickupdate)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(textArea, Alignment.LEADING)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_7)
											.addGap(18)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(162)))))
					.addGap(274))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAdditionEquipement)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPickupdate)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Phonenum)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(RoadStar)
								.addComponent(rdbtnYes)
								.addComponent(rdbtnNo)
								.addComponent(Customername))))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
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
		
		
		
		btnProceedToPayment = new JButton("Proceed To PayPal");
		btnProceedToPayment.setBackground(Color.GRAY);
		
		btnAddPoints = new JButton("Add Points");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblOdometerReading)
													.addGap(18)
													.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btnCost))
												.addComponent(btnCalculateTotalCost)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblTotalCost)
													.addGap(58)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(71)
													.addComponent(lblFuelPercentage))
												.addComponent(lblRedeemPoints)
												.addComponent(lblCostAfterRedeeming)))
										.addComponent(lblDamgeCost))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnProceedToPayment)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnGoBackToHome))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(17)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
													.addGap(32)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnAddPoints)
														.addComponent(btnRedeem)))
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textField_12)
														.addComponent(textField_10)
														.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnCost_1)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addGap(46))
								.addComponent(lblEnterCurrentDetails))
							.addGap(48))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(192)
							.addComponent(lblRentalAgreementNumber)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCheckDetails))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 851, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnTaxCost))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVehicleDescription)
								.addComponent(btnIncCost))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRentalAgreementNumber)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheckDetails))
							.addGap(266)
							.addComponent(lblEnterCurrentDetails)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOdometerReading)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCost)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFuelPercentage)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCost_1)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVehicleDescription)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDamgeCost)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRedeemPoints)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRedeem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCostAfterRedeeming)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddPoints)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIncCost))
							.addGap(18)
							.addComponent(btnCalculateTotalCost)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalCost))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnProceedToPayment)
								.addComponent(btnGoBackToHome)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTaxCost)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
