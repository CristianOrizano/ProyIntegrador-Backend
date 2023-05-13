package com.ecommerce.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estado")
public class Estado {
	@Id
	@Column(name="id_estado")
	private int estado;
	
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")//ASOC nombre tipo
	private List<Electrodomestico> listaelec;

	/*@JsonIgnore
	@OneToMany(mappedBy = "esta")//ASOC nombre tipo
	private List<Cliente> listaCliente ; */
	
	
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Electrodomestico> getListaelec() {
		return listaelec;
	}

	public void setListaelec(List<Electrodomestico> listaelec) {
		this.listaelec = listaelec;
	}
	

}
