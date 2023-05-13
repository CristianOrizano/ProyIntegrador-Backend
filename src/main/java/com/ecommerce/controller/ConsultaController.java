package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.service.BoletaService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class ConsultaController {
	
	@Autowired
	ElectroService eleserv;
	
	//metodo para listar 
	@GetMapping("/{id}")
	public ResponseEntity<List<DetalleBoleta>> ListarConsulta(@PathVariable("id") int cod) {
		List<DetalleBoleta> lista= eleserv.listarconsulta(cod);
       
		return ResponseEntity.ok(lista);
	}
	

}
