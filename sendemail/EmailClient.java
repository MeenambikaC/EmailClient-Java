package com.sendemail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class EmailClient implements CreateEmailClientTxtFile,CheckMail,IsFoundText,SerializedDeserialized{

	private String type;
	private String name;
	private String email;
	public static int count=0;
	private ArrayList<Email> emailObject=new ArrayList<Email>();

	public EmailClient(String type,String name, String email) throws FileNotFoundException {
		
		if (checkMail(email)) {
			this.type=type;
			this.name=name;
			this.email=email;
			//getCount();
			//count++;
			//write();
		}
		else {
			System.out.println("Invalid email address");
			return;
			//TODO get details again -make logic 
			//TODO get a logic to break here
		}}
		


	public static void intialize() {
		try {
	        File Obj = new File("count.txt");
	        Scanner Reader = new Scanner(Obj);
	            String data = Reader.nextLine();
	            count=Integer.parseInt(data);

	        Reader.close();
	 
	    }
	    catch (FileNotFoundException e) {
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
	    }
	}
	public void write() {
		try {
			FileWriter writer = new FileWriter("count.txt",false);

			writer.write(String.valueOf(count));
			writer.write("\n");
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
			}
		}

	@Override
	public void addDetails(String data) {
		// TODO Auto-generated method stub
		FileWriter writer = null;
		try {
			writer = new FileWriter("client.txt",true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (!isFound(data)) {
				//System.out.println("DD class");
				getCount();
				count++;
				write();
				writer.write(data);
				//System.out.println(count);
				writer.write("\n");
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getCount() {
		intialize();
		return count;
	}
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public String getEmail() {
		return this.email;
	}

	
}
