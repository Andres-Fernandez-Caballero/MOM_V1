package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

public abstract class Arma extends Item {

    protected   int baseDamage;

    public Arma(String nombre, int peso, int baseDamage) {
        super(nombre, peso);
        this.baseDamage = baseDamage;
    }

    public abstract int ataque();

    @Override
    public void usar(Personaje personaje) {
        personaje.equiparArmaManoDerecha(this);
    }

    @Override
    public String toString() {
        return "Arma nombre: " + getNombre() + " daño base " + baseDamage;
    }

    
}
