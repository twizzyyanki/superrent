package org.superrent.views.general;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.superrent.controllers.MakeReservationController;

public class cancelReservationPanel extends JPanel {
	private JTextField confirmationNoTextField;
	private MakeReservationController mrc;
	private JLabel lblCancelInfo;

	/**
	 * Create the panel.
	 */
	public cancelReservationPanel(MakeReservationController mrc) {
		this.mrc = mrc;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblYourConfirmationNo = new JLabel("Your Confirmation No.");
		add(lblYourConfirmationNo, "4, 10, center, default");
		
		confirmationNoTextField = new JTextField();
		add(confirmationNoTextField, "6, 10, fill, default");
		confirmationNoTextField.setColumns(10);
		
		lblCancelInfo = new JLabel("");
		add(lblCancelInfo, "4, 18, 3, 1");
		
		JButton btnCancel = new JButton("Confirm to cancel");
		add(btnCancel, "6, 20");
		btnCancel.addActionListener(this.mrc);

	}

	public JTextField getConfirmationNoTextField() {
		return confirmationNoTextField;
	}
	public JLabel getLblCancelInfo() {
		return lblCancelInfo;
	}
}
