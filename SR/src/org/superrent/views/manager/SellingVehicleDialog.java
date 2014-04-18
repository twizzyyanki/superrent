package org.superrent.views.manager;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class SellingVehicleDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField regNumberTxt;
	private JTextField brandTxt;
	private JTextField price;
	JComboBox<String> categoryCombox = new JComboBox<String>();
	JComboBox<String> typeCombox = new JComboBox<String>();
	ManagerController managerController;

	
	/**
	 * Create the dialog.
	 */
	public SellingVehicleDialog(ManagerController managerController) {
		this.managerController = managerController;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("434px"),},
			new RowSpec[] {
				RowSpec.decode("228px"),
				RowSpec.decode("33px"),}));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "1, 1, fill, fill");
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("152px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("67px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
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
			JLabel lblNewLabel = new JLabel("For Sale");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblNewLabel, "2, 4, center, top");
		}
		{
			JLabel lblRegisterNumber = new JLabel("Register Number");
			contentPanel.add(lblRegisterNumber, "1, 8, right, center");
		}
		{
			regNumberTxt = new JTextField();
			contentPanel.add(regNumberTxt, "4, 8, fill, default");
			regNumberTxt.setColumns(10);
			regNumberTxt.setEnabled(false);
		}
		{
			JLabel lblCategory = new JLabel("Category");
			contentPanel.add(lblCategory, "1, 10, right, center");
		}
		{
			typeCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"ECONOMY", "COMPACT", "MID-SIZE", "STANDARD", "FULL-SIZE", "PREMIUM", "LUXURY", "SUV", "VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", "CARGO VAN"}));
			typeCombox.setEnabled(false);
			contentPanel.add(typeCombox, "4, 10, fill, default");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Type");
			contentPanel.add(lblNewLabel_1, "1, 12, right, default");
		}
		{
			categoryCombox.setModel(new DefaultComboBoxModel<String>(new String[] {"CAR", "TRUCK"}));
			categoryCombox.setEnabled(false);
			contentPanel.add(categoryCombox, "4, 12, fill, default");
		}
		{
			JLabel lblBrand = new JLabel("Brand");
			contentPanel.add(lblBrand, "1, 14, right, default");
		}
		{
			brandTxt = new JTextField();
			contentPanel.add(brandTxt, "4, 14, fill, default");
			brandTxt.setColumns(10);
			brandTxt.setEnabled(false);
		}
		{
			JLabel lblForSalePrice = new JLabel("For Sale Price");
			contentPanel.add(lblForSalePrice, "1, 16, right, default");
		}
		{
			price = new JTextField();
			contentPanel.add(price, "4, 16, fill, default");
			price.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "1, 2, fill, top");
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(managerController);
					
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
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
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	public JComboBox<String> getCategoryCombox() {
		return categoryCombox;
	}

	public void setCategoryCombox(String categoryCombox) {
		this.categoryCombox.setSelectedItem(categoryCombox);
	}

	public JComboBox<String> getTypeCombox() {
		return typeCombox;
	}

	public void setTypeCombox(String typeCombox) {
		this.typeCombox.setSelectedItem(typeCombox);
	}
	
	public String getRegNumberTxt() {
		return regNumberTxt.getText();
	}

	public String getBrandTxt() {
		return brandTxt.getText();
	}

	public void setBrandTxt(String brandTxt) {
		this.brandTxt.setText(brandTxt);
	}

	public void setRegNumberTxt(String regNumberTxt) {
		this.regNumberTxt.setText(regNumberTxt);
	}


	public String getPrice() {
		return price.getText();
	}


	public void setPrice(String price) {
		this.price.setText(price);
	}

}
