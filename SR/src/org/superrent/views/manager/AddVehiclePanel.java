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
import com.toedter.calendar.JCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	JButton btnAdd = new JButton("Add");
	
	private final JLabel lblPurchaseDate = new JLabel("Purchase Date");
	private JCalendar calendar = new JCalendar();

	public JCalendar getCalendar() {
		return calendar;
	}

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
				ColumnSpec.decode("max(101dlu;default)"),},
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
		
		
		add(lblAddVehicle, "12, 2");
		
		
		add(lblRegisternumber, "10, 6, right, default");
		
		
		add(regNumberTxt, "14, 6, left, center");
		regNumberTxt.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "10, 8");
		
		
		categoryCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT", "Car", "Truck"}));
		add(categoryCombox, "14, 8, left, default");
		
		//  prevent action events from being fired when the up/down arrow keys are used
		categoryCombox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		categoryCombox.addActionListener( this );
		
				
				JLabel lblType = new JLabel("Type");
				add(lblType, "10, 10");
		
		
		add(typeCombox, "14, 10, left, default");
		typeCombox.setEnabled(false);
		
		JLabel lblBrand = new JLabel("Brand");
		add(lblBrand, "10, 12");
		
		
		add(brandTxt, "14, 12, left, default");
		brandTxt.setColumns(10);
		
		add(lblPurchaseDate, "10, 14");
		calendar.setLocale(Locale.US);
		
		add(calendar, "14, 14, fill, fill");
		
		
		add(btnAdd, "12, 16");
		btnAdd.addActionListener(managerController);

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

	public void clearVehicleScreen(){
		
		regNumberTxt.setText("");
		brandTxt.setText("");		
		categoryCombox.setSelectedIndex(0);
		typeCombox.setSelectedIndex(0);
		calendar = new JCalendar();
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
