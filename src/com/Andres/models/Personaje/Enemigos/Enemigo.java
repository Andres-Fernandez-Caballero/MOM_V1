package com.Andres.models.Personaje.Enemigos;

import com.Andres.models.Personaje.DefinicionPersonaje.*;

public abstract class Enemigo extends AbstracPersonaje implements IEnemigo {

    private Raza raza;
    private int rangoAtaque;

    public Enemigo(String nombre, int ataque_base, int defensa_base, int nivel, int vidaMax, Raza raza,
            int rangoAtaque) {
        super(nombre, ataque_base, defensa_base, nivel, vidaMax);
        this.raza = raza;
        this.rangoAtaque = rangoAtaque;
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
