package com.sendemail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class EmailProcess implements FormatDate,SerializedDeserialized,ReadTextFile {
	//ArrayList<WishBirthday> WishingList= new ArrayList<WishBirthday>();;
	private Date dateOfToday = new Date();
	private Email email;
	private EmailClient emailclient;
	//private SerializeDeserialize obj;
	private SerializedDeserialized obj1;
	private ArrayList<Email> emails=new ArrayList<Email>();
	private static String wished="false";
	public EmailProcess() throws FileNotFoundException, ParseException {
		getWished();
		if (wished.equals("false")) {
			//System.out.println(wished);
			WishBirthdayToday();
			wished="true";
			write();
			}
	}
	//TODO here the objects of class are going to be created according to the type!!!
	
	public EmailClient emailClients(String data) throws FileNotFoundException{
		EmailClient client = null;
		String[] itemsReceptient=data.split(",");

		String[] val=itemsReceptient[0].split(":");
		String type=val[0];
		if(type.equals("Official")){
			Officials officialClient=new Officials(val[0],val[1],itemsReceptient[1], itemsReceptient[2]);
			client=officialClient;
		}
		else if(type.equals("Personal")){
			PersonalFriends PersonalClient=new PersonalFriends(val[0],val[1],itemsReceptient[1], itemsReceptient[2],itemsReceptient[3]);
			client = PersonalClient;
		}
		else if (type.equals("Office_friend")){
			//System.out.println("emailProcess class");
			OfficialFriends OfficialFriendClient=new OfficialFriends(val[0],val[1],itemsReceptient[1], itemsReceptient[2],itemsReceptient[3]);
			client = OfficialFriendClient;
		} 
		return client;
	}
	public void WishBirthdayToday() throws ParseException, FileNotFoundException {
		ArrayList<WishBirthday> WishingList=wishingList();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd");//no need of age no?
        String stringDate1= format.format(dateOfToday);
		for (int i = 0; i < WishingList.size(); i++) {

	        EmailClient client=(EmailClient) WishingList.get(i);

				if (client.getType().equals("Personal")){//TODO 
					PersonalFriends personalFriends = (PersonalFriends) client;
					String date2=personalFriends.getDOB();
					Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date2);
			        String stringDate2=format.format(date1);
					if (stringDate1.equals(stringDate2)) {
						personalFriends.wish(client.getEmail());
					}
				}
				if (client.getType().equals("Office_friend")) {//TODO 
					OfficialFriends officialFriends = (OfficialFriends) client;

					String date2=officialFriends.getDOB();
					Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date2);
			        String stringDate2=format.format(date1);
					if (stringDate1.equals(stringDate2)) {
						officialFriends.wish(client.getEmail());
						
					}
				}
				
			}

			}  
	
	public void namesOfBday(String date) throws ParseException, FileNotFoundException {//TODO check for invalid date
		ArrayList<WishBirthday> WishingList=wishingList();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd");//no need of age no?
        Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
        String stringDate1= format.format(date1);
        //System.out.println("here");
		for (int i = 0; i < WishingList.size(); i++) {
			EmailClient client=(EmailClient) WishingList.get(i);
			String stringDate2 = null,stringDate3=null;
			//System.out.println(client.getType());
			//System.out.println(WishingList.size());
			if (client.getType().equals("Personal")){
				//System.out.println(EmailClient.getCount());
				PersonalFriends personalFriends =(PersonalFriends) client;
				//System.out.println(EmailClient.getCount());
				String date2=personalFriends.getDOB();
				Date date3=new SimpleDateFormat("yyyy/MM/dd").parse(date2);
		        stringDate2= format.format(date3);		     
		        if (stringDate2.equals(stringDate1)) {
					System.out.println(client.getName());
				}
			}
			if (client.getType().equals("Office_friend")) {//TODO 
				OfficialFriends officialFriends = (OfficialFriends) client;
				String date2=officialFriends.getDOB();
				Date date3=new SimpleDateFormat("yyyy/MM/dd").parse(date2);
		        stringDate3= format.format(date3);
		        //System.out.println(client.getName());
		        if (stringDate3.equals(stringDate1)) {
					System.out.println(client.getName());
				}
			}
			
	        
		}
	}
	public void detailsOfEmailThatDay(String date) throws ParseException, IOException, ClassNotFoundException {

		ArrayList<Email> emails = new ArrayList<Email>();

		emails=deserializeEmailObj();
		for(int i = 0; i < emails.size(); i++) {
			email=emails.get(i);
			//System.out.println(email.getDate());
			if (email.getDate().equals(date) ){
				System.out.println(email.getTo()+" "+email.getSubject()+" "+email.getContent()+" "+email.getDate());
			}
		}
		
		
		
	}
	public ArrayList<EmailClient> readobj() throws FileNotFoundException {
	ArrayList<EmailClient>emailClient=new ArrayList<EmailClient>();
	emailClient= readTxtFile("client.txt");
	return emailClient;
	}
	
	public ArrayList<WishBirthday> wishingList() throws FileNotFoundException{
		ArrayList<WishBirthday> list=new ArrayList<WishBirthday>();
		ArrayList<EmailClient>client=readobj();
		for (int i=0;i<client.size();i++) {
			EmailClient cli=client.get(i);
			//System.out.println(client.size());
			if (cli.getType().equals("Personal")) {
				PersonalFriends friends=(PersonalFriends)cli;
				list.add(friends);
			}
			if (cli.getType().equals("Office_friend")) {
				OfficialFriends friends=(OfficialFriends)cli;
				list.add(friends);
			}
		}
		
		
		return list;
		
	}
	
	public void sendMailTo (String data) throws ParseException, FileNotFoundException {
		String[] items=data.split(",");
		String EmailAd=items[0];
		String subject=items[1];
		String content=items[2];
		Email sendMail=new Email(EmailAd,subject,content);
		serilalized(sendMail);
	}
	public int getcount() {
		return EmailClient.getCount();
	}
	
	public static void intialize() {
		try {
	        File Obj = new File("wished.txt");
	        Scanner Reader = new Scanner(Obj);
	            String data = Reader.nextLine();
	            wished=data;
	        Reader.close();
	 
	    }
	    catch (FileNotFoundException e) {
	        System.out.println("An error has occurred.");
	        e.printStackTrace();
	    }
	}
	public void write() {
		try {
			FileWriter writer = new FileWriter("wished.txt",false);

			writer.write(wished);
			writer.write("\n");
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
			}
		}
	public static String getWished() {
		intialize();
		return wished;
	}

}
