package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public class BossInflingir extends BossDecorator {

    private final int ataqueAumentado = 30;

    public BossInflingir(AbstracPersonaje personajeEnvoltorio) {
        super(personajeEnvoltorio);
    }

    @Override
    public int getAtaque() {
        return super.getAtaque() + ataqueAumentado;    }

    
    
}
