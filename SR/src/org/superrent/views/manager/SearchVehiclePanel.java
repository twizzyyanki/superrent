package org.superrent.views.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JYearChooser;

public class SearchVehiclePanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable searchtable = new JTable();
	JComboBox<String> categoryCombox = new JComboBox<String>();
	JComboBox<String> typeCombox = new JComboBox<String>();

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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(57dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblSearchVehicles = new JLabel("Search Vehicles");
		add(lblSearchVehicles, "14, 2, 2, 1, center, center");
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "4, 4, right, default");
		
		JComboBox<String> locationCombox = new JComboBox<String>();
		locationCombox.setModel(new DefaultComboBoxModel(new String[] {"All", "Vancouver"}));
		add(locationCombox, "6, 4, left, center");
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "8, 4, fill, default");
		
		
		categoryCombox.setModel(new DefaultComboBoxModel(new String[] {"All", "Car", "Truck"}));
		add(categoryCombox, "10, 4, left, default");
		
	    //  prevent action events from being fired when the up/down arrow keys are used
		categoryCombox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		categoryCombox.addActionListener( this );
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "12, 4, fill, default");
		
		typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
																		  "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
																		  "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
																		  "CARGO VAN"}));
		add(typeCombox, "14, 4, fill, default");
		
		JLabel lblPurchasedyear = new JLabel("Year Purchased");
		add(lblPurchasedyear, "16, 4, right, default");
		
		JYearChooser yearChooser = new JYearChooser();
		add(yearChooser, "18, 4, left, fill");
		
		JButton btnSearch = new JButton("Search");
		add(btnSearch, "20, 4, right, default");
		btnSearch.addActionListener(managerController);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 8, 23, 1, fill, fill");
		
		searchtable = new JTable();
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
		add(btnEdit, "16, 10, center, fill");
		
		JButton btnAddForSale = new JButton("Add For Sale");
		add(btnAddForSale, "18, 10, center, default");
		btnAddForSale.addActionListener(managerController);

	}

	//@Override
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

}
