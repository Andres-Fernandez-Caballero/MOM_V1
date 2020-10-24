package com.Andres.models.Items.MochilaEInventario;

import com.Andres.models.Items.Item;
import com.Andres.models.Items.Ardmaduras.*;
import com.Andres.models.Items.Armas.Arma;

public class Inventario {

    private Arma manoDerecha;
    private ConjuntoArmadura armadura;
    private Mochila mochilaPrincipal;

    public Inventario(int capacidad_peso_maximo) {
        manoDerecha = null;
        armadura = new ConjuntoArmadura("Conjunto Armadura", 0, 0);
        mochilaPrincipal = new Mochila("Mochila_Principal",0,capacidad_peso_maximo);
    }

    public void equiparArmaManoDerecha(Arma arma){
        this.manoDerecha = arma;
    }

    public  Arma getArmaManoDerecha(){
        return this.manoDerecha;
    }
    
    public ConjuntoArmadura getArmadura(){
        return this.armadura;
    }

    public void agregar(Item item){
        this.mochilaPrincipal.agregar(item);
    }

    public void tirar(Item item){
        this.mochilaPrincipal.eliminar(item);
    }

    public boolean armaEquipada(){
        return this.manoDerecha != null;
    }

    public boolean armaduraEquipada(){
        return this.armadura != null;
    }

    public Item buscar( String nombre_item){
        return mochilaPrincipal.buscar(nombre_item);
    }

    public Mochila getMochilaPrincipal(){
        return  this.mochilaPrincipal;
    }

}
