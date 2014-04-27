package org.superrent.views.clerk;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.toedter.calendar.JDateChooser;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.superrent.controllers.ClerkController;

public class ClerkSearchVehicle extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDateChooser calendar1 = new JDateChooser();
	private JDateChooser calendar2 = new JDateChooser();
	JComboBox<Object> comboBox;
	JComboBox<Object> comboBox_1;
	private JComboBox<String> comboBox_2= new JComboBox<String>();
	private final JLabel lblCategory = new JLabel("Category");
	private final JLabel lblType = new JLabel("Type");
	private final JLabel lblFrom = new JLabel("From");
	private final JLabel lblTo = new JLabel("To");
	private final JTable table = new JTable();
	private final JButton btnSearch = new JButton("Search");
	private final JScrollPane scrollPane = new JScrollPane();;
	
	/**
	 * Create the panel.
	 */
	
	public ClerkSearchVehicle() 
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(48dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(23dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(38dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(11dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(12dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(27dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(29dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(26dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));	
		
		JLabel lblLocation = new JLabel("Location");
		add(lblLocation, "2, 2, right, default");
		
		String[] type={"ALL", "ECONOMY","COMPACT","MID-SIZE",
			  "STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
			  "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
			  "CARGO VAN"};
		
		String[] category={"ALL","CAR","TRUCK"};
		
		comboBox = new JComboBox<Object>(category);
		
		
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String item = (String)comboBox.getSelectedItem();
				if(item.equalsIgnoreCase("CAR")){
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] { "All","ECONOMY","COMPACT","MID-SIZE",
							  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
							  													"VAN"}));
				}
				else if(item.equalsIgnoreCase("TRUCK")){
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"All","24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
							  												   "CARGO VAN"}));
				}
				else if(item.equalsIgnoreCase("ALL")){
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
							  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
							  													"VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
							  													"CARGO VAN"}));
				}
			}
		});
		
		String[] location={"ALL","VANCOUVER"};
		comboBox_2.setModel(new DefaultComboBoxModel<String>(location));
		
		add(comboBox_2, "4, 2, fill, default");
		
		add(lblCategory, "6, 2, right, default");
		
		add(comboBox, "8, 2, fill, default");
		
		add(lblType, "10, 2, right, default");
		comboBox_1 = new JComboBox<Object>(type);
		
		
		add(comboBox_1, "12, 2, fill, default");
		
		add(lblFrom, "14, 2, right, default");
		
		add(calendar1,"16, 2, 4, 1, fill, default");
		
		add(lblTo, "20, 2, right, default");
		
		add(calendar2,"22, 2, 9, 1, fill, default");
		
		add(btnSearch, "4, 4");
		
		add(scrollPane, "3, 5, 27, 2, fill, fill");
		scrollPane.setViewportView(table);
		
	}
	
	
	
	public JDateChooser getCalendar1() 
	{
		return calendar1;
	}
	
	public JDateChooser getCalendar2()
	{
		return calendar2;
	}
	
	public void searchActionListener(ClerkController clerk)
	{
		btnSearch.addActionListener(clerk);
	}

}
