package com.capacitacion.TrabajoDePrueba.view;

import java.util.ArrayList;

import com.capacitacion.TrabajoDePrueba.dao.Cliente;

public class ViewCliente {
	public void verCliente(Cliente cliente) 
	{
		System.out.println("Datos del cliente: " + cliente);
	}
	
	public void verClientes(ArrayList<Cliente> clientes) 
	{
		for(Cliente cliente : clientes) 
		{
			System.out.println("Datos del cliente: " + cliente);
		}
	}
}
