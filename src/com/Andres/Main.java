package com.Andres;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Arco;
import com.Andres.models.Items.Armadura;
import com.Andres.models.Items.Comida;
import com.Andres.models.Items.Espada;
import com.Andres.models.Items.Flecha;
import com.Andres.models.Items.Hacha;
import com.Andres.models.Items.Mochila;
import com.Andres.models.Personaje.AbstracPersonaje;
import com.Andres.models.Personaje.Enemigo;
import com.Andres.models.Personaje.Personaje;
import com.Andres.models.Personaje.Raza;

public class Main {

    public static void main(String[] args) {

        Personaje gatitoHeroe = new Personaje("Gatito Heroe", 2,0,10);
        Personaje odinGigante = new Personaje("OdinGigante", 2,0,10);
        Enemigo chucknorris = new Enemigo("Chuck Norris", Raza.Humano,5,5,100);


        /******************** Lista de items ******************************/
        Espada espadaSagrada = new Espada("Espada Sagrada", 5, 5);
        Espada espadaArcoiris = new Espada("Espada de Arcoiris", 1, 3);
        Hacha hachaDelDestino = new Hacha("Hacha del Destino", 7, 4, 30);
        Mochila bolsito = new Mochila("bolso de viajero", 5, 10);
        Flecha flechaBasica = new Flecha("Flecha de madera", 1, 1, 5);
        Arco arcoMadera = new Arco("Arco de madera", 2, 1);
        Armadura armaduraLegendaria = new Armadura("Armadura Legendaria", 5, 8);
        Comida semillasHermitanio = new Comida("Semillas del Hermitaño", 1, 5, 3);

        /******************** Agrego items a los personajes ***********************/
        //gatitoHeroe.agregarAlInventario(espadaSagrada);
        gatitoHeroe.agregarAlInventario(espadaArcoiris);
        //gatitoHeroe.agregarAlInventario(bolsito);
        //gatitoHeroe.agregarAlInventario(bolsito.agregar(espadaArcoiris));
        //gatitoHeroe.agregarAlInventario(hachaDelDestino);
        //gatitoHeroe.agregarAlInventario(arcoMadera);
        //gatitoHeroe.agregarAlInventario(flechaBasica);
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
        //mostrarEstadisticas(gatitoHeroe);

        // mostrarEstadisticas(odinGigante);

        /********** simula una pelea*******************/

            pelea(gatitoHeroe, chucknorris);

        mostrarPersonaje(gatitoHeroe);
        mostrarPersonaje(chucknorris);
       // odinGigante.agregarAlInventario(semillasHermitanio);
        try {
            odinGigante.usa("Semillas del Hermitaño");
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }
        mostrarPersonaje(chucknorris);
        //odinGigante.usa("Semillas del Hermitaño");
        //mostrarPersonaje(odinGigante);

    }

    private static void mostrarPersonaje(AbstracPersonaje personaje) {
        System.out.println(personaje.toString());
    }

    private static void pelea(AbstracPersonaje atacante, AbstracPersonaje rival) {
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
}
