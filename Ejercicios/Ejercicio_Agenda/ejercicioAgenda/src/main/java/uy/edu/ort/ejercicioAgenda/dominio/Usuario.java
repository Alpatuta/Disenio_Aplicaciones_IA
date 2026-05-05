package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.CredencialesNoValidasException;

public class Usuario {

	private String nombre;

	private String contrasenia;

	private Agenda agenda;

	public void agregarContacto(Contacto nuevo) {

	}

	/**
	 *  
	 */
	public Contacto buscarContacto(String nombre) {
		return null;
	}

	public Agenda getAgenda() {
		return null;
	}

	public Boolean validarContrasenia(String contrasenia) {
		return null;
	}

}
