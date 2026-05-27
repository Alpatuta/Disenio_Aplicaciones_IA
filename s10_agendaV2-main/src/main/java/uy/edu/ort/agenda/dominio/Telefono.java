package uy.edu.ort.agenda.dominio;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Telefono {
    private String numero;

    private TipoTelefono tipoTelefono;

    private String tipo;

    public Telefono(String numero, TipoTelefono tipoTelefono) throws AgendaException {
        this.numero = numero;
        this.tipoTelefono = tipoTelefono;

    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void validar() throws AgendaException {
        tipoTelefono.validar(numero);
        validarNumero();
    }

    private void validarNumero() throws AgendaException {
        if (numero == null || numero.isBlank()) {
            throw new AgendaException("El número de teléfono no puede estar vacío.");
        }
        if (!numero.matches("\\d+")) {
            throw new AgendaException("El número de teléfono debe contener solo dígitos.");
        }
    }

}
