package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	
       public static void main(String[] args) {
    	   File file=new File("Demo.txt");
    	   
    	   if (file.exists()) {
    		   
    		   try {
				FileWriter fileWriter=new FileWriter(file);
			    fileWriter.write("Namaste World");
			    System.out.println("Data  Written in File ");
			    fileWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {
			try {
				file.createNewFile();
				System.out.println("File is Created");
				FileWriter fileWriter=new FileWriter(file);
				fileWriter.write("Namaste World");
			    System.out.println("Data  Written in File ");
			    fileWriter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
        
        

}
