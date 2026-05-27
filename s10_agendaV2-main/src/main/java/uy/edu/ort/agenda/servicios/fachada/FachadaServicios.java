package uy.edu.ort.agenda.servicios.fachada;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.TipoContacto;
import uy.edu.ort.agenda.dominio.TipoTelefono;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.dominio.UsuarioConectado;
import uy.edu.ort.agenda.excepciones.AgendaException;
import uy.edu.ort.agenda.servicios.ServicioAgenda;
import uy.edu.ort.agenda.servicios.ServicioUsuarios;

public class FachadaServicios {

    private static FachadaServicios instancia;
    private ServicioUsuarios sUsuarios;
    private ServicioAgenda sAgenda;

    private FachadaServicios() {
        sUsuarios = new ServicioUsuarios();
        sAgenda = new ServicioAgenda();
    }

    public static FachadaServicios getInstancia() {
        if (instancia == null) {
            instancia = new FachadaServicios();
        }
        return instancia;
    }

    public void agregar(Usuario usuario) {
        sUsuarios.agregar(usuario);
    }

    public UsuarioAgenda loginAgenda(String nombre, String contrasenia) throws AgendaException {
        return sUsuarios.loginAgenda(nombre, contrasenia);
    }

    public Administrador loginAdministrador(String nombre, String contrasenia) throws AgendaException {
        return sUsuarios.loginAdministrador(nombre, contrasenia);
    }

    public void logoutAdministrador(String nombre) {
        sUsuarios.logoutAdministrador(nombre);
    }

    public void agregarTipoContacto(String nombre) {
        sAgenda.agregarTipoContacto(nombre);
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return sAgenda.getTiposContacto();
    }

    public List<UsuarioConectado> getUsuariosConectados() {
        return sUsuarios.getUsuariosConectados();
    }

    public void desconectarUsuario(UsuarioAgenda usuario) {
        sUsuarios.desconectarUsuario(usuario);
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return sAgenda.getTiposTelefono();
    }

}
