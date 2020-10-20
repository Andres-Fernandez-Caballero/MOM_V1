package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

public class Flecha extends Consumible {

    int damage;

    public Flecha(String nombre, int peso, int cantidad, int damage) {
        super(nombre, peso, cantidad);
        this.damage = damage;
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

}
