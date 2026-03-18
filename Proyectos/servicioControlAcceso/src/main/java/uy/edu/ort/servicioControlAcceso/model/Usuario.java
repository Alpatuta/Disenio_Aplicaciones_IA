package uy.edu.ort.servicioControlAcceso.model;

import java.util.ArrayList;

public class Usuario {
    private String userName;
    private String nombre;
    private String apellido;
    private boolean habilitado;

    public String getUserName() {
        return userName;
    }

    public String getNombre() {
        return nombre;
    }   

    public String getApellido() {
        return apellido;
    }

    public boolean habilitado(){
        return habilitado;
    }

    public ArrayList<Acceso> getAccesos() {
        return null;
    }
}
