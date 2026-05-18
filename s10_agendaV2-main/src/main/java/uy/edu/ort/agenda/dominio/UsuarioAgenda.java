package uy.edu.ort.agenda.dominio;

import lombok.Getter;

public class UsuarioAgenda extends Usuario {
    @Getter
    private Agenda agenda;

    public UsuarioAgenda(String nombre, String contrasenia, String nombreCompleto) {
        super(nombre, contrasenia, nombreCompleto);
        this.agenda = new Agenda();
    }

}
