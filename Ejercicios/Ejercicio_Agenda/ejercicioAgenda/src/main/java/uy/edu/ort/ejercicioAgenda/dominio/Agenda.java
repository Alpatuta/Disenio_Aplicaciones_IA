package uy.edu.ort.ejercicioAgenda.dominio;

import java.util.List;

public class Agenda {

	private List<Contacto> contactos;

	public Agenda(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public void agregarContacto(Contacto nuevo) {
		contactos.add(nuevo);
	}

	public Contacto buscarContacto(String nombre) {
		for (Contacto contacto : contactos) {
			if (contacto.getNombre().equals(nombre)) {
				return contacto;
			}
		}
		return null;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

}
