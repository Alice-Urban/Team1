package com.accenture.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.accenture.exceptions.DaoException;

public class ConnectionFactory {
	String driver="oracle.jdbc.driver.OracleDriver";

 
	String connectionUrl="jdbc:oracle:thin:@localhost:1521:xe";
	String dbUser="rossella";
	String dbPassword="password";
	
	private static ConnectionFactory connectionFactory=null;


	private ConnectionFactory(){
	try {
		//reflection
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

  public Connection getConnection() throws DaoException{
	Connection con=null;
	try {
		con= DriverManager.getConnection(connectionUrl,dbUser,dbPassword);
	} catch (SQLException e) {
		 e.printStackTrace();
		 throw new DaoException("Siamo spiacenti, si � verificato un errore durante il caricamento dei dati.");
		
	 
	}
	return con;
}

//get instance istanzia automaticamente l'oggetto connectionFactory richiamando 
// il costruttore
// pattern singleton
public static ConnectionFactory getIstance(){

	if(connectionFactory==null){
		connectionFactory= new ConnectionFactory();
	}

	return connectionFactory;
}

}


