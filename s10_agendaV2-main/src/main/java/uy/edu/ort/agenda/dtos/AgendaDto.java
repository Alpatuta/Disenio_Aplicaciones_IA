package uy.edu.ort.agenda.dtos;

import java.util.ArrayList;
import java.util.List;
import uy.edu.ort.agenda.dominio.Agenda;
import uy.edu.ort.agenda.dominio.Contacto;

public class AgendaDto {
 
    
    private int cantidadContactos;
    private List<ContactoDto> contactos;

    public AgendaDto(Agenda agenda) {
        contactos = new ArrayList<>();
        cantidadContactos = agenda.cantidadContactos();
        for(Contacto contacto:agenda.getContactos()){
            contactos.add(new ContactoDto(contacto));
        }     
    }

    public AgendaDto(List<Contacto> lista, int cantidad){
        contactos = new ArrayList<>();
        cantidadContactos = cantidad;
        for(Contacto contacto:lista){
            contactos.add(new ContactoDto(contacto));
        }
    }

    public int getCantidadContactos() {
        return cantidadContactos;
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }
    
    
    
    
}