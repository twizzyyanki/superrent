
package org.superrent.views.general;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.MakeReservationController;

import javax.swing.JSpinner;

public class SearchVReservationPanel extends JPanel implements ActionListener{
	private JTable searchTable;
	private MakeReservationController mrc;
	private JComboBox<String> categoryCombox_1;
	private JComboBox<String> typeCombox_1;
	private JButton btnSearch;
	private JDateChooser dateChooserPick;
	private JDateChooser dateChooserReturn;
	private JLabel lblAmount;
	private JButton btnReserve;
	private JLabel lblSearchInfo;
	private JScrollPane scrollPane;
	private JSpinner spinnerPickUp;
	private JSpinner spinnerDrop;
	private JButton btnEquip;
	private JLabel lblCad;
	
	/**
	 * Create the Reservation panel.
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
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPickUpDate = new JLabel("Pick up Date and Time");
		add(lblPickUpDate, "4, 4, center, default");
		
		dateChooserPick = new JDateChooser();
		dateChooserPick.setMinSelectableDate(new Date());
		dateChooserPick.setDate(new Date());
		add(dateChooserPick, "6, 4, fill, fill");
		
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE);
		spinnerPickUp = new JSpinner();
		spinnerPickUp.setModel(model);
		spinnerPickUp.setEditor(new JSpinner.DateEditor(spinnerPickUp, "HH:00"));
		
		add(spinnerPickUp, "14, 4");
		
		dateChooserReturn = new JDateChooser();
		dateChooserReturn.setMinSelectableDate(new Date());
		dateChooserReturn.setDate(new Date());
		add(dateChooserReturn, "6, 6, fill, fill");
		
		SpinnerDateModel model2 = new SpinnerDateModel();
		model2.setCalendarField(Calendar.MINUTE);
		spinnerDrop = new JSpinner();
		spinnerDrop.setModel(model2);
		spinnerDrop.setEditor(new JSpinner.DateEditor(spinnerDrop, "HH:00"));
		Calendar time  = Calendar.getInstance();
		
		add(spinnerDrop, "14, 6");
		
		JLabel lblReturnDate = new JLabel("Return Date and Time");
		add(lblReturnDate, "4, 6, center, default");
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory, "4, 8, center, default");
		
		categoryCombox_1 = new JComboBox<String>();
		categoryCombox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Car", "Truck"}));
		categoryCombox_1.addActionListener(this.mrc);
		add(categoryCombox_1, "6, 8, fill, default");
		
		JLabel lblType = new JLabel("Type");
		add(lblType, "12, 8, center, default");
		
		typeCombox_1 = new JComboBox<String>();
		typeCombox_1.setModel(new DefaultComboBoxModel(new String[] {"ALL", "ECONOMY", "COMPACT", "MID-SIZE", "STANDARD", "FULL-SIZE", "PREMIUM", "LUXURY", "SUV", "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", "CARGO VAN"}));
		typeCombox_1.addActionListener(this.mrc);
		add(typeCombox_1, "14, 8, fill, default");
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "4, 10, center, default");
		
		JComboBox<String> LocationBox = new JComboBox<String>();
		LocationBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Vancouver"}));
		LocationBox.addActionListener(this.mrc);
		add(LocationBox, "6, 10, fill, default");
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this.mrc);
		add(btnSearch, "14, 10");
		
		lblSearchInfo = new JLabel("");
		add(lblSearchInfo, "4, 12, 3, 1");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "4, 14, 15, 1, fill, fill");
		
		searchTable = new JTable();
		searchTable.setToolTipText("");
		searchTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category", "Type", "Brand", "RegNo"
			}
		));
		searchTable.getSelectionModel().addListSelectionListener(this.mrc);
		scrollPane.setViewportView(searchTable);
		
		btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(this.mrc);
		btnReserve.setEnabled(false);
		JLabel lblEquip = new JLabel("Add additional equipment");
		lblEquip.setToolTipText("Please select vehicle first");
		
		add(lblEquip, "4, 16");
		
		btnEquip = new JButton("choose equipment");
		btnEquip.addActionListener(this.mrc);
		btnEquip.setEnabled(false);
		add(btnEquip, "6, 16");
		
		JLabel lblEstamited = new JLabel("Estimated cost:");
		add(lblEstamited, "4, 18");
		
		lblAmount = new JLabel("0");
		add(lblAmount, "6, 18");
		
		lblCad = new JLabel("CAD");
		add(lblCad, "8, 18");

		add(btnReserve, "14, 20, center, default");

	}

	//Just for combo box actions
	//@Override
	public void actionPerformed(ActionEvent event) {
	
		


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

	public JLabel getLblAmount() {
		return lblAmount;
	}
	public JButton getBtnReserve() {
		return btnReserve;
	}
	public JLabel getLblSearchInfo() {
		return lblSearchInfo;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JSpinner getSpinnerPickUp() {
		return spinnerPickUp;
	}
	public JSpinner getSpinnerDrop() {
		return spinnerDrop;
	}
	public JButton getBtnEquip() {
		return btnEquip;
	}
}


