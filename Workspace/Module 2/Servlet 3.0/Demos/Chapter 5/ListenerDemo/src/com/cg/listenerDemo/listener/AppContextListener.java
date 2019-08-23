package com.cg.listenerDemo.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cg.listenerDemo.db.DBConnectionManager;



@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	
    	String url = ctx.getInitParameter("DBURL");
    	String u = ctx.getInitParameter("DBUSER");
    	String p = ctx.getInitParameter("DBPWD");
    	
    	//create database connection from init parameters and set it to context
    	DBConnectionManager dbManager = new DBConnectionManager(url, u, p);
    	ctx.setAttribute("DBManager", dbManager);
    	System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
    	dbManager.closeConnection();
    	System.out.println("Database connection closed for Application.");
    	
    }
	
}