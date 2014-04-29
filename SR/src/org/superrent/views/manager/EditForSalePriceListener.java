package org.superrent.views.manager;

import java.awt.EventQueue;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;

public class EditForSalePriceListener implements DocumentListener{
	
	EditForSalePrice editForSalePrice;
	public EditForSalePriceListener(EditForSalePrice editForSalePrice){
		this.editForSalePrice = editForSalePrice;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		checkValidation();
		
	}

	private void checkValidation() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Problem validateAll = editForSalePrice.getGroup().performValidation();
				// System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					editForSalePrice.getOkButton()
							.setEnabled(true);
					editForSalePrice.revalidate();
					editForSalePrice.repaint();
					// System.out.println("Getting here");
				} else {
					if (validateAll.isFatal()) {
						editForSalePrice.getOkButton()
								.setEnabled(false);
					}
				}

			}
		});
	}
}
