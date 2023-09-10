package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Ticket;
import com.jspiders.multithreading.thread.Irctc;
import com.jspiders.multithreading.thread.Passanger;

public class TicketMain {
	
	public static void main(String[] args) {
		
		Ticket ticket=new Ticket();
		Passanger passanger=new Passanger(ticket);
		Irctc irctc=new Irctc(ticket);
		
		passanger.start();
		irctc.start();
		
		
	}

}
