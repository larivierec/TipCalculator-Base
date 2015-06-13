package controller;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.MainFrame;


public class CalculateListener implements AbstractAction{

	private JComboBox<String> taxCombo;
	private JTextField inputTotalTxt;
	private JTextField inputTipTaxText;
	
	public CalculateListener(MainFrame mainFrame){
		
	}
	
	public CalculateListener(JComboBox<String> taxCombo, JTextField inputTotalTxt, JTextField inputTipTaxText) {
		this.taxCombo = taxCombo;
		this.inputTotalTxt = inputTotalTxt;
		this.inputTipTaxText = inputTipTaxText;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double gov = Double.parseDouble(taxCombo.getSelectedItem().toString());
		double tip = Double.parseDouble(inputTipTaxText.getText().toString());
		double total = Integer.parseInt(inputTotalTxt.getText().toString());
		tipSystem.createTip(gov,tip,total);
	}

}
