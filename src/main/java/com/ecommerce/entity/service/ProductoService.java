package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Producto;
import com.ecommerce.entity.repository.CategoriaRepository;
import com.ecommerce.entity.repository.ProductoRepository;

@Service
public class ProductoService {
	
	
	@Autowired
	private ProductoRepository repo;
	

	public Producto guardar(Producto ad) {
		return repo.save(ad);
	}
	

	public List<Producto> listadoProductos(){
		return repo.findAll();
	}
	
	//metodo eliminar por estado
	public void eliminar(int esta) {
			
	   repo.deleteById(esta); 
			
	} 

}
