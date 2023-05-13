package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable
public class DetalleBoletaPK implements Serializable {
	
	@Column(name = "num_bol")
	private int numeroBoleta;
	
	@Column(name = "codigo_ele")
	private int codigoElec;

	public int getNumeroBoleta() {
		return numeroBoleta;
	}

	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}

	public int getCodigoElec() {
		return codigoElec;
	}

	public void setCodigoElec(int codigoElec) {
		this.codigoElec = codigoElec;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoElec, numeroBoleta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleBoletaPK other = (DetalleBoletaPK) obj;
		return codigoElec == other.codigoElec && numeroBoleta == other.numeroBoleta;
	}
	
	

	
	
}
