package com.Andres.models.Personaje.DecoradoresAbsPersonaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;
import com.Andres.models.Personaje.DefinicionPersonaje.IAbsPersonaje;
import com.Andres.models.Personaje.Enemigos.IEnemigo;

public abstract class BossDecorator implements IEnemigo, IAbsPersonaje {

    protected AbstracPersonaje personajeEnvoltorio;

    public BossDecorator(AbstracPersonaje personajeEnvoltorio) {
        this.personajeEnvoltorio = personajeEnvoltorio;
    }

    @Override
    public void realizarAccion(AbstracPersonaje objetivo) throws PersonajeException {
        if (this.personajeEnvoltorio.isDead()) {
            throw new PersonajeException(PersonajeException.PERSONAJE_MUERTO);
        }

        if (personajeEnvoltorio.getRango() < this.personajeEnvoltorio.getCoordenadas()
                .distanciaA(objetivo.getCoordenadas())) {

            throw new PersonajeException(PersonajeException.PERSONAJE_FUERA_RANGO + "\ndistancia del objetivo: "
                    + this.personajeEnvoltorio.getCoordenadas().distanciaA(objetivo.getCoordenadas())
                    + " rango del arma: " + this.personajeEnvoltorio.getRango());
        }

        objetivo.recibeAtaque(this.getAtaque());
    }

    @Override
    public int getAtaque() {
        return personajeEnvoltorio.getAtaque();
    }

    @Override
    public int getDefensa() {
        return personajeEnvoltorio.getDefensa();
    }

    

}
