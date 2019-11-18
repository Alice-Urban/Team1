package com.accenture.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.accenture.model.Utente;
import com.ats.exceptions.DaoException;

public interface IDaoUtente {
	public void addUtente(Utente utente) throws ClassNotFoundException, DaoException;
    public void updateUtente(Utente utente)throws SQLException, DaoException;
	public void deleteUtente(String username)throws SQLException, DaoException;
	public LinkedList<Utente> getallUtenti () throws SQLException,DaoException;
	public Utente getUtentebyUsername (String username) throws SQLException, DaoException;

}
