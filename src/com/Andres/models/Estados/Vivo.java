package com.Andres.models.Estados;

public class Vivo implements IEstadoSalud {
    @Override
    public float reduccion() {
        return 1;
    }

    @Override
    public String toString() {
        return "Vivo";
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
