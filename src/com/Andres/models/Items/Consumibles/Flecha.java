package com.Andres.models.Items.Consumibles;

import com.Andres.models.Items.Armas.Arco;
import com.Andres.models.Personaje.Personaje;

public class Flecha extends Consumible {

    int damage;
    int rango;

    public Flecha(String nombre, int peso, int cantidad, int damage, int rango) {
        super(nombre, peso, cantidad);
        this.damage = damage;
        this.rango = rango;
    }

    @Override
    public void usar(Personaje personaje) {

        if (personaje.getManoDerecha().getClass() == Arco.class) {
            Arco arco = (Arco) personaje.getManoDerecha();
            arco.equipar(this);

            System.out.println(arco.toString());
        }
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getNombre() + " cantidad " + getCantidad();
    }

    public int getRango() {
        return rango;
    }
}
