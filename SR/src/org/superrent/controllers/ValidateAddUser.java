package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.clubmember.JChangePassword;
import org.superrent.views.superadmin.AddUserPanel;

public class ValidateAddUser implements DocumentListener {
	private AddUserPanel aup;
	
	public ValidateAddUser(AddUserPanel aup) {
		this.aup = aup;
	} 
	
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
		
	}

	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
		
	}

	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		checkValidation();
	}
	
	private void checkValidation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println(aup.getGroup());
				Problem validateAll = aup.getGroup().performValidation();
				// System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					aup.getBtnAdd().setEnabled(true);
					aup.revalidate();
					aup.repaint();
					// System.out.println("Getting here");
				} else {
					if (validateAll.isFatal()) {
						aup.getBtnAdd().setEnabled(false);
					}
				}

			}
		});
	}

}
