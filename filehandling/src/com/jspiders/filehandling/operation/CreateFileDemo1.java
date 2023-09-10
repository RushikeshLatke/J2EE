package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo1 { //DefaultPath

	public static void main(String[] args) {
		File file=new File("Demo.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
