package com.Andres.models.Estados;

public class Herido implements IEstadoSalud {

    private final float REDUCCION_PORCENTAJE_ATAQUE = 50; //%
    private final float REDUCCION_PORCENTAJE_EXPERIENCIA = 50; //%

    @Override
    public String toString() {
        return "Herido";
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public float modificadorAtaque() {
        return REDUCCION_PORCENTAJE_ATAQUE/100;
    }

    @Override
    public float modificadorExperiencia() {
        return REDUCCION_PORCENTAJE_EXPERIENCIA/100;
    }
}
