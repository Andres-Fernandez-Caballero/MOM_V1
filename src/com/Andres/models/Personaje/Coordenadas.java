package com.Andres.models.Personaje;

public class Coordenadas {

    private final int maxPosX;
    private final int maxPosY;

    private int posX;
    private int posY;

    public Coordenadas(int maxPosX, int maxPosY) {
        this.maxPosX = maxPosX;
        this.maxPosY = maxPosY;
    }

    public double distanciaA( Coordenadas objetivo){
        int xHastaObjetivo = objetivo.posX - this.posX;
        int yHastaObjetivo = objetivo.posY - this.posY;

        double distancia = convertirAmodulo(xHastaObjetivo,yHastaObjetivo);

        return distancia;
    }

    public void mover(int newPosX, int newPosY){
        this.posX = newPosX;
        this.posY = newPosY;
    }

    public int getPosX() {
        return posX;
    }

    public int getMaxPosY() {
        return maxPosY;
    }

    private double convertirAmodulo(int x,int y){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    @Override
    public String toString() {
        return "Coordenadas {" +
                "maxPosX=" + maxPosX +
                ", maxPosY=" + maxPosY +
                ", posX=" + posX +
                ", posY=" + posY +
              //  ", moduloPos= " + getModuloPos() +
                '}';
    }
}
