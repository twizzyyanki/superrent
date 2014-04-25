
package org.superrent.views.general;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.MakeReservationController;

public class SearchVReservationPanel extends JPanel implements ActionListener{
	private JTable searchTable;
	private MakeReservationController mrc;
	private JComboBox<String> categoryCombox_1;
	private JComboBox<String> typeCombox_1;
	private JComboBox<String> equipComboBox_1;
	private JButton btnSearch;
	private JDateChooser dateChooserPick;
	private JDateChooser dateChooserReturn;
	private JLabel lblAmount;
	private JButton btnReserve;
	
	/**
	 * Create the panel.
	 */
	public SearchVReservationPanel(MakeReservationController mrc) {
		
		this.mrc = mrc;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(17dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPickUpDate = new JLabel("Pick up Date");
		add(lblPickUpDate, "4, 4, center, default");
		
		dateChooserPick = new JDateChooser();
		add(dateChooserPick, "6, 4, fill, fill");
		
		JLabel lblReturnDate = new JLabel("Return Date");
		add(lblReturnDate, "10, 4, center, default");
		
		dateChooserReturn = new JDateChooser();
		add(dateChooserReturn, "12, 4, fill, fill");
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "4, 6, center, default");
		
		categoryCombox_1 = new JComboBox<String>();
		categoryCombox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Car", "Truck"}));
		categoryCombox_1.addActionListener(this);
		add(categoryCombox_1, "6, 6, fill, default");
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "10, 6, center, default");
		
		typeCombox_1 = new JComboBox<String>();
		typeCombox_1.setModel(new DefaultComboBoxModel(new String[] {"ALL", "ECONOMY", "COMPACT", "MID-SIZE", "STANDARD", "FULL-SIZE", "PREMIUM", "LUXURY", "SUV", "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", "CARGO VAN"}));
		typeCombox_1.addActionListener(this);
		add(typeCombox_1, "12, 6, fill, default");
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "4, 8, center, default");
		
		JComboBox<String> LocationBox = new JComboBox<String>();
		LocationBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Vancouver"}));
		add(LocationBox, "6, 8, fill, default");
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(mrc);
		add(btnSearch, "12, 8");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 12, 13, 1, fill, fill");
		
		searchTable = new JTable();
		searchTable.setToolTipText("");
		searchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"ubc", "454", "4654", null},
				{null, null, null, null},
			},
			new String[] {
				"Location", "Category", "Type", "Rate"
			}
		));
		searchTable.getSelectionModel().addListSelectionListener(mrc);
		scrollPane.setViewportView(searchTable);
		
		btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(mrc);
		btnReserve.setEnabled(false);
		JLabel lblEquip = new JLabel("Add additional equipment");
		lblEquip.setToolTipText("Please select vehicle first");
		
		add(lblEquip, "4, 14");
		
		equipComboBox_1 = new JComboBox();
		equipComboBox_1.setToolTipText("Please select vehicle first");
		equipComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		equipComboBox_1.addActionListener(this);
		add(equipComboBox_1, "6, 14, fill, default");
		
		JLabel lblEstamited = new JLabel("Estimated cost:");
		add(lblEstamited, "4, 16");
		
		lblAmount = new JLabel("amount");
		add(lblAmount, "6, 16");
		add(btnReserve, "12, 18, center, default");

	}

	//Just for combo box actions
	//@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource() == categoryCombox_1){
			
			String item = (String)categoryCombox_1.getSelectedItem();
			if(item.equalsIgnoreCase("CAR")){
				typeCombox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "All","ECONOMY","COMPACT","MID-SIZE",
						  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
						  													"VAN"}));
				
				equipComboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "None","Child seat"}));
			}
			else if(item.equalsIgnoreCase("TRUCK")){
				typeCombox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"All","24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
						  												   "CARGO VAN"}));
			}
			else if(item.equalsIgnoreCase("ALL")){
				typeCombox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
						  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
						  													"VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
						  													"CARGO VAN"}));
			
			}
		}
		


	}

	public JComboBox getCategoryCombox() {
		return categoryCombox_1;
	}
	public JComboBox getTypeCombox() {
		return typeCombox_1;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public JDateChooser getDateChooserPick() {
		return dateChooserPick;
	}
	public JDateChooser getDateChooserReturn() {
		return dateChooserReturn;
	}
	public JTable getSearchTable() {
		return searchTable;
	}
	public JComboBox getEquipComboBox() {
		return equipComboBox_1;
	}
	public JLabel getLblAmount() {
		return lblAmount;
	}
	public JButton getBtnReserve() {
		return btnReserve;
	}
}


