package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public abstract class Telefono {
    private String numero;

    public Telefono(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public abstract void validarSegunTipo(String numero) throws AgendaException;
}
