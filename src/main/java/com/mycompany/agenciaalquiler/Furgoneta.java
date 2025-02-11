package com.mycompany.agenciaalquiler;

/**
 *
 * @author Irene RODRÍGUEZ RODRÍGUEZ
 * @version 1.0
 */
public class Furgoneta extends Vehiculo {

    private float capacidad;

    public Furgoneta() {
    }

    public Furgoneta(String matricula) {
        super(matricula);
    }

    public Furgoneta(String matricula, Grupo grupo) {
        super(matricula, grupo);
    }

    @Override
    public String toString() {
        return super.toString() + " , " + capacidad;
    }

    public float getPrecio() {
        float precio = 0;

        switch (getGrupo()) {
            case A -> {
                // se tiene que poner con el punto y la F para que no de fallo
                precio = 50 + 1.5f * capacidad;
            }
            case B -> {
                precio = 55 + 2 * capacidad;
            }
            case C -> {
                precio = 60 + 2.5f * capacidad;
            }
        }
        return precio;
    }

    @Override
    public float getPrecioAlquiler() {
        return switch (getGrupo()) {
            case A ->
                50 + 5f * capacidad;
            case B ->
                55 + 10f * capacidad;
            case C ->
                60 + 15f * capacidad;
        };
    }
}
