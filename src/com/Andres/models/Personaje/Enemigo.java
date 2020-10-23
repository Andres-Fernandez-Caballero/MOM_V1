package com.Andres.models.Personaje;

import com.Andres.models.Exepciones.PersonajeException;

public class Enemigo extends AbstracPersonaje {

    private Raza raza;
    private int rangoAtaque;

    public Enemigo(String nombre, Raza raza, int ataque_base, int defensa_base, int vidaMax, int rango_ataque) {
        super(nombre, ataque_base, defensa_base, vidaMax);
        this.raza = raza;
    }

    public Raza getRaza(){
        return this.raza;
    }

    @Override
    public int getAtaque() {
        return this.getEstadisticas().getAtaque();
    }

    @Override
    public int getDefensa() {
        return this.getEstadisticas().getDefensa();
    }

    @Override
    public int getRango() {
        return rangoAtaque;
    }

}
