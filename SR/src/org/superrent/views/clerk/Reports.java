package org.superrent.views.clerk;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;


import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.superrent.controllers.ReportController;
import java.awt.Font;

public class Reports extends JPanel {
	private JComboBox reportType;
	private JDateChooser startDate;
	private JDateChooser endDate;
	private JButton btnGenerateReport;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private final ReportController rc;
	private JLabel reportMessage;

	/**
	 * Create the panel.
	 */
	public Reports() {
		rc = new ReportController(this);		
		setBackground(UIManager.getColor("Panel.background"));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblNewLabel = new JLabel("Reports are generated in excel and saved on the desktop");
		lblNewLabel.setForeground(Color.RED);
		add(lblNewLabel, "4, 2, 7, 1, center, default");
		
		lblNewLabel_1 = new JLabel("Reservation Reports");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		add(lblNewLabel_1, "4, 4, 7, 1, center, bottom");
		
		reportType = new JComboBox();
		reportType.setModel(new DefaultComboBoxModel(new String[] {"Reserved Vehicles", "Returned Vehicles", "Rented Vehicles", "Cancelled Reservations"}));
		add(reportType, "4, 6, left, default");
		
		startDate = new JDateChooser();
		startDate.setMaxSelectableDate(new Date());
		startDate.setDate(new Date());
		add(startDate, "6, 6, fill, top");
		
		endDate = new JDateChooser();
		endDate.setMaxSelectableDate(new Date());
		endDate.setDate(new Date());
		add(endDate, "8, 6, fill, top");
		
		btnGenerateReport = new JButton("Generate");
		btnGenerateReport.addActionListener(rc);
		add(btnGenerateReport, "10, 6");		
		
		reportMessage = new JLabel("");
		add(reportMessage, "4, 8, 7, 1, center, default");
	}

	public JComboBox getReportType() {
		return reportType;
	}
	public String getStartDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = dateFormat.format(startDate.getDate());
		return startDateString;
	}
	public String getEndDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String endDateString = dateFormat.format(endDate.getDate());
		return endDateString;
	}
	
/*	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					JFrame m = new JFrame();
					m.setSize(650, 300);
					Reports r = new Reports();
					r.setSize(400, 400);
					m.getContentPane().add(r);
					
					
					m.setVisible(true);
					
					System.out.println("Hello there");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	} */
	public JLabel getReportMessage() {
		return reportMessage;
	}
}
