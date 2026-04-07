/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ort.da.ejemplos.contador.modelo;

/**
 *
 * @author Dario
 */
public class Contador {
    
    private int valor;
       
    public void sumar(){
        valor++;
    }
    public boolean restar() {
        if(valor>0){
            valor--;
            return true;
            
        }return false;
        
    }

    public int getValor() {
        return valor;
    }
  
    
    
}
