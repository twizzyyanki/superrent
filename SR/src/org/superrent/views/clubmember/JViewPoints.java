package org.superrent.views.clubmember;


import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import org.superrent.controllers.ClubMemberController;
/**
 * This class is the view points panel for the ClubMember class.
 * 
 * @c.pre Users clicks the view points button in the ClubMember UI.
 * @c.post This panel will show in the ClubMember UI BorderLayout.CENTER position.
 * @c.invariant clubMemberController 
 */
public class JViewPoints extends JPanel {

	private final ClubMemberController clubMemberController;
	private JLabel points;
	
	/**
	 * This is the constructor for this class. All the components in this panel will be set up.
	 * @param clubMemberController is the controller that will 
	 */
	public JViewPoints(ClubMemberController clubMemberController) {
		this.clubMemberController = clubMemberController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel totalPoints = new JLabel("Total Points:");
		add(totalPoints, "4, 4");
		
		points = new JLabel("");
		add(points, "6, 4");
		
		
		
		this.setVisible(true);
	
	}

	public JLabel getPoints() {
		return points;
	}
}
