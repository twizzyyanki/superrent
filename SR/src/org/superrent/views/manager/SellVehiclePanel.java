package org.superrent.views.manager;

import javax.swing.JButton;
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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellVehiclePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable sellTable;
	ManagerController managerController;
	JButton btnSellVehicle = new JButton("Sell");

	/**
	 * Create the panel.
	 * @param managerController 
	 */
	public SellVehiclePanel(ManagerController managerController) {
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
				ColumnSpec.decode("max(77dlu;default)"),},
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Sell Vehicle List");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label, "16, 4, center, default");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 10, 31, 1, fill, fill");
		
		sellTable = new JTable();
		scrollPane.setViewportView(sellTable);
		sellTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Register Number", "Selling Price", "For Sale From"
			}
		));
		sellTable.getColumnModel().getColumn(0).setPreferredWidth(107);
		sellTable.getColumnModel().getColumn(2).setPreferredWidth(88);
		
		JButton btnEditSellingPrice = new JButton("Change Price");
		add(btnEditSellingPrice, "14, 12");
		btnEditSellingPrice.addActionListener(managerController);
		
		
		add(btnSellVehicle, "16, 12, center, default");
		
		btnSellVehicle.addActionListener(managerController);
		
		JButton btnTorent = new JButton("To-Rent");
		add(btnTorent, "18, 12");
		btnTorent.addActionListener(managerController);

	}
	
	public JTable getSellTable() {
		return sellTable;
	}

	public void setSellTable(JTable sellTable) {
		this.sellTable = sellTable;
	}


	
}
