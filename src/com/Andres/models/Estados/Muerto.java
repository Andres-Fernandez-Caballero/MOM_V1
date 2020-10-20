package com.Andres.models.Estados;

public class Muerto implements IEstadoSalud {
  
    @Override
    public float reduccion() {
        return 0;
    }

    @Override
    public String toString() {
        return "Muerto";
    }

    @Override
    public boolean isDead() {
        return true;
    }
}
