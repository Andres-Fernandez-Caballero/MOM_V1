package com.Andres.models.Items;

import com.Andres.models.Personaje.Personaje;

import java.util.ArrayList;
import java.util.Iterator;

public class Mochila extends Item {

    private final ArrayList<Item> items;
    private final int pesoMax;
    private float peso;

    public Mochila(String nombre, int peso, int pesoMax) {
        super(nombre, peso);
        this.pesoMax = pesoMax;
        this.peso = 0;
        this.items = new ArrayList<>();
    }

    public void agregar(Item item){
        if(this.peso + item.getPeso() < pesoMax){
            this.peso += item.getPeso();
            items.add(item);
        }else{
            //TODO: arrojar una exepcion personalizada
            System.out.println("no se puede recoger este item peso exedido");
        }
    }

    public Item buscar(String nombreItem){

        Item iBuscado = null;

        Iterator<Item> itemIterator = items.iterator();

        while(iBuscado == null && itemIterator.hasNext() ){
            Item item = itemIterator.next();
            if(item.getClass() == Mochila.class){
                iBuscado = ((Mochila) item).buscar(nombreItem);
            }else{
                if(item.getNombre().equals(nombreItem)){
                    iBuscado = item;
                }
            }
        }
        return iBuscado;
    }


    public void eliminar(Item item){
        peso -= item.getPeso();
        items.remove(item);
    }

    public ArrayList<Item> listar(){
        return items;
    }

    public int cantItems(){
        return items.size();
    }

    @Override
    public float getPeso(){
        peso = 0;
        for (Item item : items){
            peso += item.getPeso();
        }
        return peso;
    }

    @Override
    public void usar(Personaje personaje) {
        personaje.agregarAlInventario(this);
    }

    public int getpesoMax() {
        return this.pesoMax;
    }

}
