package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.clubmember.JChangePassword;

public class ValidateJChangePassword implements DocumentListener {
	JChangePassword jcp;
		
	public ValidateJChangePassword(JChangePassword jcp) {
		this.jcp = jcp;
	}

	//@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
	}

	//@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
	}

	//@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
	}
	
	private void checkValidation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Problem validateAll = ((ClubMember)SwingUtilities.getWindowAncestor(jcp)).getChangePasswordGroup().performValidation();
				 System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					jcp.getConfirmButton().setEnabled(true);
					jcp.revalidate();
					jcp.repaint();
					 System.out.println("Getting here - after modifying jcp");
				} else {
					if (validateAll.isFatal()) {
						jcp.getConfirmButton().setEnabled(false);
					}
				}

			}
		});
	}

}