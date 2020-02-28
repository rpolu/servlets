package com.util;

import javax.servlet.http.HttpSession;

public class CheckValidation {
	public static boolean isvalid(HttpSession s) {
		if (s == null || s.isNew())
			return false;
		String ss = (String) s.getAttribute("user");
		if (ss == null)
			return false;
		else
			return true;
	}
}
