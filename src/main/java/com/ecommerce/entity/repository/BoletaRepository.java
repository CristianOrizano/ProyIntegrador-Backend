package com.ecommerce.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Boleta;
import com.ecommerce.entity.Electrodomestico;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {

}
