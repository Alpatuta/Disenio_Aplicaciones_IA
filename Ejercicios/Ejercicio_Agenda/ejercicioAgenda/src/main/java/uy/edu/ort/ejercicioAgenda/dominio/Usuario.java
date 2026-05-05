package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.CredencialesNoValidasException;
import uy.edu.ort.ejercicioAgenda.exception.NombreNoValidoException;

public class Usuario {

	private String nombre;

	private String contrasenia;

	private Agenda agenda;

	public Usuario(String nombre, String contrasenia, Agenda agenda)
			throws NombreNoValidoException {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.agenda = agenda;
	}

	public void agregarContacto(Contacto nuevo) {
		agenda.agregarContacto(nuevo);
	}

	public Contacto buscarContacto(String nombre) {
		Contacto contactoEncontrado = agenda.buscarContacto(nombre);

		if (contactoEncontrado == null) {
			return null;
		}

		return contactoEncontrado;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public Boolean validarContrasenia(String contrasenia) {
		boolean esValida = this.contrasenia.equals(contrasenia);
		return esValida;
	}

}
