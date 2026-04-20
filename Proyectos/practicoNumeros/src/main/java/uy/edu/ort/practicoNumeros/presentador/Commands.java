package uy.edu.ort.practicoNumeros.presentador;

import java.util.List;

public class Commands {
    private List<Command> comandos;

    private Commands(List<Command> comandos) {
        this.comandos = comandos;
    }

    public static Commands create(Command... comandos) {
        return new Commands(List.of(comandos));
    }

    
    //Agrega un comando a la lista de comandos y retorna el mismo objeto para permitir encadenar llamadas
    public Commands add(Command comando) {
        this.comandos.add(comando);
        return this;
    }

    //Agrega multiples comandos a la lista de comandos y retorna el mismo objeto para permitir encadenar llamadas
    public Commands add(Command... comandos) {
        this.comandos.addAll(List.of(comandos));
        return this;
    }

    public List<Command> getComands() {
        return comandos;
    }

    public void setComands(List<Command> comandos) {
        this.comandos = comandos;
    }

}
