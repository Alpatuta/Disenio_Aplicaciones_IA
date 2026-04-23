package uy.edu.ort.practicoMvp.modelo;

import java.time.LocalDate;

public class Factura {

    private Cliente cliente;
    private LineaFactura lineaFactura;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LineaFactura getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(LineaFactura lineaFactura) {
        this.lineaFactura = lineaFactura;
    }

    public boolean agregar(int cantidad, Producto producto) {
        return true;
    }

    public boolean tieneProducto(Producto producto) {
        // Verifico si la factura tiene el producto
        if (lineaFactura != null) {
            return lineaFactura.getProducto().equals(producto);
        }
        return false;
    }

    public int total() {
        return 0;
    }

    public int getTotal() {
        return lineaFactura.getTotal();
    }

    public String toString() {
        LocalDate fecha = java.time.LocalDate.now();
        String fechaFormateada = fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "Factura [cliente = " + cliente.getNombre() + ", total = " + "$" + getTotal() + ", fecha = "
                + fechaFormateada + "]";
    }
}
