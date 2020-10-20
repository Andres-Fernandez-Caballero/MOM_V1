package com.Andres.models.Estados;

public class Herido implements IEstadoSalud {

    private final float reduccionDamage = (float) 0.5;

    @Override
    public float reduccion() {
        return reduccionDamage;
    }

    @Override
    public String toString() {
        return "Herido";
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
