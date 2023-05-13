package com.ecommerce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Detalle;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.BoletaService;
import com.ecommerce.entity.service.CategoriaService;
import com.ecommerce.entity.service.ElectroService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/boleta")
@CrossOrigin(origins = "https://cyberelectronicoliv.netlify.app/")
public class BoletaController {
	
	@Autowired
	BoletaService bolser;
	
	//metodo para listar 
	@GetMapping()
	public ResponseEntity<List<Boleta>> ListarBolet(Model model) {
		List<Boleta> lista= bolser.listarTodosbole();
       
		return ResponseEntity.ok(lista);
	}
	
	//metodo para insertar
		@PostMapping()
		public void insertar(@RequestBody List<Detalle> listbol) throws ParseException {
			
			List<DetalleBoleta> lista=new ArrayList<DetalleBoleta>();
			int codicli=0;
			double total=0;
			for (Detalle bo : listbol) {
				codicli= bo.getCodcli();
				total= bo.getTotal();
				
				DetalleBoleta detabol=new DetalleBoleta();
				Electrodomestico el=new Electrodomestico();
				el.setCodigoele(bo.getCodigopro());
				detabol.setElec(el);
				detabol.setCantidad(bo.getCantidad());
				lista.add(detabol);
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(new Date());
			
			Cliente cli= new Cliente();
			cli.setCodigo(codicli);
			
			Boleta bol = new Boleta();
			bol.setCliente(cli);
			bol.setFechaEmision(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			bol.setMonto(total);
			bol.setListaDetalleBol(lista);
		
			
			bolser.registrarBoleta(bol);
		}


}
