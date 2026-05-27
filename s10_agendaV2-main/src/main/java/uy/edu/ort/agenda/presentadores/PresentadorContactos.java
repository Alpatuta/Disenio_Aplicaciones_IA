package uy.edu.ort.agenda.presentadores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import uy.edu.ort.agenda.dominio.Agenda;
import uy.edu.ort.agenda.dominio.Celular;
import uy.edu.ort.agenda.dominio.Contacto;
import uy.edu.ort.agenda.dominio.Fijo;
import uy.edu.ort.agenda.dominio.Internacional;
import uy.edu.ort.agenda.dominio.Telefono;
import uy.edu.ort.agenda.dominio.TipoContacto;
import uy.edu.ort.agenda.dominio.TipoTelefono;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.dtos.AgendaDto;
import uy.edu.ort.agenda.dtos.TipoContactoDto;
import uy.edu.ort.agenda.dtos.TipoTelefonoDto;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;

@RestController
@RequestMapping("/contactos")
@Scope("session") // Define el alcance de la sesión para este controlador
public class PresentadorContactos {

    private Agenda agenda;
    private List<TipoContacto> tiposContacto;

    @GetMapping("/vistaConectada")
    public Commands inicializarVista(
            @SessionAttribute(name = "usuarioAgenda", required = false) UsuarioAgenda usuario) {
        if (usuario == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Command.lista(new Command("usuarioNoAutenticado", "login.html"));
        }
        agenda = usuario.getAgenda();
        return Command.lista(tiposContacto(), tiposTelefono(), agenda());

    }

    @PostMapping("/crearContacto")
    public Commands crearContacto(@RequestParam String nombre, @RequestParam String telefono,
            @RequestParam String tipoTelefono, @RequestParam int posTipoContacto) throws AgendaException {

        // esto me sirve para validar que el usuario haya seleccionado un tipo de
        // contacto, ya que si no selecciona ninguno, el valor de posTipoContacto será
        // -1, lo que indica que no se ha seleccionado ningún tipo de contacto válido.
        if (posTipoContacto < 0)
            return Command.lista(new Command("error", "Seleccione el tipo de contacto"));

        TipoContacto tc = tiposContacto.get(posTipoContacto); // obtengo el tipo de contacto seleccionado por el usuario
                                                              // a través de su posición en la lista "tiposContacto".
        agenda.agregar(new Contacto(nombre, crearTelefono(tipoTelefono, telefono), tc));
        return Command.lista(agenda(), mensaje("Contacto creado con exito"), new Command("limpiarFormulario", true));

    }

    private Telefono crearTelefono(String tipoTelefono, String numero) throws AgendaException {
        if ("Fijo".equals(tipoTelefono)) {
            return new Telefono(numero, new Fijo(numero));
        }
        if ("Celular".equals(tipoTelefono)) {
            return new Telefono(numero, new Celular(numero));
        }
        if ("Internacional".equals(tipoTelefono)) {
            return new Telefono(numero, new Internacional(numero));
        }
        throw new AgendaException("Seleccione el tipo de telefono");
    }

    private Command agenda() {
        return new Command("agenda", new AgendaDto(agenda));
    }

    private Command tiposContacto() {

        tiposContacto = new ArrayList<TipoContacto>(FachadaServicios.getInstancia().getTiposContacto());

        List<TipoContactoDto> tiposDto = new ArrayList<TipoContactoDto>();

        for (TipoContacto tc : tiposContacto) {
            tiposDto.add(new TipoContactoDto(tc));
        }
        return new Command("tiposContacto", tiposDto);
    }

    private Command tiposTelefono() {

        List<TipoTelefonoDto> tiposDto = new ArrayList<TipoTelefonoDto>();

        for (TipoTelefono tipo : FachadaServicios.getInstancia().getTiposTelefono()) {
            tiposDto.add(new TipoTelefonoDto(tipo));
        }
        return new Command("tiposTelefono", tiposDto);
    }

    private Command mensaje(String msg) {
        return new Command("mensaje", msg);
    }
}
