package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Proveedor;
import com.ecommerce.entity.Reclamo;
import com.ecommerce.entity.repository.ProveedorRepository;
import com.ecommerce.entity.repository.ReclamoRepository;

@Service
public class ReclamoService {

	
	@Autowired
	private ReclamoRepository repo;
	
	//los metodos del crud
	//insert and update
	public Reclamo guardar(Reclamo ad) {
		return repo.save(ad);
	}
	
	
	//metodo eliminar por estado
	public void eliminar(int codi) {
		
	   repo.deleteById(codi);
		
	} 
	
	//listado especial para estado activos
	public List<Reclamo> listadoReclamos(){
		return repo.findAll();
	}
	public  List<Reclamo> buscarporcodigore(int cod){
		return repo.findByCodigo(cod);
    }
	
	public Reclamo buscaridclientereclamo(int cod){
			return repo.findByClienteCodigo(cod);
	}
}
