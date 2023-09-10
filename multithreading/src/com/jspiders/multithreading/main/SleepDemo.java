package com.jspiders.multithreading.main;

public class SleepDemo {
	
	public static void main(String[] args) {
		String msg="This Is The Sleep";
		
	for (int i = 0; i < msg.length(); i++) {
			
			System.out.println(msg.charAt(i));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
    }	
}


