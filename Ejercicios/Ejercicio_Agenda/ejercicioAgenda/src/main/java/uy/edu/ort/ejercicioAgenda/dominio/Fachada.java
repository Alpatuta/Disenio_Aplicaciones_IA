package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.CredencialesNoValidasException;

public class Fachada {

	private static Fachada instancia = new Fachada();

	private SistemaUsuarios su = SistemaUsuarios.getInstancia();

	public void agregarContacto(Contacto nuevo) {
		su.agregarContacto(nuevo);
	}

	public Contacto buscarContacto(String nombre) {
		return su.buscarContacto(nombre);
	}

	public Usuario buscarUsuario(String nombre, String contrasenia) throws CredencialesNoValidasException {
		return su.buscarUsuario(nombre, contrasenia);
	}

	public Agenda mostrarAgenda(Usuario u) throws CredencialesNoValidasException {
		return su.mostrarAgenda(u);
	}

	public static Fachada getInstancia() {
		return instancia;
	}
}
