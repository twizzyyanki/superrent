package org.superrent.views.clerk;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.superrent.controllers.ClerkController;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.ScrollPaneConstants;



public class AddCM extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnAddMember;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	
	public AddCM()
	{
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Name");
		
		JLabel label_1 = new JLabel("Email id");
		
		JLabel label_3 = new JLabel("Phone Number");
		
		JTextArea textArea = new JTextArea();
		
		JLabel label_2 = new JLabel("Adress");
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("70px"),
				ColumnSpec.decode("36px"),
				ColumnSpec.decode("93px"),
				ColumnSpec.decode("151px"),
				ColumnSpec.decode("2px"),},
			new RowSpec[] {
				RowSpec.decode("57px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("23px"),
				RowSpec.decode("14px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("36px"),
				RowSpec.decode("21px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("23px"),}));
		add(label_3, "2, 6, left, center");
		add(label_1, "2, 4, left, center");
		add(label, "2, 2, left, center");
		add(label_2, "2, 8, left, top");
		add(textField_1, "4, 4, 3, 1, fill, top");
		add(textField, "4, 2, 3, 1, fill, top");
		add(textField_2, "4, 6, 3, 1, fill, top");
		add(scrollPane, "4, 8, 2, 3");
		
		btnAddMember = new JButton("Add Member");
		add(btnAddMember, "4, 13, left, top");
	}
	public void addmemberActionListener(ClerkController clerk)
	{
		btnAddMember.addActionListener(clerk);
	}
	
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
