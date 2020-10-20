package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

public class Armadura extends Item {

    private int defensa;

    public Armadura(String nombre, int peso, int defensa) {
        super(nombre, peso);
        this.defensa = defensa;
    }

    public int getDefensa(){
        return defensa;
    }

    @Override
    public void usar(Personaje personaje) {
        personaje.equiparArmadura(this);

    }

    @Override
    public String toString() {
        return "Armadura => nombre: " + getNombre() + " defensa: " + getDefensa();
    }    
}
