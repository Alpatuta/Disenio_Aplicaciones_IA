package uy.edu.ort.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.Contacto;
import uy.edu.ort.agenda.dominio.TipoContacto;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) throws AgendaException {
		
		SpringApplication.run(AgendaApplication.class, args);
		cargarDatosDePrueba();
	}

	private static void cargarDatosDePrueba() throws AgendaException {
		// Datos de prueba
		TipoContacto particular = new TipoContacto("Particular");
		TipoContacto laboral = new TipoContacto("Laboral");
		TipoContacto familiar = new TipoContacto("Familiar");
		FachadaServicios.getInstancia().agregarTipoContacto(particular.getDescripcion());	
		FachadaServicios.getInstancia().agregarTipoContacto(laboral.getDescripcion());	
		FachadaServicios.getInstancia().agregarTipoContacto(familiar.getDescripcion());	

		UsuarioAgenda ana = new UsuarioAgenda("a", "a", "Ana Perez");
		UsuarioAgenda beatriz = new UsuarioAgenda("b", "b","Beatriz Gomez");
		UsuarioAgenda carlos = new UsuarioAgenda("c", "c","Carlos Lopez");

		ana.getAgenda().agregar(new Contacto("Pedro", "1234-5678", familiar));
		ana.getAgenda().agregar(new Contacto("Maria", "8765-4321", laboral));
		beatriz.getAgenda().agregar(new Contacto("Luis", "1122-3344", particular));
		beatriz.getAgenda().agregar(new Contacto("Ana", "4433-2211", laboral));

		FachadaServicios.getInstancia().agregar(ana);
		FachadaServicios.getInstancia().agregar(beatriz);
		FachadaServicios.getInstancia().agregar(carlos);
		
		Administrador admin = new Administrador("admin", "admin", "Administrador Principal");
		FachadaServicios.getInstancia().agregar(admin);
	}

}
