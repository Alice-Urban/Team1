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

@WebServlet("/ServletAdministrator")
public class ServletAdministrator extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ServletAdministrator() {
		super();

	}


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
		Utente utente= new Utente ();
		RequestDispatcher richiesta;
		UtenteService utenteService = new UtenteService();


		String usernameInserito = (String) session.getAttribute("userDaUpdate");


		try {

			if (usernameInserito != null) {
				String passwordInserita = request.getParameter("password");
				String data_nascita = request.getParameter("data_di_nascita");
				LocalDate localDate = LocalDate.parse(data_nascita);
				String nomeInserito = request.getParameter("nome");
				String cognomeInserito = request.getParameter("cognome");
				String indirizzoInserito = request.getParameter("indirizzo");
				String citt‡Inserita = request.getParameter("citt‡");

				utente = utenteService.getUtenteByUsername(usernameInserito);
				if (utente!=null) {

					utente.setPassword(passwordInserita);
					utente.setNome(nomeInserito);
					utente.setCognome(cognomeInserito);
					utente.setIndirizzo(indirizzoInserito);
					utente.setCitt‡(citt‡Inserita);
					utente.setData_nascita(localDate);
					System.out.println(utente);

					utenteService.updateUtente(utente);

					System.out.println(utente);

					richiesta = request.getRequestDispatcher("Lista.jsp");
					response.sendRedirect("http://localhost:8082/ProgettoUtente/Lista");
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

}