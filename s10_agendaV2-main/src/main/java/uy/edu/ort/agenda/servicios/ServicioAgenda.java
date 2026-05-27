package uy.edu.ort.agenda.servicios;

import java.util.ArrayList;

import uy.edu.ort.agenda.dominio.TipoContacto;
import uy.edu.ort.agenda.dominio.TipoTelefono;

public class ServicioAgenda {

    private ArrayList<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();

    private ArrayList<TipoTelefono> tiposTelefono = new ArrayList<TipoTelefono>();

    public void agregarTipoContacto(String nombre) {
        tiposContacto.add(new TipoContacto(nombre));
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return tiposContacto;
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return tiposTelefono;
    }

}
