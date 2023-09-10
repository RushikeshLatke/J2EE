package com.jspiders.multithreading.resource;

public class Ticket {
	
	private int availableTicket;
	
	public synchronized void ticketBooking(int ticketBooking) {
		
		System.out.println(" Trying to Book "+ticketBooking+" Ticket ");
		
		if(availableTicket<ticketBooking) {
			
			System.out.println(" Ticket Booking for "+ticketBooking+" Seats are not available Your ticket is in waiting...! ");
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		availableTicket-=ticketBooking;
		System.out.println(" Ticket Booking For "+ticketBooking+" seats Confirm");
		System.out.println(" "+availableTicket+" Tickets Available ");
		
	}
	
	 public synchronized void ticketCancel(int ticketCancel) {
		 
		 
		 availableTicket+=ticketCancel;
		 System.out.println(" "+availableTicket+" tickets Available");
		 this.notifyAll();
		 
		 
	 }

}
