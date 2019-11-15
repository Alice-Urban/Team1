package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Utente;
import com.accenture.service.UtenteService;

@WebServlet("/AggiornaProfilo")
public class AggiornaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiornaProfilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();	
		Utente utente= new Utente ();
		RequestDispatcher richiesta;
		UtenteService utenteService = new UtenteService();
		
		String usernameInserito = (String)session.getAttribute("username");
		
		String passwordInserita = request.getParameter("password");
		String data_nascita = request.getParameter("data_di_nascita");
		LocalDate localDate = LocalDate.parse(data_nascita);
		String nomeInserito = request.getParameter("nome");
		String cognomeInserito = request.getParameter("cognome");
		String indirizzoInserito = request.getParameter("indirizzo");
		String citt‡Inserita = request.getParameter("citt‡");
		try {
			utente = utenteService.getUtenteByUsername(usernameInserito);
			if (utente!=null) {
				 
			
				 utente.setPassword(passwordInserita);
				 utente.setNome(nomeInserito);
				 utente.setCognome(cognomeInserito);
				 utente.setIndirizzo(indirizzoInserito);
				 utente.setCitt‡(citt‡Inserita);
				 utente.setData_nascita(localDate);
				 
				 utenteService.updateUtente(utente);
				 
				 session.setAttribute("update", "Utente aggiornato!");
				 richiesta = request.getRequestDispatcher("Benvenuto.jsp");
				 richiesta.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
}
