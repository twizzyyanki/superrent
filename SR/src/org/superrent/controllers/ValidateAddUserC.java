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
	private boolean runVUC = false;
	private boolean isValid = false;
	private String text;
	private int count = 1;
	
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
		if (runVUC) {
			//runVUC = false;
			System.out.println("I'm in vaC");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					System.out.println(aup.getGroupCM());
					Problem validateAll = aup.getGroupCM().performValidation();
					// System.out.println("validate all is  " + validateAll);
					// validateAll == null && aup.getValidateAU().AddUserValid()
					if (validateAll == null) {
						isValid = true;
						System.out.println("VUC makes it true");
						//aup.getBtnAdd().setEnabled(true);
						// aup.revalidate();
						// aup.repaint();
						// System.out.println("Getting here");
					} else {
						if (validateAll != null) {
							if (validateAll.isFatal()) {
								//aup.getBtnAdd().setEnabled(false);
								System.out.println("VUC makes it false");
								if (count-- == 1){
									text = aup.getTextFieldUserName().getText();
									aup.getTextFieldUserName().setText("test");
									aup.getTextFieldUserName().setText(null);
									aup.getTextFieldUserName().setText(text);
									
									text = aup.getTextFieldMembershipNum().getText();
									aup.getTextFieldMembershipNum().setText("test");
									aup.getTextFieldMembershipNum().setText(null);
									aup.getTextFieldMembershipNum().setText(text);
								}
								isValid = false;
							}
						}
					}
	
				}
			});
		}
	}
	
	public void setRunVUC(boolean bl){
		runVUC = bl;
	}
	
	public boolean getRunVUC( ) {
		return runVUC;
	}
	
	public boolean AddUserValidC() {
		return isValid;
	}
	
	public void setAddUserValidC(boolean bl){
		isValid = bl;
	}
	 
}
