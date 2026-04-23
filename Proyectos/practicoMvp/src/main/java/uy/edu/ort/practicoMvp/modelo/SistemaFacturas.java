package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class SistemaFacturas {

    private static final SistemaFacturas instancia = new SistemaFacturas();

    private ArrayList<Factura> facturas;

    private SistemaFacturas() {
        this.facturas = new ArrayList<>();
    }

    public boolean agregarFactura(Factura factura) {
        return true;
    }

    public boolean clienteComproProducto(Cliente c, Producto p) {
        return true;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public static SistemaFacturas getInstancia() {
        return instancia;
    }

}
