package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

public class Proveedor {
    private String nombre;

    private ArrayList<Producto> productos;

    public Proveedor(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    protected boolean agregarProducto(Producto producto) {
        this.productos.add(producto);
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Proveedor: " + nombre;
    }
}
