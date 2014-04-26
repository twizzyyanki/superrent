package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.superadmin.AddUserPanel;

public class ValidateAddUserR implements DocumentListener {

	private AddUserPanel aup;
	private ValidateAddUser va;
	//private boolean isValid;
	private boolean runVUR = false;
	
	public ValidateAddUserR(AddUserPanel aup, ValidateAddUser va) {
		this.aup = aup;
		this.va = va;
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
		
		if (runVUR){
			System.out.println("I'm in vaR");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					System.out.println(aup.getGroupR());
					Problem validateAll = aup.getGroupR().performValidation();
					// System.out.println("validate all is  " + validateAll);
					if (validateAll == null && runVUR) {
						//isValid = true;
						aup.getBtnAdd().setEnabled(true);
						aup.revalidate();
						aup.repaint();
						// System.out.println("Getting here");
					} else {
						if (validateAll.isFatal()) {
							//isValid = false;
							aup.getBtnAdd().setEnabled(false);
						}
					}
	
				}
			});
		}
	}
	/*
	public boolean AddUserValidR() {
		return isValid;
	}

	public void setUserValidR(boolean bl){
		isValid = bl;
	}
	*/
	public void setRunVUR(boolean bl){
		runVUR = bl;
	}
}
