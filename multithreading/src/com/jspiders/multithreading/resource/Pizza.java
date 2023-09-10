package com.jspiders.multithreading.resource;

public class Pizza {
	
	private int availablepizza;
	
	public synchronized void orderPizza(int orderedPizza) {
		
		System.out.println(" Trying to order "+orderedPizza+" Pizza ");
		
		if(availablepizza<orderedPizza)
		{
			System.out.println(orderedPizza+" pizza not available "+" Please wait....!");
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		availablepizza-=orderedPizza;
		
		System.out.println(orderedPizza+"Pizza Delivered");
		System.out.println(availablepizza+"Pizza Available");
		
		
	}
	
	public synchronized void bakePizza(int bakedPizza) {
		System.out.println(" Baking "+bakedPizza+" Pizza ");
		availablepizza+=bakedPizza;
		System.out.println(availablepizza+" Pizza Baked ");
		System.out.println(availablepizza+" Pizza available ");
		this.notifyAll();
	}
	

}
