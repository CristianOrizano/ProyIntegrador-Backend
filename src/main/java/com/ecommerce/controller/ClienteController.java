package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ClienteService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class ClienteController {
	
	@Autowired
	private ClienteService sercli;
	
	//metodo para listar 
	@GetMapping()
	public List<Cliente> ListarClie(Model model) {
		List<Cliente> lista= sercli.listadoActivos(1);

		return lista;
	}

	//metodo prueba
	//metodo para insertar
	@PostMapping()
	public Cliente insertar(@RequestBody Cliente admin,Model model) {
		
		return sercli.guardar(admin);
	}
	
	
	//metodo para Actualizar
	@PutMapping()
	public Cliente actualizar(@RequestBody Cliente elec) {
		
		return sercli.guardar(elec);
	}
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		sercli.eliminar(0,cod);

	}
	
	
}
