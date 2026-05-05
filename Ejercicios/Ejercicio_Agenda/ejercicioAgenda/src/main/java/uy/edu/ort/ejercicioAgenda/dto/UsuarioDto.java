package uy.edu.ort.ejercicioAgenda.dto;

public class UsuarioDto {

	private String nombre;

	private String contrasenia;

	private AgendaDto agenda;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public AgendaDto getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDto agenda) {
		this.agenda = agenda;
	}
}
