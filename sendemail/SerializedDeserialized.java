package com.sendemail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public interface SerializedDeserialized {
	public default void serilalized(Email email) {
		try {
			
			  FileOutputStream fout=new FileOutputStream("EmailObject.txt",true); 

			  
			  ObjectOutputStream out=new ObjectOutputStream(fout); 
			   
			  out.writeObject(email);    
			  out.flush();       
			  out.close();    
			  System.out.println("success");
			  
				
		}catch(Exception e){
				  System.out.println(e);
				  } 

			 }
	public default ArrayList<Email> deserializeEmailObj() throws FileNotFoundException, IOException, ClassNotFoundException{
		ArrayList<Email> emailObjects=new ArrayList<Email>();
		FileInputStream fis=new FileInputStream("EmailObject.txt");
		while(fis.available()!=0){
			ObjectInputStream in = new ObjectInputStream(fis);
	        Email email = (Email)in.readObject(); 
	        //System.out.println(email.getTo()+" "+email.getContent());
	        emailObjects.add(email);	
		
	}
		fis.close();
		//in.close();
		return emailObjects;
		}

}





