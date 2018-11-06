package com.hemant.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	 static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS"); 
	 static Date date;
	 static String str;
	
	public static String getDateTime() {

		date = new Date();

		 str = dateFormat.format(date);
		 return str;
		 //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		   // Date date = new Date();  
		    //System.out.println(formatter.format(date));  
	}
	
	/*public static void main(String[] args) {
		DateUtil du = new DateUtil();
		
		String mystr = du.getDateTime();
		
		System.out.println(mystr);
		
	}*/
}
