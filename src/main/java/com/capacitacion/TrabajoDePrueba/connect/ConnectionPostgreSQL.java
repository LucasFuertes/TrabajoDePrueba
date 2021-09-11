package com.capacitacion.TrabajoDePrueba.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL {

	public Connection connectDatabase() {
		Connection connection = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ventas", "postgres", "root");

		} catch (SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
		if (connection != null) 
		{
			System.out.println("Conectado");
		}
		return connection;
	}

	public Connection connectDatabase(String host, String port, String database, String user, String password) {
		String url = "";
		Connection connection = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
			url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException sqle) {
			System.out.println("Error al conectar con la base de datos de PostgreSQL (" + url + "): " + sqle);
		}
		if(connection != null) 
		{
			System.out.println("Conectado");
		}
		return connection;
	}

}