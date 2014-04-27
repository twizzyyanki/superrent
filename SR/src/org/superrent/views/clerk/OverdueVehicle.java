package org.superrent.views.clerk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class OverdueVehicle extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public OverdueVehicle()
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(307dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(33dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblOverDueVehicles = new JLabel("OVER DUE VEHICLES");
		lblOverDueVehicles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOverDueVehicles.setForeground(new Color(0, 0, 0));
		add(lblOverDueVehicles, "4, 2");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 4, 1, 3, fill, fill");
		
		setTable(new JTable());
		scrollPane.setViewportView(getTable());

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
