package com.sendemail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Officials extends EmailClient implements CreateEmailClientTxtFile{
	private String position;
	private String data;
	public Officials(String type,String name, String email,String position) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(type,name, email);
		this.position=position;

		if (checkMail(email)){
			data=type+":"+name+","+email+","+position;
			addDetails(data);

	}
	}

}

