package com.Andres.models.Estados;

public class Vivo implements IEstadoSalud {

    private final float PORCENTAJE_ATAQUE = 100; //%
    private final float PORCENTAJE_EXPERIENCIA = 100; //%

    @Override
    public String toString() {
        return "Vivo";
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public float modificadorAtaque() {
        return PORCENTAJE_ATAQUE/100;
    }

    @Override
    public float modificadorExperiencia() {
        return PORCENTAJE_EXPERIENCIA/100;
    }
}
