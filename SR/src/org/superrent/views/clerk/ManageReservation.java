package org.superrent.views.clerk;

import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

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
	public JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("yyy/MM/dd"));
	public JTextField textField_2;
	private JLabel lblConfirmationno;
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
				RowSpec.decode("max(27dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(41dlu;default):grow"),}));
		
		lblConfirmationno = new JLabel("ConfirmationNo");
		add(lblConfirmationno, "6, 4, right, default");
		
		setTextField_2(new JTextField());
		add(getTextField_2(), "8, 4, fill, default");
		getTextField_2().setColumns(10);
		
		JLabel lblChangeDropDate = new JLabel("Change Drop Date");
		add(lblChangeDropDate, "10, 4, center, default");
		
		dateField.setValue(new java.util.Date());
		add(dateField,"12, 4, fill, default");
		
		btnUpdate = new JButton("Update");
		add(btnUpdate, "14, 4, center, default");
		
		JLabel lblConfirmationNo = new JLabel("Confirmation No");
		add(lblConfirmationNo, "6, 6, center, default");
		
		setTextField_1(new JTextField());
		add(getTextField_1(), "8, 6, fill, default");
		getTextField_1().setColumns(10);
		
		
		add(btnCancelReservation, "10, 6, center, default");
		
		
		
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
}
