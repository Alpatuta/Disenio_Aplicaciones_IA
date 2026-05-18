package uy.edu.ort.agenda.dominio;

import lombok.Getter;
import uy.edu.ort.agenda.excepciones.AgendaException;

public class Contacto {
    @Getter
    private String nombre;
    @Getter
    private String telefono;
    @Getter
    private TipoContacto tipoContacto;

    public Contacto(String nombre, String telefono, TipoContacto tipoContacto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoContacto = tipoContacto;
    }

    public void validar() throws AgendaException {
        if (nombre == null || nombre.isBlank()) {
            throw new AgendaException("El nombre no puede estar vacio");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new AgendaException("El telefono no puede estar vacio");
        }

        if (telefono != null && telefono.length() < 8) {
            throw new AgendaException("El telefono debe tener al menos 8 digitos");
        }
        if (tipoContacto == null) {
            throw new AgendaException("El tipo de contacto no puede estar vacio");
        }
    }
}
