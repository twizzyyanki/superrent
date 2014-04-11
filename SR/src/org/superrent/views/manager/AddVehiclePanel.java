package org.superrent.views.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AddVehiclePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField regNumberTxt = new JTextField();
	private JTextField brandTxt = new JTextField();
	JLabel lblAddVehicle = new JLabel("Add Vehicle");
	JLabel lblRegisternumber = new JLabel("RegisterNumber");
	JComboBox<String> categoryCombox = new JComboBox<String>();
	JComboBox<String> typeCombox = new JComboBox<String>();
	ManagerController managerController;
	
	JButton btnAddVehicle = new JButton("Add Vehicle");

	/**
	 * Create the panel.
	 */
	public AddVehiclePanel(ManagerController managerController) {
		this.managerController = managerController;
		setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("default:grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		add(lblAddVehicle, "14, 8");
		
		
		add(lblRegisternumber, "10, 12, right, default");
		
		
		add(regNumberTxt, "14, 12, left, center");
		regNumberTxt.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "10, 14");
		
		
		categoryCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT", "Car", "Truck"}));
		add(categoryCombox, "14, 14, left, default");
		
		//  prevent action events from being fired when the up/down arrow keys are used
		categoryCombox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		categoryCombox.addActionListener( this );

		
		JLabel lblType = new JLabel("Type");
		add(lblType, "10, 16");
		
		
		add(typeCombox, "14, 16, left, default");
		typeCombox.setEnabled(false);
		
		JLabel lblBrand = new JLabel("Brand");
		add(lblBrand, "10, 18");
		
		
		add(brandTxt, "14, 18, left, default");
		brandTxt.setColumns(10);
		
		
		add(btnAddVehicle, "12, 22");
		btnAddVehicle.addActionListener(managerController);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item = (String)categoryCombox.getSelectedItem();
		if(item.equalsIgnoreCase("CAR")){
			typeCombox.setEnabled(true);
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT","ECONOMY","COMPACT","MID-SIZE",
					  												   "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
					  												   "VAN"}));
		}
		else if(item.equalsIgnoreCase("TRUCK")){
			typeCombox.setEnabled(true);
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT","24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
					   "CARGO VAN"}));
		}
		
	}

	
	public String getRegNumberTxt() {
		return regNumberTxt.getText();
	}

	public String getBrandTxt() {
		return brandTxt.getText();
	}

	public void setBrandTxt(JTextField brandTxt) {
		this.brandTxt = brandTxt;
	}

	public void setRegNumberTxt(JTextField regNumberTxt) {
		this.regNumberTxt = regNumberTxt;
	}
	
	public JComboBox<String> getCategoryCombox() {
		return categoryCombox;
	}

	public void setCategoryCombox(JComboBox<String> categoryCombox) {
		this.categoryCombox = categoryCombox;
	}

	public JComboBox<String> getTypeCombox() {
		return typeCombox;
	}

	public void setTypeCombox(JComboBox<String> typeCombox) {
		this.typeCombox = typeCombox;
	}



}
