package uy.edu.ort.practicoMvp.modelo;

import java.util.ArrayList;

class SistemaFacturas {

    private static final SistemaFacturas instancia = new SistemaFacturas();

    private ArrayList<Factura> facturas;

    private SistemaFacturas() {
        this.facturas = new ArrayList<>();
    }

    public boolean agregarFactura(Factura factura) {
        return true;
    }

    public boolean clienteComproProducto(Cliente c, Producto p) {
        // Verifico si el cliente tiene una factura en proceso (sin producto o con el
        // producto)
        for (Factura factura : facturas) {
            if (factura.getCliente().equals(c)) {
                if (p != null && factura.tieneProducto(p)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Cliente buscarCliente(String cedula) {
        // Verifico si el cliente tiene una factura en proceso
        for (Factura factura : facturas) {
            if (factura.getCliente().getCedula().equals(cedula)) {
                return factura.getCliente();
            }
        }

        return null;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public static SistemaFacturas getInstancia() {
        return instancia;
    }

    public int getTotalFacturas() {
        int total = 0;

        for (Factura factura : facturas) {
            total += factura.getTotal();
        }

        return total;
    }

    public Factura iniciarFacturaParaCliente(String cedula) {
        Cliente c = buscarCliente(cedula);

        if (c != null) {
            Factura factura = new Factura(c);
            facturas.add(factura);
            return factura;
        }

        return null;
    }

    public Object agregarProductoAFactura(int idProducto, int cantidad) {
        Producto p = Fachada.getInstancia().buscarProducto(idProducto);
        // TODO : Terminar este metodo
        return p;
    }

}
