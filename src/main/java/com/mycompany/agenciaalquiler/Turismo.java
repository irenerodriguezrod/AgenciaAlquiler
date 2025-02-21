package com.mycompany.agenciaalquiler;

import java.util.zip.DataFormatException;

/**
 *
 * @author Irene RODRÍGUEZ RODRÍGUEZ
 * @version 1.0
 */
public class Turismo extends Vehiculo {

    private int plazas;

    public Turismo() {
    }

    public Turismo(String matricula) throws MatriculaException {
        super(matricula);
    }

    public Turismo(String matricula, Grupo grupo) {
        super(matricula, grupo);
    }

    public Turismo(String matricula, Grupo grupo, int plazas) throws DataFormatException {
        super(matricula, grupo);

        if (plazas < 0 || plazas > 9) {
            throw new DataFormatException("El número de plazas es incorrecto");
        }
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString() + " , " + plazas;
    }

    //se hace un switch con los precios de la tabla
    public float getPrecio() {
        float precio = 0;

        switch (getGrupo()) {
            case A -> {
                // se tiene que poner con el punto y la F para que no de fallo
                precio = 50 + 1.5f * plazas;
            }
            case B -> {
                precio = 55 + 2 * plazas;
            }
            case C -> {
                precio = 60 + 2.5f * plazas;
            }
        }
        return precio;
    }

    @Override
    public float getPrecioAlquiler() {
        /* Otra posible manera de hacerlo sería la siguiete: 
        
        return switch (getGrupo()) {
            case A ->
                50 + 1.5f * plazas;
            case B ->
                55 + 2f * plazas;
            case C ->
                60 + 2.5f * plazas;
        };
        
         */
        return getGrupo().getPrecioBase() + getGrupo().getFactorTurismo() * plazas;
    }
    
    
}
