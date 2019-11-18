package com.accenture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.accenture.model.Utente;
import com.accenture.utility.ConnectionFactory;




public class DaoUtenteImpl implements IDaoUtente {
	
	Connection conn=null;
	PreparedStatement prepStatement= null;
	ResultSet resultset= null;
	
	private Connection getConnection() {
		Connection conn;
		conn= ConnectionFactory.getIstance().getConnection();
		return conn;
	}

	@Override
	public void addUtente(Utente utente) throws ClassNotFoundException {
		Date data_nascita = Date.valueOf(utente.getData_nascita());
		try{
			String query="insert into Utente "
					+ "values(?,?,?,?,?,?,?)";
			conn= getConnection();
			prepStatement= conn.prepareStatement(query);
			prepStatement.setString(1, utente.getUsername());
			prepStatement.setString(2, utente.getPassword());
			prepStatement.setString(3, utente.getNome());
			prepStatement.setString(4,utente.getCognome());
			prepStatement.setString(5, utente.getIndirizzo());
			prepStatement.setString(6, utente.getCittà());
			prepStatement.setDate(7, data_nascita);
			int numeroRighe = prepStatement.executeUpdate();
			if(numeroRighe > 0) {
				System.out.println("Utente aggiunto con successo!");
			}
			prepStatement.close();
			conn.close();
		} catch (SQLException sql) {
			// TODO: handle exception
			e.printStackTrace();
		throw new DaoException(sql.getMessage());
		}
		
		
		
	
		
	}


	@Override
	public void updateUtente(Utente utente) throws SQLException, DaoException {
		Date data_nascita = Date.valueOf(utente.getData_nascita());
		try {
			String query="update Utente set  password_utente=?, nome=?, cognome=?, indirizzo=?, citta=?, data_nascita=? where username=? ";
		
		conn= getConnection();
		prepStatement= conn.prepareStatement(query);
		
		prepStatement.setString(1,utente.getPassword());
		prepStatement.setString(2, utente.getNome());
		prepStatement.setString(3, utente.getCognome());
		prepStatement.setString(4, utente.getIndirizzo());
		prepStatement.setString(5,utente.getCittà());
		prepStatement.setDate(6, data_nascita );
		prepStatement.setString(7, utente.getUsername());
		prepStatement.executeUpdate();
		System.out.println("Utente modificato con successo!");
		
		 prepStatement.close();
		conn.close();
	}catch (SQLException sql) {
		// TODO: handle exception
		throw new DaoException(sql.getMessage());
	}

	}
		
	

	@Override
	public void deleteUtente(String username) throws SQLException,DaoException {
		try {
		String query="delete from Utente where username=?";
		conn=getConnection();
		prepStatement=conn.prepareStatement(query);
		prepStatement.setString(1, username);
		prepStatement.executeUpdate();
		System.out.println("Utente cancellato con successo!");
		prepStatement.close();
		conn.close();
		}catch (SQLException sql) {
			// TODO: handle exception
			throw new DaoException(sql.getMessage());
		}
		
	}

	@Override
	public LinkedList<Utente> getallUtenti() throws SQLException, DaoException {
		try {
		String query="select * from Utente";
		LinkedList <Utente> listaUtenti = new LinkedList<Utente>();
		
		conn=getConnection();
		prepStatement=conn.prepareStatement(query);
		resultset=prepStatement.executeQuery();

		while(resultset.next()){

			Utente utente =new Utente();
			
			
			utente.setUsername(resultset.getString("username"));
			utente.setPassword(resultset.getString("password_utente"));
			utente.setNome(resultset.getString("nome"));
			utente.setCognome(resultset.getString("cognome"));
			utente.setIndirizzo(resultset.getString("indirizzo"));
			utente.setCittà(resultset.getString("citta"));
			utente.setData_nascita(resultset.getDate("data_nascita").toLocalDate());
			listaUtenti.add(utente);
			
			
		}
	
		return listaUtenti;
	}catch (SQLException sql) {
		// TODO: handle exception
		throw new DaoException(sql.getMessage());
	}
	}



	
	
		
		
	

	@Override
	public Utente getUtentebyUsername(String username) throws SQLException {
		try {
		String query="select * from Utente where username=?";
		conn=getConnection();
		prepStatement=conn.prepareStatement(query);
		prepStatement.setString(1, username);
		resultset=prepStatement.executeQuery();
		
		Utente utente = null;
		
		while(resultset.next()) {
			utente = new Utente ();
			utente.setUsername(resultset.getString("username"));
			utente.setPassword(resultset.getString("password_utente"));
			utente.setNome(resultset.getString("nome"));
			utente.setCognome(resultset.getString("cognome"));
			utente.setIndirizzo(resultset.getString("indirizzo"));
			utente.setCittà(resultset.getString("citta"));
			utente.setData_nascita(resultset.getDate("data_nascita").toLocalDate());
	}
		return utente;
	    }catch (SQLException sql)  {
		throw new DaoException(sql.getMessage());
	}
	}
	

}
