package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.report.ReportManager;
import net.sf.jxls.report.ReportManagerImpl;
import net.sf.jxls.report.ResultSetCollection;
import net.sf.jxls.transformer.Configuration;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.superrent.application.DatabaseConnection;
import org.superrent.views.clerk.Reports;

public class ReportController implements ActionListener {

	Reports r;

	public ReportController(Reports r) {
		this.r = r;
	}

	public String generateReport(int reportType, String startDate,
			String endDate) {
		System.out.println("Start date and end date are " + startDate + "  "
				+ endDate);
		String templateFileName = "report.xls";
		String destFileName = null;
		String query = null;
		if (reportType == 0) {
			destFileName = System.getProperty("user.home") + "/Desktop"
					+ "/reservations.xls";
			query = "SELECT U.name, U.email, U.address, MR.confirmationNo, R.pickDate, R.dropDate, "
					+ "R.charges, V.regNo, V.category, V.brand FROM User U, MakeReservation MR, "
					+ "Vehicle V, Reservation R WHERE U.uid=MR.uid AND V.regNo = MR.regNo AND "
					+ "MR.confirmationNo=R.confirmationNo AND R.creationDate >= '"
					+ startDate
					+ "' AND "
					+ "R.creationDate <= '"
					+ endDate
					+ "'";

			System.out.println(query);
		}

		if (reportType == 1) {
			destFileName = System.getProperty("user.home") + "/Desktop"
					+ "/returned.xls";
			query = "SELECT U.name, U.email, U.address, MR.confirmationNo, R.pickDate, R.dropDate, "
					+ "R.charges, V.regNo, V.category, V.brand FROM User U, MakeReservation MR, "
					+ "Vehicle V, Reservation R WHERE U.uid=MR.uid AND V.regNo = MR.regNo AND "
					+ "MR.confirmationNo=R.confirmationNo AND R.dropDate >= '"
					+ startDate
					+ "' AND "
					+ "R.dropDate < '"
					+ endDate
					+ "' AND MR.status = 2";

			System.out.println(query);
		}

		if (reportType == 2) {
			destFileName = System.getProperty("user.home") + "/Desktop"
					+ "/rented.xls";
			query = "SELECT U.name, U.email, U.address, MR.confirmationNo, R.pickDate, R.dropDate, "
					+ "R.charges, V.regNo, V.category, V.brand FROM User U, MakeReservation MR, "
					+ "Vehicle V, Reservation R WHERE U.uid=MR.uid AND V.regNo = MR.regNo AND "
					+ "MR.confirmationNo=R.confirmationNo AND MR.date >= '"
					+ startDate
					+ "' AND "
					+ "MR.date <= '"
					+ endDate
					+ "' AND MR.status = 1";

			System.out.println(query);
		}
		
		if (reportType == 3) {
			destFileName = System.getProperty("user.home") + "/Desktop"
					+ "/rented.xls";
			query = "SELECT U.name, U.email, U.address, MR.confirmationNo, R.pickDate, R.dropDate, "
					+ "R.charges, V.regNo, V.category, V.brand FROM User U, MakeReservation MR, "
					+ "Vehicle V, Reservation R WHERE U.uid=MR.uid AND V.regNo = MR.regNo AND "
					+ "MR.confirmationNo=R.confirmationNo AND MR.date >= '"
					+ startDate
					+ "' AND "
					+ "MR.date <= '"
					+ endDate
					+ "' AND MR.status = 2";

			System.out.println(query);
		}

		String message = "";
		Connection con;
		try {
			con = DatabaseConnection.createConnection();

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			Map beans = new HashMap();
			ResultSetCollection rsc = new ResultSetCollection(rs, false);
			beans.put("user", rsc);
			XLSTransformer transformer = new XLSTransformer();
			try {
				transformer.transformXLS(templateFileName, beans, destFileName);
				message = "Your report is on your desktop";
			} catch (ParsePropertyException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			message = e1.getMessage();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			message = e1.getMessage();
		}
		return message;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Generate")) {
			System.out.println("Generate button clicked");
			try {
				if (new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(
						r.getEndDate()).compareTo(
						new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
								.parse(r.getStartDate())) >= 0) {
					String message = generateReport(r.getReportType()
							.getSelectedIndex(), r.getStartDate(),
							r.getEndDate());
					r.getReportMessage().setText(message);
				} else {
					r.getReportMessage()
							.setText(
									"Please input an end date that is after a start date");
				}
			} catch (ParseException e1) {
				r.getReportMessage().setText("Invalid dates given");
			}
		}
	}

}
