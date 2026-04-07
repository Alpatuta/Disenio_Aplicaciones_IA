/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ort.da.ejemplos.contador.presentador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ort.da.ejemplos.contador.modelo.Contador;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/contador")

public class PresentadorContador {
    
    private Contador contador = new Contador();
    
    @PostMapping("/vistaConectada")
    public Commands vistaConectada() {
       return Commands.create(valorContador());
    }
    @PostMapping("/sumar")
    public Commands sumar(){
        contador.sumar();
        return Commands.create(valorContador());
    }
    @PostMapping("/restar")
    public Commands restar() {
        if(contador.restar()){
          return Commands.create(valorContador());
        }else return Commands.create(mensaje("No es posible restar"));
    }
    
    private Command valorContador() {
        return new Command("valor",contador.getValor());
    }
        
    private Command mensaje(String texto){
        return new Command("mensaje", texto);
    }
    
}
