package com.Andres.models.Items.Consumibles;

import com.Andres.models.Items.Item;

public abstract class Consumible extends Item {

    private int cantidad;

    public Consumible(String nombre, int peso, int cantidad) {
        super(nombre, peso);
        this.cantidad = cantidad;
    }


    /* TODO: al ser consumido completamente deberia de hacer algo */
    public boolean consumir(){
        boolean hayConsumibles = false;
        if( cantidad >0 ){
            cantidad--;
            System.out.println("Item consumido");
            hayConsumibles = true;
        }else{
            // TODO: deberia arrojar una exepcion
            System.out.println("no hay mas existencias");
        }
        return hayConsumibles;
    }

    public int getCantidad() {
        return cantidad;
    }
    
}
