package com.Andres.models.Personaje.DefinicionPersonaje;

import com.Andres.models.Personaje.Personaje;

public class BarraExperiencia {

    private static final int NIVEL_MAXIMO = 10;
    private final int EXPERIENCIA_MAXIMA = 100;

    private final int COEFICIENTE_DE_EXPERIENCIA = 3;
    private final int COEFICIENTE_AUMENTO_STATS = 10;

    public static final int OPCION_MAS_VIDA = 1;
    public static final int OPCION_MAS_ATAQUE = 2;

    private int experienciaActual;
    private int nivel;

    public BarraExperiencia() {
        this.nivel = 1;
        this.experienciaActual = 0;
    }

    public BarraExperiencia(int nivel){
        this.experienciaActual = 0;
        this.nivel = nivel;
    }

    public void acumularExperiencia(Personaje personaje, AbstracPersonaje rival) {

        int nivelRival = rival.getBarraExperiencia().getNivel();
        float modificadorExp = personaje.getEstadisticas().getEstadoSalud().modificadorExperiencia();

        int expGanada = (int) (COEFICIENTE_DE_EXPERIENCIA * nivelRival * modificadorExp);

        experienciaActual += expGanada;
        if (experienciaActual > EXPERIENCIA_MAXIMA) {
            experienciaActual = 0;
            
            if(nivel < NIVEL_MAXIMO){
                subirNivel(personaje);
            }
        }
    }

    private void subirNivel(Personaje personaje) {

        int caracteristica_mejorar = elejirOpcion();

        switch (caracteristica_mejorar) {
            case OPCION_MAS_ATAQUE:
                int ataqPersonaje = personaje.getEstadisticas().getAtaque();
                int nuevoAtaqBase = ataqPersonaje + COEFICIENTE_AUMENTO_STATS;
                personaje.getEstadisticas().setAtaqueBase(nuevoAtaqBase);
                break;

            case OPCION_MAS_VIDA:
                int vidaPersonaje = personaje.getEstadisticas().getVidaMax();
                int nuevaVidaMax = vidaPersonaje + COEFICIENTE_AUMENTO_STATS;
                personaje.setVidaMax(nuevaVidaMax);
                break;
        }

    }

    private int elejirOpcion() {
        //TODO: hacer la logica para elegir la opcion deseada
        return OPCION_MAS_VIDA;
    }

    public int getNivel() {
        return nivel;
    }

}
+