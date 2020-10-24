package com.Andres.models.Personaje.Enemigos;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;
import com.Andres.models.Personaje.DefinicionPersonaje.BarraVida;

public class Chaman extends Enemigo {

    private int curacion;

    public Chaman(String nombre, int ataque_base, int defensa_base, int nivel, int vidaMax, Raza raza, int rangoAtaque,
            int curacion) {
        super(nombre, ataque_base, defensa_base, nivel, vidaMax, raza, rangoAtaque);
        this.curacion = curacion;
    }

    @Override
    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {
        
        objetivo.setVidaActual(curacion, BarraVida.TIPO_CURA);
    }

    public int getCuracion() {
        return curacion;
    }

    

    
    
}
