package com.capacitacion.TrabajoDePrueba.service;

import java.util.ArrayList;

import com.capacitacion.TrabajoDePrueba.dao.Cliente;

public interface ClienteService {
	public Boolean createCliente(Cliente cliente);
	public ArrayList<Cliente> readCliente();
	public Boolean updateCliente(Cliente cliente);
	public Boolean deleteCliente(Cliente cliente);
}
