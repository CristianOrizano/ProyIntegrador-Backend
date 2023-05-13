package com.ecommerce.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.Cliente;
import com.ecommerce.entity.Proveedor;

import jakarta.transaction.Transactional;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	
	@Transactional
	@Modifying
	@Query ("update Proveedor a set a.estado.estado=?1 where a.codigo=?2")
	public void eliminarProv(int est,int codigo);
	
	@Query ("select a from Proveedor a where a.estado.estado=?1")
	public List<Proveedor> listadoActivo(int est);
}
