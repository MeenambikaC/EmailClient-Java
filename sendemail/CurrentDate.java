package com.sendemail;


import java.util.Date;  
import java.text.SimpleDateFormat;

public interface CurrentDate {
	Date dateOfTodayoday = new Date();  
	default String setCurrentDate() {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");  
	    String stringDate= format.format(dateOfTodayoday);
	    return stringDate;
	}
}
