package com.Andres.models.Items.Ardmaduras;

import com.Andres.models.Items.Item;

public abstract class Armadura extends Item {

    private int defensa;

    public Armadura(String nombre, int peso, int defensa) {
        super(nombre, peso);
        this.defensa = defensa;
    }

    public int getDefensa(){
        return defensa;
    }

    @Override
    public String toString() {
        return "Armadura => nombre: " + getNombre() + " defensa: " + getDefensa();
    }    
}
