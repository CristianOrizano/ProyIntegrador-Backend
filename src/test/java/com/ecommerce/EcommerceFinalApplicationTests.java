package com.ecommerce;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.service.BoletaService;
import com.ecommerce.entity.service.ElectroService;

@SpringBootTest
class EcommerceFinalApplicationTests {

	@Autowired
	ElectroService serelec;
	
	@Test
	void contextLoads() {
		List<DetalleBoleta> lista= serelec.listarconsulta(2002);
        for (DetalleBoleta bo : lista) {
        	
        	/*System.out.println("codigo "+ bo.getCodigoele());
        	System.out.println("descripcion "+ bo.getDescripcion());
        	System.out.println("precio "+ bo.getPrecio()); */
        	System.out.println("codigo "+ bo.getElec().getDescripcion());
        	System.out.println("descripcion "+ bo.getElec().getDescripcion());
        	System.out.println("precio "+ bo.getElec().getPrecio());
        	System.out.println("cantidad "+ bo.getCantidad());
		
		}
		
	}

}
