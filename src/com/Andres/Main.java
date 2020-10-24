package com.Andres;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Ardmaduras.Armadura;
import com.Andres.models.Items.Ardmaduras.Peto;
import com.Andres.models.Items.Armas.*;
import com.Andres.models.Items.Consumibles.Comida;
import com.Andres.models.Items.Consumibles.Flecha;
import com.Andres.models.Items.MochilaEInventario.Mochila;
import com.Andres.models.Personaje.Enemigos.*;
import com.Andres.models.Personaje.Personaje;
import com.Andres.models.Personaje.DecoradoresAbsPersonaje.DecoradorPersonajeVidaPorcentPluss;
import com.Andres.models.Personaje.DefinicionPersonaje.*;

public class Main {

    public static void main(String[] args) {

        Personaje gatitoHeroe = new Personaje("Gatito Heroe", 2,0,10);
        Personaje odinGigante = new Personaje("OdinGigante", 2,0,10);
        Enemigo chucknorris = new Guerrero("Chuck Norris", Raza.Humano,5,5,100,2);


        /******************** Lista de items ******************************/
        Espada espadaArcoiris = new Espada("Espada de Arcoiris", 1, 3,2);
        Hacha hachaDelDestino = new Hacha("Hacha del Destino", 7, 4,2, 30);
        Mochila bolsito = new Mochila("bolso de viajero", 5, 10);
        Flecha flechaBasica = new Flecha("Flecha de madera", 1, 1, 5,2);
        Arco arcoMadera = new Arco("Arco de madera", 2, 1,5);
        Armadura armaduraLegendaria = new Peto("Armadura Legendaria", 5, 8);
        Comida semillasHermitanio = new Comida("Semillas del Hermitaño", 1, 5, 3);

        /******************** Agrego items a los personajes ***********************/
        //gatitoHeroe.agregarAlInventario(espadaSagrada);
        gatitoHeroe.agregarAlInventario(espadaArcoiris);
        //gatitoHeroe.agregarAlInventario(bolsito);
        //gatitoHeroe.agregarAlInventario(bolsito.agregar(espadaArcoiris));
        //gatitoHeroe.agregarAlInventario(hachaDelDestino);
        gatitoHeroe.agregarAlInventario(arcoMadera);
        gatitoHeroe.agregarAlInventario(flechaBasica);
        gatitoHeroe.agregarAlInventario(armaduraLegendaria);

        //odinGigante.agregarAlInventario(armaduraLegendaria);
        //odinGigante.usa("Armadura Legendaria");

        // equipo / uso un item
        try {
            gatitoHeroe.usa("Espada de Arcoiris");
            //gatitoHeroe.usa("Hacha del Destino");
            //gatitoHeroe.usa("Arco de madera");
            //gatitoHeroe.usa("Flecha de madera");
            //gatitoHeroe.usa("Armadura Legendaria");
        }catch (PersonajeException exception){
            System.out.println(exception.getMessage());
        }
        /************ Estadisticas **********************/
      //  mostrarEstadisticas(gatitoHeroe);
       // DecoradorAtaqueMejorado gatitoHeroeSuperSayayin = new DecoradorAtaqueMejorado(gatitoHeroe,2);
       // mostrarPersonaje(gatitoHeroeSuperSayayin);
        // mostrarEstadisticas(odinGigante);


        System.out.println(gatitoHeroe.getNombre() + " vida: " 
            + gatitoHeroe
                .getEstadisticas()
                    .getBarraVida().toString());

        DecoradorPersonajeVidaPorcentPluss gatitoSuperSayayin = 
            new DecoradorPersonajeVidaPorcentPluss(gatitoHeroe, 50);

        System.out.println(gatitoSuperSayayin.getPersonajeEnvuelto().getNombre() + " vida: " 
            + gatitoSuperSayayin.getPersonajeEnvuelto().getEstadisticas().getBarraVida().toString());


        /** simular pelea */
        //simulacionDePelea(gatitoHeroe,chucknorris);

    }

    private static void mostrarPersonaje(IAbsPersonaje personaje) {
        System.out.println(personaje.toString());
    }

    private static void pelea(Personaje atacante, AbstracPersonaje rival) {
        try {
            System.out.println(
                    atacante.getNombre() + " ataca a " + rival.getNombre()
                            + " y le inflinje " + atacante.atacaA(rival) + " de daño"
            );
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarEstadisticas(Personaje p) {
        String arma = (p.getInventario().armaEquipada()) ? p.getInventario().getArmaManoDerecha().getNombre() : "No equipada";
        String armadura = (p.getInventario().armaduraEquipada()) ? p.getInventario().getArmadura().getNombre() : "No equipada";


        System.out.println(
                "nombre: " + p.getNombre() + "\n"
                        + "Estadisticas: " + "\n"
                        + "Ataque: " + p.getAtaque() + "\n"
                        + "Defensa: " + p.getDefensa() + "\n"
                        + "Arma: " + arma + "\n"
                        + "Armadura: " + armadura + "\n"
                        + "-------------------------------------------------------"
        );
    }

    public static void simulacionDePelea(Personaje personaje1, AbstracPersonaje personaje2){
        pelea(personaje1, personaje2);

        System.out.println("chuchNorris retrocede");
        personaje2.getCoordenadas().mover(0,10);

        pelea(personaje1,personaje2);
        /*
        try {
             personaje1.usa("Arco de madera");
             personaje1.usa("Flecha de madera");
        }catch (PersonajeException e){
            System.out.println(e.getMessage());
        }

         */
        pelea(personaje1,personaje2);

        mostrarPersonaje(personaje1);
        mostrarPersonaje(personaje2);
    }
}
