package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;
import com.Andres.models.Personaje.DefinicionPersonaje.IAbsPersonaje;

public class AbstractDecoradorPersonaje implements IAbsPersonaje {
    protected AbstracPersonaje personajeEnvuelto;

    public AbstractDecoradorPersonaje(AbstracPersonaje abstracPersonaje) {
        this.personajeEnvuelto = abstracPersonaje;
    }

    public AbstracPersonaje getPersonajeEnvuelto() {
        return personajeEnvuelto;
    }


    @Override
    public int getAtaque() {
        return personajeEnvuelto.getAtaque();
    }

    @Override
    public String toString() {
        return personajeEnvuelto.toString();
    }

    @Override
    public int getDefensa() {
        return personajeEnvuelto.getDefensa();
    }
}
