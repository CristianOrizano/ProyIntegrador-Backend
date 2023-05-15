package com.ecommerce.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.DetalleBoleta;
import com.ecommerce.entity.Electrodomestico;

import jakarta.transaction.Transactional;

public interface ElectroRepository extends JpaRepository<Electrodomestico, Integer> {
	
	@Transactional
	@Modifying
	@Query ("update Electrodomestico a set a.estado.estado=?1 where a.codigoele=?2")
	public void eliminarElec(int est,int codigo);
	
	@Query ("select a from Electrodomestico a where a.estado.estado=?1")
	public List<Electrodomestico> listadoActivo(int est);
	
	/*@Query ("select a.codigoele,a.descripcion,a.precio,de.cantidad from Electrodomestico a join   where a.estado.estado=?1")
	public List<Electrodomestico> listadoDetallepro(int est); */
	
	/*@Query ("select a.codigoele,a.descripcion,a.precio,de.cantidad from DetalleBoleta de join de.elec a  where de.boleta.numeroBoleta=?1")
	public List<DetalleBoleta> listadoDetallepro(int est); */
	@Query ("select de from DetalleBoleta de join de.elec a  where de.boleta.numeroBoleta=?1")
	public List<DetalleBoleta> listadoDetallepro(int est); 
	
	
	@Transactional
	@Modifying
	@Query ("update Electrodomestico e set e.stock= e.stock - ?1 where e.codigoele=?2")
	public void actualizarStock(int can,int codigo);
}
