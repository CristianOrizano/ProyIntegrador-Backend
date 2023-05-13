package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService cateser;
	
	//metodo para listar 
	@GetMapping()
	public List<Categoria> ListarCate(Model model) {
		List<Categoria> lista= cateser.listadoActivos();

		return lista;
	}

}
