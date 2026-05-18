package uy.edu.ort.agenda.servicios;

import java.util.ArrayList;

import uy.edu.ort.agenda.dominio.TipoContacto;

public class ServicioAgenda {

    private ArrayList<TipoContacto> tiposContacto = new ArrayList<TipoContacto> ();
    
    public void agregarTipoContacto(String nombre){
        tiposContacto.add(new TipoContacto(nombre));
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return tiposContacto;
    }

}
