package org.superrent.views.clerk;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.superrent.controllers.ClerkController;

public class ManageReservation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField textField_1;
	JButton btnCancelReservation = new JButton("Cancel Reservation");
	JButton btnUpdate;
	public JTextField textField_2;
	private JLabel lblConfirmationno;
	public JDateChooser calendar = new JDateChooser();
	
	/**
	 * Create the panel.
	 */
	public ManageReservation() 
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),
				ColumnSpec.decode("max(52dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(77dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(42dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(118dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(38dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(53dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(26dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblConfirmationno = new JLabel("ConfirmationNo");
		add(lblConfirmationno, "6, 4, right, default");
		
		setTextField_2(new JTextField());
		add(getTextField_2(), "8, 4, fill, default");
		getTextField_2().setColumns(10);
		
		JLabel lblChangeDropDate = new JLabel("Change Drop Date");
		add(lblChangeDropDate, "6, 6, center, default");
		
		add(calendar,"8, 6, fill, default");
		
		btnUpdate = new JButton("Extend");
		add(btnUpdate, "10, 6, center, default");
		
		JLabel lblConfirmationNo = new JLabel("Confirmation No");
		add(lblConfirmationNo, "6, 8, center, default");
		
		setTextField_1(new JTextField());
		add(getTextField_1(), "8, 8, fill, default");
		getTextField_1().setColumns(10);
		
		
		add(btnCancelReservation, "10, 8, center, default");
		
		
	}
	
	public void cancelReservActionListener(ClerkController clerk)
	{
		btnCancelReservation.addActionListener(clerk);
	}
	
	public void changeDropdateActionListener(ClerkController clerk)
	{
		btnUpdate.addActionListener(clerk);
	}
	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public void setTextField(JTextField textField) {
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	
	public JDateChooser getCalendar1() 
	{
		return calendar;
	}
	
}
