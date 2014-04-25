package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.superadmin.AddUserPanel;

public class ValidateAddUserC implements DocumentListener {
	private AddUserPanel aup;
	private ValidateAddUserR vaR;
	private ValidateAddUser va;
	
	public ValidateAddUserC(AddUserPanel aup, ValidateAddUser va, ValidateAddUserR vaR) {
		this.aup = aup;
		this.va = va;
		this.vaR = vaR;
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
				System.out.println(aup.getGroupCM());
				Problem validateAll = aup.getGroupCM().performValidation();
				// System.out.println("validate all is  " + validateAll);
				if (validateAll == null && va.AddUserValid() && vaR.AddUserValidR()) {
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
