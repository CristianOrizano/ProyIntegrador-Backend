package com.ecommerce.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_cli")
	private int codigo;
	
	@Column(name="nom_cli")
	private String nombre;
	
	@Column(name="ape_cli")
	private String apellido;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="sexo")
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_naci")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechanaci;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechanaci() {
		return fechanaci;
	}

	public void setFechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
