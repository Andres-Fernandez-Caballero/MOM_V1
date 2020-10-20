package com.Andres.models.Personaje;

import com.Andres.models.Estados.IEstadoSalud;
import com.Andres.models.Items.Inventario;

public class Estadisticas {

    private BarraVida barraVida;
    private final int ataqueBase;
    private final int defensaBase;

    public Estadisticas(int ataqueBase, int defensaBase, int vidaMax) {
        this.ataqueBase = ataqueBase;
        this.defensaBase = defensaBase;
        this.barraVida = new BarraVida(vidaMax);
    }

    public int getAtaque() {

        return this.ataqueBase;
    }

    public int getDefensa(){
      return this.defensaBase;
    }

    public int getVidaMax(){
        return  barraVida.getVidaMax();
    }

    public int getVidaActual(){
        return barraVida.getVidaActual();
    }

    public IEstadoSalud getEstadoSalud(){
        return barraVida.getEstadoSalud();
    }

    public void setVidaActual(int cantVida, int tipo_efecto){
        barraVida.setVidaActual(cantVida,tipo_efecto);
    }

    public void setEstadoSalud(IEstadoSalud nuevo_estado){
        barraVida.setEstadoSalud(nuevo_estado);
    }

    public BarraVida getBarraVida() {
        return barraVida;
    }

    public boolean isDead(){
        return this.barraVida.getEstadoSalud().isDead();
    }

    @Override
    public String toString() {
        return
                "Estadisticas" + "\n"
                + barraVida.toString() + "\n"
                + "Ataque base: " + ataqueBase +"\n"
                + "Defensa base: " + defensaBase + "\n";
    }
}
