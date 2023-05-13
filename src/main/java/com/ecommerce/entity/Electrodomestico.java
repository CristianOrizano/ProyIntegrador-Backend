package com.ecommerce.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_electrodomesticos")
public class Electrodomestico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_ele")
	private int codigoele;
	
	@ManyToOne
	@JoinColumn(name="ide_cat")
	private Categoria cate;//ASOC.
	
	private String descripcion;
	
	private int stock;
	
	private double precio;
	
	private String marca;
	
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;//ASOC.


	

	public int getCodigoele() {
		return codigoele;
	}

	public void setCodigoele(int codigoele) {
		this.codigoele = codigoele;
	}

	public Categoria getCate() {
		return cate;
	}

	public void setCate(Categoria cate) {
		this.cate = cate;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}



	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	
	

	
}
