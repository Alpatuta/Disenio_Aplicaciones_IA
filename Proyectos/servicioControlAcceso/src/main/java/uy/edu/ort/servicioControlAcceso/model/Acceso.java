package uy.edu.ort.servicioControlAcceso.model;
import java.util.Date;

import lombok.Getter;

public class Acceso {
    @Getter private Date entrada;
    @Getter private Date salida;

}
