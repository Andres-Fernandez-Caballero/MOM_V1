package com.Andres.models.Personaje.Enemigos;

import javax.swing.AbstractAction;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public interface IEnemigo {

    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException;
}
