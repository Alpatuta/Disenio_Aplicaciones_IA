package uy.edu.ort.practicoMvp.modelo;

public class Cliente {
    private String nombre;

    private String cedula;

    private String email;

    public Cliente(String nombre, String cedula, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validar() {
        return verificarCedula(cedula) && verificarEmail() && verificarNombre();
    }

    private boolean verificarCedula(String cedula) {
        return true;
    }

    private boolean verificarEmail() {
        return true;
    }

    private boolean verificarNombre() {
        return true;
    }

}
