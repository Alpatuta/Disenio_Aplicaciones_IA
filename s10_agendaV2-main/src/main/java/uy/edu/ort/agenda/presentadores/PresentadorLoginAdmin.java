package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.utils.Commands;

@RestController
@RequestMapping("/admin")
public class PresentadorLoginAdmin extends PresentadorLogin<Administrador> {

    @Override
    protected String siguienteCU() {
        return "admin.html";
    }

    @Override
    protected Administrador obtenerUsuario(String nombre, String contrasenia) throws AgendaException {
        return FachadaServicios.getInstancia().loginAdministrador(nombre, contrasenia);
    }

    @PostMapping("/logout")
    public Commands logout(HttpSession session) {
        Administrador admin = (Administrador) session.getAttribute("usuarioAgenda");
        if (admin != null) {
            FachadaServicios.getInstancia().logoutAdministrador(admin.getNombre());
        }
        session.invalidate();
        return new Commands(null);
    }

}
