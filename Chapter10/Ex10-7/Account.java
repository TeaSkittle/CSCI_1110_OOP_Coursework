// Author: Travis Dowd
// Date: 4-24-2020
// Chapter 10, exercise 10-7

package exercise;

import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annuallInterestRate = 0;
	Date dateCreated = new Date();	
	// Constructor Methods
	public Account() { }
	public Account( int id, double balance ) {
		this.id = id;
		this.balance = balance;
	}
	// Getters
	public int getId() {
		return id;
	}
	public double getBalance( ) {
		return balance;
	}
	public double getAnnuallInterestRate() {
		return annuallInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		double interest = this.annuallInterestRate / 100;
		double total = interest / 12;
		return total;
	}
	public double getMonthlyInterest() {
		return this.balance * getMonthlyInterestRate();
	}
	// Setters
	public void setId( int id ) {
		this.id = id;
	}
	public void setBalance( double balance ) {
		this.balance = balance;
	}
	public void setAnnuallInterestRate( double annuallInterestRate ) {
		this.annuallInterestRate = annuallInterestRate;	
	}
	// Other methods
	public double withdraw( double amount ) {
		balance -= amount; 
		return balance;
	}
	public double deposit( double amount ) {
		balance += amount;
		return balance;
	}
}
