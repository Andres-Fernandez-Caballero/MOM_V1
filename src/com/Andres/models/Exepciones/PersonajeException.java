package com.Andres.models.Exepciones;

public class PersonajeException extends Exception {

    public static  final  String PERSONAJE_MUERTO =  "Personaje Muerto, no puede realizar accion";
    public static final String ITEM_NO_ENCONTRADO = "El item no se encuentra en el invetario";
    public static final String PERSONAJE_FUERA_RANGO = "EL personaje se encuentra fuera de rango de ataque";

    public PersonajeException(String message) {
        super(message);
    }
}
