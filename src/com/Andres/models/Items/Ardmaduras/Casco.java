package com.Andres.models.Items.Ardmaduras;

import com.Andres.models.Personaje.Personaje;

public class Casco extends Armadura {

    public Casco(String nombre, int peso, int defensa) {
        super(nombre, peso, defensa);
    }

    @Override
    public void usar(Personaje personaje) {
       personaje.equiparCasco(this);
    }
}
