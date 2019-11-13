package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Utente;
import com.accenture.service.UtenteService;


@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	LinkedList<Utente> listaUtenti = new LinkedList<Utente> ();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher richiesta;
		UtenteService UtenteService = new UtenteService();

		String usernameInserito = (String)session.getAttribute("username");
		String passwordInserita = (String)session.getAttribute("password");
		
	             if (usernameInserito.equalsIgnoreCase("admin") && 
            		passwordInserita.equalsIgnoreCase("admin123")) {
	               
					try {
					
			        listaUtenti = UtenteService.getallUtenti();
				    session.setAttribute("listaUtenti", listaUtenti);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}

					richiesta = request.getRequestDispatcher("Lista.jsp");
					richiesta.forward(request, response);
					
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher richiesta;
		UtenteService UtenteService = new UtenteService();

		String usernameInserito = (String)session.getAttribute("username");
		String passwordInserita = (String)session.getAttribute("password");
		
	             if (usernameInserito.equalsIgnoreCase("admin") && 
            		passwordInserita.equalsIgnoreCase("admin123")) {
	               
					try {
					
			        listaUtenti = UtenteService.getallUtenti();
				    session.setAttribute("listaUtenti", listaUtenti);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					
				
				richiesta = request.getRequestDispatcher("Lista.jsp");
				richiesta.forward(request, response);
			}

		

	

	{
}
}
}
