package uy.edu.ort.agenda.presentadores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;

@RestController
@RequestMapping("/usuario")
public class PresentadorUsuario {

    private Administrador administrador;

    private final FachadaServicios f = FachadaServicios.getInstancia();

    @GetMapping("/vistaConectada")
    public Commands inicializarVista() {

        // Retornar comandos: el primero con el nombre del usuario administrador.
        Command mostrarUsuarioAdmin = mostrarUsuarioAdmin();
        // El segundo es la lista de usuarios conectados en formato DTO.
        Command mostrarUsuariosConectados = mostrarUsuariosConectados();

        return new Commands(List.of(mostrarUsuarioAdmin, mostrarUsuariosConectados));
    }

    private Command mostrarUsuariosConectados() {
        return new Command("mostrarUsuariosConectados", f.getUsuariosConectados());
    }

    private Command mostrarUsuarioAdmin() {
        return new Command("mostrarUsuarioAdmin", administrador.getNombre());
    }
}
