package uy.edu.ort.ejercicioAgenda.dominio;

import uy.edu.ort.ejercicioAgenda.exception.CredencialesNoValidasException;

import java.util.ArrayList;
import java.util.List;

public class SistemaUsuarios {

	private List<Usuario> usuarios;

	public SistemaUsuarios() {
		// Inicializar la lista de usuarios
		usuarios = new ArrayList<>();
	}

	public void agregarContacto(Contacto nuevo) {

	}

	public Contacto buscarContacto(String nombre) {
		Contacto contactoEncontrado = null;

		for (Usuario usuario : usuarios) {
			for (Contacto contacto : usuario.getAgenda().getContactos()) {
				if (contacto.getNombre().equals(nombre)) {
					contactoEncontrado = contacto;
					break;
				}
			}
			if (contactoEncontrado != null) {
				break;
			}
		}

		return contactoEncontrado;
	}

	public Agenda mostrarAgenda(Usuario u) throws CredencialesNoValidasException {
		Usuario usuarioEncontrado = buscarUsuario(u.getNombre(), u.getContrasenia());

		if (usuarioEncontrado == null) {
			throw new CredencialesNoValidasException("Credenciales no válidas");
		}

		return usuarioEncontrado.getAgenda();
	}

	public Usuario buscarUsuario(String nombre, String contrasenia) throws CredencialesNoValidasException {
		Usuario usuarioEncontrado = null;

		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getContrasenia().equals(contrasenia)) {
				usuarioEncontrado = usuario;
				break;
			}
		}

		if (usuarioEncontrado == null) {
			throw new CredencialesNoValidasException("Credenciales no válidas");
		}

		return usuarioEncontrado;
	}

	public static SistemaUsuarios getInstancia() {
		return new SistemaUsuarios();
	}

}
