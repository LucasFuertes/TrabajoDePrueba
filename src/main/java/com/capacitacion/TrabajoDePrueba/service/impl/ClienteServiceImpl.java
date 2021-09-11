package com.capacitacion.TrabajoDePrueba.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.capacitacion.TrabajoDePrueba.connect.ConnectionPostgreSQL;
import com.capacitacion.TrabajoDePrueba.dao.Cliente;
import com.capacitacion.TrabajoDePrueba.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	public ConnectionPostgreSQL connectionPostgreSQL = new ConnectionPostgreSQL();

	public Boolean createCliente(Cliente cliente) {
		Boolean registrar = false;

		Statement stm = null;
		Connection con = null;

		String sql = "INSERT INTO cliente(cedula, nombre, apellido) values ('" + cliente.getCedula() + "','"
				+ cliente.getNombre() + "','" + cliente.getApellido() + "')";

		try {
			con = connectionPostgreSQL.connectDatabase("localhost", "5432", "ventas", "postgres", "root");
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteServiceImpl, método createCliente");
			e.printStackTrace();
		}
		return registrar;
	}

	public ArrayList<Cliente> readCliente() {
		Connection connection = null;
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM cliente order by idcliente";

		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			connection = connectionPostgreSQL.connectDatabase();
			stm = connection.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setCedula(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setApellido(rs.getString(4));
				listaCliente.add(cliente);
			}
			stm.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteServiceImpl, metodo readCliente");
		}
		return listaCliente;
	}

	public Boolean updateCliente(Cliente cliente) {
		Connection connect = null;
		Statement stm = null;

		Boolean actualizar = false;

		String sql = "Update cliente set cedula = '" + cliente.getCedula() + "', nombre= '" + cliente.getNombre()
				+ "', apellido = '" + cliente.getApellido() + "'" + " where idcliente = " + cliente.getId();
		try {
			connect = connectionPostgreSQL.connectDatabase();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error, Clase ClienteServiceImpl, metodo updateCliente");
		}
		return actualizar;
	}

	public Boolean deleteCliente(Cliente cliente) {
		Connection connect = null;
		Statement stm = null;

		Boolean eliminar = false;
		Boolean aux;

		String sql = "Delete from cliente where idcliente = " + cliente.getId();
		try {
			connect = connectionPostgreSQL.connectDatabase();
			stm = connect.createStatement();
			aux = stm.execute(sql);
			System.out.println(aux);
		} catch (SQLException e) {
			System.out.println("Error: Clase ClaseServiceImpl, metodo deleteCliente");
		}
		return eliminar;
	}

}
