package org.superrent.views.manager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ManageRatesPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ManagerController managerController;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField membershipTxtField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_3;

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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Rental Rates", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category", "Type", "Hourly Rates", "Daily Rates"
			}
		));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Exceeded limit Rates", null, panel_4, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category", "Type", "Per Hour Rate", "Per Day Rate"
			}
		));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("All SuperRent Rates", null, panel_2, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category", "Type", "Per Hour Rate", "Per Day Rate"
			}
		));
		
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblMembershipFees = new JLabel("Membership Fees");
		panel_3.add(lblMembershipFees, "16, 6");
		
		membershipTxtField = new JTextField();
		panel_3.add(membershipTxtField, "20, 6, fill, default");
		membershipTxtField.setColumns(10);
		
		JLabel lblTax = new JLabel("Tax");
		panel_3.add(lblTax, "16, 8");
		
		textField = new JTextField();
		panel_3.add(textField, "20, 8, fill, default");
		textField.setColumns(10);
		
		JLabel lblMembershipRentalPoints = new JLabel("Membership Rental Points");
		panel_3.add(lblMembershipRentalPoints, "16, 10");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "20, 10, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblFuelRatesTank = new JLabel("Fuel Rates(10% tank)");
		panel_3.add(lblFuelRatesTank, "16, 12");
		
		textField_2 = new JTextField();
		panel_3.add(textField_2, "20, 12, fill, default");
		textField_2.setColumns(10);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(94);

	}

}
