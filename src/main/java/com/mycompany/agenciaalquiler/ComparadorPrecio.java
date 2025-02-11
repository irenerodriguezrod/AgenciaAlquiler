package com.mycompany.agenciaalquiler;

import java.util.Comparator;

/**
 * 
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */


public class ComparadorPrecio implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        // Comparar por precio de alquiler
        int resultado = Float.compare(v1.getPrecioAlquiler(), v2.getPrecioAlquiler());

        // Si los precios son iguales, comparar por grupo
        if (resultado == 0) {
            return v1.getGrupo().compareTo(v2.getGrupo());
        }

        return resultado;
    }
}
