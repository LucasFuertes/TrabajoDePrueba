package com.capacitacion.TrabajoDePrueba;

import com.capacitacion.TrabajoDePrueba.controller.ControllerCliente;
import com.capacitacion.TrabajoDePrueba.dao.Cliente;

public class Ventas {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setCedula("44332211");
		cliente.setNombre("Sandra");
		cliente.setApellido("Ramos");
		
		ControllerCliente controllerCliente = new ControllerCliente();
		
//		controllerCliente.crear(cliente);
//		controllerCliente.verClientes();
//		controllerCliente.eliminar(cliente2);
		controllerCliente.actualizar(cliente);
	}
}
