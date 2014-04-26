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
	
	private static int insuranceRow=-1;
	private static int rentalRow=-1;
	private static int addnEquipRow=-1;
	
	JButton btnEditInsuranceRate = new JButton("Edit Insurance Rate");
	JButton btnEditRentalRate = new JButton("Edit Rental Rate");
	JButton saveInsuranceRateBtn = new JButton("Save");
	JButton btnCancelInsuranceEdit = new JButton("Cancel");
	JButton btnCancelEditRental = new JButton("Cancel");
	JButton rentalRateSaveEditBtn = new JButton("Save");
	
	JButton btnAddnEquipCanel = new JButton("Cancel");
	JButton btnEditSelectedRate = new JButton("Edit Selected Rate");
	JButton btnAddnEquipSaveBtn = new JButton("Save");
	
	JPanel rentalratePanel = new JPanel();
	JButton btnSave = new JButton("Save");
	private JTable additionalEquipmentTable;
	private JTextField minReedemablePointsTxt;
	private JTextField clubPointsPerDollarTxt;

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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("65px"),
				FormFactory.RELATED_GAP_COLSPEC,
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
				ColumnSpec.decode("max(159dlu;default)"),
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
		rentalratePanel.add(scrollPane, "2, 2, 17, 1, fill, top");
		
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
		rentalratePanel.add(btnEditRentalRate, "12, 4, center, center");
		
		
		rentalRateSaveEditBtn.setActionCommand("rentalRateSaveEdit");
		rentalRateSaveEditBtn.setEnabled(false);
		rentalRateSaveEditBtn.addActionListener(managerController);
		rentalratePanel.add(rentalRateSaveEditBtn, "10, 6, center, default");
		
		
		btnCancelEditRental.addActionListener(this);
		btnCancelEditRental.setEnabled(false);
		btnCancelEditRental.setActionCommand("Cancel Rental Edit");
		rentalratePanel.add(btnCancelEditRental, "14, 6, center, default");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Insurance Rates", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
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
				ColumnSpec.decode("max(137dlu;default)"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("327px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "3, 2, 20, 1, fill, top");
		
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
		panel_1.add(btnEditInsuranceRate, "14, 4, center, center");
		
		
		saveInsuranceRateBtn.setActionCommand("SaveInsuranceRate");
		saveInsuranceRateBtn.setEnabled(false);
		saveInsuranceRateBtn.addActionListener(managerController);
		panel_1.add(saveInsuranceRateBtn, "12, 6, center, default");
		
		
		
		btnCancelInsuranceEdit.setActionCommand("Cancel Insurance Edit");
		btnCancelInsuranceEdit.setEnabled(false);
		btnCancelInsuranceEdit.addActionListener(this);
		panel_1.add(btnCancelInsuranceEdit, "16, 6");
		
		insuranceTable.getColumnModel().getColumn(6).setPreferredWidth(90);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Additional Equipment Rate", null, panel_2, null);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(221dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, "2, 2, 15, 1, fill, fill");
		
		additionalEquipmentTable = new JTable(){
			
			private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               
	        	if((!btnEditSelectedRate.isEnabled())  && addnEquipRow == row && !(column == 0) && !(column == 1) && !(column == 2) && !(column == 5)){
	        		return true;
	        	}
	        	return false;               
	        };
	        
	        @Override
	    	public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
	    		if (!btnEditSelectedRate.isEnabled()) {
	    			int currentIndex = addnEquipRow;
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
		additionalEquipmentTable.setPreferredScrollableViewportSize(new Dimension(650, 300));
		scrollPane_2.setViewportView(additionalEquipmentTable);
		additionalEquipmentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		
		btnEditSelectedRate.addActionListener(this);
		panel_2.add(btnEditSelectedRate, "12, 4, center, default");
		
		
		btnAddnEquipCanel.setEnabled(false);
		btnAddnEquipCanel.setActionCommand("AddnEquipCancel");
		btnAddnEquipCanel.addActionListener(this);
		
		
		btnAddnEquipSaveBtn.setEnabled(false);
		btnAddnEquipSaveBtn.setActionCommand("Additional Equipment Save");
		btnAddnEquipSaveBtn.addActionListener(managerController);
		panel_2.add(btnAddnEquipSaveBtn, "10, 6");
		panel_2.add(btnAddnEquipCanel, "14, 6, center, default");
		
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
				RowSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Location");
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
		
		JLabel lblNewLabel_1 = new JLabel("Minimum Redeemable Points");
		panel_3.add(lblNewLabel_1, "16, 8");
		
		minReedemablePointsTxt = new JTextField();
		minReedemablePointsTxt.setEnabled(false);
		panel_3.add(minReedemablePointsTxt, "20, 8, fill, default");
		minReedemablePointsTxt.setColumns(10);
		
		JButton btnReemablePointsEdit = new JButton("Edit");
		btnReemablePointsEdit.addActionListener(this);
		btnReemablePointsEdit.setActionCommand("Reedemable Points Button");
		panel_3.add(btnReemablePointsEdit, "22, 8");
		
		JLabel lblClubpointsPerDollar = new JLabel("ClubPoints per dollar");
		panel_3.add(lblClubpointsPerDollar, "16, 10, left, center");
		
		clubPointsPerDollarTxt = new JTextField();
		clubPointsPerDollarTxt.setEnabled(false);
		clubPointsPerDollarTxt.setActionCommand("Club Points Per Dollar");
		panel_3.add(clubPointsPerDollarTxt, "20, 10, fill, default");
		clubPointsPerDollarTxt.setColumns(10);
		
		JButton clubPointsPerDollarBtn = new JButton("Edit");
		clubPointsPerDollarBtn.addActionListener(this);
		clubPointsPerDollarBtn.setActionCommand("ClubPoints Per Dollar Button");
		panel_3.add(clubPointsPerDollarBtn, "22, 10");
		
		JLabel lblTax = new JLabel("Tax");
		panel_3.add(lblTax, "16, 12");
		
		taxField = new JTextField();
		taxField.setEnabled(false);
		panel_3.add(taxField, "20, 12, fill, default");
		taxField.setColumns(10);
		
		JButton btnEditTax = new JButton("Edit");
		btnEditTax.setActionCommand("EditTax");	
		btnEditTax.addActionListener(this);
		panel_3.add(btnEditTax, "22, 12");
		
		JLabel lblMembershipRentalPoints = new JLabel("Membership Points");
		panel_3.add(lblMembershipRentalPoints, "16, 14");
		
		memPointsTxt = new JTextField();
		memPointsTxt.setEnabled(false);
		panel_3.add(memPointsTxt, "20, 14, fill, default");
		memPointsTxt.setColumns(10);
		
		JButton btnMemPoints = new JButton("Edit");
		btnMemPoints.setActionCommand("EditMemPoints");
		btnMemPoints.addActionListener(this);
		panel_3.add(btnMemPoints, "22, 14");
		
		JLabel lblFuelRatesTank = new JLabel("Fuel Rates(10% tank)");
		panel_3.add(lblFuelRatesTank, "16, 16");
		
		FuelRateTxt = new JTextField();
		FuelRateTxt.setEnabled(false);
		panel_3.add(FuelRateTxt, "20, 16, fill, default");
		FuelRateTxt.setColumns(10);
		
		JButton btnFuelRate = new JButton("Edit");
		btnFuelRate.setActionCommand("EditFuelRates");
		btnFuelRate.addActionListener(this);
		panel_3.add(btnFuelRate, "22, 16");
		
		
		btnSave.setActionCommand("Save Other Rates");
		btnSave.addActionListener(managerController);
		panel_3.add(btnSave, "18, 18");

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
	

	public JButton getBtnEditInsuranceRate() {
		return btnEditInsuranceRate;
	}

	public void setBtnEditInsuranceRate(JButton btnEditInsuranceRate) {
		this.btnEditInsuranceRate = btnEditInsuranceRate;
	}

	public JButton getBtnEditRentalRate() {
		return btnEditRentalRate;
	}

	public void setBtnEditRentalRate(JButton btnEditRentalRate) {
		this.btnEditRentalRate = btnEditRentalRate;
	}

	public JButton getSaveInsuranceRateBtn() {
		return saveInsuranceRateBtn;
	}

	public void setSaveInsuranceRateBtn(JButton saveInsuranceRateBtn) {
		this.saveInsuranceRateBtn = saveInsuranceRateBtn;
	}

	public JButton getBtnCancelInsuranceEdit() {
		return btnCancelInsuranceEdit;
	}

	public void setBtnCancelInsuranceEdit(JButton btnCancelInsuranceEdit) {
		this.btnCancelInsuranceEdit = btnCancelInsuranceEdit;
	}

	public JButton getBtnCancelEditRental() {
		return btnCancelEditRental;
	}

	public void setBtnCancelEditRental(JButton btnCancelEditRental) {
		this.btnCancelEditRental = btnCancelEditRental;
	}

	public JButton getRentalRateSaveEditBtn() {
		return rentalRateSaveEditBtn;
	}

	public void setRentalRateSaveEditBtn(JButton rentalRateSaveEditBtn) {
		this.rentalRateSaveEditBtn = rentalRateSaveEditBtn;
	}

	public JButton getBtnAddnEquipCanel() {
		return btnAddnEquipCanel;
	}

	public void setBtnAddnEquipCanel(JButton btnAddnEquipCanel) {
		this.btnAddnEquipCanel = btnAddnEquipCanel;
	}

	public JButton getBtnEditSelectedRate() {
		return btnEditSelectedRate;
	}

	public void setBtnEditSelectedRate(JButton btnEditSelectedRate) {
		this.btnEditSelectedRate = btnEditSelectedRate;
	}

	public JButton getBtnAddnEquipSaveBtn() {
		return btnAddnEquipSaveBtn;
	}

	public void setBtnAddnEquipSaveBtn(JButton btnAddnEquipSaveBtn) {
		this.btnAddnEquipSaveBtn = btnAddnEquipSaveBtn;
	}

	public JTable getAdditionalEquipmentTable() {
		return additionalEquipmentTable;
	}

	public void setAdditionalEquipmentTable(JTable additionalEquipmentTable) {
		this.additionalEquipmentTable = additionalEquipmentTable;
	}

	// @Override
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
		else if(e.getActionCommand().equals("ClubPoints Per Dollar Button")){
			
			clubPointsPerDollarTxt.setEnabled(true);
			
		}
		else if(e.getActionCommand().equals("Reedemable Points Button")){
			
			minReedemablePointsTxt.setEnabled(true);
			
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
		else if(e.getActionCommand().equals("Edit Selected Rate")){
			
			btnEditSelectedRate.setEnabled(false);
			btnAddnEquipSaveBtn.setEnabled(true);
			btnAddnEquipCanel.setEnabled(true);
			int row = additionalEquipmentTable.getSelectedRow();
			System.out.println("row----" + row);
			addnEquipRow = row;
			
			
			
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
		
		else if(e.getActionCommand().equals("AddnEquipCancel")){
			
			btnAddnEquipSaveBtn.setEnabled(false);
			btnAddnEquipCanel.setEnabled(false);
			btnEditSelectedRate.setEnabled(true);
			managerController.getAddnEquipRates();
			addnEquipRow=-1;
			
		}
	
	}

	public String getMinReedemablePointsTxt() {
		return minReedemablePointsTxt.getText();
	}

	public void setMinReedemablePointsTxt(String minReedemablePointsTxt) {
		this.minReedemablePointsTxt.setText(minReedemablePointsTxt);
	}

	public String getClubPointsPerDollarTxt() {
		return clubPointsPerDollarTxt.getText();
	}

	public void setClubPointsPerDollarTxt(String clubPointsPerDollarTxt) {
		this.clubPointsPerDollarTxt.setText(clubPointsPerDollarTxt);
	}

}
