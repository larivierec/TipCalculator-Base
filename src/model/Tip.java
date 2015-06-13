package model;

public class Tip {
	private double priceOfObject;
	private double govTax;
	private double tipTax;
	
	
	/***    DEFALT CONSTRUCTOR   ***/
	public Tip (){
		this.priceOfObject = 20;
		this.govTax = 0.05;
		this.tipTax = 0.15;
	}
	public Tip(double price, double govTax, double tip){
		this.priceOfObject = price;
		this.govTax = govTax;
		this.tipTax = tip;
	}
	
	/***    PUBLIC METHODS   ***/
	public double getPrice(){
		return this.priceOfObject;
	}
	public void setPrice(double newPrice){
		this.priceOfObject = newPrice;
	}
	public void setTipTax(double newTip){
		this.tipTax = newTip;
	}
	public double getTipTax(){
		return this.tipTax;
	}
	public double getGovTax(){
		return this.govTax;
	}
	public void setGovTax(double newPercentage){
		this.govTax = newPercentage;
	}
	/***    PRIVATE METHODS   ***/
}
