package com.Andres.models.Items;

public class Espada extends Arma {

    public Espada(String nombre, int peso, int baseDamege) {
        super(nombre, peso, baseDamege);
    }

    @Override
    public int ataque() {
        return baseDamage;
    }
    
}
