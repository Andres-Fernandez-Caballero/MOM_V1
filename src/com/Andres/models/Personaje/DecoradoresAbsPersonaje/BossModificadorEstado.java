package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Estados.Herido;
import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public class BossModificadorEstado extends BossDecorator {

    public BossModificadorEstado(AbstracPersonaje personajeEnvoltorio) {
        super(personajeEnvoltorio);
    }

    @Override
    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {
       super.realizarAccion(objetivo);
       objetivo.getEstadisticas().setEstadoSalud(new Herido());
    }

    @Override
    public int getAtaque() {
        return super.getAtaque();
    }

    @Override
    public int getDefensa() {
        return super.getDefensa();
    }
    
}
