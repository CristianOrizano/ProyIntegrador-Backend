package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.repository.ElectroRepository;


@Service
public class ElectroService {
	
	@Autowired
	private ElectroRepository repo;
	
	//los metodos del crud
	//insert and update
	public Electrodomestico guardar(Electrodomestico ad) {
		return repo.save(ad);
	}
	
	
	//metodo eliminar por estado
	public void eliminar(int esta, int codigo) {
		
	   repo.eliminarElec(esta,codigo);
		
	} 
	
	//listado especial para estado activos
	public List<Electrodomestico> listadoActivos(int estado){
		return repo.listadoActivo(estado);
	}
	
	//Metodo buscar para update
	public Electrodomestico BuscarElectr(Integer cod){
		return repo.findById(cod).orElse(null);
	}
	
	//consultas
		public List<DetalleBoleta> listarconsulta(int cod){
			return repo.listadoDetallepro(cod);
		}

}
