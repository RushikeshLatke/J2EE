package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {
	
	public static void main(String[] args)throws IOException {
		
		File file=new File("Demo1.txt");
		
		if (file.exists()) {
			
			try {
				
				FileOutputStream fileOutputStream=new FileOutputStream(file);
				fileOutputStream.write(20);
				System.out.println("Data Added in File Demo1");
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
	}else {
		
			   file.createNewFile();
			   System.out.println("File Demo1 is Created");
			   FileOutputStream fileOutputStream=new FileOutputStream(file);
				fileOutputStream.write(20);
				System.out.println("Data Added in File Demo1");
				fileOutputStream.close();
		
		   
	}

  }
}
