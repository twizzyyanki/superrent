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
		
		JDateChooser dateChooserPick = new JDateChooser();
		add(dateChooserPick, "6, 4, fill, fill");
		
		JLabel lblReturnDate = new JLabel("Return Date");
		add(lblReturnDate, "10, 4, center, default");
		
		JDateChooser dateChooserReturn = new JDateChooser();
		add(dateChooserReturn, "12, 4, fill, fill");
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "4, 6, center, default");
		
		JComboBox<String> categoryBox = new JComboBox<String>();
		categoryBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Car", "Truck"}));
		add(categoryBox, "6, 6, fill, default");
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "10, 6, center, default");
		
		JComboBox<String> TypeBox = new JComboBox<String>();
		TypeBox.setModel(new DefaultComboBoxModel(new String[] {"ALL", "ECONOMY", "COMPACT", "MID-SIZE", "STANDARD", "FULL-SIZE", "PREMIUM", "LUXURY", "SUV", "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", "CARGO VAN"}));
		add(TypeBox, "12, 6, fill, default");
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "4, 8, center, default");
		
		JComboBox<String> LocationBox = new JComboBox<String>();
		LocationBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Vancouver"}));
		add(LocationBox, "6, 8, fill, default");
		
		JButton btnSearch = new JButton("Search");
		add(btnSearch, "12, 8");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 12, 13, 1, fill, fill");
		
		searchTable = new JTable();
		searchTable.setToolTipText("");
		searchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Location", "Category", "Type", "Rate"
			}
		));
		scrollPane.setViewportView(searchTable);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(mrc);
		
		JLabel lblEquip = new JLabel("Add additional equipment");
		lblEquip.setToolTipText("Please select vehicle first");
		
		add(lblEquip, "4, 14");
		
		JComboBox equipComboBox = new JComboBox();
		equipComboBox.setToolTipText("Please select vehicle first");
		equipComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		add(equipComboBox, "6, 14, fill, default");
		
		JLabel lblEstamited = new JLabel("Estimated cost:");
		add(lblEstamited, "4, 16");
		
		JLabel lblAmount = new JLabel("amount");
		add(lblAmount, "6, 16");
		add(btnReserve, "12, 18, center, default");

	}

}
