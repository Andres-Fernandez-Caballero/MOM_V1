package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.AbstracPersonaje;
import com.Andres.models.Personaje.IAbsPersonaje;

public class AbstractDecoradorPersonaje implements IAbsPersonaje {
    protected AbstracPersonaje personajeEnvuelto;

    public AbstractDecoradorPersonaje(AbstracPersonaje abstracPersonaje) {
        this.personajeEnvuelto = abstracPersonaje;
    }


    @Override
    public int getAtaque() {
        return personajeEnvuelto.getAtaque();
    }

    @Override
    public String toString() {
        return personajeEnvuelto.toString();
    }
}
