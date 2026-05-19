package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Celular extends Telefono {

    public Celular(String numero) {
        super(numero);
    }

    @Override
    public void validarSegunTipo(String numero) throws AgendaException {
        if (!numero.matches("\\d{9}")) {
            throw new AgendaException("El número de teléfono celular debe contener exactamente 9 dígitos.");
        }

        if (!numero.startsWith("09")) {
            throw new AgendaException("El número de teléfono celular debe comenzar con '09'.");
        }
    }

}
