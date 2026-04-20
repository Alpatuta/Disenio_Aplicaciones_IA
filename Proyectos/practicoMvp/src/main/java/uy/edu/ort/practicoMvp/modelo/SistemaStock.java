package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class SistemaStock {
    private ArrayList<Producto> productos;

    private ArrayList<Proveedor> proveedores;

    public Producto getProductoMenorPrecio() {
        return new Producto();
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public boolean agregarProducto(Producto producto) {
        productos.add(producto);
        return true;
    }

    public SistemaStock getInstancia() {
        return this;
    }
}
