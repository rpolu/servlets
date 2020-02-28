package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convert(String s1, String s2) {
		SimpleDateFormat f = new SimpleDateFormat(s2);
		Date d = null;
		try {
			System.out.println("Date String:" + s1);
			d = f.parse(s1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
