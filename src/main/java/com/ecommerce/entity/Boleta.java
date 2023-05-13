package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "tb_boleta")
public class Boleta implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_bol")
	private int numeroBoleta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_emi")
	private Date fechaEmision;

	@ManyToOne
	@JoinColumn(name = "cod_cli")
	private Cliente cliente;
	
	@Column(name = "total")
	private double monto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "boleta")
	private List<DetalleBoleta> listaDetalleBol;
	
	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public List<DetalleBoleta> getListaDetalleBol() {
		return listaDetalleBol;
	}

	public void setListaDetalleBol(List<DetalleBoleta> listaDetalleBol) {
		this.listaDetalleBol = listaDetalleBol;
	}

	

	
	

}
