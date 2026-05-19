package uy.edu.ort.agenda.presentadores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.UsuarioConectado;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.dtos.UsuarioConectadoDto;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;

import jakarta.servlet.http.HttpSession;

// ... existing code ...
@RestController
@RequestMapping("/usuario")
public class PresentadorUsuario {

    private final FachadaServicios f = FachadaServicios.getInstancia();

    @GetMapping("/vistaConectada")
    public Commands inicializarVista(HttpSession session) {
        Administrador admin = (Administrador) session.getAttribute("usuarioAgenda");
        if (admin == null) {
            // This should not happen if the user is properly logged in as an admin.
            // You might want to throw an exception or handle it gracefully.
            return Commands.create("error", "No se ha iniciado sesión como administrador.");
        }

        // Retornar comandos: el primero con el nombre del usuario administrador.
        Command mostrarUsuarioAdmin = new Command("mostrarUsuarioAdmin", admin.getNombre());
        // El segundo es la lista de usuarios conectados en formato DTO.
        Command mostrarUsuariosConectados = mostrarUsuariosConectados();

        return Commands.create("inicializarVista", List.of(mostrarUsuarioAdmin, mostrarUsuariosConectados));
    }

    // ... existing code ...
    private Command mostrarUsuariosConectados() {

        List<UsuarioConectado> uc = f.getUsuariosConectados();
        List<UsuarioConectadoDto> usuariosConectados = new ArrayList<>();

        for (UsuarioConectado usuario : uc) {
            usuariosConectados.add(new UsuarioConectadoDto(usuario));
        }
        return new Command("mostrarUsuariosConectados", usuariosConectados);
    }

}
