package uy.edu.ort.ejercicioAgenda.exception;

public class TelefonoNoValidoException extends Exception {
    public TelefonoNoValidoException() {
        super("El teléfono no es válido.");
    }

    public TelefonoNoValidoException(String mensaje) {
        super(mensaje);
    }
}
