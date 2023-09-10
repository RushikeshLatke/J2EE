package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo2 {
	
	public static void main(String[] args) {
		 File file=new File( "D:/J2EEfile/Demo2.txt");
		 
		 try {
			file.createNewFile();
			System.out.println("File Created");
		} catch (IOException e) {
			
			e.printStackTrace();
			
			System.out.println("File Not Created");
		}
	}

}
