package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.superadmin.AddUserPanel;

public class ValidateAddUserR implements DocumentListener {

	private AddUserPanel aup;
	private ValidateAddUser va;
	private boolean isValid;
	private boolean runVUR = false;
	private String text;
	private int count = 1;
	
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
			//runVUR = false;
			System.out.println("I'm in vaR");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					System.out.println(aup.getGroupR());
					Problem validateAll = aup.getGroupR().performValidation();
					// System.out.println("validate all is  " + validateAll);
					System.out.println("RunVUC() "+aup.getValidateAUC().getRunVUC());
					System.out.println("RunVUR"	+ runVUR);
					System.out.println("ValidateVUR"+validateAll+" Validate"+aup.getValidateAU().AddUserValid());
					//validateAll == null && !aup.getValidateAUC().getRunVUC() && aup.getValidateAU().AddUserValid()
					if (validateAll == null ) {
						isValid = true;
						System.out.println("VUR makes it true");
						//aup.getBtnAdd().setEnabled(true);
						// aup.revalidate();
						// aup.repaint();
						// System.out.println("Getting here");
					} else {
						if (validateAll != null) {
							if (validateAll.isFatal()) {
								isValid = false;
								System.out.println("VUR makes it false");
								if (count-- == 1) {
									text = aup.getTextFieldUserName().getText();
									aup.getTextFieldUserName().setText("test");
									aup.getTextFieldUserName().setText(null);
									aup.getTextFieldUserName().setText(text);
									
									text = aup.getTextFieldEmail().getText();
									aup.getTextFieldEmail().setText("test");
									aup.getTextFieldEmail().setText(null);
									aup.getTextFieldEmail().setText(text);
								}
								// aup.getBtnAdd().setEnabled(false);
							}
						}
					}
	
				}
			});
		}
	}
	
	public boolean AddUserValidR() {
		return isValid;
	}

	public void setUserValidR(boolean bl){
		isValid = bl;
	}
	
	public void setRunVUR(boolean bl){
		runVUR = bl;
	}
	
	public boolean getRunVUR() {
		return runVUR;
	}
}
