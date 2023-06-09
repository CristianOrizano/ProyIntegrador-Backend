package com.ecommerce.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{
	
	//buscar reclamo por cliente
	Reclamo findByClienteCodigo(int codigoClientedd);
	
	List<Reclamo> findByCodigo(int cody);

}
