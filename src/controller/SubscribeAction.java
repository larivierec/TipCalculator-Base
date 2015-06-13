package controller;

import model.TipSystem;
import view.AbstractPanel;

public class SubscribeAction {

	public SubscribeAction() {
		// TODO Auto-generated constructor stub
	}
	static public void subscribeToModel(AbstractPanel ap) {
		System.out.println("SubscribeActive:: Subscribtion has been bridged.");
		TipSystem ts = TipSystem.getInstance();
		ts.setSubscription(ap);
		
	}
}
