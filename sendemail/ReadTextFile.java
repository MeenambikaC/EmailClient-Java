package com.sendemail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface ReadTextFile {
	public default ArrayList<EmailClient> readTxtFile(String filename) throws FileNotFoundException{
		File file=new File(filename);
		Scanner s= new Scanner(file);
		ArrayList<EmailClient> list=new ArrayList<EmailClient>();
		
		while (s.hasNextLine()){
	
			String line=s.nextLine();
			String[] items=line.split(",");
			String[] val=items[0].split(":");
			String type=val[0];
			String name=val[1];
			//System.out.println(type);
			if (type.equals("Official")) {
				String email=items[1];
				String position=items[2];

				EmailClient emailCLIENT =new Officials(type,name, email,position);

				list.add(emailCLIENT);

			}
			else if (type.equals("Personal")){
				String nickname=items[1];
				String email=items[2];
				String DOB=items[3];
				//System.out.println(type);
				EmailClient emailCLIENT =new PersonalFriends(type,name, nickname,email,DOB);
				list.add(emailCLIENT);

			}
			else if(type.equals("Office_friend")) {

				String email=items[1];
				String position=items[2];
				String DOB=items[3];
				EmailClient emailCLIENT =new OfficialFriends(type,name, email,position,DOB);
				list.add(emailCLIENT);
					
			}
			

			
		}
		s.close();

		return list;
		
	}
}
