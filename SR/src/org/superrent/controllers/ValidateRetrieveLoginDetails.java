/**
 * 
 */
package org.superrent.controllers;

import java.awt.EventQueue;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.views.general.RetrieveLoginDetails;

/**
 * @author welcome
 *
 */
public class ValidateRetrieveLoginDetails implements DocumentListener {
	RetrieveLoginDetails jd;
	
	public ValidateRetrieveLoginDetails(RetrieveLoginDetails jd) {
		this.jd = jd;
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
				Problem validateAll = jd.getGroup().performValidation();
				 System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					jd.getOkButton().setEnabled(true);
					jd.revalidate();
					jd.repaint();
					 System.out.println("Getting here");
				} else {
					if (validateAll.isFatal()) {
						jd.getOkButton().setEnabled(false);
					}
				}

			}
		});
	}

}
