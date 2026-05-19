package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Internacional extends Telefono {

    public Internacional(String numero) {
        super(numero);
    }

    @Override
    public void validarSegunTipo(String numero) throws AgendaException {
        if (!numero.startsWith("00") && !numero.startsWith("+")) {
            throw new AgendaException("El número de teléfono internacional debe comenzar con '00' o '+'.");
        }

        String numeroSinPrefijo = numero.startsWith("00") ? numero.substring(2) : numero.substring(1);

        // Eliminar espacios en blanco del número
        numeroSinPrefijo = numeroSinPrefijo.replaceAll("\\s+", "");

        if (!numeroSinPrefijo.matches("\\d{10}")) {
            throw new AgendaException("El número debe tener 10 caracteres numéricos");
        }
    }

}
