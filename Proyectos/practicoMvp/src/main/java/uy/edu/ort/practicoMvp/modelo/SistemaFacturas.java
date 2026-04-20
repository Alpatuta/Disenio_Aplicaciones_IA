package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class SistemaFacturas {

    private ArrayList<Factura> facturas;

    public boolean agregarFactura(Factura factura) {
        return true;
    }

    public boolean clienteComproProducto(Cliente c, Producto p) {
        return true;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
}
