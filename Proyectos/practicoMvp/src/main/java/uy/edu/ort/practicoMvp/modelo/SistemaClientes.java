package uy.edu.ort.practicoMvp.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SistemaClientes {
    private ArrayList<Cliente> clientes;

    public ArrayList<Cliente> clientesNoCompraronProductoMenorPrecio() {
        return new ArrayList<Cliente>();
    }

    public boolean existeCliente(String unaCedula) {
        boolean existe = false;

        for (Cliente c : clientes) {
            if (c.getCedula().equals(unaCedula)) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    public Cliente buscarCliente(String unaCedula) {

        for (Cliente c : clientes) {
            if (c.getCedula().equals(unaCedula)) {
                return c;
            }
        }

        return null;
    }

    public boolean agregar(Cliente c) {
        boolean agregado = false;

        if (!existeCliente(c.getCedula())) {
            clientes.add(c);
            agregado = true;
        }

        return agregado;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
