package com.elegant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("from contextInitialized() of Listner");
	}

	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("from contextDestroyed() of Listner");

	}

}
