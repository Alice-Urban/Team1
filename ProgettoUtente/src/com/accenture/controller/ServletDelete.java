package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.exceptions.DaoException;
import com.accenture.model.Utente;
import com.accenture.service.UtenteService;


@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletDelete() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtenteService utenteService = new UtenteService();
		HttpSession session = request.getSession();	
		Utente utente= new Utente ();
		RequestDispatcher richiesta;
		
		
		String usernameEliminato = request.getParameter("username");
	
			 try {
				utente = utenteService.getUtenteByUsername(usernameEliminato);
				
				if (utente!=null) {
					
					utenteService.deleteUtente(usernameEliminato);
					
					session.setAttribute("delete", "Utente cancellato!");
					
					
					richiesta = request.getRequestDispatcher("Lista.jsp");
					response.sendRedirect("http://localhost:8082/ProgettoUtente/Lista");
					
					System.out.println(usernameEliminato);
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (DaoException sql) {
				sql.getMessage();
				richiesta = request.getRequestDispatcher("Error.jsp");
				session.setAttribute("Errore","Si è verificato un errore nella cancellazione dei dati.");
				richiesta.forward(request, response);
			}
			 
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
