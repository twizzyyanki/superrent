package org.superrent.views.general;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import org.superrent.controllers.MakeReservationController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ReservationSuccessDialog extends JDialog{
	private MakeReservationController mrc;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblGetCoNo;
	private JLabel lblGetLocation;
	private JLabel lblGetPickUpDate;
	private JLabel lblGetReturnDate;


	/**
	 * Create the dialog.
	 */
	public ReservationSuccessDialog(MakeReservationController mrc) {
		setTitle("Reservation confirmation");
		this.mrc = mrc;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(36dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
			JLabel lblYourConfirmationNo = new JLabel("Your Confirmation No:");
			contentPanel.add(lblYourConfirmationNo, "4, 4");
		}
		{
			lblGetCoNo = new JLabel("");
			contentPanel.add(lblGetCoNo, "6, 4, 3, 1, left, default");
		}
		{
			JLabel lblPickUpLocation = new JLabel("Pick up location");
			contentPanel.add(lblPickUpLocation, "4, 6");
		}
		{
			lblGetLocation = new JLabel("");
			contentPanel.add(lblGetLocation, "6, 6, 3, 1");
		}
		{
			JLabel lblPickUpDate = new JLabel("Pick Up Date:");
			contentPanel.add(lblPickUpDate, "4, 8");
		}
		{
			lblGetPickUpDate = new JLabel("");
			contentPanel.add(lblGetPickUpDate, "6, 8, 3, 1");
		}
		{
			JLabel lblReturnDate = new JLabel("Return Date:");
			contentPanel.add(lblReturnDate, "4, 10");
		}
		{
			lblGetReturnDate = new JLabel("");
			contentPanel.add(lblGetReturnDate, "6, 10, 3, 1");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{134, 54, 0, 0, 0};
			gbl_buttonPane.rowHeights = new int[]{31, 0, 23, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.insets = new Insets(0, 0, 5, 5);
				gbc_okButton.anchor = GridBagConstraints.NORTH;
				gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_okButton.gridx = 2;
				gbc_okButton.gridy = 1;
				buttonPane.add(okButton, gbc_okButton);
				okButton.addActionListener(this.mrc);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}


	public JLabel getLblGetCoNo() {
		return lblGetCoNo;
	}
	public JLabel getLblGetLocation() {
		return lblGetLocation;
	}
	public JLabel getLblGetPickUpDate() {
		return lblGetPickUpDate;
	}
	public JLabel getLblGetReturnDate() {
		return lblGetReturnDate;
	}
}
