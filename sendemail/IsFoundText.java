package com.sendemail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface IsFoundText {
	public default  boolean isFound(String data) throws FileNotFoundException{
		File file=new File("client.txt");
		Scanner s= new Scanner(file);
		
		while (s.hasNextLine()){
			String line=s.nextLine();
			if (line.equals(data)) {
				return true;
			}}
		return false;
			} 
}
