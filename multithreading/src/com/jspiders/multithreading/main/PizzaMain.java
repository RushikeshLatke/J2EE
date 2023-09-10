package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Pizza;
import com.jspiders.multithreading.thread.Dominose;
import com.jspiders.multithreading.thread.Friends;

public class PizzaMain {
	
	public static void main(String[] args) {
		
		Pizza pizza=new Pizza();
		Friends friends=new Friends(pizza);
		Dominose dominose=new Dominose(pizza);
		
		friends.start();
		dominose.start();
	}

}
