package com.Andres.models.Personaje.DefinicionPersonaje;

public abstract class AbstracPersonaje implements IAbsPersonaje {

    private final String nombre;
    private Estadisticas estadisticas;
    private Coordenadas coordenadas;
    private BarraExperiencia barraExperiencia;

    public AbstracPersonaje(String nombre, int ataque_base, int defensa_base, int vidaMax) {
        this.nombre = nombre;
        this.estadisticas = new Estadisticas(ataque_base, defensa_base, vidaMax);
        this.coordenadas = new Coordenadas(100, 100); // TODO: sacar el numero magico
        this.barraExperiencia = new BarraExperiencia();
    }

    public AbstracPersonaje(String nombre, int ataque_base, int defensa_base, int nivel ,int vidaMax) {
        this.nombre = nombre;
        this.estadisticas = new Estadisticas(ataque_base, defensa_base, vidaMax);
        this.coordenadas = new Coordenadas(100, 100);
        this.barraExperiencia = new BarraExperiencia(nivel);
    }

    public void setVidaActual(int cantVida, int tipo_efecto) {
        this.estadisticas.setVidaActual(cantVida, tipo_efecto);
    }

    public String getNombre() {
        return this.nombre;
    }

    public Estadisticas getEstadisticas() {
        return this.estadisticas;
    }

    public boolean isDead() {
        return this.estadisticas.isDead();
    }

    public int recibeAtaque(int damage) {
        int ataqueRecibido = damage - this.getDefensa();

        this.getEstadisticas().setVidaActual(ataqueRecibido, BarraVida.TIPO_DAMAGE);

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
        return "nombre: " + nombre + '\n' + "Vida: " + estadisticas.getVidaActual() + "/" + estadisticas.getVidaMax()
                + "\n" + "coordenadas: " + coordenadas + "\n" + "defensa: " + getDefensa() + "\n" + "Ataque: "
                + getAtaque() + "\n" + "rango: " + getRango() + "\n"
                + "-------------------------------------------------------";
    }

    public void setVidaMax(int nueva_vida_max) {
        this.getEstadisticas().setVidaMax(nueva_vida_max);
    }

    public BarraExperiencia getBarraExperiencia() {
        return barraExperiencia;
    }
    
}
