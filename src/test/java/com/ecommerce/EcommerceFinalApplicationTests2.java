package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.Reclamo;
import com.ecommerce.entity.service.BoletaService;
import com.ecommerce.entity.service.ClienteService;
import com.ecommerce.entity.service.ElectroService;
import com.ecommerce.entity.service.ReclamoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class EcommerceFinalApplicationTests2 {

	@Autowired
	ElectroService serelec;
	
	@Autowired
	private ReclamoService serrecla;
	@Autowired
	private ClienteService serclie;

	@Test
	void guardarReclamo() throws JsonMappingException, JsonProcessingException {
		
		Map<String, Object> salida = new HashMap<>();
		Reclamo rec= serrecla.buscaridclientereclamo(1002);

		if (rec == null) {
			salida.put("mensaje", "el codigo de cliente no existe");

		} else {
			salida.put("mensaje", rec);
		}
		
		System.out.println("mensaje ====> "+salida);
		
		
	}
	
	
	

		
	

}
