package uy.edu.ort.practicoMvp.modelo;

import java.util.List;

public class Fachada {
    private final SistemaClientes sc = SistemaClientes.getInstancia();
    private final SistemaFacturas sf = SistemaFacturas.getInstancia();
    private final SistemaStock ss = SistemaStock.getInstancia();
    private static Fachada instancia = new Fachada();

    private Fachada() {
        super();
    }

    public static Fachada getInstancia() {
        return instancia;
    }

    public Cliente buscarCliente(String unaCedula) {
        return sc.buscarCliente(unaCedula);
    }

    public boolean agregarCliente(Cliente c) {
        return sc.agregar(c);
    }

    public List<Cliente> getClientes() {
        return sc.getClientes();
    }

    public List<Producto> getProductos() {
        return ss.getProductos();
    }

    public List<Proveedor> getProveedores() {
        return ss.getProveedores();
    }

    public List<Factura> getFacturas() {
        return sf.getFacturas();
    }

    public int getTotalFacturas() {
        return sf.getTotalFacturas();
    }

    public Factura iniciarFacturaParaCliente(String cedula) {
        return sf.iniciarFacturaParaCliente(cedula);
    }

    public boolean agregarFactura(Factura factura) {
        return sf.agregarFactura(factura);
    }

    public boolean clienteComproProducto(Cliente c, Producto p) {
        return sf.clienteComproProducto(c, p);
    }

    public boolean existeCliente(String unaCedula) {
        return sc.existeCliente(unaCedula);
    }

    public List<Cliente> clientesNoCompraronProductoMenorPrecio() {
        return sc.clientesNoCompraronProductoMenorPrecio();
    }

    public boolean agregarProducto(Producto producto) {
        return ss.agregarProducto(producto);
    }

    public void agregarProveedor(Proveedor proveedor) {
        ss.agregarProveedor(proveedor);
    }

    public boolean existeProducto(String nombre) {
        return ss.existeProducto(nombre);
    }

    public Proveedor getProveedorPorNombre(String nombre) {
        return ss.getProveedorPorNombre(nombre);
    }

    public Producto getProductoMenorPrecio() {
        return ss.getProductoMenorPrecio();
    }

    public Producto buscarProducto(int idProducto) {
        return ss.buscarProducto(idProducto);
    }

    public Object agregarProductoAFactura(int idProducto, int cantidad) {
        return sf.agregarProductoAFactura(idProducto, cantidad);
    }

}
