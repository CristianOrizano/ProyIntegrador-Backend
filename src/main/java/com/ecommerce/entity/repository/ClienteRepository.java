package com.ecommerce.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Electrodomestico;

import jakarta.transaction.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Transactional
	@Modifying
	@Query ("update Cliente a set a.estado.estado=?1 where a.codigo=?2")
	public void eliminarCli(int est,int codigo);
	
	@Query ("select a from Cliente a where a.estado.estado=?1")
	public List<Cliente> listadoActivo(int est);
}
