package com.Andres.models.Personaje.Enemigos;

import com.Andres.models.Estados.Herido;
import com.Andres.models.Estados.IEstadoSalud;
import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public class Mago extends Enemigo {

    public Mago(String nombre, int ataque_base, int defensa_base, int nivel, int vidaMax, Raza raza, int rangoAtaque) {
        super(nombre, ataque_base, defensa_base, nivel, vidaMax, raza, rangoAtaque);
    }
    

    @Override
    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {

        // el estado deberia se una opcion del personaje dentro de una variedad.
        // para el caso practico de este trabajo solo se cambiara el estado a herido 

        IEstadoSalud estadoModificado = new Herido();

        objetivo.getEstadisticas().setEstadoSalud(estadoModificado);

    }



    
}
