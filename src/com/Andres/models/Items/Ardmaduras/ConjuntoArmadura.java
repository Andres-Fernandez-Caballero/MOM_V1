package com.Andres.models.Items.Ardmaduras;

import com.Andres.models.Personaje.Personaje;

public class ConjuntoArmadura extends Armadura {

    private Armadura cabeza;
    private Armadura pecho;
    private Armadura manos;
    private Armadura piernas;

    public ConjuntoArmadura(String nombre, int peso, int defensa) {
        super(nombre, peso, defensa);
    }

    @Override
    public int getDefensa() {
        int defensa = 0;

        if (cabeza != null)
            defensa += cabeza.getDefensa();
        if (pecho != null)
            defensa += pecho.getDefensa();
        if (manos != null)
            defensa += manos.getDefensa();
        if (piernas != null)
            defensa += piernas.getDefensa();

        return defensa;
    }

    @Override
    public float getPeso() {
        float peso = 0;

        if (cabeza != null)
            peso += cabeza.getPeso();
        if (pecho != null)
            peso += pecho.getPeso();
        if (manos != null)
            peso += manos.getPeso();
        if (piernas != null)
            peso += piernas.getPeso();

        return peso;
    }

    public void equiparCasco(Casco casco) {
        this.cabeza = casco;
    }

    public void equiparPeto(Peto peto) {
        this.pecho = peto;
    }

    public void equiparGuanteletes(Guanteletes guanteletes) {
        this.manos = guanteletes;
    }

    public void equiparGrebas(Grebas grebas) {
        this.piernas = grebas;
    }

    @Override
    public void usar(Personaje personaje) {
      /* me aseguro q no se rompa nada...
       * capas debi crear otra clase totalmente nueva para evitar esto.
       */  
    }

    
    
}
