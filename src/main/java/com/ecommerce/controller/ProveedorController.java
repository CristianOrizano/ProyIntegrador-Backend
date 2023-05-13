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

import com.ecommerce.entity.Proveedor;

import com.ecommerce.entity.service.ProveedorService;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class ProveedorController {
	
	@Autowired
	private ProveedorService serpro;
	
	//metodo para listar 
	@GetMapping()
	public List<Proveedor> ListarProv(Model model) {
		List<Proveedor> lista= serpro.listadoActivos(1);

		return lista;
	}

	
	//metodo para insertar
	@PostMapping()
	public Proveedor insertar(@RequestBody Proveedor admin,Model model) {
		
		return serpro.guardar(admin);
	}
	
	
	//metodo para Actualizar
	@PutMapping()
	public Proveedor actualizar(@RequestBody Proveedor elec) {
		
		return serpro.guardar(elec);
	}
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		serpro.eliminar(0,cod);

	}

}
