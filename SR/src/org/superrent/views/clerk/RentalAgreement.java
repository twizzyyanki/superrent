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

public class RentalAgreement extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	public JButton btnGobackToHome;

	/**
	 * Create the panel.
	 */
	public RentalAgreement()
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(28dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(83dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(92dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(55dlu;default):grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblRentalAgreementNumber = new JLabel("RENTAL AGREEMENT NUMBER");
		add(lblRentalAgreementNumber, "4, 8, center, default");
		
		setTextField(new JTextField());
		add(getTextField(), "6, 8, fill, default");
		getTextField().setColumns(10);
		
		JLabel lblVehcileType = new JLabel("VEHCILE TYPE");
		add(lblVehcileType, "4, 10, center, default");
		
		setTextField_1(new JTextField());
		add(getTextField_1(), "6, 10, fill, default");
		getTextField_1().setColumns(10);
		
		JLabel lblVehicleCategory = new JLabel("VEHICLE CATEGORY");
		add(lblVehicleCategory, "4, 12, center, default");
		
		setTextField_2(new JTextField());
		add(getTextField_2(), "6, 12, fill, default");
		getTextField_2().setColumns(10);
		
		JLabel lblVehcileRegisteredNumber = new JLabel("VEHCILE REGISTERED NUMBER");
		add(lblVehcileRegisteredNumber, "4, 14, right, default");
		
		setTextField_3(new JTextField());
		add(getTextField_3(), "6, 14, fill, default");
		getTextField_3().setColumns(10);
		
		JLabel lblAdditionalEquipment = new JLabel("ADDITIONAL EQUIPMENT");
		add(lblAdditionalEquipment, "4, 16, right, default");
		
		setTextField_4(new JTextField());
		add(getTextField_4(), "6, 16, fill, default");
		getTextField_4().setColumns(10);
		
		JLabel lblTotalCost = new JLabel("TOTAL COST");
		add(lblTotalCost, "4, 18, center, default");
		
		setTextField_5(new JTextField());
		add(getTextField_5(), "6, 18, fill, default");
		getTextField_5().setColumns(10);
		
		JLabel lblCustomerName = new JLabel("CUSTOMER NAME");
		add(lblCustomerName, "4, 20, center, default");
		
		setTextField_6(new JTextField());
		add(getTextField_6(), "6, 20, fill, default");
		getTextField_6().setColumns(10);
		
		JLabel lblCustomerUserId = new JLabel("CUSTOMER USER ID");
		add(lblCustomerUserId, "4, 22, center, default");
		
		setTextField_7(new JTextField());
		add(getTextField_7(), "6, 22, fill, default");
		getTextField_7().setColumns(10);
		
		JLabel lblCustomerContactNumber = new JLabel("CUSTOMER CONTACT NUMBER");
		add(lblCustomerContactNumber, "4, 24, right, default");
		
		setTextField_8(new JTextField());
		add(getTextField_8(), "6, 24, fill, default");
		getTextField_8().setColumns(10);
		
		JLabel lblPickUpDate = new JLabel("Pick Up Date");
		add(lblPickUpDate, "4, 26, center, default");
		
		setTextField_9(new JTextField());
		add(getTextField_9(), "6, 26, fill, default");
		getTextField_9().setColumns(10);
		
		JLabel lblDropDate = new JLabel("Drop Date");
		add(lblDropDate, "4, 28, center, default");
		
		setTextField_10(new JTextField());
		add(getTextField_10(), "6, 28, fill, default");
		getTextField_10().setColumns(10);
		
		btnGobackToHome = new JButton("GoBack to Home");
		add(btnGobackToHome, "6, 34, center, default");
		
	}

	public void GoBackHomeActionListener(ClerkController clerk)
	{
		btnGobackToHome.addActionListener(clerk);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
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
}
