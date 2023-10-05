package com.sendemail;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class PersonalFriends extends EmailClient implements WishBirthday, CreateEmailClientTxtFile{
	private String nickName;
	private String DOB;

	private String data;
	public PersonalFriends(String type,String name,String nickName,String email,String DOB) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(type, name, email);
		this.nickName=nickName;
		this.DOB=DOB;
		
		if (checkMail(email)){
			data=type+":"+name+","+nickName+","+email+","+DOB;
			//System.out.println(type);
			addDetails(data);}
		}

	@Override
	public  void wish(String email) {

		String subject="Happy Birthday!";
		String content="hugs and love on your birthday.-c.meenambika";
		try {
			Email sendMail=new Email(email,subject,content);
			serilalized(sendMail);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDOB() {
		return this.DOB;
	}
	

	
}
