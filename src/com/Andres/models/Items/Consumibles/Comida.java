package com.Andres.models.Items.Consumibles;

import com.Andres.models.Personaje.DefinicionPersonaje.*;
import com.Andres.models.Personaje.Personaje;

public class Comida extends Consumible {

    private int vidaCurada;

    public Comida(String nombre, int peso, int cantidad, int vidaCurada) {
        super(nombre, peso, cantidad);
        this.vidaCurada = vidaCurada;
    }

    @Override
    public void usar(Personaje personaje) {

        if (consumir()) { //si quedan existencias consumo el consumible
        
            personaje.getEstadisticas().setVidaActual(this.vidaCurada, BarraVida.TIPO_CURA);
            System.out.println("Vida regenerada " + this.vidaCurada + " existencias restantes " +  this.getCantidad());
        }else{
            // TODO: arrojar alguna exepcion si no hay items por ahora mensajito de advertencia
    
        }
    }

}
