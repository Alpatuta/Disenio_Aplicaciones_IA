package uy.edu.ort.ejercicioAgenda.presentador;

import uy.edu.ort.ejercicioAgenda.dominio.Command;
import uy.edu.ort.ejercicioAgenda.dominio.Commands;
import uy.edu.ort.ejercicioAgenda.dominio.Fachada;
import uy.edu.ort.ejercicioAgenda.dominio.Usuario;
import uy.edu.ort.ejercicioAgenda.exception.CredencialesNoValidasException;

public class PresentadorUsuarios {

	Fachada f;

	public Commands login(String nombre, String contrasenia) throws CredencialesNoValidasException {
		Commands c = null;
		Usuario u = f.buscarUsuario(nombre, contrasenia);
		if (u == null) {
			throw new CredencialesNoValidasException("Credenciales no válidas");
		} else {
			c = Commands.create(new Command("Login exitoso", u));
		}

		return c;
	}

	public Commands logout() {
		return Commands.create(new Command("Logout", null));
	}

}
