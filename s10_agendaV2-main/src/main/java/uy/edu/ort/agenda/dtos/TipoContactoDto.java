package uy.edu.ort.agenda.dtos;

import lombok.Getter;
import uy.edu.ort.agenda.dominio.TipoContacto;

public class TipoContactoDto {

    @Getter
    private String descripcion;
  
    public TipoContactoDto(TipoContacto tc) {
        this.descripcion = tc.getDescripcion();   
       
    }  

}
