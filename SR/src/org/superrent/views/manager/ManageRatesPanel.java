package org.superrent.views.manager;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ManageRatesPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ManagerController managerController;
	private JTable rentalRateTable;
	private JTable insuranceTable;
	private JTextField membershipTxtField;
	private JTextField taxField;
	private JTextField memPointsTxt;
	private JTextField FuelRateTxt;
	private JTable table_3;
	private static int insuranceRow=-1;
	private static int rentalRow=-1;
	
	JButton btnEditInsuranceRate = new JButton("Edit Insurance Rate");
	JButton btnEditRentalRate = new JButton("Edit Rental Rate");
	JButton saveInsuranceRateBtn = new JButton("Save");
	JButton btnCancelInsuranceEdit = new JButton("Cancel");
	JButton btnCancelEditRental = new JButton("Cancel");
	JButton rentalRateSaveEditBtn = new JButton("Save");
	
	JPanel rentalratePanel = new JPanel();
	JButton btnSave = new JButton("Save");
	
	private JTextField carDayCSTxt;
	private JTextField carSRDayTxt;
	private JTextField truckHourCSTxt;
	private JTextField truckHourSRTxt;
	private JTextField truckDayCSTxt;
	private JTextField truckDaySRTxt;
	private JTextField carHourCSTxt;
	private JTextField carHourSRTxt;

	/**
	 * Create the panel.
	 */
	public ManageRatesPanel(ManagerController managerController) {
		this.managerController = managerController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("78px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("18px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "2, 2, 5, 7, fill, fill");
		rentalratePanel.setAlignmentY(Component.TOP_ALIGNMENT);
		rentalratePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		tabbedPane.addTab("Rental Rates", null, rentalratePanel, null);
		rentalratePanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("65px"),
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
				ColumnSpec.decode("652px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("652px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("327px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		rentalratePanel.add(scrollPane, "2, 2, 15, 1, left, top");
		
		rentalRateTable = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               
	        	if(!btnEditRentalRate.isEnabled()  && rentalRow == row && !(column == 0) && !(column == 1) && !(column == 2) && !(column == 8)){
	        		return true;
	        	}
	        	return false;               
	        };
	        
	        @Override
	    	public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
	    		if (!btnEditRentalRate.isEnabled()) {
	    			int currentIndex = rentalRow;
	    			if (rowIndex != currentIndex) {
	    				
	    			}else{
	    				// make the selection change
	    	    		super.changeSelection(rowIndex, columnIndex, toggle, extend);
	    			}
	    		}else{
	    			// make the selection change
    	    		super.changeSelection(rowIndex, columnIndex, toggle, extend);
	    		}
	    		
	    	}

		};
		rentalRateTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		rentalRateTable.setPreferredScrollableViewportSize(new Dimension(650, 300));
		scrollPane.setViewportView(rentalRateTable);
		rentalRateTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "Category", "Type", "Hourly Rates", "Daily Rates"
			}
		));
		
		btnEditRentalRate.addActionListener(this);
		rentalratePanel.add(btnEditRentalRate, "8, 4, center, center");
		
		
		rentalRateSaveEditBtn.setActionCommand("rentalRateSaveEdit");
		rentalRateSaveEditBtn.setEnabled(false);
		rentalRateSaveEditBtn.addActionListener(managerController);
		rentalratePanel.add(rentalRateSaveEditBtn, "10, 4, center, default");
		
		
		btnCancelEditRental.addActionListener(this);
		btnCancelEditRental.setEnabled(false);
		btnCancelEditRental.setActionCommand("Cancel Rental Edit");
		rentalratePanel.add(btnCancelEditRental, "12, 4, center, default");
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Exceeded limit Rates", null, panel_4, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setPreferredScrollableViewportSize(new Dimension(650, 300));
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category", "Type", "Per Kilometer Rate"
			}
		));
		table_3.getColumnModel().getColumn(2).setPreferredWidth(107);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Insurance Rates", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("65px"),
				FormFactory.BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("327px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "2, 2, 11, 1, left, top");
		
		insuranceTable = new JTable(){
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {  
	        	
	        	if(!btnEditInsuranceRate.isEnabled() && insuranceRow == row && !(column == 0) && !(column == 1) && !(column == 2) && !(column == 6)){
	        		return true;
	        	}
	                return false;               
	        };
	        
	        @Override
	    	public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
	    		if (!btnEditInsuranceRate.isEnabled()) {
	    			int currentIndex = insuranceRow;
	    			if (rowIndex != currentIndex) {
	    				
	    			}else{
	    				// make the selection change
	    	    		super.changeSelection(rowIndex, columnIndex, toggle, extend);
	    			}
	    		}else{
	    			// make the selection change
    	    		super.changeSelection(rowIndex, columnIndex, toggle, extend);
	    		}
	    		
	    	}
	       
		};
		insuranceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		insuranceTable.setPreferredScrollableViewportSize(new Dimension(650, 300));
		scrollPane_1.setViewportView(insuranceTable);
		insuranceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "Category", "Type", "Per Hour Rate", "Per Day Rate"
			}
		));
		
		btnEditInsuranceRate.addActionListener(this);
		panel_1.add(btnEditInsuranceRate, "12, 4, center, center");
		
		
		saveInsuranceRateBtn.setActionCommand("SaveInsuranceRate");
		saveInsuranceRateBtn.setEnabled(false);
		saveInsuranceRateBtn.addActionListener(managerController);
		panel_1.add(saveInsuranceRateBtn, "14, 4, center, default");
		
		
		
		btnCancelInsuranceEdit.setActionCommand("Cancel Insurance Edit");
		btnCancelInsuranceEdit.setEnabled(false);
		btnCancelInsuranceEdit.addActionListener(this);
		panel_1.add(btnCancelInsuranceEdit, "16, 4");
		
		insuranceTable.getColumnModel().getColumn(6).setPreferredWidth(90);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Additional Equipment Rate", null, panel_2, null);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default)"),
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
		
		JLabel lblLocation = new JLabel("Location");
		panel_2.add(lblLocation, "10, 4, center, default");
		
		JComboBox<String> locationCombox = new JComboBox<String>();
		locationCombox.setEnabled(false);
		locationCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vancouver"}));
		panel_2.add(locationCombox, "14, 4, left, default");
		
		JLabel lblCar = new JLabel("Car");
		panel_2.add(lblCar, "6, 6, center, default");
		
		JLabel lblTruck = new JLabel("Truck");
		panel_2.add(lblTruck, "16, 6, center, default");
		
		JLabel label_3 = new JLabel("Per Hour");
		panel_2.add(label_3, "6, 8, center, default");
		
		JLabel label_2 = new JLabel("Per Day");
		panel_2.add(label_2, "8, 8, center, default");
		
		JLabel lblPerHour = new JLabel("Per Hour");
		panel_2.add(lblPerHour, "16, 8, center, default");
		
		JLabel lblPerDay = new JLabel("Per Day");
		panel_2.add(lblPerDay, "18, 8, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("Child Seat");
		panel_2.add(lblNewLabel_1, "4, 10");
		
		carHourCSTxt = new JTextField();
		carHourCSTxt.setEnabled(false);
		carHourCSTxt.setColumns(10);
		panel_2.add(carHourCSTxt, "6, 10, fill, default");
		
		carDayCSTxt = new JTextField();
		carDayCSTxt.setEnabled(false);
		panel_2.add(carDayCSTxt, "8, 10, fill, default");
		carDayCSTxt.setColumns(10);
		
		JButton carCSEditBtn = new JButton("Edit");
		carCSEditBtn.setActionCommand("carCSEditBtn");
		panel_2.add(carCSEditBtn, "10, 10");
		
		JLabel label = new JLabel("Child Seat");
		panel_2.add(label, "14, 10, center, default");
		
		truckHourCSTxt = new JTextField();
		truckHourCSTxt.setEnabled(false);
		truckHourCSTxt.setColumns(10);
		panel_2.add(truckHourCSTxt, "16, 10, fill, default");
		
		truckDayCSTxt = new JTextField();
		truckDayCSTxt.setEnabled(false);
		truckDayCSTxt.setColumns(10);
		panel_2.add(truckDayCSTxt, "18, 10, fill, default");
		
		JButton TruckCSEditBtn = new JButton("Edit");
		TruckCSEditBtn.setActionCommand("TruckCSEditBtn");
		panel_2.add(TruckCSEditBtn, "20, 10");
		
		JLabel lblSkiRack = new JLabel("Ski Rack");
		panel_2.add(lblSkiRack, "4, 12, right, default");
		
		carHourSRTxt = new JTextField();
		carHourSRTxt.setEnabled(false);
		carHourSRTxt.setColumns(10);
		panel_2.add(carHourSRTxt, "6, 12, fill, default");
		
		carSRDayTxt = new JTextField();
		carSRDayTxt.setEnabled(false);
		panel_2.add(carSRDayTxt, "8, 12, fill, default");
		carSRDayTxt.setColumns(10);
		
		JButton carSREditBtn = new JButton("Edit");
		carSREditBtn.setActionCommand("carSREditBtn");
		panel_2.add(carSREditBtn, "10, 12");
		
		JLabel label_1 = new JLabel("Ski Rack");
		panel_2.add(label_1, "14, 12, center, default");
		
		truckHourSRTxt = new JTextField();
		truckHourSRTxt.setEnabled(false);
		truckHourSRTxt.setColumns(10);
		panel_2.add(truckHourSRTxt, "16, 12, fill, default");
		
		truckDaySRTxt = new JTextField();
		truckDaySRTxt.setEnabled(false);
		truckDaySRTxt.setColumns(10);
		panel_2.add(truckDaySRTxt, "18, 12, fill, default");
		
		JButton TruckSREditBtn = new JButton("Edit");
		TruckSREditBtn.setActionCommand("TruckSREditBtn");
		panel_2.add(TruckSREditBtn, "20, 12");
		
		JButton updateAddnEquip = new JButton("Save");
		updateAddnEquip.setActionCommand("updateAddnEquip");
		panel_2.add(updateAddnEquip, "12, 18");
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Other Rates", null, panel_3, null);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("max(100dlu;default)"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel, "16, 4");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vancouver"}));
		comboBox.setEnabled(false);
		panel_3.add(comboBox, "20, 4, fill, center");
		
		JLabel lblMembershipFees = new JLabel("Membership Fees");
		panel_3.add(lblMembershipFees, "16, 6");
		
		membershipTxtField = new JTextField();
		membershipTxtField.setEnabled(false);
		panel_3.add(membershipTxtField, "20, 6, fill, default");
		membershipTxtField.setColumns(10);
		
		JButton btnMemberShipEdit = new JButton("Edit");
		btnMemberShipEdit.setActionCommand("EditMembershipFees");
		btnMemberShipEdit.addActionListener(this);
		panel_3.add(btnMemberShipEdit, "22, 6");
		
		JLabel lblTax = new JLabel("Tax");
		panel_3.add(lblTax, "16, 8");
		
		taxField = new JTextField();
		taxField.setEnabled(false);
		panel_3.add(taxField, "20, 8, fill, default");
		taxField.setColumns(10);
		
		JButton btnEditTax = new JButton("Edit");
		btnEditTax.setActionCommand("EditTax");	
		btnEditTax.addActionListener(this);
		panel_3.add(btnEditTax, "22, 8");
		
		JLabel lblMembershipRentalPoints = new JLabel("Membership Points");
		panel_3.add(lblMembershipRentalPoints, "16, 10");
		
		memPointsTxt = new JTextField();
		memPointsTxt.setEnabled(false);
		panel_3.add(memPointsTxt, "20, 10, fill, default");
		memPointsTxt.setColumns(10);
		
		JButton btnMemPoints = new JButton("Edit");
		btnMemPoints.setActionCommand("EditMemPoints");
		btnMemPoints.addActionListener(this);
		panel_3.add(btnMemPoints, "22, 10");
		
		JLabel lblFuelRatesTank = new JLabel("Fuel Rates(10% tank)");
		panel_3.add(lblFuelRatesTank, "16, 12");
		
		FuelRateTxt = new JTextField();
		FuelRateTxt.setEnabled(false);
		panel_3.add(FuelRateTxt, "20, 12, fill, default");
		FuelRateTxt.setColumns(10);
		
		JButton btnFuelRate = new JButton("Edit");
		btnFuelRate.setActionCommand("EditFuelRates");
		btnFuelRate.addActionListener(this);
		panel_3.add(btnFuelRate, "22, 12");
		
		
		btnSave.setActionCommand("Save Other Rates");
		btnSave.addActionListener(managerController);
		panel_3.add(btnSave, "18, 14");

	}

	public JTable getRentalRateTable() {
		return rentalRateTable;
	}

	public void setRentalRateTable(JTable rentalRateTable) {
		this.rentalRateTable = rentalRateTable;
	}

	public JPanel getRentalratePanel() {
		return rentalratePanel;
	}

	public void setRentalratePanel(JPanel rentalratePanel) {
		this.rentalratePanel = rentalratePanel;
	}

	public JTable getInsuranceTable() {
		return insuranceTable;
	}

	public void setInsuranceTable(JTable insuranceTable) {
		this.insuranceTable = insuranceTable;
	}

	public String getMembershipTxtField() {
		return membershipTxtField.getText();
	}

	public void setMembershipTxtField(String membershipTxtField) {
		this.membershipTxtField.setText(membershipTxtField);
		this.membershipTxtField.setEnabled(false);
	}

	public String getMemPointsTxt() {
		return this.memPointsTxt.getText();
	}

	public void setMemPointsTxt(String memPointsTxt) {
		this.memPointsTxt.setText(memPointsTxt);
		this.memPointsTxt.setEnabled(false);
	}

	public String getFuelRateTxt() {
		return this.FuelRateTxt.getText();
	}

	public void setFuelRateTxt(String fuelRateTxt) {
		this.FuelRateTxt.setText(fuelRateTxt);
		this.FuelRateTxt.setEnabled(false);
	}

	public String getTaxField() {
		return this.taxField.getText();
	}

	public void setTaxField(String taxField) {
		this.taxField.setText(taxField);
		this.taxField.setEnabled(false);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("EditMemPoints")){
			
			memPointsTxt.setEnabled(true);
			
		}else if(e.getActionCommand().equals("EditMembershipFees")){
			
			membershipTxtField.setEnabled(true);
			
		}
		else if(e.getActionCommand().equals("EditTax")){
			
			taxField.setEnabled(true);
		}
		else if(e.getActionCommand().equals("EditFuelRates")){
			
			FuelRateTxt.setEnabled(true);
			
		}
		else if(e.getActionCommand().equals("Edit Rental Rate")){
			
			btnEditRentalRate.setEnabled(false);
			rentalRateSaveEditBtn.setEnabled(true);
			btnCancelEditRental.setEnabled(true);
			int row = rentalRateTable.getSelectedRow();
			rentalRow = row;
		}
		else if(e.getActionCommand().equals("Edit Insurance Rate")){
			
			btnEditInsuranceRate.setEnabled(false);
			saveInsuranceRateBtn.setEnabled(true);
			btnCancelInsuranceEdit.setEnabled(true);
			int row = insuranceTable.getSelectedRow();
			insuranceRow = row;
			
			
			
		}
		else if(e.getActionCommand().equals("Cancel Insurance Edit")){
			
			saveInsuranceRateBtn.setEnabled(false);
			btnCancelInsuranceEdit.setEnabled(false);
			btnEditInsuranceRate.setEnabled(true);
			managerController.getInsuranceRates();
			insuranceRow =-1;
			
		}
		
		else if(e.getActionCommand().equals("Cancel Rental Edit")){
			
			rentalRateSaveEditBtn.setEnabled(false);
			btnCancelEditRental.setEnabled(false);
			btnEditRentalRate.setEnabled(true);
			managerController.getRentalRates();
			rentalRow=-1;
			
		}
	
	}

}
