package com.Andres.models.Personaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Inventario;

public abstract class AbstracPersonaje {

    private final String nombre;
    private Estadisticas estadisticas;

    public AbstracPersonaje(String nombre, int ataque_base, int defensa_base, int vidaMax) {
        this.nombre = nombre;
        this.estadisticas = new Estadisticas(ataque_base, defensa_base, vidaMax);
    }

    public void setVidaActual(int cantVida, int tipo_efecto){
        this.estadisticas.setVidaActual(cantVida,tipo_efecto);
    }

    public String getNombre(){
        return this.nombre;
    }

    public Estadisticas getEstadisticas(){
        return this.estadisticas;
    }

    public abstract  int getAtaque();

    public abstract int getDefensa();



    public boolean isDead(){
       return this.estadisticas.isDead();
    }

    public int atacaA(AbstracPersonaje objetivo) throws PersonajeException {
        if(this.isDead()){
            throw new PersonajeException(PersonajeException.PERSONAJE_MUERTO);
        }
        return objetivo.recibeAtaque(this.getAtaque());
    }

    public int recibeAtaque(int damage) {
        int ataqueRecibido = damage - this.getDefensa();

        this.getEstadisticas().setVidaActual(ataqueRecibido,BarraVida.TIPO_DAMAGE);

        if (ataqueRecibido < 0) {
            ataqueRecibido = 0;
        }

        return ataqueRecibido;
    }
    
}
