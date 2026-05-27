package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public abstract class TipoTelefono {
    String nombre;

    public TipoTelefono(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void validar(String numero) throws AgendaException;

}
