package com.accenture.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.accenture.model.Utente;

public interface IDaoUtente {
	public void addUtente(Utente utente) throws ClassNotFoundException;
    public void updateUtente(Utente utente)throws SQLException;
	public void deleteUtente(String username)throws SQLException;
	public LinkedList<Utente> getallUtenti () throws SQLException;
	public Utente getUtentebyUsername (String username) throws SQLException;

}
