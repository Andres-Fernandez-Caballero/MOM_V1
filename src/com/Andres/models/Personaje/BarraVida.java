package com.Andres.models.Personaje;

import com.Andres.models.Estados.Herido;
import com.Andres.models.Estados.IEstadoSalud;
import com.Andres.models.Estados.Muerto;
import com.Andres.models.Estados.Vivo;

public class BarraVida {

    public static final int TIPO_CURA = 0;
    public static final int TIPO_DAMAGE = 1;

    private final int umbralHerido;

    private  final int vidaMax;
    private int vidaActual;
    private IEstadoSalud estadoSalud;

    public BarraVida(int vidaMax) {
        this.vidaMax = vidaMax;
        this.vidaActual = vidaMax;
        this.umbralHerido = vidaMax/2;
        this.estadoSalud = new Vivo();
    }

    public IEstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaActual(int cantVida, int tipo_efecto) {
        // hacer algo aca para modificar la vida 
        
        /* calculo la vida actual dependiendo del tipo de efecto
            si me paso de los limites inferior y superior la vida actual
            se convierte en el limite correspondiente. 
        */
        if(tipo_efecto == TIPO_CURA){
            // curo al personaje
            vidaActual = vidaActual + cantVida;
            if(vidaActual > vidaMax){
                vidaActual = vidaMax;
            }
        }else if(tipo_efecto == TIPO_DAMAGE){
            // daño al personaje
            vidaActual = vidaActual - cantVida;
            if(vidaActual < 0){
                vidaActual = 0;
            }
        }
        
        /* determino el estado correspondiente a la salud actual */
        if(vidaActual <= vidaMax && vidaActual > umbralHerido){
            setEstadoSalud(new Vivo());
        }else if(vidaActual <= umbralHerido &&  vidaActual >0){
            setEstadoSalud(new Herido());
        }else if(vidaActual >= 0){
            setEstadoSalud(new Muerto());
        }
    }

    public void setEstadoSalud(IEstadoSalud nuevo_estado){
        this.estadoSalud = nuevo_estado;
    }

    @Override
    public String toString() {
        return this.vidaActual + "/" +this.vidaMax + " Estado: " + this.estadoSalud.toString();
    }

    
    
}
