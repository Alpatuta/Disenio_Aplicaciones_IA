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
        // Mostrar la lista de usuarios conectados en formato DTO

        ArrayList<UsuarioConectado> uc = new ArrayList<UsuarioConectado>(f.getUsuariosConectados());

        List<UsuarioConectadoDto> usuariosConectados = new ArrayList<>();
        for (UsuarioConectado usuario : uc) {
            usuariosConectados.add(new UsuarioConectadoDto(usuario));
        }
        return new Command("mostrarUsuariosConectados", usuariosConectados);
    }

    private Command mostrarUsuarioAdmin() {
        return new Command("mostrarUsuarioAdmin", administrador.getNombre());
    }

}
