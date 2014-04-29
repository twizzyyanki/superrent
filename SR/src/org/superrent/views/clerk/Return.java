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
import javax.swing.JComboBox;
import java.awt.Font;

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
	
	JLabel lblCostAfterRedeeming = new JLabel("Cost After Redeeming");
	
	JButton btnCalculateTotalCost = new JButton("Calculate Total Cost");
	
	JButton btnProceedToPayment;
	
	private JLabel lblAdditionEquipement;
	
	private JTextField textField_14;
	public JTextArea textArea_1;
	public JTextArea textArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnPayByCash;
	private JLabel lblCad;
	private JLabel lblCad_1;
	private JLabel lblCad_2;
	private JLabel lblCad_4;
	private JLabel lblCad_3;
	private JLabel lblCad_5;
	private JLabel lblCad_6;
	private JLabel lblCAD;
	private JLabel lblCad_7;
	private JScrollPane scrollPane_2;
	private JButton btnShowPoints;
	private JButton btnPayWithPoints;
	private JPanel panel_1;
	private JScrollPane scrollPane_3;
	/**
	 * Create the panel.
	 */
	public Return()
	{
		
		ButtonGroup bG=new ButtonGroup();
		
		JLabel lblRentalAgreementNumber = new JLabel("Rental Agreement Number");
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		btnCheckDetails = new JButton("Check Details");
		
		scrollPane_2 = new JScrollPane();
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(169, 169, 169));
		
		JLabel Customername = new JLabel("CustomerName");
		
		setTextField_1(new JTextField());
		getTextField_1().setColumns(10);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("81px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("48px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("68px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(13dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(10dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel Phonenum = new JLabel("Phone Number");
		panel.add(Phonenum, "8, 2, 7, 1, right, center");
		
		setTextField_2(new JTextField());
		getTextField_2().setColumns(10);
		panel.add(textField_2, "15, 2, 11, 1, fill, fill");
		
		JLabel RoadStar = new JLabel("Roadstar");
		panel.add(RoadStar, "2, 3, right, center");
		
		rdbtnYes = new JRadioButton("Yes");
		bG.add(rdbtnYes);
		panel.add(rdbtnYes, "4, 3, left, top");
		
		rdbtnNo = new JRadioButton("No");
		bG.add(rdbtnNo);
		panel.add(rdbtnNo, "6, 3, left, top");
		
		JLabel lblPickupdate = new JLabel("PickUpdate");
		panel.add(lblPickupdate, "2, 4, right, center");
		
		setTextField_4(new JTextField());
		getTextField_4().setColumns(10);
		panel.add(textField_4, "4, 4, 3, 1, fill, center");
		
		JLabel label_5 = new JLabel("DropDate");
		panel.add(label_5, "9, 4, 5, 1, right, center");
		panel.add(Customername, "2, 2, right, center");
		panel.add(textField_1, "4, 2, 3, 1, fill, fill");
			
			setTextField_3(new JTextField());
			getTextField_3().setColumns(10);
			panel.add(textField_3, "15, 4, 11, 1, fill, fill");
			
			JLabel label_2 = new JLabel("Charges");
			panel.add(label_2, "2, 5, right, center");
			
			setTextField_7(new JTextField());
			getTextField_7().setColumns(10);
			panel.add(textField_7, "4, 5, 3, 1, default, center");
			
			lblCad = new JLabel("CAD");
			panel.add(lblCad, "8, 5");
			
			JLabel label_4 = new JLabel("Odometer Reading");
			panel.add(label_4, "9, 5, 6, 1, right, center");
			
			setTextField_5(new JTextField());
			getTextField_5().setColumns(10);
			panel.add(textField_5, "15, 5, 11, 1, fill, center");
			
			lblAdditionEquipement = new JLabel("Addition Equipement");
			panel.add(lblAdditionEquipement, "2, 6, left, center");
			
			setTextField_14(new JTextField());
			getTextField_14().setEditable(false);
			getTextField_14().setColumns(10);
			panel.add(textField_14, "4, 6, 3, 1, fill, center");
			
			JLabel label_7 = new JLabel("Fuel Percentage");
			panel.add(label_7, "9, 6, 5, 1, right, center");
			
			setTextField_6(new JTextField());
			getTextField_6().setColumns(10);
			panel.add(textField_6, "15, 6, 11, 1, fill, fill");
			
			JLabel label_3 = new JLabel("Vehicle Description");
			panel.add(label_3, "2, 8, right, top");
			
			scrollPane_1 = new JScrollPane();
			panel.add(scrollPane_1, "4, 8, 3, 1");
			
			textArea = new JTextArea(2,30);
			scrollPane_1.setViewportView(textArea);
			textArea.setRows(2);
			textArea.setColumns(30);
			
				textArea.setLineWrap(true);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("276px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("128px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("150px"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		add(lblRentalAgreementNumber, "4, 2, right, center");
		add(textField, "6, 2, fill, fill");
		add(btnCheckDetails, "8, 2, left, fill");
		add(scrollPane_2, "4, 4, 19, 1, fill, fill");
		
		scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "4, 6, 19, 2, fill, fill");
		
		panel_1 = new JPanel();
		scrollPane_3.setViewportView(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default)"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblEnterCurrentDetails = new JLabel("Enter Current Details");
		lblEnterCurrentDetails.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel_1.add(lblEnterCurrentDetails, "2, 2");
		
		JLabel lblOdometerReading = new JLabel("Odometer Reading");
		panel_1.add(lblOdometerReading, "2, 4");
		
		setTextField_9(new JTextField());
		getTextField_9().setColumns(10);
		panel_1.add(btnCost, "6, 4");
		
		setTextField_8(new JTextField());
		getTextField_8().setColumns(10);
		
		lblCad_1 = new JLabel("CAD");
		panel_1.add(lblCad_1, "10, 4");
		
		JLabel lblFuelPercentage = new JLabel("Fuel Percentage");
		panel_1.add(lblFuelPercentage, "2, 6");
		
		setTextField_10(new JTextField());
		getTextField_10().setColumns(10);
		panel_1.add(btnCost_1, "6, 6");
		
		setTextField_19(new JTextField());
		getTextField_19().setColumns(10);
		
		lblCad_2 = new JLabel("CAD");
		panel_1.add(lblCad_2, "10, 6");
		
		JLabel lblVehicleDescription = new JLabel("Vehicle Description");
		panel_1.add(lblVehicleDescription, "2, 8");
		
		textArea_1 = new JTextArea(2,30);
		textArea_1.setLineWrap(true);
		
		scrollPane = new JScrollPane(textArea_1);
		panel_1.add(scrollPane, "4, 8, 3, 1");
		scrollPane.setViewportView(textArea_1);
		
		JLabel lblDamgeCost = new JLabel("Damge Cost");
		panel_1.add(lblDamgeCost, "2, 10");
		
		textField_12 = new JTextField();
		panel_1.add(textField_12, "4, 10");
		textField_12.setColumns(10);
		
		lblCad_3 = new JLabel("CAD");
		panel_1.add(lblCad_3, "6, 10");
		
		JLabel lblNewLabel = new JLabel("OverDue Cost");
		panel_1.add(lblNewLabel, "2, 12");
		
		textField_13 = new JTextField();
		panel_1.add(textField_13, "4, 12");
		textField_13.setColumns(10);
		
		lblCad_5 = new JLabel("CAD");
		panel_1.add(lblCad_5, "6, 12");
		panel_1.add(btnIncCost, "2, 14");
		
		setTextField_20(new JTextField());
		getTextField_20().setColumns(10);
		
		lblCad_6 = new JLabel("CAD");
		panel_1.add(lblCad_6, "6, 14");
		
		btnCalculateTotalCost = new JButton("Calculate Total Cost");
		panel_1.add(btnCalculateTotalCost, "2, 18");
		
		setTextField_15(new JTextField());
		getTextField_15().setColumns(10);
		
		lblCAD = new JLabel("CAD");
		panel_1.add(lblCAD, "6, 20");
		panel_1.add(btnTaxCost, "2, 22");
		
		setTextField_11(new JTextField());
		getTextField_11().setColumns(10);
		
		lblCad_7 = new JLabel("CAD");
		panel_1.add(lblCad_7, "6, 22");
		
		btnShowPoints = new JButton("Show Points");
		panel_1.add(btnShowPoints, "2, 24");
		
		JLabel lblRedeemPoints = new JLabel("Club Points");
		panel_1.add(lblRedeemPoints, "4, 24");
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		panel_1.add(lblTotalCost, "2, 20");
		
		textField_17 = new JTextField();
		panel_1.add(textField_17, "6, 24");
		textField_17.setText("0");
		textField_17.setColumns(10);
		
		btnPayWithPoints = new JButton("Pay With Points");
		panel_1.add(btnPayWithPoints, "2, 26");
		panel_1.add(lblCostAfterRedeeming, "4, 26");
		
		
		
		setTextField_18(new JTextField());
		getTextField_18().setColumns(10);
		
		lblCad_4 = new JLabel("CAD");
		panel_1.add(lblCad_4, "8, 26");
		
		btnPayByCash = new JButton("Pay By Cash");
		panel_1.add(btnPayByCash, "4, 28");
		btnPayByCash.setBackground(Color.GRAY);
		
		
		
		btnProceedToPayment = new JButton("Pay By PayPal");
		panel_1.add(btnProceedToPayment, "6, 28");
		btnProceedToPayment.setBackground(Color.GRAY);
		
	}
	
	public void payByCashAddActionListener(ClerkController clerk)
	{
		btnPayByCash.addActionListener(clerk);
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
		btnShowPoints.addActionListener(clerk);
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
		panel_1.add(textField_10, "4, 6");
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
		panel_1.add(textField_8, "8, 4");
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
		panel_1.add(textField_9, "4, 4");
	}

	public void setTextField_16(JTextField textField_16) {
	}

	public JTextField getTextField_19() {
		return textField_19;
	}

	public void setTextField_19(JTextField textField_19) {
		this.textField_19 = textField_19;
		panel_1.add(textField_19, "8, 6");
	}

	public JTextField getTextField_20() {
		return textField_20;
	}

	public void setTextField_20(JTextField textField_20) {
		this.textField_20 = textField_20;
		panel_1.add(textField_20, "4, 14");
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
		panel_1.add(textField_11, "4, 22");
	}

	public JTextField getTextField_15() {
		return textField_15;
	}

	public void setTextField_15(JTextField textField_15) {
		this.textField_15 = textField_15;
		panel_1.add(textField_15, "4, 20");
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
		panel_1.add(textField_18, "6, 26");
		textField_18.setText("0");
	}
}
