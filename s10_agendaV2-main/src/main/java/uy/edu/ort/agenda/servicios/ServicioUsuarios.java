package uy.edu.ort.agenda.servicios;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.dominio.Administrador;
import uy.edu.ort.agenda.dominio.Usuario;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.excepciones.AgendaException;

public class ServicioUsuarios {
    private List<Usuario> usuarios;

    public ServicioUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    private Usuario login(String nombre, String contrasenia) throws AgendaException {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.esContrasenaValida(contrasenia)) {
                return usuario;
            }
        }
        throw new AgendaException("Usuario y/o contraseña incorrectos");
    }

    public Administrador loginAdministrador(String nombre, String contrasenia) throws AgendaException {
        Usuario usuario = login(nombre, contrasenia);
        if (usuario instanceof Administrador) {
            return (Administrador) usuario;
        }
        throw new AgendaException("Usuario no es administrador");
    }

    public UsuarioAgenda loginAgenda(String nombre, String contrasenia) throws AgendaException {
        Usuario usuario = login(nombre, contrasenia);
        if (usuario instanceof UsuarioAgenda) {
            return (UsuarioAgenda) usuario;
        }
        throw new AgendaException("Usuario no es usuario de agenda");
    }
}
