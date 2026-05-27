package uy.edu.ort.agenda.dtos;

import lombok.Getter;
import uy.edu.ort.agenda.dominio.TipoTelefono;

public class TipoTelefonoDto {

    @Getter
    private String nombre;

    public TipoTelefonoDto(TipoTelefono tipo) {
        this.nombre = tipo.getNombre();

    }
}
