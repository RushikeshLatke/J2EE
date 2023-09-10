package com.jspiders.multithreading.resource;

public class Account {
	private int balance;
	
	public Account(int balance) {
		
		
		this.balance=balance;
	}
	
	public int checkBalance() {
		
		return balance;
	}
	
	public void deposit(int amount) {
		
		System.out.println("trying to deposit"+amount+"Rs");
		balance+=amount;
		System.out.println("Deposit successfull");
		System.out.println("Account : "+checkBalance());
	}
	
	public void withdraw(int amount) {
		
		System.out.println("Trying to withdraw"+amount+"Rs");
		
		if (balance>=amount) {
			
			balance-=amount;
			
			System.out.println("Withdraw Successfull");
			System.out.println("Account : "+checkBalance());
			
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}

}
