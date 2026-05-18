package uy.edu.ort.agenda.dominio;

import lombok.Getter;

public class TipoContacto {
    
    @Getter
    private String descripcion;

    public TipoContacto(String descripcion) {
        this.descripcion = descripcion;
    }

 
}
