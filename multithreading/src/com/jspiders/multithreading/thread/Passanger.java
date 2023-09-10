package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Ticket;

public class Passanger extends Thread{
	
	private Ticket ticket;
	
	public Passanger(Ticket ticket) {
		
		this.ticket=ticket;
	}
	public void run() {
		ticket.ticketBooking(10);
	
	}


}
