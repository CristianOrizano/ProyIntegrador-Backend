package com.ecommerce.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Categoria;
import com.ecommerce.entity.Electrodomestico;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
