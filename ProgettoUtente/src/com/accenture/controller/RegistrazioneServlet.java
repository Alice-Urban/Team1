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



@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteService utenteService = new UtenteService();
		HttpSession session = request.getSession();	
		Utente utente= new Utente ();
		RequestDispatcher richiesta;
		String usernameInserito = request.getParameter("username_inserito");
		
		String bottone = request.getParameter("bottone2");
	
			 try {
				utente = utenteService.getUtenteByUsername(usernameInserito);
				if (utente!=null && bottone.equalsIgnoreCase("Elimina")) {
					utenteService.deleteUtente(usernameInserito);
					session.setAttribute("delete", "Utente cancellato!");
					richiesta = request.getRequestDispatcher("HomePage.jsp");
					richiesta.forward(request,response);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 

		
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();	
	Utente utenteDaInserire= new Utente ();
	RequestDispatcher richiesta;
	UtenteService utenteService = new UtenteService();
	String usernameInserito = request.getParameter("username_inserito");
	String passwordInserita = request.getParameter("password_inserita");
	String data_nascita = request.getParameter("data_nascita");
	LocalDate localDate = LocalDate.parse(data_nascita);
	String nomeInserito = request.getParameter("nome_inserito");
	String cognomeInserito = request.getParameter("cognome_inserito");
	String indirizzoInserito = request.getParameter("indirizzo_inserito");
	String citt‡Inserita = request.getParameter("citt‡_inserita");
	
	
	try {
		 utenteDaInserire = utenteService.getUtenteByUsername(usernameInserito);
		 if (utenteDaInserire!= null) {
			
			richiesta = request.getRequestDispatcher("Registrazione.jsp");
			session.setAttribute("error", "Utente gi‡ inserito!");
			richiesta.forward(request,response);
            
            
			

		 } else {
			 utenteDaInserire = new Utente ();
			 utenteDaInserire.setUsername(usernameInserito);
			 utenteDaInserire.setPassword(passwordInserita);
			 utenteDaInserire.setNome(nomeInserito);
			 utenteDaInserire.setCognome(cognomeInserito);
			 utenteDaInserire.setIndirizzo(indirizzoInserito);
			 utenteDaInserire.setCitt‡(citt‡Inserita);
			 utenteDaInserire.setData_nascita(localDate);
		     utenteService.addUtente(utenteDaInserire);	
			 richiesta = request.getRequestDispatcher("Benvenuto.jsp");
			 richiesta.forward(request, response);
			
		 }
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
//	 session.invalidate();
	
     }

}
