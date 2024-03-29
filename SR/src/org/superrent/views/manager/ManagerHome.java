package org.superrent.views.manager;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.superrent.controllers.LoginController;
import org.superrent.controllers.ManagerController;
import org.superrent.views.clerk.ClerkHome;
import org.superrent.views.clerk.Reports;

import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;


public class ManagerHome extends JFrame {

	/**
	 * 
	 */
	private final LoginController lc;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddVehicle = new JButton("Add Vehicle");
	JButton btnSearchVehicle = new JButton("Search Vehicle");
	JButton btnSearch = new JButton("Search");
	JButton btnChangeRates = new JButton("Change Rates");
	JButton btnSellVehicle = new JButton("Sell Vehicle");
	JButton btnReports = new JButton("Reports");
	JButton btnClerkScreen = new JButton("Clerk View");
	JComboBox<String> comboBox_1 = new JComboBox<String>();
	private JMenuItem mntmLogout;
	
	
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane sellScrollPane = new JScrollPane();
	private JTable searchTable, sellTable;
	ManagerController managerController = new ManagerController(this);
	SellVehiclePanel sellVehicleListPanel = new SellVehiclePanel(managerController);
	SearchVehiclePanel searchVehicleListPanel = new SearchVehiclePanel(managerController);
	AddVehiclePanel addVehiclePanel = new AddVehiclePanel(managerController);
	ManageRatesPanel manageRatesPanel = new ManageRatesPanel(managerController);
	EditVehicleInfoDialog editVehicleInfoDialog = new EditVehicleInfoDialog(managerController);
	SellingVehicleDialog sellingVehicleDialog = new SellingVehicleDialog(managerController);
	EditForSalePrice editForSalePriceDialog = new EditForSalePrice(managerController);
	UpdateProfileForManager updateProfileForManager = new UpdateProfileForManager(managerController);
	Reports reportsPanel = new Reports();
	ClerkHome clerkHome = new ClerkHome();
	ChangePasswordManagerPanel changePasswordPanel = new ChangePasswordManagerPanel(managerController);

	public EditVehicleInfoDialog getEditVehicleInfoDialog() {
		return editVehicleInfoDialog;
	}

	public void setEditVehicleInfoDialog(EditVehicleInfoDialog editVehicleInfoDialog) {
		this.editVehicleInfoDialog = editVehicleInfoDialog;
	}

	/**
	 * Create the frame.
	 */
	public ManagerHome() {
		lc = new LoginController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 569);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);
		menuBar.add(btnClerkScreen);
		btnClerkScreen.addActionListener(managerController);

		JLabel lblWelcomeBackManager = new JLabel(
				"                                                                                         Welcome Back Manager!!!!!!                                                                    ");
		menuBar.add(lblWelcomeBackManager);

		JMenu mnProfile = new JMenu("Profile");
		menuBar.add(mnProfile);

		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.setActionCommand("Edit Profile Details");
		mntmEdit.addActionListener(managerController);
		mnProfile.add(mntmEdit);

		JMenuItem mntmChangePassword = new JMenuItem("change Password");
		mntmChangePassword.addActionListener(managerController);
		mnProfile.add(mntmChangePassword);

		mntmLogout = new JMenuItem("Logout");
		mntmLogout.setActionCommand("Log Out");
		mntmLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mntmLogout);
		
		mntmLogout.addActionListener(lc);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[92px,grow]", "[28px][][][][][][][][-7.00][][]"));

		
		// all panel buttons
		
		
		panel.add(btnSellVehicle, "cell 0 3,grow");
		btnSellVehicle.addActionListener(managerController);
		
		panel.add(btnSearchVehicle, "cell 0 4,growx");	
		btnSearchVehicle.requestFocusInWindow();
		btnSearchVehicle.addActionListener(managerController);
		
		panel.add(btnChangeRates, "cell 0 5,growx");
		btnChangeRates.addActionListener(managerController);
		
		panel.add(btnAddVehicle, "cell 0 2,growx,aligny top");
		btnAddVehicle.addActionListener(managerController);
		
		btnReports.addActionListener(managerController);
			
		panel.add(btnReports, "cell 0 6,growx");
		
		//creating panel1
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new MigLayout("", "[][][]", "[]"));

		
		editVehicleInfoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		sellingVehicleDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		editForSalePriceDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		//adding panel5 and panel6 to panel2
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(100, 10));
		GroupLayout groupLayout = new GroupLayout(panel_2);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(groupLayout);
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(searchVehicleListPanel).addComponent(addVehiclePanel).addComponent(sellVehicleListPanel).
								addComponent(manageRatesPanel).addComponent(reportsPanel).addComponent(changePasswordPanel).addComponent(updateProfileForManager));
		groupLayout.setVerticalGroup(groupLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(searchVehicleListPanel).addComponent(addVehiclePanel).addComponent(sellVehicleListPanel).addComponent(manageRatesPanel)
					.addComponent(reportsPanel).addComponent(changePasswordPanel).addComponent(updateProfileForManager));
		
		
		managerController.getVehicle(this);
		
		//making the add vehicle panel invisible
		addVehiclePanel.setEnabled(false);
		addVehiclePanel.setVisible(false);
		sellVehicleListPanel.setEnabled(false);
		sellVehicleListPanel.setVisible(false);
		manageRatesPanel.setVisible(false);
		reportsPanel.setVisible(false);
		clerkHome.setVisible(false);
		changePasswordPanel.setVisible(false);
		updateProfileForManager.setVisible(false);
	}	

	public SellingVehicleDialog getSellingVehicleDialog() {
		return sellingVehicleDialog;
	}

	public void setSellingVehicleDialog(SellingVehicleDialog sellingVehicleDialog) {
		this.sellingVehicleDialog = sellingVehicleDialog;
	}

	public SearchVehiclePanel getSearchVehicleListPanel() {
		return searchVehicleListPanel;
	}

	public void setSearchVehicleListPanel(SearchVehiclePanel searchVehicleListPanel) {
		this.searchVehicleListPanel = searchVehicleListPanel;
	}

	public SellVehiclePanel getSellVehicleListPanel() {
		return sellVehicleListPanel;
	}

	public void setSellVehicleListPanel(SellVehiclePanel sellVehicleListPanel) {
		this.sellVehicleListPanel = sellVehicleListPanel;
	}

	public JTable getSellTable() {
		return sellTable;
	}

	public void setSellTable(JTable sellTable) {
		this.sellTable = sellTable;
	}

	//all setters and getters
	public JComboBox<String> getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox<String> comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
	
	public JTable getTable_1() {
		return searchTable;
	}

	public void setTable_1(JTable table_1) {
		this.searchTable = table_1;
	}
	
	public JButton getBtnAddVehicle() {
		return btnAddVehicle;
	}

	public void setBtnAddVehicle(JButton btnAddVehicle) {
		this.btnAddVehicle = btnAddVehicle;
	}

	public JButton getBtnSearchVehicle() {
		return btnSearchVehicle;
	}

	public void setBtnSearchVehicle(JButton btnSearchVehicle) {
		this.btnSearchVehicle = btnSearchVehicle;
	}

	public JButton getBtnChangeRates() {
		return btnChangeRates;
	}

	public void setBtnChangeRates(JButton btnChangeRates) {
		this.btnChangeRates = btnChangeRates;
	}

	public JButton getBtnSellVehicle() {
		return btnSellVehicle;
	}

	public void setBtnSellVehicle(JButton btnSellVehicle) {
		this.btnSellVehicle = btnSellVehicle;
	}

	public AddVehiclePanel getAddVehiclePanel() {
		return addVehiclePanel;
	}

	public void setAddVehiclePanel(AddVehiclePanel addVehiclePanel) {
		this.addVehiclePanel = addVehiclePanel;
	}

	public ManageRatesPanel getManageRatesPanel() {
		return manageRatesPanel;
	}

	public void setManageRatesPanel(ManageRatesPanel manageRatesPanel) {
		this.manageRatesPanel = manageRatesPanel;
	}

	public EditForSalePrice getEditForSalePriceDialog() {
		return editForSalePriceDialog;
	}

	public Reports getReportsPanel() {
		return reportsPanel;
	}

	public ChangePasswordManagerPanel getChangePasswordPanel() {
		return changePasswordPanel;
	}

	public UpdateProfileForManager getUpdateProfileForManager() {
		return updateProfileForManager;
	}

	public void setUpdateProfileForManager(
			UpdateProfileForManager updateProfileForManager) {
		this.updateProfileForManager = updateProfileForManager;
	}

	public void setChangePasswordPanel(
			ChangePasswordManagerPanel changePasswordPanel) {
		this.changePasswordPanel = changePasswordPanel;
	}

	public ClerkHome getClerkHome() {
		return clerkHome;
	}

	public void setClerkHome(ClerkHome clerkHome) {
		this.clerkHome = clerkHome;
	}

	public void setReportsPanel(Reports reportsPanel) {
		this.reportsPanel = reportsPanel;
	}

	public void setEditForSalePriceDialog(EditForSalePrice editForSalePriceDialog) {
		this.editForSalePriceDialog = editForSalePriceDialog;
	}

}
