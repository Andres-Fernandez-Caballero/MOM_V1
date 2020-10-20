package com.Andres.models.Items;

public class Arco extends Arma{

    private Flecha flecha;

    public Arco(String nombre, int peso, int baseDamage) {
        super(nombre, peso, baseDamage);
        flecha = null; //no tengo flechas equipadas cuando creo un arco
    }

    public void equipar(Flecha flecha){
        this.flecha = flecha;
    }

    @Override
    public int ataque() {
        int damage = 0;

        if(this.flecha != null){ //tengo flechas en el arco
            if(flecha.consumir()){
                damage = baseDamage + flecha.getDamage();
            }
        }
        return damage;
    }

    @Override
    public String toString() {
        return getNombre() + " equipado con " + this.flecha.toString();
    }

    


    
}
