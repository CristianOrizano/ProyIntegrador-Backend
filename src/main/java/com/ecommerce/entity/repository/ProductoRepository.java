package com.ecommerce.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	

}
