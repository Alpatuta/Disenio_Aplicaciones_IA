package uy.edu.ort.practicoMvp.modelo;

public class Proveedor {
    private String nombre;

    private Producto producto;

    protected boolean agregarProducto(Producto producto) {
        this.producto = producto;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String ToString() {
        return "Proveedor: " + nombre + " Producto: " + producto.getNombre();
    }
}
