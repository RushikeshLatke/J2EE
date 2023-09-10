package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Ticket;

public class Irctc extends Thread {
	
	private Ticket ticket;
	
	public Irctc(Ticket ticket) {
		this.ticket=ticket;
	}
	
	public void run() {
		
		ticket.ticketCancel(15);
	}
	
	

}
