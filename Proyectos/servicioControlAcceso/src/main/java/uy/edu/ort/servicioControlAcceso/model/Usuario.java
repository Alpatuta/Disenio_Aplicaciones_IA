package uy.edu.ort.servicioControlAcceso.model;

import java.util.ArrayList;

import lombok.Getter;

public class Usuario {
    @Getter private String userName;
    @Getter private String nombre;
    @Getter private String apellido;
    @Getter private boolean habilitado;

    public ArrayList<Acceso> getAccesos() {
        return null;
    }
}
