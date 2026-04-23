package uy.edu.ort.practicoMvp.modelo;

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
        return true;
    }

    public int total() {
        return 0;
    }

    public int getTotal() {
        return lineaFactura.getTotal();
    }
}
