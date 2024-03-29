package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import org.superrent.controllers.MakeReservationController;

import javax.swing.JButton;

import com.jgoodies.forms.factories.FormFactory;

public class MakeReservationPage extends JFrame {

	private JPanel contentPane;
	private final MakeReservationController mrc;
	private JPanel panelCenter;

	/**
	 * Create the frame.
	 */
	
	public MakeReservationPage() {
		setTitle("Reservation");
		mrc = new MakeReservationController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 601);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				RowSpec.decode("default:grow"),}));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("130px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JButton searchVbtn = new JButton("Home Page");
		panelNorth.add(searchVbtn, "2, 2");
		searchVbtn.setActionCommand("Home Page");
		searchVbtn.addActionListener(mrc);
		
		JButton btnCancelReservation = new JButton("Cancel Reservation");
		panelNorth.add(btnCancelReservation, "4, 2, center, default");
		btnCancelReservation.addActionListener(this.mrc);
		
		JButton btnLoginPage = new JButton("Login Page");
		panelNorth.add(btnLoginPage, "6, 2");
		btnLoginPage.addActionListener(mrc);
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
	
		//virtual click home page button
		searchVbtn.doClick();

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

	public JPanel setCenterPanel(JPanel newPanel){
		panelCenter = newPanel;
		contentPane.add(panelCenter, BorderLayout.CENTER);
		return panelCenter;
	}

}
