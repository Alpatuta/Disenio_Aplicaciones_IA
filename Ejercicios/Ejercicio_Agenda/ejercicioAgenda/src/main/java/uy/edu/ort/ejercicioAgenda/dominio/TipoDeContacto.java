package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.TipoNoValidoException;

public class TipoDeContacto {

	private String nombre;

	public TipoDeContacto(String nombre) throws TipoNoValidoException {
		this.nombre = nombre;
	}

	public void nombreValido() throws TipoNoValidoException {
		if (nombre == null || nombre.isEmpty()) {
			throw new TipoNoValidoException("El tipo de contacto no puede estar vacío");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws TipoNoValidoException {
		nombreValido();
		this.nombre = nombre;
	}

}
