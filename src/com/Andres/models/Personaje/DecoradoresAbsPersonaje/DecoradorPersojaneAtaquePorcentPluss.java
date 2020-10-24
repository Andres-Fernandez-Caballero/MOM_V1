package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.DefinicionPersonaje.*;

public class DecoradorPersojaneAtaquePorcentPluss extends AbstractDecoradorPersonaje {

    private double porcentajeAumento;

    public DecoradorPersojaneAtaquePorcentPluss(AbstracPersonaje abstracPersonaje, double porcentaje_aumento) {
        super(abstracPersonaje);
        this.porcentajeAumento = porcentaje_aumento;
    }

    @Override
    public int getAtaque() {

        int ataque = super.getAtaque();

        int ataqueAumentado = (int) (ataque * (1 + (porcentajeAumento / 100)));
      
        return ataqueAumentado;
    }

    
    
}
