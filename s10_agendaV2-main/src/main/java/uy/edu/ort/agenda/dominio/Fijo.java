package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Fijo extends Telefono {

    public Fijo(String numero) {
        super(numero);
    }

    @Override
    public void validarSegunTipo(String numero) throws AgendaException {
        if (!numero.matches("\\d{8}")) {
            throw new AgendaException("El número de teléfono fijo debe contener exactamente 8 dígitos.");
        }
    }

}
