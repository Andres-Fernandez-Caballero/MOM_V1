package com.Andres.models.Estados;

public class Muerto implements IEstadoSalud {

    @Override
    public String toString() {
        return "Muerto";
    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public float modificadorAtaque() {
        return 0;
    }

    @Override
    public float modificadorExperiencia() {
        return 0;
    }
}
