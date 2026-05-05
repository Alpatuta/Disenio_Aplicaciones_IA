package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.NombreNoValidoException;
import uy.edu.ort.ejercicioAgenda.exception.TelefonoNoValidoException;
import uy.edu.ort.ejercicioAgenda.exception.TipoNoValidoException;

public class Contacto {

	private String nombre;

	private Integer telefono;

	private TipoDeContacto tipo;

	public Contacto(String nombre, Integer telefono, TipoDeContacto tipo)
			throws NombreNoValidoException, TelefonoNoValidoException, TipoNoValidoException {
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public void nombreValido() throws NombreNoValidoException {
		if (nombre == null || nombre.isEmpty()) {
			throw new NombreNoValidoException("El nombre no puede estar vacío");
		}
	}

	public void telefonoValido() throws TelefonoNoValidoException {
		if (telefono == null || telefono <= 0) {
			throw new TelefonoNoValidoException("El teléfono no es válido");
		}
	}

	public void tipoValido() throws TipoNoValidoException {
		if (tipo == null) {
			throw new TipoNoValidoException("El tipo de contacto no puede ser nulo");
		}
	}

	public void contactoValido() throws NombreNoValidoException, TelefonoNoValidoException, TipoNoValidoException {
		nombreValido();
		telefonoValido();
		tipoValido();
	}

	public void setNombre(String nombre) throws NombreNoValidoException {
		nombreValido();
		this.nombre = nombre;
	}

	public void setTelefono(Integer telefono) throws TelefonoNoValidoException {
		telefonoValido();
		this.telefono = telefono;
	}

	public void setTipo(TipoDeContacto tipo) throws TipoNoValidoException {
		tipoValido();
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public TipoDeContacto getTipo() {
		return tipo;
	}

}
