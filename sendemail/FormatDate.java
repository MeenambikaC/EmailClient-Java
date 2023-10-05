package com.sendemail;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface FormatDate {
     public default Date formatDate(String date) throws ParseException {
     Date date1=(Date) new SimpleDateFormat("yyyy/MM/dd").parse(date);
     return date1;
     //System.out.println(date1);
}
}