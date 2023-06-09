package com.ecommerce.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.ecommerce.entity.Proveedor;
import com.ecommerce.entity.Reclamo;
import com.ecommerce.entity.service.ClienteService;
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
	@Autowired
	private ClienteService serclie;
	
	//metodo para listar para reclamos
	@GetMapping()
	public List<Reclamo> ListarRecla(Model model) {
		List<Reclamo> lista= serrecla.listadoReclamos();

		return lista;
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Map<String, Object>> Buscarreclamo(@PathVariable("codigo") int cod) {
		Map<String, Object> salida = new HashMap<>();
		Reclamo rec= serrecla.buscaridclientereclamo(cod);

		if (rec == null) {
			salida.put("mensaje", "el codigo de cliente no existe");

		} else {
			salida.put("mensaje", rec);
		}
		
		System.out.println("mensaje ====> "+salida);
		return ResponseEntity.ok(salida);
	}
	
	//metodo para insertar
	@CrossOrigin
	@PostMapping()
	public ResponseEntity<Map<String, Object>> insertar(@RequestBody Reclamo rec,Model model) {
		
		Map<String, Object> salida = new HashMap<>();
		try {
			//Reclamo rec = serrecla.guardar(rec);
			Cliente cli = serclie.BuscarCli(rec.getCliente().getCodigo());
			Reclamo re= serrecla.buscaridclientereclamo(rec.getCliente().getCodigo());
			if (cli == null) {		
					salida.put("mensaje", "el codigo de cliente no existe");
				
			}else if(re != null) {
				salida.put("mensaje", "el cliente ya tiene un reclamo registrado");
			}
			else {
				Reclamo rclm = serrecla.guardar(rec);
				salida.put("mensaje", "exito al registrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error al registrar");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	//metodo para Eliminar
	@DeleteMapping("/{id}")
	public void Eliminar(@PathVariable("id") int cod) {
		serrecla.eliminar(cod);

	}


}
