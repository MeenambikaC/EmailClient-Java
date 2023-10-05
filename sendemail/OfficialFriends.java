package com.sendemail;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class OfficialFriends extends EmailClient implements WishBirthday{
	private String DOB;
	private String position;
	private String data;
	public OfficialFriends(String type,String name, String email,String position,String DOB) throws FileNotFoundException {//check order
		// TODO Auto-generated constructor stub
		super(type, name, email);
		this.position=position;
		this.DOB=DOB;
		if (checkMail(email)){
			data=type+":"+name+","+email+","+position+","+DOB;
			addDetails(data);}
	}
	@Override
	public void wish(String email) {

		String subject="Happy Birthday!";
		String content="Wish you a Happy Birthday.-c.meenambika ";

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
