package org.superrent.views.superadmin;

import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.superrent.controllers.SystemAdminController;

public class SearchVehiclePanel extends JPanel {
	private SystemAdminController sac;
	private JTextField textFieldVehicleType;
	private JTextField textFieldvehicleCategory;

	/**
	 * Create the panel.
	 */
	public SearchVehiclePanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("60px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblVehicle = new JLabel("Vehicle Type");
		add(lblVehicle, "2, 4, left, default");
		
		textFieldVehicleType = new JTextField();
		add(textFieldVehicleType, "4, 4, left, default");
		textFieldVehicleType.setColumns(10);
		
		JLabel lblVehicleCate = new JLabel("Vehicle Category");
		add(lblVehicleCate, "2, 6, left, default");
		
		textFieldvehicleCategory = new JTextField();
		textFieldvehicleCategory.setColumns(10);
		add(textFieldvehicleCategory, "4, 6, left, default");
		
		JButton btnConfirmVehicle = new JButton("Confirm");
		btnConfirmVehicle.setActionCommand("ConfirmVehicle");
		btnConfirmVehicle.addActionListener(sac);
		add(btnConfirmVehicle, "4, 8, left, default");
	}
	

}
