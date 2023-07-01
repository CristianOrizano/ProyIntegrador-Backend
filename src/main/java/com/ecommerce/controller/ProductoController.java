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
import com.ecommerce.entity.Producto;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ProductoService;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("/productos")
@CrossOrigin()
public class ProductoController {
	
	@Autowired
	private ProductoService proser;
	
	//metodo para listar 
	@GetMapping()
	public List<Producto> ListarProd(Model model) {
		List<Producto> lista= proser.listadoProductos();

		return lista;
	}
	

	//metodo para insertar
	@PostMapping()
	public Producto insertar(@RequestBody Producto prod,Model model) {
		
		return proser.guardar(prod);
	}
	
	
	//metodo para Actualizar
	@PutMapping()
	public Producto actualizar(@RequestBody Producto cate) {
		
		return proser.guardar(cate);
	}
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		proser.eliminar(cod);

	}

}
