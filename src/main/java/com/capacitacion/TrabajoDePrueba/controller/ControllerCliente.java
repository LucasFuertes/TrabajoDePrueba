package com.capacitacion.TrabajoDePrueba.controller;

import java.util.ArrayList;

import com.capacitacion.TrabajoDePrueba.dao.Cliente;
import com.capacitacion.TrabajoDePrueba.service.impl.ClienteServiceImpl;
import com.capacitacion.TrabajoDePrueba.view.ViewCliente;

public class ControllerCliente {

	private ViewCliente view = new ViewCliente();
	private ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();

	public ControllerCliente() {
	}

	public void crear(Cliente cliente) {
		Boolean registro = clienteServiceImpl.createCliente(cliente);

		if (registro == true) {
			System.out.println("Se ha enviado el registro correctamente");
		} else {
			System.out.println("Ha ocurrido un error");
		}
	}

	public void verClientes() {
		ArrayList<Cliente> clientes = clienteServiceImpl.readCliente();
		view.verClientes(clientes);
	}

	public void actualizar(Cliente cliente) {
		Boolean cambiar = clienteServiceImpl.updateCliente(cliente);
		if (cambiar == true) {
			System.out.println("Se actualizo los datos exitosamente");
		} else {
			System.out.println("No se pudo actualizar correctamente");
		}
	}

	public void eliminar(Cliente cliente) {
		Boolean borrar = clienteServiceImpl.deleteCliente(cliente);

		if (borrar != true) {
			System.out.println("No se ha podido eliminar correctamente este cliente con id: " + cliente.getId());
		} else {
			System.out.println("Se ha eliminado correctamente el cliente con id: " + cliente.getId());
		}
	}
}
