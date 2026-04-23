package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class SistemaStock {
    private static final SistemaStock instancia = new SistemaStock();

    private ArrayList<Producto> productos;

    private ArrayList<Proveedor> proveedores;

    private SistemaStock() {
        this.productos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
    }

    public Producto getProductoMenorPrecio() {
        return new Producto();
    }

    public void agregarProveedor(Proveedor proveedor) {
        if (proveedor == null) {
            return;
        }
        proveedores.add(proveedor);
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        productos.add(producto);
        return true;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public static SistemaStock getInstancia() {
        return instancia;
    }

    public boolean existeProducto(String nombre) {
        if (nombre == null || productos == null) {
            return false;
        }
        for (Producto p : productos) {
            if (p != null && nombre.equals(p.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public Proveedor getProveedorPorNombre(String nombre) {
        if (nombre == null || proveedores == null) {
            return null;
        }
        for (Proveedor p : proveedores) {
            if (p != null && nombre.equals(p.getNombre())) {
                return p;
            }
        }
        return null;
    }

}
