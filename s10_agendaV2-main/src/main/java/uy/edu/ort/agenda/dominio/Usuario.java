package uy.edu.ort.agenda.dominio;

import lombok.Getter;

public abstract class Usuario {
    @Getter
    private String nombre;
    @Getter
    private String nombreCompleto;

    private String contrasenia;

    public boolean esContrasenaValida(String contrasenia) {
        return this.contrasenia.equals(contrasenia);
    }

    public Usuario(String nombre, String contrasenia, String nombreCompleto) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
}
