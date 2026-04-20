package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class SistemaClientes {
    private static final SistemaClientes instancia = new SistemaClientes();
    private ArrayList<Cliente> clientes;

    private SistemaClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

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

    public static SistemaClientes getInstancia() {
        return instancia;
    }
}
