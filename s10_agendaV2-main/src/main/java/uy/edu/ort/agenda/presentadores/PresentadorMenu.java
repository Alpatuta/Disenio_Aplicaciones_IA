package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;

@RestController
@RequestMapping("/menu")
public class PresentadorMenu {

    @GetMapping("/vistaConectada")
    public Commands inicializarVista(@SessionAttribute(name = "usuarioAgenda", required = false) Usuario usuario) {
        if (usuario == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Command.lista(new Command("usuarioNoAutenticado", "login.html"));
        }
        return Command.lista(new Command("nombreCompleto", usuario.getNombreCompleto()));

    }

}
