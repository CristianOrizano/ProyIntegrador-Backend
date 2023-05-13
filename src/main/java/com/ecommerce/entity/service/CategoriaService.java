package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Proveedor;
import com.ecommerce.entity.repository.CategoriaRepository;
import com.ecommerce.entity.repository.ProveedorRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	//los metodos del crud
	//insert and update
	public Categoria guardar(Categoria ad) {
		return repo.save(ad);
	}
	

	//listado especial para estado activos
	public List<Categoria> listadoActivos(){
		return repo.findAll();
	}
	


}
