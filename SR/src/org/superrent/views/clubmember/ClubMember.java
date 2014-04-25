package org.superrent.views.clubmember;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JSplitPane;
import javax.swing.JLabel;

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.superrent.controllers.ClubMemberController;
import org.superrent.controllers.LoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class ClubMember extends JFrame {

	private JPanel contentPane;
	private final LoginController lc;
	private final ClubMemberController clubMemberController;
	private JPanel panelCenter;
	private ValidationGroup changePasswordGroup;
	
	/*	*//**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try {
	 * 
	 * ClubMember frame = new ClubMember(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ClubMember() {
		setTitle("Wellcome Club Member");
		clubMemberController = new ClubMemberController(this);
		lc = new LoginController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);

		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);

		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);

		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("170px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		JButton viewPoints = new JButton("View Points");
		viewPoints.addActionListener(clubMemberController);
		panelWest.add(viewPoints, "2, 4, fill, top");

		JButton updataProfile = new JButton("Update Profile");
		updataProfile.addActionListener(clubMemberController);
		panelWest.add(updataProfile, "2, 6");

		JButton changePassword = new JButton("Change Password");
		changePassword.addActionListener(clubMemberController);
		panelWest.add(changePassword, "2, 8");

		JButton checkReservation = new JButton("Check Reservation");
		checkReservation.addActionListener(clubMemberController);
		panelWest.add(checkReservation, "2, 10");

		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("23px"), }));

		JButton Logout = new JButton("Logout");
		Logout.setActionCommand("Log Out");
		Logout.addActionListener(lc);
		panelNorth.add(Logout, "50, 2, right, top");

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return
	 */
	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * @param newPanel
	 * @return
	 */
	public JPanel setCenterPanel(JPanel newPanel) {
		String className = newPanel.getClass().getSimpleName();

		if (className.equals("JChangePassword")) {
			ValidationPanel changePPanel = new ValidationPanel();
			changePPanel.setInnerComponent(newPanel);
			changePasswordGroup = changePPanel.getValidationGroup();
			changePasswordGroup.add(
					((JChangePassword) newPanel).getTextCurrentPassword(),
					StringValidators.REQUIRE_NON_EMPTY_STRING);
			changePasswordGroup.add(
					((JChangePassword) newPanel).getTextConfriPassword(),
					StringValidators.REQUIRE_NON_EMPTY_STRING);
			changePasswordGroup.add(
					((JChangePassword) newPanel).getTextNewPassword(),
					StringValidators.REQUIRE_NON_EMPTY_STRING);
			panelCenter = changePPanel;
			contentPane.add(panelCenter, BorderLayout.CENTER);
		} else {

			panelCenter = newPanel;
			contentPane.add(panelCenter, BorderLayout.CENTER);
		}
		return panelCenter;
	}

	public ValidationGroup getChangePasswordGroup() {
		return changePasswordGroup;
	}
}
