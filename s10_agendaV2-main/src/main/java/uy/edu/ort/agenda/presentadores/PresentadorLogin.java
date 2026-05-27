package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;

public abstract class PresentadorLogin<U extends Usuario> {

    private final FachadaServicios f = FachadaServicios.getInstancia();

    @PostMapping("/login")
    public Commands login(HttpSession sesionHttp, @RequestParam String nombre, @RequestParam String contrasenia)
            throws AgendaException {

        U usuarioLogueado = obtenerUsuario(nombre, contrasenia);
        if (usuarioLogueado == null)
            throw new AgendaException("Usuario o contraseña incorrectos");

        sesionHttp.setAttribute("usuarioAgenda", usuarioLogueado);
        return Command.lista(new Command("loginExitoso", siguienteCU()));
    }

    @PostMapping("/logout")
    public Commands logout(HttpSession sesionHttp) {
        Usuario usuario = (Usuario) sesionHttp.getAttribute("usuarioAgenda");
        if (usuario != null) {
            sesionHttp.removeAttribute("usuarioAgenda");
            sesionHttp.invalidate();
        }

        // Si el usuario es usuarioAgenda lo saco de la lista de usuarios conectados
        if (usuario instanceof UsuarioAgenda) {
            f.desconectarUsuario((UsuarioAgenda) usuario);
        }
        return Command.lista(new Command("usuarioNoAutenticado", loginUrl()));
    }

    protected abstract String siguienteCU();

    protected abstract U obtenerUsuario(String nombre, String contrasenia) throws AgendaException;

    protected abstract String loginUrl();
}
