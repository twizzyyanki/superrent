package org.superrent.views.clerk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.superrent.controllers.ClerkController;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ClerkHome extends JFrame
{

	private JPanel contentPane;
	JButton btnRent = new JButton("Rent");
	JButton btnReturn = new JButton("Return");
	JButton btnManageReservation = new JButton("Manage Reservation");

	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_4 = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton btnAddClubMember = new JButton("Add ClubMember");
	private final JButton btnViewRentalAgreement = new JButton("View Rental Agreement");
	private final JButton btnHome = new JButton("Home");
	private final JButton btnUpdateProfile = new JButton("Update Profile");
	private final JButton btnChangePassword = new JButton("Change Password");
	private final JButton btnLogout = new JButton("Logout");
	private final JButton btnSearchReservation = new JButton("Search Reservation");
	private JTextField textField;
	public JButton btnRefresh = new JButton("Refresh");
	ClerkController c;
	/**
	 * Create the frame.
	 */
	public ClerkHome() 
	{
		c=new ClerkController(this);
		setTitle("ClerkHome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("159px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		panel.add(btnRent, "2, 4, fill, top");
		
		
		panel.add(btnReturn, "2, 8, fill, default");
		
		
		panel.add(btnManageReservation, "2, 12, fill, center");
		
		panel.add(btnAddClubMember, "2, 16, fill, default");
		
		panel.add(btnViewRentalAgreement, "2, 20, fill, default");
		
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("97px"),
				ColumnSpec.decode("67px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default)"),
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
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("56px"),}));
		panel_1.add(btnHome, "4, 2, fill, top");
		
		panel_1.add(btnUpdateProfile, "8, 2, fill, top");
		
		panel_1.add(btnChangePassword, "12, 2, default, top");
		
		panel_1.add(btnLogout, "16, 2, default, top");
		panel_2.setAutoscrolls(true);
		
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		
		GroupLayout gl_panel_2 = new GroupLayout(getPanel_2());
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(161)
					.addComponent(btnSearchReservation)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRefresh)
					.addContainerGap(547, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchReservation)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnRefresh)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		
		getTable().setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
					"Confirmation Number", "pickDate","dropDate","charges","status"}
			));
		
		scrollPane.setViewportView(getTable());
		getPanel_2().setLayout(gl_panel_2);
		
		
		contentPane.add(panel_3, BorderLayout.EAST);
		
		contentPane.add(panel_4, BorderLayout.SOUTH);
	}


	public void SearchReservationbtnActionListener(ClerkController clerkController) 
	{
		btnSearchReservation.addActionListener(clerkController);
	}


	public void RentbtnActionListener(ClerkController clerkController)
	{
		btnRent.addActionListener(clerkController);
	}

	public void AddClubMemberbtnActionListener(ClerkController clerkController)
	{
		btnAddClubMember.addActionListener(clerkController);	
	}
	
	public void RefreshbtnActionListener(ClerkController clerkController) 
	{
		btnRefresh.addActionListener(clerkController);
	}


	public void HomebtnActionListener(ClerkController clerkController) 
	{
		btnHome.addActionListener(clerkController);
	}


	public void ReturnbtnActionListener(ClerkController clerkController)
	{
		btnReturn.addActionListener(clerkController);
	}


	public void UpdateProfileActionListener(ClerkController clerkController) 
	{
		btnUpdateProfile.addActionListener(clerkController);
		
	}


	public void ViewRentalAgreementActionListener(ClerkController clerkController) 
	{
		btnViewRentalAgreement.addActionListener(clerkController);
	}


	public void ManageReservationActionListener(ClerkController clerkController) 
	{
		btnManageReservation.addActionListener(clerkController);
	}

	public void ChangePasswordActionListener(ClerkController clerkController)
	{
		btnChangePassword.addActionListener(clerkController);
	}

	public JPanel getPanel_2() {
		return panel_2;
	}


	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel setCenterPanel(JPanel newPanel)
	{
		panel_2=newPanel;
		contentPane.add(panel_2, BorderLayout.CENTER);
		return panel_2;
	}

	public JTable getTable() {
		return table;
	}


	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
