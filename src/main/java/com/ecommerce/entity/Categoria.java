package com.ecommerce.entity;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ide_cat")
	private int codigocate;
	
	@Column(name="descripcion")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cate")//ASOC nombre tipo
	private List<Electrodomestico> listaElectro;
	

	
	public int getCodigocate() {
		return codigocate;
	}

	public void setCodigocate(int codigocate) {
		this.codigocate = codigocate;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Electrodomestico> getListaElectro() {
		return listaElectro;
	}

	public void setListaElectro(List<Electrodomestico> listaElectro) {
		this.listaElectro = listaElectro;
	}
	
	

}
