package com.Andres.models.Personaje.Enemigos;

import javax.swing.AbstractAction;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public class Guerrero extends Enemigo {

    public Guerrero(String nombre, int ataque_base, int defensa_base, int nivel, int vidaMax, Raza raza,
    int rangoAtaque) {
        super(nombre, ataque_base, defensa_base, nivel, vidaMax, raza, rangoAtaque);
    }
    

    @Override
    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {
        if (this.isDead()) {
            throw new PersonajeException(PersonajeException.PERSONAJE_MUERTO);
        }

        if (getRango() < this.getCoordenadas().distanciaA(objetivo.getCoordenadas())) {

            throw new PersonajeException(PersonajeException.PERSONAJE_FUERA_RANGO + "\ndistancia del objetivo: "
                    + this.getCoordenadas().distanciaA(objetivo.getCoordenadas()) + " rango del arma: " + this.getRango());
        }

         objetivo.recibeAtaque(this.getAtaque());
    }

  

}
