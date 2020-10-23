package com.Andres.models.Personaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Arma;
import com.Andres.models.Items.Armadura;
import com.Andres.models.Items.Inventario;
import com.Andres.models.Items.Item;

public class Personaje extends AbstracPersonaje {

    private Inventario inventario;

    public Personaje(String nombre, int ataque_base, int defensa_base, int vidaMax) {
        super(nombre, ataque_base, defensa_base, vidaMax);
        this.inventario = new Inventario(100); //TODO: arreglar ese Horrendo numero magico...
    }

    @Override
    public int getAtaque() {
        int ataque = this.getEstadisticas().getAtaque();
        if(inventario.armaEquipada()){
            ataque *= inventario.getArmaManoDerecha().ataque();
        }
        return ataque;
    }

    @Override
    public int getDefensa() {
        int defensa = this.getEstadisticas().getDefensa();
        if(inventario.armaduraEquipada()){
            defensa += inventario.getArmadura().getDefensa();
        }
        return defensa;
    }

    @Override
    public int getRango() {
        return this.getManoDerecha().getRango();
    }

    public void usa(String nombreItem) throws PersonajeException{
        Item item = this.inventario.buscar(nombreItem);
        if(item == null){ // si no encuentra el item
            throw new PersonajeException(PersonajeException.ITEM_NO_ENCONTRADO);
        }
        item.usar(this);
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public Arma getManoDerecha() {
        return this.inventario.getArmaManoDerecha();
    }

    public void agregarAlInventario(Item item) {
        this.inventario.agregar(item);

        System.out.println("se agrego al inventario de " + this.getNombre() + " " + item.getNombre() + "\n"
                + "peso actual del inventario =>" + inventario.getMochilaPrincipal().getPeso() + "/" + inventario.getMochilaPrincipal().getpesoMax() + "\n"
                + "-------------------------------------------------------"
        );
    }

    public void equiparArmadura(Armadura armadura){
        // equipar armadura
        this.inventario.equiparArmadura(armadura);
        System.out.println("ahora " + this.getNombre() + " esta protegido por " + armadura.getNombre());
    }

    public void equiparArmaManoDerecha(Arma arma){
        // equipar arma
        this.inventario.equiparArmaManoDerecha(arma);
        System.out.println(this.getNombre() + " ahora porta " + this.getManoDerecha().getNombre());
    }

    @Override
    public String toString() {
        return
                "Personaje " + getNombre() + " " + getEstadisticas().toString() + "\n"
                        + "-------------------------------------------------------";
    }
}
