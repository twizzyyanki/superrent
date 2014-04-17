package org.superrent.views.clerk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import org.superrent.controllers.ClerkController;

public class ClerkHome extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField textField;
	private JTable table;

	JButton btnRefresh = new JButton("Refresh");
	
	JScrollPane scrollPane = new JScrollPane();
	
	JButton btnRent = new JButton("Rent");
	
	JButton btnReturn = new JButton("Return");
	
	JButton btnManageReservation = new JButton("Manage Reservation");
	
	JButton btnAddClubmember = new JButton("Add ClubMember");
	
	JButton btnUpdateProfile = new JButton("Update Profile");
	
	JButton btnChangePassword = new JButton("Change Password");
	
	JButton btnLogout = new JButton("Logout");
	
	public JPanel panel = new JPanel();
	
	JButton btnSearchReservation = new JButton("Search Reservation");
	
	JButton btnViewRentalAgreement = new JButton("View Rental Agreement");
	
	ClerkController c;
	/**
	 * Create the frame.
	 */
	public ClerkHome() 
	{
		c = new ClerkController(this);

		setTitle("Clerk Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRent)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReturn)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnManageReservation)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAddClubmember)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnViewRentalAgreement))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(135)
							.addComponent(btnUpdateProfile)
							.addGap(66)
							.addComponent(btnChangePassword)
							.addGap(66)
							.addComponent(btnLogout)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRent)
						.addComponent(btnReturn)
						.addComponent(btnManageReservation)
						.addComponent(btnAddClubmember)
						.addComponent(btnViewRentalAgreement))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateProfile)
						.addComponent(btnChangePassword)
						.addComponent(btnLogout)))
		);
		GroupLayout gl_panel = new GroupLayout(getPanel());
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnSearchReservation)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRefresh))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchReservation)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnRefresh))
		);
		
		setTable(new JTable());
		scrollPane.setViewportView(getTable());
		getPanel().setLayout(gl_panel);
		
		contentPane.setLayout(gl_contentPane);
		
		getTable().setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
					"Confirmation Number", "pickDate","dropDate","charges"}
			));
	}
	
	public void RefreshbtnActionListener(ClerkController clerk)
	{
		btnRefresh.addActionListener(clerk);
	}
	
	public void RentbtnActionListener(ClerkController clerk)
	{
		btnRent.addActionListener(clerk);
	}
	
	public void ReturnbtnActionListener(ClerkController clerk)
	{
		btnReturn.addActionListener(clerk);
	}
	
	public void AddClubMemberbtnActionListener(ClerkController clerk)
	{
		btnAddClubmember.addActionListener(clerk);
	}
	
	public void SearchReservationbtnActionListener(ClerkController clerk)
	{
		btnSearchReservation.addActionListener(clerk);
	}
	
	public void UpdateProfileActionListener(ClerkController clerk)
	{
		btnUpdateProfile.addActionListener(clerk);
	}
	
	public void ViewRentalAgreemenetActionListener(ClerkController clerk)
	{
		btnViewRentalAgreement.addActionListener(clerk);
	}
	
	public void ManageReservationActionListener(ClerkController clerk)
	{
		btnManageReservation.addActionListener(clerk);
	}
	
	public void ViewRentalAgreementActionListener(ClerkController clerk)
	{
		btnViewRentalAgreement.addActionListener(clerk);
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
