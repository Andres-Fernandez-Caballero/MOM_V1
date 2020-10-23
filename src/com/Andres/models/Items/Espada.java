package com.Andres.models.Items;

public class Espada extends Arma {

    public Espada(String nombre, int peso, int baseDamege, int rango) {
        super(nombre, peso, baseDamege, rango);
    }

    @Override
    public int ataque() {
        return baseDamage;
    }
    
}
