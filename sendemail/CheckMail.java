package com.sendemail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CheckMail {
	public default boolean checkMail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email);  
        return matcher.matches();
	}

}
