package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.DefinicionPersonaje.*;

public class DecoradorPersonajeVidaPorcentPluss extends AbstractDecoradorPersonaje {

    public DecoradorPersonajeVidaPorcentPluss(AbstracPersonaje abstracPersonaje, double porcentaje_aumento) {
        super(abstracPersonaje);
        setVidaMax(porcentaje_aumento);
    }

    private void setVidaMax(double porcentaje_aumento){

        int vidaMaxActual = this.personajeEnvuelto.getEstadisticas().getBarraVida().getVidaMax();
        int nuevaVidaMax = (int) (vidaMaxActual * (1 + (porcentaje_aumento/ 100)));

        this.personajeEnvuelto.setVidaMax(nuevaVidaMax);
    }

    



    
}
