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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

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
	
	JButton btnRedeem = new JButton("Show Points");
	
	JLabel lblCostAfterRedeeming = new JLabel("Cost After Redeeming");
	
	JButton btnCalculateTotalCost = new JButton("Calculate Total Cost");
	
	JButton btnPayWithPoints;
	
	JButton btnProceedToPayment;
	
	private JLabel lblAdditionEquipement;
	
	private JTextField textField_14;
	public JTextArea textArea_1;
	public JTextArea textArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	/**
	 * Create the panel.
	 */
	public Return()
	{
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel Customername = new JLabel("CustomerName");
		
		setTextField_1(new JTextField());
		getTextField_1().setColumns(10);
		
		ButtonGroup bG=new ButtonGroup();
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		
		setTextField_15(new JTextField());
		getTextField_15().setColumns(10);
		
		btnCalculateTotalCost = new JButton("Calculate Total Cost");
		
		btnCheckDetails = new JButton("Check Details");
		
		setTextField_20(new JTextField());
		getTextField_20().setColumns(10);
		
		setTextField_11(new JTextField());
		getTextField_11().setColumns(10);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("98px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("106px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("106px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("163px"),
				ColumnSpec.decode("max(31dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("59px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(76dlu;default)"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("23px"),
				RowSpec.decode("29px"),
				RowSpec.decode("37px"),
				RowSpec.decode("19px"),}));
		
		JLabel Phonenum = new JLabel("Phone Number");
		panel.add(Phonenum, "6, 2, left, center");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		panel.add(textField_2, "8, 2, fill, center");
		
		JLabel RoadStar = new JLabel("Roadstar");
		panel.add(RoadStar, "11, 2, left, center");
		
		rdbtnYes = new JRadioButton("Yes");
		bG.add(rdbtnYes);
		panel.add(rdbtnYes, "13, 2, left, top");
		
		rdbtnNo = new JRadioButton("No");
		bG.add(rdbtnNo);
		panel.add(rdbtnNo, "15, 2, left, top");
		
		lblAdditionEquipement = new JLabel("Addition Equipement");
		panel.add(lblAdditionEquipement, "2, 3, left, center");
		
		setTextField_14(new JTextField());
		getTextField_14().setEditable(false);
		getTextField_14().setColumns(10);
		panel.add(textField_14, "4, 3, fill, center");
		
		JLabel label_5 = new JLabel("DropDate");
		panel.add(label_5, "6, 3, left, center");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		panel.add(textField_4, "8, 3, fill, center");
		
		JLabel lblPickupdate = new JLabel("PickUpdate");
		panel.add(lblPickupdate, "11, 3, right, center");
		
		setTextField_3(new JTextField());
		getTextField_3().setColumns(10);
		panel.add(textField_3, "13, 3, 3, 1, fill, center");
		
		JLabel label_4 = new JLabel("Odometer Reading");
		panel.add(label_4, "2, 4, right, center");
		
		setTextField_5(new JTextField());
		getTextField_5().setColumns(10);
		panel.add(textField_5, "4, 4, fill, center");
		
		JLabel label_7 = new JLabel("Fuel Percentage");
		panel.add(label_7, "6, 4, left, center");
		
		setTextField_6(new JTextField());
		getTextField_6().setColumns(10);
		panel.add(textField_6, "8, 4, fill, center");
		
		JLabel label_2 = new JLabel("Charges");
		panel.add(label_2, "11, 4, left, center");
		
		setTextField_7(new JTextField());
		getTextField_7().setColumns(10);
		panel.add(textField_7, "13, 4, 3, 1, default, center");
		panel.add(Customername, "2, 2, right, center");
		panel.add(textField_1, "4, 2, fill, center");
		
		JLabel label_3 = new JLabel("Vehicle Description");
		panel.add(label_3, "2, 5, right, top");
		
		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "4, 5, 3, 1, fill, fill");
		
		textArea = new JTextArea(2,30);
		scrollPane_1.setViewportView(textArea);
		textArea.setRows(2);
		textArea.setColumns(30);
		
			textArea.setLineWrap(true);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("101px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("69px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("109px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("12px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("64px"),
				ColumnSpec.decode("43px"),
				ColumnSpec.decode("13px"),
				ColumnSpec.decode("79px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("103px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("12px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("101px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("79px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("161px"),
				RowSpec.decode("32px"),
				RowSpec.decode("32px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("36px"),
				RowSpec.decode("13px"),
				RowSpec.decode("27px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				RowSpec.decode("9px"),
				RowSpec.decode("23px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("31px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				RowSpec.decode("25px"),
				RowSpec.decode("38px"),}));
		
		JLabel lblRentalAgreementNumber = new JLabel("Rental Agreement Number");
		add(lblRentalAgreementNumber, "4, 2, 3, 1, left, center");
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		add(textField, "8, 2, 5, 1, fill, center");
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		add(lblEnterCurrentDetails, "2, 5, left, center");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		add(lblOdometerReading, "2, 6, left, center");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		add(textField_9, "4, 6, fill, center");
		add(btnCost, "6, 6, 3, 1, fill, center");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		add(textField_8, "10, 6, 3, 1, left, center");
		
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		add(lblFuelPercentage, "2, 8, left, center");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		add(textField_10, "4, 8, right, center");
		add(btnCost_1, "6, 8, 3, 1, fill, center");
		
		setTextField_19(new JTextField());
		getTextField_19().setColumns(10);
		add(textField_19, "10, 8, 3, 1, left, center");
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		add(lblVehicleDescription, "2, 10, left, center");
		
		textArea_1 = new JTextArea(2,30);
		textArea_1.setLineWrap(true);
		
		scrollPane = new JScrollPane(textArea_1);
		scrollPane.setViewportView(textArea_1);
		add(scrollPane, "4, 10, 3, 1, fill, fill");
		
		JLabel lblDamgeCost = new JLabel("Damge Cost");
		add(lblDamgeCost, "2, 12, left, center");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		add(textField_12, "4, 12, right, center");
		
		JLabel lblNewLabel = new JLabel("OverDue Cost");
		add(lblNewLabel, "2, 14, left, center");
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		add(textField_13, "4, 14, right, center");
		add(btnCalculateTotalCost, "2, 18, 3, 1, left, bottom");
		
		JLabel lblRedeemPoints = new JLabel("Club Points");
		add(lblRedeemPoints, "12, 18, 2, 1, left, top");
		
		textField_17 = new JTextField();
		textField_17.setText("0");
		textField_17.setColumns(10);
		add(textField_17, "15, 18, center, center");
		add(btnRedeem, "17, 18, fill, top");
		add(lblTotalCost, "2, 20, left, center");
		add(textField_15, "4, 20, 3, 1, left, bottom");
		add(lblCostAfterRedeeming, "12, 20, 2, 1, left, center");
		
		
		
		setTextField_18(new JTextField());
		getTextField_18().setColumns(10);
		add(textField_18, "15, 20, left, top");
		
		btnPayWithPoints = new JButton("Pay With points");
		add(btnPayWithPoints, "17, 20, 3, 1, left, top");
		add(textField_11, "4, 22, 3, 1, left, top");
		add(btnCheckDetails, "15, 2, 3, 1, left, top");
		add(panel, "2, 4, 22, 1, fill, top");
		add(btnTaxCost, "2, 22, left, top");
		add(btnIncCost, "2, 16, left, top");
		add(textField_20, "4, 16, left, center");
		
		
		
		btnProceedToPayment = new JButton("Proceed To PayPal");
		btnProceedToPayment.setBackground(Color.GRAY);
		add(btnProceedToPayment, "15, 22, 3, 1, left, center");
		
	}

	public void rdbtnActionListener(ClerkController clerk)
	{
		rdbtnYes.addActionListener(clerk);
		rdbtnNo.addActionListener(clerk);
	}
	
	public void addPointsActionListener(ClerkController clerk)
	{
		btnPayWithPoints.addActionListener(clerk);
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
		textField_18.setText("0");
	}
}
