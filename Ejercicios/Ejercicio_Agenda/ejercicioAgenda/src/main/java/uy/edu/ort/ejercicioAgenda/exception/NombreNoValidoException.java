package uy.edu.ort.ejercicioAgenda.exception;

public class NombreNoValidoException extends Exception {
    public NombreNoValidoException() {
        super("El nombre no es válido.");
    }

    public NombreNoValidoException(String mensaje) {
        super(mensaje);
    }
}
