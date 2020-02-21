package com.elegant;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyLister2 implements ServletRequestListener {

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("from requestInitialized");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("from requestDestroyed ");
	}

}
