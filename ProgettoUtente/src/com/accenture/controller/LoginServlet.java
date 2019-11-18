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



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher richiesta;
		UtenteService utenteservice = new UtenteService();
		String usernameInserito = request.getParameter("username_inserito");
		String passwordInserita = request.getParameter ("password_inserita");
		Utente utenteLog = new Utente ();
		 try {
			utenteLog = utenteservice.getUtenteByUsername(usernameInserito);
			if (utenteLog !=null &&
            utenteLog.getPassword().equals(passwordInserita))  {
			session.setAttribute("username", usernameInserito);	
			session.setAttribute("password", passwordInserita);
			richiesta = request.getRequestDispatcher("Benvenuto.jsp");
			richiesta.forward(request,response);
			
				
			}else  {
				String error = "Credenziali invalide!";
				session.setAttribute ("errore", error);
				richiesta = request.getRequestDispatcher("HomePage.jsp");
				richiesta.forward(request,response);
				
	         
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (DaoException sql) {
			sql.printStackTrace();
			sql.getMessage();
			richiesta = request.getRequestDispatcher("Error.jsp");
			session.setAttribute("Errore","Siamo spiacenti, si è verificato un errore durante il login.");
			richiesta.forward(request, response);
			

		}

		
//	session.invalidate();
		}
		
	
}


