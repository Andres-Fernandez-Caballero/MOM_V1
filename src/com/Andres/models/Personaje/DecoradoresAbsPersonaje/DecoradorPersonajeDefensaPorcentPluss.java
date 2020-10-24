package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.DefinicionPersonaje.*;

public class DecoradorPersonajeDefensaPorcentPluss extends AbstractDecoradorPersonaje {

        private double porcentajeAumento;    

    public DecoradorPersonajeDefensaPorcentPluss(AbstracPersonaje abstracPersonaje, double porcentaje_aumento) {
        super(abstracPersonaje);
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public int getDefensa() {
        
        int defensa = super.getDefensa();

        int defensaAumentada = (int) (defensa * (1 + (porcentajeAumento / 100)));
      
        return defensaAumentada;
    }
    
}
