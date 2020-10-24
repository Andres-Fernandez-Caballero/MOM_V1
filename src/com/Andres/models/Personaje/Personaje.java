package com.Andres.models.Personaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Item;
import com.Andres.models.Items.Ardmaduras.*;
import com.Andres.models.Items.Armas.Arma;
import com.Andres.models.Items.MochilaEInventario.Inventario;
import com.Andres.models.Misiones.RegistroMisiones;
import com.Andres.models.Personaje.DefinicionPersonaje.AbstracPersonaje;

public class Personaje extends AbstracPersonaje {

    private Inventario inventario;
    private RegistroMisiones registroMisiones;

    public Personaje(String nombre, int ataque_base, int defensa_base, int vidaMax) {
        super(nombre, ataque_base, defensa_base, vidaMax);
        this.inventario = new Inventario(100); //TODO: arreglar ese Horrendo numero magico...
        this.registroMisiones = new RegistroMisiones();
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
        defensa += this.getInventario().getArmadura().getDefensa();
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

    public int atacaA(AbstracPersonaje objetivo) throws PersonajeException {
        if (this.isDead()) {
            throw new PersonajeException(PersonajeException.PERSONAJE_MUERTO);
        }

        if (getRango() < this.getCoordenadas().distanciaA(objetivo.getCoordenadas())) {

            throw new PersonajeException(PersonajeException.PERSONAJE_FUERA_RANGO + "\ndistancia del objetivo: "
                    + this.getCoordenadas().distanciaA(objetivo.getCoordenadas()) + " rango del arma: " + this.getRango());
        }
        
        int ataqueEfectuado = objetivo.recibeAtaque(this.getAtaque());

        if(objetivo.isDead()){
            this.getBarraExperiencia().acumularExperiencia(this, objetivo);
            this.registroMisiones.infrormarPersonajeMuerto(this);
        }

        return ataqueEfectuado;
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

    public void equiparCasco(Casco casco){

        this.getInventario().getArmadura().equiparCasco(casco);;
        mensajeArmaduraEquipada(casco);
    
    }

    public void equiparPeto(Peto peto){
        this.getInventario().getArmadura().equiparPeto(peto);
        mensajeArmaduraEquipada(peto);
    }

    public void equiparGuanteletes(Guanteletes guanteletes){
        this.getInventario().getArmadura().equiparGuanteletes(guanteletes);
        mensajeArmaduraEquipada(guanteletes);
    }

    public void equiparGrebas(Grebas grebas){
        this.getInventario().getArmadura().equiparGrebas(grebas);
        mensajeArmaduraEquipada(grebas);
    }

    public void equiparArmaManoDerecha(Arma arma){
        // equipar arma
        this.inventario.equiparArmaManoDerecha(arma);
        System.out.println(this.getNombre() + " ahora porta " + this.getManoDerecha().getNombre());
    }

    public void mensajeArmaduraEquipada(Armadura armadura){
        System.out.println("ahora " + this.getNombre() + " esta protegido por " + armadura.getNombre());
    }

}
