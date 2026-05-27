package uy.edu.ort.agenda.servicios;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.dominio.Celular;
import uy.edu.ort.agenda.dominio.Fijo;
import uy.edu.ort.agenda.dominio.Internacional;
import uy.edu.ort.agenda.dominio.TipoBusqueda;
import uy.edu.ort.agenda.dominio.TipoBusquedaCombinada;
import uy.edu.ort.agenda.dominio.TipoBusquedaNombre;
import uy.edu.ort.agenda.dominio.TipoBusquedaNumero;
import uy.edu.ort.agenda.dominio.TipoContacto;
import uy.edu.ort.agenda.dominio.TipoTelefono;

public class ServicioAgenda {

    private ArrayList<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();

    private ArrayList<TipoTelefono> tiposTelefono = new ArrayList<>(List.of(
            new Fijo("Fijo"),
            new Celular("Celular"),
            new Internacional("Internacional")));

    private ArrayList<TipoBusqueda> tiposBusqueda = new ArrayList<>(List.of(
            new TipoBusquedaNumero(),
            new TipoBusquedaNombre(),
            new TipoBusquedaCombinada()));

    public void agregarTipoContacto(String nombre) {
        tiposContacto.add(new TipoContacto(nombre));
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return tiposContacto;
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return tiposTelefono;
    }

    public ArrayList<TipoBusqueda> getTiposBusqueda() {
        return tiposBusqueda;
    }

}
