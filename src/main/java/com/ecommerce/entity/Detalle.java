package com.ecommerce.entity;

public class Detalle {
	
	public int codigopro,cantidad,codcli;
	public double precio,importe,total;
	public String descripcion;
	
	public int getCodigopro() {
		return codigopro;
	}
	public void setCodigopro(int codigopro) {
		this.codigopro = codigopro;
	}
	public int getCodcli() {
		return codcli;
	}
	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
    
    
    
}
