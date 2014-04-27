package org.superrent.views.clerk;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;


@SuppressWarnings("serial")
public class MembershipNum extends JDialog
{
	private final JPanel contentPanel = new JPanel();
	private JLabel lblName = new JLabel("Name");
	JLabel lblMembershipNumber = new JLabel("MemberShip Number ");
	
	JLabel lblWelcome = new JLabel("Welcome");
	
	JLabel lblYouAreNow = new JLabel("You are now a Clum Member of SuperRent");
	
	JLabel lblWith = new JLabel("with");
	
	private JLabel lblNumber = new JLabel("Number");
	
	JLabel label = new JLabel("....!!!!");
	
	

	/**
	 * Create the dialog.
	 */
	public MembershipNum() {
		setTitle("Congrats...You are now a member");
		setBounds(100, 100, 472, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("56px"),
				ColumnSpec.decode("19px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("27px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("64px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("37px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("90px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("64px"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		lblWelcome.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblWelcome, "3, 2, 3, 1, left, top");
		lblName.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblName, "8, 2, 3, 1, left, top");
		lblYouAreNow.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblYouAreNow, "3, 4, 10, 1, left, top");
		lblWith.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblWith, "3, 6, left, top");
		lblMembershipNumber.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblMembershipNumber, "3, 8, 7, 1, left, top");
		lblNumber.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(lblNumber, "10, 8, 3, 1, right, top");
		label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		contentPanel.add(label, "14, 8, left, top");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}



	public JLabel getLblName() {
		return lblName;
	}



	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}



	public JLabel getLblNumber() {
		return lblNumber;
	}



	public void setLblNumber(JLabel lblNumber) {
		this.lblNumber = lblNumber;
	}
}
