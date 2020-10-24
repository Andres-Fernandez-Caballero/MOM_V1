package com.Andres.models.Items.Armas;

public class Hacha  extends Arma{

    private float golpeCritico;

    public Hacha(String nombre, int peso, int baseDamage,int rango, float golpeCritico) {
        super(nombre, peso, baseDamage, rango);
        setGolpeCritico(golpeCritico);
    }

    @Override
    public int ataque() {
        int damage = baseDamage;
        if(golpeCritico()){
             damage *=  2;
        }
        return damage;
    }

    private void setGolpeCritico(float golpeCritico) { 
        /*TODO: este metodo tiene q arrojar una expecion de ingreseo de datos
            para evitar un ingreso incorrecto de valores rompiendo todo ... */ 
        this.golpeCritico = golpeCritico;
    }

    private boolean golpeCritico(){
        // en un futuro se implementara algun metodo para dar golpes criticos
        return false;
    }
    
}
