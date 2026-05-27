package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;

@RestController
@RequestMapping("/usuario")
public class PresentadorLoginUsuario extends PresentadorLogin<UsuarioAgenda> {

    @Override
    protected String siguienteCU() {
        return "menu.html";
    }

    @Override
    protected UsuarioAgenda obtenerUsuario(String nombre, String contrasenia) throws AgendaException {
        return FachadaServicios.getInstancia().loginAgenda(nombre, contrasenia);
    }

    @Override
    protected String loginUrl() {
        return "login.html";
    }

}
