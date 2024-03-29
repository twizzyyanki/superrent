package org.superrent.views.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JCalendar;

import java.awt.Component;

import com.toedter.calendar.JDateChooser;

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
	JButton btnAdd = new JButton("Save");
	private ValidationGroup group;
	private ValidationPanel xpanel;


	private final JLabel lblPurchaseDate = new JLabel("Purchase Date");
	private JDateChooser calendar = new JDateChooser();

	public JDateChooser getCalendar() {
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
				ColumnSpec.decode("max(76dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				RowSpec.decode("max(14dlu;default)"),
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
		regNumberTxt.getDocument().addDocumentListener(managerController);
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "10, 8");
		
		
		categoryCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"Car", "Truck"}));
		add(categoryCombox, "14, 8, left, default");
		
		//  prevent action events from being fired when the up/down arrow keys are used
		categoryCombox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		categoryCombox.addActionListener( this );
		
				
				JLabel lblType = new JLabel("Type");
				add(lblType, "10, 10");
		
		
		add(typeCombox, "14, 10, left, default");
		typeCombox.setEnabled(true);
		
		
		JLabel lblBrand = new JLabel("Brand");
		add(lblBrand, "10, 12");
		
		
		add(brandTxt, "14, 12, left, default");
		brandTxt.setColumns(10);
		brandTxt.getDocument().addDocumentListener(managerController);
		
		add(lblPurchaseDate, "10, 14");
		/*calendar.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calendar.setDate(calendar.getS)
			}
		});*/
		calendar.setMaxSelectableDate( new java.util.Date(System.currentTimeMillis()));
		calendar.setDate( new java.util.Date(System.currentTimeMillis()));
		calendar.getDateEditor().setEnabled(false);
		add(calendar, "14, 14, fill, fill");
		
		typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ECONOMY","COMPACT","MID-SIZE",
				   "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
				   "VAN"}));
		
		add(btnAdd, "12, 16");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(managerController);
		
		xpanel = new ValidationPanel();
		xpanel.setInnerComponent(this);
		group = xpanel.getValidationGroup();
		group.add(this.regNumberTxt, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(7),StringValidators.minLength(7));
		group.add(this.brandTxt, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(20),StringValidators.minLength(3));
		//group.add(this.calendar, StringValidators.REQUIRE_NON_EMPTY_STRING);
		
	}

	public void setCalendar(String calendar) {
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		Date date = null;
		try {
			date = (Date) new SimpleDateFormat(pattern).parse(calendar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.calendar.setDate(date);
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		String item = (String)categoryCombox.getSelectedItem();
		if(item.equalsIgnoreCase("CAR")){
			typeCombox.setEnabled(true);
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ECONOMY","COMPACT","MID-SIZE",
					  												   "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
					  												   "VAN"}));
		}
		else if(item.equalsIgnoreCase("TRUCK")){
			typeCombox.setEnabled(true);
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
					   "CARGO VAN"}));
		}
		
	}

	public void clearVehicleScreen(){
		
		regNumberTxt.setText("");
		brandTxt.setText("");		
		categoryCombox.setSelectedIndex(0);
		typeCombox.setSelectedIndex(0);
		calendar.setDate( new java.util.Date(System.currentTimeMillis()));
	}
	
	public String getRegNumberTxt() {
		return regNumberTxt.getText();
	}

	public String getBrandTxt() {
		return brandTxt.getText();
	}

	public void setBrandTxt(String brandTxt) {
		this.brandTxt.setText(brandTxt);
	}

	public void setRegNumberTxt(String regNumberTxt) {
		this.regNumberTxt.setText(regNumberTxt);
	}
	
	public JComboBox<String> getCategoryCombox() {
		return categoryCombox;
	}

	public void setCategoryCombox(String categoryCombox) {
		this.categoryCombox.setSelectedItem(categoryCombox);
	}

	public JComboBox<String> getTypeCombox() {
		return typeCombox;
	}

	public void setTypeCombox(String typeCombox) {
		this.typeCombox.setSelectedItem(typeCombox);
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JLabel getLblAddVehicle() {
		return lblAddVehicle;
	}

	public ValidationGroup getGroup() {
		return group;
	}

	public void setGroup(ValidationGroup group) {
		this.group = group;
	}

	public ValidationPanel getXpanel() {
		return xpanel;
	}

	public void setXpanel(ValidationPanel xpanel) {
		this.xpanel = xpanel;
	}

	public void setLblAddVehicle(JLabel lblAddVehicle) {
		this.lblAddVehicle = lblAddVehicle;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	
	public void disableRegNoTxt(){
		regNumberTxt.setEnabled(false);
	}

}
