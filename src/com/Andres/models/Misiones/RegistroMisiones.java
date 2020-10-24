package com.Andres.models.Misiones;

import java.util.ArrayList;

import javax.swing.AbstractAction;

import com.Andres.models.Personaje.Personaje;

public class RegistroMisiones {

    ArrayList<Mision> misiones;

    public RegistroMisiones() {
        misiones = new ArrayList<>();
    }    

    public void agregarMision(Mision mision){
        misiones.add(mision);
    }

    public void eliminarMision(Mision mision){
        misiones.remove(mision);
    }

    public void infrormarPersonajeMuerto(Personaje personaje){
        for (Mision mision : misiones) {
              mision.actualizar(personaje);  
        }
    }

    
    
}
