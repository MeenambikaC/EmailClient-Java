package com.sendemail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Email implements Serializable,CheckMail,FormatDate,CurrentDate{
	private String to;
	private String subject;
	private String content;
	private String dateOfToday;
	private static final long serialVersionUID = 1286227048434253704L;

	public Email(String to, String subject, String content) throws ParseException {

		if (checkMail(to)) {

			this.to=to;
			this.subject=subject;
			this.content=content;
			this.dateOfToday=setCurrentDate();//TODO consider this to find mails on  a particular day 

			send(to,subject,content);
			}

	}
	
	public String getTo() {
		return this.to;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getContent() {
		return this.content;
	}
	public static void send(String to,String subject,String content) {

		SendMail sendMail=new SendMail();
		sendMail.send(to,subject,content);
	}


	public String getDate() throws ParseException {

		return dateOfToday;
	}


}    






      
