package org.superrent.views.general;

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

public class SearchVReservationPanel extends JPanel {
	private JTable searchTable;
	private MakeReservationController mrc;

	/**
	 * Create the panel.
	 */
	public SearchVReservationPanel(MakeReservationController mrc) {
		this.mrc = mrc;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Pick up Date");
		add(lblNewLabel, "4, 4, center, default");
		
		JDateChooser dateChooser = new JDateChooser();
		add(dateChooser, "6, 4, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Return Date");
		add(lblNewLabel_1, "10, 4, center, default");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		add(dateChooser_1, "12, 4, fill, fill");
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "4, 6, center, default");
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Car", "Truck"}));
		add(comboBox_1, "6, 6, fill, default");
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "10, 6, center, default");
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ALL", "ECONOMY", "COMPACT", "MID-SIZE", "STANDARD", "FULL-SIZE", "PREMIUM", "LUXURY", "SUV", "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", "CARGO VAN"}));
		add(comboBox_2, "12, 6, fill, default");
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "4, 8, center, default");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Vancouver"}));
		add(comboBox, "6, 8, fill, default");
		
		JButton btnSearch = new JButton("Search");
		add(btnSearch, "12, 8");
		
		JButton btnNewButton = new JButton("Reserve");
		add(btnNewButton, "4, 10, center, default");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 12, 13, 1, fill, fill");
		
		searchTable = new JTable();
		searchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Location", "Category", "Type", "Price"
			}
		));
		scrollPane.setViewportView(searchTable);

	}

}
