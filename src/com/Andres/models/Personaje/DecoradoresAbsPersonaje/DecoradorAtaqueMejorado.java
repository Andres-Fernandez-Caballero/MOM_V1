package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.AbstracPersonaje;

public class DecoradorAtaqueMejorado extends AbstractDecoradorPersonaje {

    private int mejoraAtaque;

    public DecoradorAtaqueMejorado(AbstracPersonaje abstracPersonaje, int mejoraAtaque) {
        super(abstracPersonaje);
        this.mejoraAtaque = mejoraAtaque;
    }

    @Override
    public int getAtaque() {
        return (super.getAtaque());
    }
}
