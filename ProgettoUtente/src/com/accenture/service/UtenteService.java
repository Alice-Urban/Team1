package com.accenture.service;

import java.sql.SQLException;
import java.util.LinkedList;

import com.accenture.dao.DaoUtenteImpl;
import com.accenture.model.Utente;

public class UtenteService {

		
		private DaoUtenteImpl daoUtente = new  DaoUtenteImpl();
		 
		public void addUtente(Utente utente) throws ClassNotFoundException {
			daoUtente.addUtente(utente);
		}
			
		
		public void updateUtente (Utente utente) throws SQLException {
			daoUtente.updateUtente(utente);
		}
		
		public void deleteUtente (String username) throws SQLException {
			daoUtente.deleteUtente(username);
		}
		public LinkedList<Utente> getallUtenti () throws SQLException {
			return daoUtente.getallUtenti();
		}
		public Utente getUtenteByUsername (String username) throws SQLException {
			Utente utente =  daoUtente.getUtentebyUsername(username);
		
		return utente;
	}
}

