package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.utils.Command;
import uy.edu.ort.agenda.utils.Commands;

public abstract class PresentadorLogin<U extends Usuario> {

    @PostMapping("/login")
    public Commands login(HttpSession sesionHttp, @RequestParam String nombre, @  RequestParam String contrasenia)
            throws AgendaException {

        U usuarioLogueado = obtenerUsuario(nombre, contrasenia);
        if (usuarioLogueado == null)
            throw new AgendaException("Usuario o contraseña incorrectos");
        
        sesionHttp.setAttribute("usuarioAgenda", usuarioLogueado);
        return Command.lista(new Command("loginExitoso", siguienteCU()));
    }

    protected abstract String siguienteCU();

    protected abstract U obtenerUsuario(String nombre, String contrasenia) throws AgendaException;
}
