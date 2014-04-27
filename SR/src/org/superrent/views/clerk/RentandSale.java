package org.superrent.views.clerk;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.ClerkController;

public class RentandSale extends JPanel 
{
	private JTable table;
	private JComboBox<String> comboBox = new JComboBox<String>();

	/**
	 * Create the panel.
	 */
	public RentandSale() 
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(92dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(88dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(55dlu;default)"),
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
				RowSpec.decode("max(63dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(69dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblRentAndSale = new JLabel("VEHICLES FOR SALE");
		lblRentAndSale.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblRentAndSale, "4, 2");
		
		JLabel lblSearchType = new JLabel("Category");
		add(lblSearchType, "4, 4, left, default");
		getComboBox().setActionCommand("Category");
		
		
		add(getComboBox(), "6, 4, left, default");
		String[] search={"ALL","CAR","TRUCK"};
		getComboBox().setModel(new DefaultComboBoxModel<String>(search));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 8, 7, 5, fill, fill");
		
		setTable(new JTable());
		scrollPane.setViewportView(getTable());
		
		
	}
	
	public void searchvehicleActionListener(ClerkController clerk)
	{
		getComboBox().addActionListener(clerk);
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
