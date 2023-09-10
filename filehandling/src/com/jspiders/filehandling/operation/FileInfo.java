package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;

public class FileInfo {
	
	public static void main(String[] args) {
		
		File file=new File("Demo.txt");
		
	if (file.exists()) {
			
			System.out.println("File already exists");
			
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File Created");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("File Not Created");
			}
		}	
		
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.err.println(file.length());
		
		if (file.canRead()) {
			System.out.println("File is readable");
			
		}else {
			System.out.println("File is not readable");
		}
		if (file.canWrite()) {
			System.out.println("File is writable");
			
		}else {
			System.out.println("File is not writable");
		}
		if (file.canExecute()) {
			System.out.println("File is Executable");
			
		}else {
			System.out.println("File is not Executable");
		}
	}

  }

