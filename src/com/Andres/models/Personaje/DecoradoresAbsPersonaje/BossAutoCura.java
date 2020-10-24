package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;
import com.Andres.models.Personaje.DefinicionPersonaje.BarraVida;

public class BossAutoCura extends BossDecorator {

    private final int curacion = 20;

    public BossAutoCura(AbstracPersonaje personajeEnvoltorio) {
        super(personajeEnvoltorio);
    }

	@Override
	public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {
		// TODO Auto-generated method stub
        super.realizarAccion(objetivo);
        
        personajeEnvoltorio.setVidaActual(curacion, BarraVida.TIPO_CURA);
	}

    
    
}
