package com.example.microServicios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microServicios.dto.pruebaCliente;
import com.example.microServicios.service.IpruebasService;

@RestController
@RequestMapping("/api")
public class controller {
	
	@Autowired
	private IpruebasService pruebasServices;

	@GetMapping("/clientes") //Consulta clientes
	public List<pruebaCliente> clientes() {
		return pruebasServices.findAll();
	}
	
	@GetMapping("/clientes/{id}") // Parametro que recibirá
	public pruebaCliente cliente(@PathVariable Long id) { // Metodo con parametro que recibe
		return pruebasServices.clienteById(id);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void eliminar(@PathVariable Long id) {
		pruebaCliente dlt = this.pruebasServices.clienteById(id);
		this.pruebasServices.eliminar(dlt);
	}
	
	@PostMapping("/clientes/guardar")
	public ResponseEntity<?> crear(@Valid @RequestBody pruebaCliente cliente) {
		System.out.println(cliente.toString());
		Map<String, Object> response = new HashMap();
		try {
			this.pruebasServices.crear(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al crear cliente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<pruebaCliente>(cliente, HttpStatus.OK);
	}
	
}
