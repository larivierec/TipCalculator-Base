package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.TipSystem;

import controller.CalculateListener;
import controller.SubscribeAction;

public class MainPanel extends AbstractPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private CalculateListener button = new CalculateListener();
	String[] taxOptionsString = {"0.05", "0.10", "0.15"
                ,"0.20"};
	private JLabel inputLbl = new JLabel("Tax:");
	private JComboBox<String> taxCombo = new JComboBox<String>(taxOptionsString);
	private JLabel inputTipTax = new JLabel("Tip:");
	private JTextField inputTipTaxText = new JTextField("0.05");
	private JLabel inputTotalLbl = new JLabel("Total:");
	private JTextField inputTotalTxt = new JTextField("100");
	private JLabel outputTotalLbl = new JLabel("Final:");
	private JTextField outputTotalTxt = new JTextField("NEW TOTAL");
	private JButton convertButton = new JButton("Convert");
	
	//Sizes
	
	private int PREFERRED_HEIGHT = 20;
	private int PREFERRED_WIDTH = 150;
	
	
	//private JButton revertButton = new JButton();
	public MainPanel(int positionX, int positionY, int width, int height,
			MainFrame frame) {
		super(positionX, positionY, width, height, frame);
		// TODO Auto-generated constructor stub
        convertButton.addActionListener(new CalculateListener(taxCombo,inputTotalTxt,inputTipTaxText));
        inputLbl.setBounds(25, 30, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        taxCombo.setBounds(25, 60, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        inputTipTax.setBounds(25, 90, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        inputTipTaxText.setBounds(25, 120, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        inputTotalLbl.setBounds(25, 150, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        inputTotalTxt.setBounds(25, 180, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        outputTotalLbl.setBounds(25, 210, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        outputTotalTxt.setBounds(25, 240, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        convertButton.setBounds(25, 270, PREFERRED_WIDTH, PREFERRED_HEIGHT);
        
        //add to panel
        
        this.add(inputLbl);
        this.add(taxCombo);
        this.add(inputTipTax);
        this.add(inputTipTaxText);
        this.add(inputTotalLbl);
        this.add(inputTotalTxt);
        this.add(outputTotalLbl);
        this.add(outputTotalTxt,BorderLayout.SOUTH);
        
        
        ButtonPanel convertButtonPanel = new ButtonPanel(25,270,PREFERRED_WIDTH,PREFERRED_HEIGHT,this);
        convertButtonPanel.add(convertButton);
        this.add(convertButtonPanel,BorderLayout.SOUTH);
        subscribe();
	}
	public class ButtonPanel extends AbstractPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ButtonPanel(int positionX, int positionY, int width,
				int height, MainPanel frame) {
			super(positionX, positionY, width, height, frame);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			changeOutputTxt();
			repaint();
			System.out.println("MainPanel:: Change Text has been invoked.");
		}
		
	}
	public void subscribe() {
		System.out.println("MainPanel:: Subscription has been started.");
		SubscribeAction.subscribeToModel(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		//changeOutputTxt();
		System.out.println("MainPanel:: Update has been called.");
		changeOutputTxt((Double)arg);
		repaint();
	}
	private void changeOutputTxt(double newVal) {
		outputTotalTxt.setText(Double.toString(newVal));
		System.out.println("MainPanel:: Change Text has updated the box.");
	}
	private void changeOutputTxt() {
		String temp = Double.toString(TipSystem.getInstance().getNewTotal());
		outputTotalTxt.setText(temp);
		System.out.println("MainPanel:: Change Text has updated the box.");
	}
}
