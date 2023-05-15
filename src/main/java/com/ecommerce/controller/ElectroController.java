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

import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/electro")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
//@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class ElectroController {
	@Autowired
	private ElectroService serelec;
	
	@Autowired
	private CategoriaService sercate;
	
	
	//metodo para listar 
	@GetMapping()
	public List<Electrodomestico> ListarElec(Model model) {
		List<Electrodomestico> lista= serelec.listadoActivos(1);

		return lista;
	}

	
	//metodo para insertar
	@PostMapping()
	public Electrodomestico insertar(@RequestBody Electrodomestico admin,Model model) {
		
		return serelec.guardar(admin);
	}
	//metodo para buscar electro
			@GetMapping("/{id}")
			public Electrodomestico BuscarElectro(@PathVariable("id") int cod) {
				Electrodomestico ele= serelec.BuscarElectr(cod);
				return ele;
			}

	
	
	//metodo para Actualizar
	@PutMapping()
	public Electrodomestico actualizar(@RequestBody Electrodomestico elec) {
		
		return serelec.guardar(elec);
	}
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		serelec.eliminar(0,cod);

	}

}
