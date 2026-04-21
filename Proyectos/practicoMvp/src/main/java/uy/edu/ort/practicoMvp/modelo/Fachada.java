package uy.edu.ort.practicoMvp.modelo;

public class Fachada {
    private final SistemaClientes sc = new SistemaClientes();
    private final SistemaFacturas sf = new SistemaFacturas();
    private final SistemaStock ss = new SistemaStock();

    public Fachada() {
        super();
    }
}
