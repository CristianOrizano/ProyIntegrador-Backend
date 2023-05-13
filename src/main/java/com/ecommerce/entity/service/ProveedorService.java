package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Proveedor;
import com.ecommerce.entity.repository.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository repo;
	
	//los metodos del crud
	//insert and update
	public Proveedor guardar(Proveedor ad) {
		return repo.save(ad);
	}
	
	
	//metodo eliminar por estado
	public void eliminar(int esta, int codigo) {
		
	   repo.eliminarProv(esta,codigo);
		
	} 
	
	//listado especial para estado activos
	public List<Proveedor> listadoActivos(int estado){
		return repo.listadoActivo(estado);
	}
	
	//Metodo buscar para update
	public Proveedor Buscarcli(Integer cod){
		return repo.findById(cod).orElse(null);
	}
	
}
