package com.mycompany.agenciaalquiler;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Vehiculo(String matricula) throws MatriculaException {
        if(!esMatriculaValida(matricula)){
            throw new MatriculaException("Formato de matricula incorrecto");
        }
        this.matricula = matricula;
    }
    
    public Vehiculo(String matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) throws MatriculaException {
        if(!esMatriculaValida(matricula)){
            throw new MatriculaException("Formato de matricula incorrecto");
        }
      
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
     * Compara dos vehiculos
     * @param v
     * @return los vehiculos que hemos introducido 
     */
    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.matricula);
    }
    
    /**
     * Calcula el precio de alquiler de un determinado vehiculo
     * @param dias
     * @return el precio del alquiler de un vehiculo (se calcula multiplicando el precio de alquiler por los dias)
     */
    public float getPrecioAlquiler(int dias){
        return dias*getPrecioAlquiler();
    }
    
    public abstract float getPrecioAlquiler();
    
    public static boolean esMatriculaValida(String matricula) {
        String patron = "([0-9]{4})([B-Z&&[^EIOUQ]]{3})"; //regex substracción. coincide con cualquier caracter que este en el primer rango pero no en el segundo
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(matricula);
        
        return false;
    }
}