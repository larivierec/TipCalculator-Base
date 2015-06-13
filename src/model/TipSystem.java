package model;
import java.util.ArrayList;
import java.util.Observable;

import view.AbstractPanel;

public class TipSystem extends Observable {

ArrayList<Integer> percentageList = new ArrayList<Integer>();
ArrayList<Tip> tipList = new ArrayList<Tip>();
int percentage;
double newTotal;
static private TipSystem ts;

	/***    DEFALT CONSTRUCTOR   ***/
	private TipSystem(){
		if (checkExistingPreferences()) {
			// First connect to database
			// Get preferences
			// Import preferences from DB to List
		}
		else {
			defaultPercentage();
		}
	}
	
	static public TipSystem getInstance(){
		if(ts == null){
			ts = new TipSystem();
		}
		return ts;
	}
	
	/***    PUBLIC METHODS   ***/
	public void createTip(double percentage, double tipTax, double total){
		Tip tempTip= new Tip(total, percentage,tipTax);
		
		tipList.add(tempTip);
		System.out.println("TipSystem:: Tip has been created.");
		newTotal = calculateTip(tempTip);
		this.setChanged();
		notifyObservers(newTotal);
		System.out.println("TipSystem:: Tip has been notified.");
		// Subscribe Tip to the observer(notify)
	}
	public double calculateTip(Tip currentTip) {
		System.out.println("TipSystem:: Tip has been calculated.");
		return (currentTip.getPrice()*currentTip.getGovTax())+currentTip.getPrice()*currentTip.getTipTax();
	}
	public double calculateTotal(Tip currentTip){
		System.out.println("TipSystem:: Tip total has been calculated.");
		return (calculateTip(currentTip) + currentTip.getPrice());
	}
	
	// Get the tips information and send it to the client's email.
	public void sendMail() {
		
	}
	public double getNewTotal(){
		return newTotal;
	}
	public void setSubscription(AbstractPanel ap) {
		addObserver(ap);
		System.out.println("TipSystem:: Subscription has been set.");
	}
	/***    PRIVATE METHODS   ***/
	@SuppressWarnings("unused")
	private int getTipListSize(){
		return tipList.size();
	}
	private void defaultPercentage(){
		this.percentageList.add(5);
		this.percentageList.add(10);
		this.percentageList.add(15);
		this.percentageList.add(20);
	}
	private boolean checkExistingPreferences(){
		return true;
	}
	

}
