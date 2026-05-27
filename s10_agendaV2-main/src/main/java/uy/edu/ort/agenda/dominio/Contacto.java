package uy.edu.ort.agenda.dominio;

import lombok.Getter;
import uy.edu.ort.agenda.excepciones.AgendaException;

public class Contacto {
    @Getter
    private String nombre;
    @Getter
    private Telefono telefono;
    @Getter
    private TipoContacto tipoContacto;

    public Contacto(String nombre, String telefono, TipoContacto tipoContacto) throws AgendaException {
        this.nombre = nombre;
        this.telefono = new Telefono(telefono, telefono.getTipoTelefono());
        this.tipoContacto = tipoContacto;
    }

    public void validar() throws AgendaException {
        if (nombre == null || nombre.isBlank()) {
            throw new AgendaException("El nombre no puede estar vacio");
        }
        if (telefono == null) {
            throw new AgendaException("El telefono no puede estar vacio");
        }

        telefono.validar();

        if (tipoContacto == null) {
            throw new AgendaException("El tipo de contacto no puede estar vacio");
        }
    }
}
