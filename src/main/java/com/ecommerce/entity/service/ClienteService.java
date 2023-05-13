package com.ecommerce.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Electrodomestico;
import com.ecommerce.entity.repository.ClienteRepository;
import com.ecommerce.entity.repository.ElectroRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	//los metodos del crud
	//insert and update
	public Cliente guardar(Cliente ad) {
		return repo.save(ad);
	}
	
	
	//metodo eliminar por estado
	public void eliminar(int esta, int codigo) {
		
	   repo.eliminarCli(esta,codigo);
		
	} 
	
	//listado especial para estado activos
	public List<Cliente> listadoActivos(int estado){
		return repo.listadoActivo(estado);
	}
	
	//Metodo buscar para update
	public Cliente BuscarCli(Integer cod){
		return repo.findById(cod).orElse(null);
	}


}
