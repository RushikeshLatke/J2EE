package com.jspiders.multithreading.thread;

public class MyThread3 extends Thread{
	
	@Override
	public void run() {
		
		
		System.out.println("Name of thread"+getName());
		System.out.println("Priority of thread"+this.getPriority());
	}
	
	

}
