package org.superrent.views.manager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JYearChooser;

import javax.swing.ListSelectionModel;

import java.awt.Font;

public class SearchVehiclePanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable searchtable = new JTable();
	JComboBox<String> categoryCombox = new JComboBox<String>();
	JComboBox<String> typeCombox = new JComboBox<String>();
	JYearChooser yearChooser = new JYearChooser();
	JComboBox<String> statusCombox = new JComboBox<String>();

	

	ManagerController managerController;
	JButton btnAddForSale = new JButton("Add For Sale");
	/**
	 * Create the panel.
	 * @param managerController 
	 */
	public SearchVehiclePanel(ManagerController managerController) {
		this.managerController = managerController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(40dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(1dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblLocation, "2, 4, right, default");
		
		JComboBox<String> locationCombox = new JComboBox<String>();
		locationCombox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		locationCombox.setEnabled(false);
		locationCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vancouver"}));
		add(locationCombox, "4, 4, fill, center");
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblCategory, "6, 4, center, default");
		categoryCombox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		categoryCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "Car", "Truck"}));
		add(categoryCombox, "8, 4, left, default");
		
	    //  prevent action events from being fired when the up/down arrow keys are used
		categoryCombox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		categoryCombox.addActionListener( this );
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblType, "10, 4, fill, default");
		typeCombox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
																		  "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
																		  "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
																		  "CARGO VAN"}));
		add(typeCombox, "12, 4, fill, default");
		
		
		JSpinner spinner = (JSpinner) yearChooser.getSpinner();
		((javax.swing.JTextField)spinner.getEditor()).setEditable(false);
		
		JLabel lblPurchasedyear = new JLabel("Purchased Before");
		lblPurchasedyear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPurchasedyear, "14, 4, right, default");
		yearChooser.getSpinner().setFont(new Font("Tahoma", Font.BOLD, 9));
		
		add(yearChooser, "16, 4, 3, 1, left, fill");
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblStatus, "20, 4, right, default");
		statusCombox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		statusCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "FOR-RENT", "FOR-SALE", "SOLD"}));
		add(statusCombox, "22, 4, fill, default");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 9));
		add(btnSearch, "22, 8, fill, default");
		btnSearch.addActionListener(managerController);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 12, 22, 1, fill, fill");
		
		searchtable = new JTable();
		searchtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchtable.setPreferredScrollableViewportSize(new Dimension(650, 300));
		searchtable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"RegisterNumber", "Category", "Type", "Brand", "Purchase Date", "For Sale",
			}
		));
		scrollPane.setViewportView(searchtable);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(managerController);
		add(btnEdit, "14, 14, center, fill");
		
		JButton btnAddForSale = new JButton("Add For Sale");
		add(btnAddForSale, "16, 14, 3, 1, center, default");
		btnAddForSale.addActionListener(managerController);

	}

	// @Override
	public void actionPerformed(ActionEvent arg0) {
		String item = (String)categoryCombox.getSelectedItem();
		if(item.equalsIgnoreCase("CAR")){
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] { "All","ECONOMY","COMPACT","MID-SIZE",
					  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
					  													"VAN"}));
		}
		else if(item.equalsIgnoreCase("TRUCK")){
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"All","24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
					  												   "CARGO VAN"}));
		}
		else if(item.equalsIgnoreCase("ALL")){
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
					  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
					  													"VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
					  													"CARGO VAN"}));
		}

		
	}
	
	public JTable getSearchtable() {
		return searchtable;
	}

	public void setSearchtable(JTable searchtable) {
		this.searchtable = searchtable;
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
	
	public JYearChooser getYearChooser() {
		return yearChooser;
	}

	public void setYearChooser(JYearChooser yearChooser) {
		this.yearChooser = yearChooser;
	}

	public JComboBox<String> getStatusCombox() {
		return statusCombox;
	}

	public void setStatusCombox(JComboBox<String> statusCombox) {
		this.statusCombox = statusCombox;
	}

}
