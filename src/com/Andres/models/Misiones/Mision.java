package com.Andres.models.Misiones;

import java.util.ArrayList;
import com.Andres.models.Items.Item;
import com.Andres.models.Personaje.Personaje;

public class Mision implements Informable{

    private String titulo;
    private String descripcion; 
    private ArrayList<Item> recompensa;
    private int cantMoustrosMuertos;

    public Mision(String titulo, String descripcion, int cantMoustrosMuertos, ArrayList<Item> recompensa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.cantMoustrosMuertos = cantMoustrosMuertos;
    }

    @Override
    public void actualizar(Personaje personaje) {
        this.cantMoustrosMuertos --;
        if(cantMoustrosMuertos <= 0){
            completarMision(personaje);
        }
    }

    private void completarMision(Personaje personaje){
        for (Item item : recompensa) {
            personaje.agregarAlInventario(item);   
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Item> getRecompensa() {
        return recompensa;
    }

    public int getCantMoustrosMuertos() {
        return cantMoustrosMuertos;
    }


 
}
