package uy.edu.ort.ejercicioAgenda.dto;

import uy.edu.ort.ejercicioAgenda.dominio.TipoDeContacto;

public class ContactoDto {

	private String nombre;

	private Integer telefono;

	private TipoDeContacto tipo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public TipoDeContacto getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeContacto tipo) {
		this.tipo = tipo;
	}
}
