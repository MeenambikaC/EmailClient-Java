package com.sendemail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MailMain {

	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException{
		// TODO Auto-generated method stub
		//C:\Users\Meena\eclipse-workspace\SendEmail -file location
		 EmailProcess process=new EmailProcess();

		 boolean quit=false;
		 while(!quit){
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("Enter option type: \n"
			 + "1 - Adding a new recipient\n"
			 + "2 - Sending an email\n"
			 + "3 - Printing out all the recipients who have birthdays\n"
			 + "4 - Printing out details of all the emails sent\n"
			 + "5 - Printing out the number of recipient objects in the application");
			 System.out.println("enter choices");
			 int option = scanner.nextInt();
			 scanner.nextLine();
			 switch(option){
			 case 1:
				 System.out.println("Enter Client Details:");
				 String dataClient= scanner.nextLine();
				 process.emailClients(dataClient);
				 //System.out.println("here");
				 break;
			 case 2:
				 System.out.println("Enter details to send mail to: subject: content:");
				 String dataEmail= scanner.nextLine();
				 process.sendMailTo(dataEmail);
				 break;
				 
			 case 3:
				 System.out.println("Enter date to find birthday");
				 String Bday= scanner.nextLine();
				 process.namesOfBday(Bday);
				 break;
				 
			 case 4:
				 System.out.println("Enter date to find email");
				 String date= scanner.nextLine();
				 process.detailsOfEmailThatDay(date);;
				 break;
				 
			 case 5:
				 System.out.println("totol count of receptients "+ process.getcount());
				 break;
		     default:
		    	 	quit=true;
					break;
			 
			 }
			 
		 }
	}
}
