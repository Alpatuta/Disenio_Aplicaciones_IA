package uy.edu.ort.practicoMvp.modelo;

import java.util.List;

public class Fachada {
    private final SistemaClientes sc = new SistemaClientes();
    private final SistemaFacturas sf = new SistemaFacturas();
    private final SistemaStock ss = new SistemaStock();
    private static Fachada instancia;

    private Fachada() {
        super();
    }

    public static Fachada getInstancia() {
        return instancia;
    }

    public Cliente buscarCliente(String unaCedula) {
        return sc.buscarCliente(unaCedula);
    }

    public boolean agregarCliente(Cliente c) {
        return sc.agregar(c);
    }

    public List<Cliente> getClientes() {
        return sc.getClientes();
    }
}
