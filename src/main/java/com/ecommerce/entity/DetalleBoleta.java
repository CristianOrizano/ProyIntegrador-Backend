package com.ecommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_detalle")
public class DetalleBoleta implements Serializable{
	
	@EmbeddedId
	private DetalleBoletaPK pk;
	
	@ManyToOne
	@JoinColumn(name="num_bol",referencedColumnName = "num_bol",insertable = false,updatable =false)
	private Boleta boleta;//ASOCI.
	
	//Relación MUCHOS  a UNO "Boleta"
	@ManyToOne
	@JoinColumn(name="codigo_ele",referencedColumnName = "codigo_ele",insertable = false,updatable =false)
	private Electrodomestico elec;//ASOCI.
	
	@Column(name = "cantidad")
	private int cantidad;

	public DetalleBoletaPK getPk() {
		return pk;
	}

	public void setPk(DetalleBoletaPK pk) {
		this.pk = pk;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Electrodomestico getElec() {
		return elec;
	}

	public void setElec(Electrodomestico elec) {
		this.elec = elec;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	

}
