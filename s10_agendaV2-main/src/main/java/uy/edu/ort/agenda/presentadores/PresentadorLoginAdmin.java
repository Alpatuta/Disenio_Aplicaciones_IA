package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;
import uy.edu.ort.agenda.utils.Command;
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

    // PresentadorLoginAdmin.java
    @Override
    @PostMapping("/logout")
    public Commands logout(HttpSession sesionHttp) {
        Administrador admin = (Administrador) sesionHttp.getAttribute("usuarioAgenda");
        if (admin != null) {
            FachadaServicios.getInstancia().logoutAdministrador(admin.getNombre());
        }
        sesionHttp.invalidate();
        return Command.lista(new Command("usuarioNoAutenticado", loginUrl()));
    }

    @Override
    protected String loginUrl() {
        return "loginAdmin.html";
    }

}
