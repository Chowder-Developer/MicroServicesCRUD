package com.example.microServicios.service;

import java.util.List;

import com.example.microServicios.dto.pruebaCliente;

public interface IpruebasService {

	public List<pruebaCliente> findAll(); //Consulta general o lista de clientes
	
	public pruebaCliente clienteById(Long Id); //Buscar por id
	
	public void eliminar(pruebaCliente cliente);
	
	public void crear(pruebaCliente cliente);
	
}

