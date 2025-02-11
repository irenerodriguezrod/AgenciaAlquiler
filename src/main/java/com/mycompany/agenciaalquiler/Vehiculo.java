package com.mycompany.agenciaalquiler;

import java.util.Objects;

/**
 *
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
public abstract class Vehiculo implements Comparable<Vehiculo>{
    private String matricula;
    private Grupo grupo;
    
    public Vehiculo(){
    
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }
    
    public Vehiculo(String matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return this.grupo == other.grupo;
    }

    @Override
    public String toString() {
        return  matricula + ", " + grupo;
    }
    
    /**
     *
     * @param v
     * @return
     */
    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.matricula);
    }
    
    public float getPrecioAlquiler(int dias){
        return dias*getPrecioAlquiler();
    }
    
    public abstract float getPrecioAlquiler();
}