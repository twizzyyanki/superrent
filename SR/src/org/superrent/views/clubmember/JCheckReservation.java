package org.superrent.views.clubmember;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javax.swing.JLabel;
import javax.swing.JButton;

import org.superrent.controllers.ClubMemberController;
/*test*/
public class JCheckReservation extends JPanel {
	private JTable table;
	private JDateChooser fromDate;
	private JDateChooser toDate;

	/**
	 * This panel is for clubmember to check reservation
	 */
	public JCheckReservation(ClubMemberController clubMemberController) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(56dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(56dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(36dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(160dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblFrom = new JLabel("From:");
		add(lblFrom, "2, 2");
		
		fromDate = new JDateChooser();
		add(fromDate, "4, 2, fill, fill");
		
		JLabel lblTo = new JLabel("To:");
		add(lblTo, "6, 2");
		
		toDate = new JDateChooser();
		add(toDate, "8, 2, fill, fill");
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(clubMemberController);
		add(searchButton, "10, 2");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 4, 7, 1, default, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Confirmation No.", "Pick Up Date", "Drop Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(table);

	}

	public JTable getTable() {
		return table;
	}
	public JDateChooser getFromDate() {
		return fromDate;
	}
	public JDateChooser getToDate() {
		return toDate;
	}
}
