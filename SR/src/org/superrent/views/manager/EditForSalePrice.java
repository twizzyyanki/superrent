package org.superrent.views.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

public class EditForSalePrice extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField registerNumber;
	private JTextField price;
	ManagerController managerController;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			EditVehicleForSellDialog dialog = new EditVehicleForSellDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param managerController 
	 */
	public EditForSalePrice(ManagerController managerController) {
		this.managerController = managerController;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(1dlu;default)"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
		{
			JLabel lblChangeSellingPrice = new JLabel("Change Selling Price");
			contentPanel.add(lblChangeSellingPrice, "14, 4");
		}
		{
			JLabel lblRegisternumber = new JLabel("RegisterNumber");
			contentPanel.add(lblRegisternumber, "12, 8");
		}
		{
			registerNumber = new JTextField();
			registerNumber.setEnabled(false);
			contentPanel.add(registerNumber, "16, 8, left, center");
			registerNumber.setColumns(10);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			contentPanel.add(lblPrice, "12, 10");
		}
		{
			price = new JTextField();
			contentPanel.add(price, "16, 10, left, default");
			price.setColumns(10);
		}
		{
			JLabel lblYear = new JLabel("Year");
			contentPanel.add(lblYear, "12, 12");
		}
		{
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setEnabled(false);
			contentPanel.add(dateChooser, "16, 12, left, top");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("Confirm Change");
				buttonPane.add(okButton);
				okButton.addActionListener(managerController);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}

	public String getRegisterNumber() {
		return registerNumber.getText();
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber.setText(registerNumber);
	}

	public String getPrice() {
		return price.getText();
	}

	public void setPrice(String price) {
		this.price.setText(price);
	}

}
