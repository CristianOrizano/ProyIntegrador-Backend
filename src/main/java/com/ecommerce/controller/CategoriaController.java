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

import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/categoria")
@CrossOrigin()
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService cateser;
	
	//metodo para listar 
	@GetMapping()
	public List<Categoria> ListarCate(Model model) {
		List<Categoria> lista= cateser.listadoActivos();

		return lista;
	}
	

	//metodo para insertar
	@PostMapping()
	public Categoria insertar(@RequestBody Categoria cate,Model model) {
		
		return cateser.guardar(cate);
	}
	
	
	//metodo para Actualizar
	@PutMapping()
	public Categoria actualizar(@RequestBody Categoria cate) {
		
		return cateser.guardar(cate);
	}
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		cateser.eliminar(cod);

	}
	

}
