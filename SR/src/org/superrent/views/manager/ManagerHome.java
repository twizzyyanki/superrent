package org.superrent.views.manager;

import org.superrent.controllers.*;
import org.superrent.application.MainApplicationWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public final class ManagerHome extends JFrame {

	private JPanel contentPane;
	private JPanel header;
	private JLabel welcomeUser;
	private JPanel left;
	private JButton forRentVehiclesButton;
	private JButton forSaleVehiclesButton;
	private JButton globalRatesButton;
	private JButton viewReportsButton;
	private JPanel right;
	private JPanel content;
	private JPanel footer;
	private JMenuBar menuBar;
	private JMenu mnMyAccount;
	private JMenuItem mntmManageAccount;
	private JMenuItem mntmLogout;
	private JLabel lblSuperrentManagerView;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHome frame = new ManagerHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerHome() {
		setTitle("SuperRent");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);		

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnMyAccount = new JMenu("My Account");
		menuBar.add(mnMyAccount);

		mntmManageAccount = new JMenuItem("Manage Account");
		mnMyAccount.add(mntmManageAccount);

		mntmLogout = new JMenuItem("Logout");
		mnMyAccount.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);	

		lblSuperrentManagerView = new JLabel("SuperRent Manager View");
		lblSuperrentManagerView.setFont(new Font("DejaVu Sans", Font.BOLD, 24));
		header.add(lblSuperrentManagerView,
				"cell 1 0,alignx center,aligny center");	

		welcomeUser = new JLabel("Welcome Manager");
		welcomeUser.setHorizontalAlignment(SwingConstants.RIGHT);
		header.add(welcomeUser, "cell 2 1,growx");

		left = new JPanel();
		contentPane.add(left, BorderLayout.WEST);
		
		forRentVehiclesButton = new JButton("For Rent Vehicles");
		forRentVehiclesButton.setPreferredSize(new Dimension(137, 40));
		forRentVehiclesButton.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		left.add(forRentVehiclesButton, "cell 0 1,grow");

		forSaleVehiclesButton = new JButton("For Sale Vehicles");
		forSaleVehiclesButton.setPreferredSize(new Dimension(135, 40));
		forSaleVehiclesButton.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		left.add(forSaleVehiclesButton, "cell 0 3,grow");

		globalRatesButton = new JButton("Set Global Rates");
		globalRatesButton.setPreferredSize(new Dimension(132, 40));
		globalRatesButton.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		left.add(globalRatesButton, "cell 0 5,grow");

		viewReportsButton = new JButton("View Reports");
		viewReportsButton.setPreferredSize(new Dimension(109, 40));
		viewReportsButton.setFont(new Font("DejaVu Sans", Font.BOLD, 15));	
		left.add(viewReportsButton, "cell 0 7,grow");	

		right = new JPanel();
		contentPane.add(right, BorderLayout.EAST);	

		content = new JPanel();
		contentPane.add(content, BorderLayout.CENTER);
		

		String[][] data = new String[2][3];
		for (int i = 0; i < data.length; i++) {
			Arrays.fill(data[i], "Yanki");
		}
	}

	public void addManageRatesActionListener(ManageRatesController listener) {
		System.out.println("Getting here");
		globalRatesButton.addActionListener(listener);

	}

	public void addForRentVehiclesButtonActionListener(
			ActionListener listener) {
		forRentVehiclesButton.addActionListener(listener);
	}

	public void addLogoutMenuActionListener(LoginController listener) {
		mntmLogout.addActionListener(listener);
	}

	public void setWelcomeUser(String text) {
		welcomeUser.setText(text);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
