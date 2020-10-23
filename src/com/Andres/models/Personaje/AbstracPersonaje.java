package com.Andres.models.Personaje;

import com.Andres.models.Exepciones.PersonajeException;
import com.Andres.models.Items.Inventario;

public abstract class AbstracPersonaje implements IAbsPersonaje{

    private final String nombre;
    private Estadisticas estadisticas;
    private Coordenadas coordenadas;

    public AbstracPersonaje(String nombre, int ataque_base, int defensa_base, int vidaMax) {
        this.nombre = nombre;
        this.estadisticas = new Estadisticas(ataque_base, defensa_base, vidaMax);
        this.coordenadas = new Coordenadas(100,100); //TODO: sacar el numero magico
    }

    public void setVidaActual(int cantVida, int tipo_efecto){
        this.estadisticas.setVidaActual(cantVida,tipo_efecto);
    }

    public String getNombre(){
        return this.nombre;
    }

    public Estadisticas getEstadisticas(){
        return this.estadisticas;
    }

    public abstract int getDefensa();



    public boolean isDead(){
       return this.estadisticas.isDead();
    }

    public int atacaA(AbstracPersonaje objetivo) throws PersonajeException {
        if(this.isDead()){
            throw new PersonajeException(PersonajeException.PERSONAJE_MUERTO);
        }

        if( getRango() < this.coordenadas.distanciaA(objetivo.coordenadas)){

            throw new PersonajeException(PersonajeException.PERSONAJE_FUERA_RANGO + "\ndistancia del objetivo: " + this.coordenadas.distanciaA(objetivo.getCoordenadas()) + " rango del arma: " + this.getRango());
        }

        return objetivo.recibeAtaque(this.getAtaque());
    }

    public int recibeAtaque(int damage) {
        int ataqueRecibido = damage - this.getDefensa();

        this.getEstadisticas().setVidaActual(ataqueRecibido,BarraVida.TIPO_DAMAGE);

        if (ataqueRecibido < 0) {
            ataqueRecibido = 0;
        }

        return ataqueRecibido;
    }

    public abstract int getRango();

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + '\n'
                + "Vida: " + estadisticas.getVidaActual() + "/" + estadisticas.getVidaMax() + "\n"
                + "coordenadas: " + coordenadas + "/n"
                + "defensa: " + getDefensa() + "/n"
                + "Ataque: " + getAtaque() + "/n"
                + "rango: " + getRango() + "/n"
                + "-------------------------------------------------------"
                ;
    }
}
