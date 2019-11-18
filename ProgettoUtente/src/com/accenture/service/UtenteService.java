package com.accenture.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.dao.DaoUtenteImpl;
import com.accenture.model.Utente;
import com.accenture.utility.ConnectionFactory;
import com.ats.exceptions.DaoException;

public class UtenteService {

		
		private DaoUtenteImpl daoUtente = new  DaoUtenteImpl();
		 
		public void addUtente(Utente utente) throws SQLException, DaoException, ClassNotFoundException {
		
				try{
					daoUtente.addUtente(utente);
				}catch(ClassNotFoundException e) {
					Connection conn = null;
					if(conn != ConnectionFactory.getIstance().getConnection());
					throw new DaoException("Siamo spiacenti, si è verificato un errore durante il caricamento dei dati.");
				}
			
		}
			
		
		public void updateUtente (Utente utente) throws DaoException, SQLException {
				try {
					daoUtente.updateUtente(utente);
				}catch (SQLException sql) {
					
					
					throw new DaoException("Siamo spiacenti, si è verificato un errore nell'aggiornamento dei dati.");
				}
			
			}
		
		
		public void deleteUtente (String username) throws SQLException, DaoException {
			try{
				daoUtente.deleteUtente(username);
			}catch (SQLException sql) {
				
			throw new DaoException("Siamo spiacenti, si è verificato un errore durante l'eliminazione dell'utente.");
			}
		}
		public LinkedList<Utente> getallUtenti () throws SQLException, DaoException {
			try {
			return daoUtente.getallUtenti();
		}catch(SQLException sql) {
			throw new DaoException("Siamo spiacenti, si è verificato un errore durante il caricamento della lista.");
		}
		}
		public Utente getUtenteByUsername (String username) throws SQLException, DaoException {
			try {
				Utente utente =  daoUtente.getUtentebyUsername(username);
				return utente;
			}catch (SQLException sql) {
				sql.printStackTrace();
				Connection conn = null;
				if(conn != ConnectionFactory.getIstance().getConnection());
				throw new DaoException("Siamo spiacenti, si è verificato un errore durante il caricamento dei dati.");
				
			}
		
		     
			}
	}


