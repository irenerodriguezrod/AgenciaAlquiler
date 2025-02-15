package com.mycompany.agenciaalquiler;

/**
 * Sirve para calcular los diferentes precios que endran los vehiculos. Cada grupo tiene un valor (precioBase), y un determinado coste (factoorTurismo o factorFurgoneta dependiendo del tipo de vehículo)
 * @author Irene RODRÍGUEZ RODRÍGUEZ
 * @version 2.0
 */

public enum Grupo {
    A(50,1.5f,5.0f),B(55,2.0f,10.0f),C(60,2.5f,15.0f);
    private final int precioBase;
    private final float factorTurismo;
    private final float factorFurgoneta;

    private Grupo(int precioBase, float factorTurismo, float factorFurgoneta) {
        this.precioBase = precioBase;
        this.factorTurismo = factorTurismo;
        this.factorFurgoneta = factorFurgoneta;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public float getFactorTurismo() {
        return factorTurismo;
    }

    public float getFactorFurgoneta() {
        return factorFurgoneta;
    }
    
}
