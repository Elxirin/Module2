package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DestinationServlet
 */
@WebServlet("/DestinationServlet")
public class DestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DestinationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) request.getAttribute("name");
		String email = (String)request.getAttribute("email");
		PrintWriter out = response.getWriter();
		out.println("Hello "+name +"  your registered Email Id is "+email);
		//another way to use the RequestDispatcher
		/*
		 ServletContext context = this.getServletContext();
		 context.setAttribute("name","Kavita");
		 context.setAttribute("email","kavita@gmail.com");
		 RequestDispatcher dispatch = request.getRequestDipatcher("/DestinationServlet");
		 dispatch.forward(request,response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
