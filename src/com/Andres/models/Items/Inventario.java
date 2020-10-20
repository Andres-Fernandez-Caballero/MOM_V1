package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

public class Inventario {

    private Arma manoDerecha;
    private Armadura armadura;
    private Mochila mochilaPrincipal;

    public Inventario(int capacidad_peso_maximo) {
        manoDerecha = null;
        armadura = null;
        mochilaPrincipal = new Mochila("Mochila_Principal",0,capacidad_peso_maximo);
    }

    public void equiparArmaManoDerecha(Arma arma){
        this.manoDerecha = arma;
    }

    public  Arma getArmaManoDerecha(){
        return this.manoDerecha;
    }

    public void equiparArmadura(Armadura armadura){
        this.armadura = armadura;
    }

    public Armadura getArmadura(){
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
