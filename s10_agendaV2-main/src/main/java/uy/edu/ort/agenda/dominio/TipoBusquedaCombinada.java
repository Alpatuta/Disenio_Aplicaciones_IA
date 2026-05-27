package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public class TipoBusquedaCombinada extends TipoBusqueda {

    public TipoBusquedaCombinada() {
        super("Combinada");
    }

    @Override
    public List<Contacto> filtrar(String filtro, List<Contacto> contactos) {
        List<Contacto> resultado = new ArrayList<>();

        for (Contacto c : contactos) {
            if (c.getNombre().contains(filtro) || c.getTelefono().getNumero().startsWith(filtro)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}
