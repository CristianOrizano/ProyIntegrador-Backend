package com.ecommerce.controller;

import java.time.LocalDate;
import java.util.Date;
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
import com.ecommerce.entity.Reclamo;
import com.ecommerce.entity.service.ProveedorService;
import com.ecommerce.entity.service.ReclamoService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin
public class ReclamoController {
	
	@Autowired
	private ReclamoService serrecla;
	
	//metodo para listar para reclamos
	@GetMapping()
	public List<Reclamo> ListarProv(Model model) {
		List<Reclamo> lista= serrecla.listadoReclamos();

		return lista;
	}

	
	//metodo para insertar
	@CrossOrigin
	@PostMapping()
	public Reclamo insertar(@RequestBody Reclamo rec,Model model) {
		
		Reclamo re= new Reclamo();
		
		re.setCliente(rec.getCliente());
		re.setDescripcion(rec.getDescripcion());
		re.setFono(rec.getFono());
		re.setFecha_emis(new Date());
		return serrecla.guardar(re);
	}
	
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		serrecla.eliminar(cod);

	}


}
