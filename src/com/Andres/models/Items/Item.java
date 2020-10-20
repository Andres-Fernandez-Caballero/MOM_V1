package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

public abstract class Item {
    private String nombre;
    private float peso;

    public Item(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public abstract void usar(Personaje personaje);

    public String getNombre(){
        return this.nombre;
    }

    public float getPeso(){
        return peso;
    }
}
