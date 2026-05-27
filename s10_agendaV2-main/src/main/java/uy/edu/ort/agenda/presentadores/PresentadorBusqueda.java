package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import uy.edu.ort.agenda.dominio.Agenda;
import uy.edu.ort.agenda.dominio.Contacto;
import uy.edu.ort.agenda.dominio.TipoBusqueda;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.dtos.AgendaDto;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.utils.Command;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uy.edu.ort.agenda.utils.Commands;

@RestController
@RequestMapping("/busqueda")
@Scope("session")
public class PresentadorBusqueda {

    private Agenda agenda;

    @GetMapping("/vistaConectada")
    public Commands inicializarVista(
            @SessionAttribute(name = "usuarioAgenda", required = false) UsuarioAgenda usuario) {

        if (usuario == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Command.lista(new Command("usuarioNoAutenticado", "login.html"));
        }
        agenda = usuario.getAgenda();

        return Command.lista(
                titulo(),
                tipoBusquedaActual(),
                tiposBusquedaDisponibles());
    }

    private Command tiposBusquedaDisponibles() {
        List<String> nombresTipos = FachadaServicios.getInstancia().getTiposBusqueda()
                .stream()
                .map(TipoBusqueda::getNombre)
                .collect(Collectors.toList());
        return new Command("tiposBusquedaDisponibles", nombresTipos);
    }

    @PostMapping("/setTipoBusqueda")
    public Commands setTipoBusqueda(@RequestParam String tipo) {
        TipoBusqueda tipoBusqueda = FachadaServicios.getInstancia().getTiposBusqueda()
                .stream()
                .filter(tb -> tb.getNombre().equals(tipo))
                .findFirst()
                .orElse(null);
        if (tipoBusqueda != null) {
            agenda.setTipoBusqueda(tipoBusqueda);
        }
        return Command.lista(tipoBusquedaActual());
    }

    private Command tipoBusquedaActual() {
        return new Command("tipoBusquedaActual", agenda.getTipoBusqueda().getNombre());
    }

    @PostMapping("/buscar")
    public Commands buscarContactos(@RequestParam String filtro) throws AgendaException {

        if (filtro.isBlank())
            throw new AgendaException("Ingrese un texto de busqueda");
        List<Contacto> lista = agenda.buscar(filtro);
        return Command.lista(resultado(lista));
    }

    private Command resultado(List<Contacto> contactos) {

        return new Command("resultado", new AgendaDto(contactos, contactos.size()));
    }

    private Command titulo() {
        return new Command("titulo", "Buscando en " + agenda.cantidadContactos() + " contactos.");
    }

}
