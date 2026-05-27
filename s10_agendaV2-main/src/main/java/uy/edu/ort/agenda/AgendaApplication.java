package uy.edu.ort.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.Celular;
import uy.edu.ort.agenda.dominio.Contacto;
import uy.edu.ort.agenda.dominio.Fijo;
import uy.edu.ort.agenda.dominio.Internacional;
import uy.edu.ort.agenda.dominio.Telefono;
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
		UsuarioAgenda beatriz = new UsuarioAgenda("b", "b", "Beatriz Gomez");
		UsuarioAgenda carlos = new UsuarioAgenda("c", "c", "Carlos Lopez");

		ana.getAgenda().agregar(new Contacto("Pedro", new Telefono("12345678", new Fijo("Fijo")), familiar));
		ana.getAgenda().agregar(new Contacto("Maria", new Telefono("87654321", new Fijo("Fijo")), laboral));
		ana.getAgenda().agregar(new Contacto("Lucia", new Telefono("091234567", new Celular("Celular")), familiar));
		ana.getAgenda().agregar(new Contacto("Carlos", new Telefono("098765432", new Celular("Celular")), laboral));
		ana.getAgenda().agregar(new Contacto("Sofia", new Telefono("11223344", new Fijo("Fijo")), familiar));
		ana.getAgenda().agregar(new Contacto("Diego", new Telefono("55667788", new Fijo("Fijo")), laboral));
		ana.getAgenda().agregar(
				new Contacto("Valentina", new Telefono("+5989911222", new Internacional("Internacional")), familiar));
		ana.getAgenda().agregar(
				new Contacto("Martin", new Telefono("001234567890", new Internacional("Internacional")), laboral));
		ana.getAgenda().agregar(new Contacto("Camila", new Telefono("094567890", new Celular("Celular")), familiar));
		ana.getAgenda().agregar(new Contacto("Joaquin", new Telefono("099112233", new Celular("Celular")), laboral));
		ana.getAgenda().agregar(new Contacto("Florencia", new Telefono("22334455", new Fijo("Fijo")), familiar));
		ana.getAgenda().agregar(new Contacto("Nicolas", new Telefono("66778899", new Fijo("Fijo")), laboral));
		ana.getAgenda().agregar(new Contacto("Agustina",
				new Telefono("+54 11 234567", new Internacional("Internacional")), familiar));
		ana.getAgenda().agregar(
				new Contacto("Federico", new Telefono("004412345678", new Internacional("Internacional")), laboral));
		ana.getAgenda().agregar(new Contacto("Paula", new Telefono("091998877", new Celular("Celular")), familiar));
		ana.getAgenda().agregar(new Contacto("Mateo", new Telefono("097445566", new Celular("Celular")), laboral));
		ana.getAgenda().agregar(new Contacto("Julieta", new Telefono("33445566", new Fijo("Fijo")), familiar));
		ana.getAgenda().agregar(new Contacto("Andres", new Telefono("77889900", new Fijo("Fijo")), laboral));
		ana.getAgenda().agregar(
				new Contacto("Renata", new Telefono("+1255512345", new Internacional("Internacional")), familiar));
		ana.getAgenda().agregar(
				new Contacto("Bruno", new Telefono("003498765432", new Internacional("Internacional")), laboral));
		ana.getAgenda().agregar(new Contacto("Micaela", new Telefono("093221144", new Celular("Celular")), familiar));
		ana.getAgenda().agregar(new Contacto("Sebastian", new Telefono("096778899", new Celular("Celular")), laboral));
		beatriz.getAgenda()
				.agregar(new Contacto("Luis", new Telefono("099112233", new Celular("Celular")), particular));
		beatriz.getAgenda().agregar(new Contacto("Ana", new Telefono("44332211", new Fijo("Fijo")), laboral));

		FachadaServicios.getInstancia().agregar(ana);
		FachadaServicios.getInstancia().agregar(beatriz);
		FachadaServicios.getInstancia().agregar(carlos);

		Administrador admin = new Administrador("admin", "admin", "Administrador Principal");
		FachadaServicios.getInstancia().agregar(admin);
	}

}
