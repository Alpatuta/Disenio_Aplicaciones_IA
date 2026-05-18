package uy.edu.ort.agenda.presentadores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.fachada.FachadaServicios;

@RestController
@RequestMapping("/admin")
public class PresentadorLoginAdmin extends PresentadorLogin<Administrador> {

    @Override
    protected String siguienteCU() {
        return "admin/usuarios-conectados.html";
    }

    @Override
    protected Administrador obtenerUsuario(String nombre, String contrasenia) throws AgendaException {
        return FachadaServicios.getInstancia().loginAdministrador(nombre, contrasenia);
    }

}
