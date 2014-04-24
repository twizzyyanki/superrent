package org.superrent.views.superadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.JTextField;

import org.superrent.controllers.LoginController;
import org.superrent.controllers.SystemAdminController;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class SystemAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panelCenter;
	private SearchUserPanel sup;
	private final SystemAdminController sac;
	private final LoginController lc;

	/**
	 * Create the frame.
	 */
	public SystemAdmin() {
		setTitle("System Administrator");
		sac = new SystemAdminController(this);
		lc = new LoginController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("351px"),
				ColumnSpec.decode("69px"),
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),}, 
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(lc);
		panelNorth.add(btnLogout, "26, 2, right, top");
		
		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("170px"),},
			new RowSpec[] {
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
		
		JButton btnSearchUser = new JButton("Search User");
		panelWest.add(btnSearchUser, "1, 1, fill, fill");
		btnSearchUser.addActionListener(sac);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(sac);
		panelWest.add(btnAddUser, "1, 3, fill, fill");
		
		
		JButton btnSearchVehicle = new JButton("Search Vehicle");
		panelWest.add(btnSearchVehicle, "1, 5, fill, fill");
		btnSearchVehicle.addActionListener(sac);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		panelWest.add(btnUpdateProfile, "1, 7, fill, fill");
		btnUpdateProfile.addActionListener(sac);
		
		JButton btnChangePassword = new JButton("Change Password");
		panelWest.add(btnChangePassword, "1, 9, fill, fill");
		btnChangePassword.addActionListener(sac);
		
		JButton btnAsClerk = new JButton("As Clerk");
		panelWest.add(btnAsClerk, "1, 11");
		btnAsClerk.addActionListener(sac);
		
		JButton btnAsManager = new JButton("As Manager");
		panelWest.add(btnAsManager, "1, 13");
		btnAsManager.addActionListener(sac);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		
		setSup(new SearchUserPanel(sac));
		panelCenter = sup.getValidationPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
	
	}
    public JPanel getMainPanel(){
    	return contentPane;
    }
    
	public JPanel getPanelCenter() {
		return panelCenter;
	}
	
	public void setPanelCenter(JPanel newJpanel) {
		panelCenter = newJpanel;
	}
	public SearchUserPanel getSup() {
		return sup;
	}
	public void setSup(SearchUserPanel sup) {
		this.sup = sup;
	}
}
