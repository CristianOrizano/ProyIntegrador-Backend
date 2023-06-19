package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
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
class EcommerceFinalApplicationTests {

	@Autowired
	ElectroService serelec;
	
	@Autowired
	private ReclamoService serrecla;
	@Autowired
	private ClienteService serclie;
	
	private final String url = "https://decorous-control-production.up.railway.app/reclamos";
	
	@Test
	void ElcodigoclienteIncorrecto() throws JsonMappingException, JsonProcessingException {
		
		Reclamo re= new Reclamo();
		Cliente cli= new Cliente();
		cli.setCodigo(10);
		re.setCliente(cli);
		re.setFono(123456789);
		re.setDescripcion("en mal estado neverita2..");
		HttpEntity<Reclamo> request = new HttpEntity<Reclamo>(re);
		  String ruta = url;
	      RestTemplate res = new RestTemplate();
	      String respuesta = res.postForObject(ruta, request, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(respuesta);
			
			String mensaje = jsonNode.get("mensaje").asText();
		
	      assertEquals("el codigo de cliente no existe", mensaje);
	}
	//Guardar el reclamo de forma exitosa
	@Test
	void GuardarconExitoReclamo() throws JsonMappingException, JsonProcessingException {
		
		Reclamo re= new Reclamo();
		Cliente cli= new Cliente();
		cli.setCodigo(1003);
		re.setCliente(cli);
		re.setFono(123456789);
		re.setDescripcion("en mal estado neverita2..");
		
		HttpEntity<Reclamo> request = new HttpEntity<Reclamo>(re);

		  String ruta = url;
	      RestTemplate res = new RestTemplate();
	      String respuesta = res.postForObject(ruta, request, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(respuesta);
			
			String mensaje = jsonNode.get("mensaje").asText();
		
	      assertEquals("exito al registrar", mensaje);
	}
	
	//codigo de cliente se repite, ya tiene reclamo
	@Test
	void CodigoSeRepite() throws JsonMappingException, JsonProcessingException {
		
		Reclamo re= new Reclamo();
		Cliente cli= new Cliente();
		cli.setCodigo(1004);
		re.setCliente(cli);
		re.setFono(123456789);
		re.setDescripcion("en mal estado neverita2..");
		
		HttpEntity<Reclamo> request = new HttpEntity<Reclamo>(re);

		  String ruta = url;
	      RestTemplate res = new RestTemplate();
	      String respuesta = res.postForObject(ruta, request, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(respuesta);
			
			String mensaje = jsonNode.get("mensaje").asText();
		
	      assertEquals("el cliente ya tiene un reclamo registrado", mensaje);
	}
		
	

}
