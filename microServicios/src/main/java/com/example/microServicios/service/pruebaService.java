package com.example.microServicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microServicios.dao.pruebaDao;
import com.example.microServicios.dto.pruebaCliente;

@Service
public class pruebaService implements IpruebasService {

	@Autowired //Inyección de dependencias (llamar a esa interfaz)
	private pruebaDao clienteDao;
	
	@Override //Sobre escribe el metodo de la interface
	public List<pruebaCliente> findAll() {
		// TODO Auto-generated method stub
		return (List<pruebaCliente>) clienteDao.findAll();  //Conversión del resultado en forma lista. 
	}

	@Override
	public pruebaCliente clienteById(Long Id) {
		// TODO Auto-generated method stub
		return  clienteDao.findById(Id).orElse(null);
	}

	@Override
	public void eliminar(pruebaCliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.delete(cliente);
		
	}

	@Override
	public void crear(pruebaCliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
		
	}

	
}
