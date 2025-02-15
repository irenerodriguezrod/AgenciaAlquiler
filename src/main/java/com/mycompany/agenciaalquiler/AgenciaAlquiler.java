package com.mycompany.agenciaalquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
//import java.util.TreeSet;

/**
 *
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
public class AgenciaAlquiler {

    public AgenciaAlquiler(String sauces) {
    }

    // private TreeSet<Vehiculo> vehiculos;
    private String nombre;
    private Map<String, Vehiculo> flota;

    /*
     * public AgenciaAlquiler(String nombre) {
     * this.nombre = nombre;
     * vehiculos = new TreeSet<>();
     * }
     */

    public List<Vehiculo> getFlota() {
        return new ArrayList<>(flota.values());
    }

    public void getNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFlota(Map<String, Vehiculo> flota) {
        this.flota = flota;
    }

    /**
     * Añade un nuevo vehículo en caso de que no exista, devuelve el nuevo
     * vehículo. Si ya existe, devuelve false.
     * 
     * @param vehiculo
     * @return
     */
    public boolean incluirVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            return flota.putIfAbsent(vehiculo.getMatricula(), vehiculo) == null;
        }
        return false;
    }

    /**
     * Clase para consultar un vehículo a partir de una matricula.
     * 
     * @param matricula
     * @return Los datos del vehiculo que hemos introducido anteriormente la matricula
     */
    public Vehiculo consultarVehiculo(String matricula) {
        return flota.get(matricula);
    }

    /**
     * Elimina un vehículo existente.
     * 
     * @param vehiculo
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return flota.remove(vehiculo.getMatricula()) != null;
    }

    /**
     * Compara dos vehículos
     * 
     */
    public class ComparadorPrecio implements Comparator<Vehiculo> {

        @Override
        public int compare(Vehiculo o1, Vehiculo o2) {
            return Float.compare(o1.getPrecioAlquiler(), o2.getPrecioAlquiler());
        }
    }

    /**
     * Lista los vehículos por precio.
     * 
     * @return un listado de vehiculos ordenado por precio
     */
    public List<Vehiculo> listarVehiculosPorPrecio() {
        List<Vehiculo> listado = new ArrayList<>(flota.values());
        listado.sort(new ComparadorPrecio());
        return listado;
    }

    /**
     * Lista los vehículos.
     * 
     * @param grupo
     * @return El listado de los vehículos
     */
    public List<Vehiculo> listarVehiculos(Grupo grupo) {
        List<Vehiculo> listado = new ArrayList<>();
        for (Vehiculo v : flota.values()) {
            if (v.getGrupo() == grupo) {
                listado.add(v);
            }

            /*
             * if(v.getGrupo().equals(grupo)){
             * listado.add(v);
             * }
             */
        }
        return listado;
    }

    /**
     * Devuelve el vehículo más barato entre los vehículos que se encuentran en la
     * flota.
     * Si la flota está vacía, se devuelve null.
     *
     * @return El vehículo más barato de la flota o null si la flota está vacía.
     */
    public Vehiculo getVehiculoMasBarato() {
        if (!flota.isEmpty()) {
            return Collections.min(flota.values(), new ComparadorPrecio()); // quedarme con el menor
        }
        return null;
    }

    /**
     * Añade un nuevo vehículo en caso de que no exista, devuelve el nuevo
     * vehículo. Si ya existe, devuelve false
     *
     * @param vehiculo
     * @return
     */
    /*
     * public boolean incluirVehiculo(Vehiculo vehiculo) {
     * if (vehiculo != null) {
     * return vehiculos.add(vehiculo);
     * }
     * return false;
     * }
     */
    /**
     *
     * @param matricula
     * @return
     */
    /*
     * public Vehiculo consultarVehiculo(String matricula) {
     * for (Vehiculo v : vehiculos) {
     * if (v.getMatricula().equals(matricula)) {
     * return v;
     * }
     * }
     * return null;
     * }
     */
    /**
     * Elimina un vehículo existente
     *
     * @param vehiculo
     * @return
     */
    /*
     * public boolean eliminarVehiculo(Vehiculo vehiculo) {
     * return vehiculos.remove(vehiculo);
     * }
     */
    /**
     * Lista los vehículos por precio
     *
     * @return
     *//*
        * public List<Vehiculo> listarVehiculosPorPrecio() {
        * List<Vehiculo> vehiculosPorPrecio = new ArrayList<>(vehiculos);
        * vehiculosPorPrecio.sort(new ComparadorPrecio());
        * return vehiculosPorPrecio;
        * }
        */

    /**
     *
     * @return
     *//*
        * public List<Vehiculo> listarFurgonetas() {
        * List<Vehiculo> furgonetas = new ArrayList<>();
        * for (Vehiculo v : vehiculos) {//se recorre todo y se saca los que quieras.
        * if (v instanceof Furgoneta) {
        * furgonetas.add(v);
        * }
        * }
        * return furgonetas;
        * }
        */

    /**
     *
     * @return
     *//*
        * public List<Vehiculo> listarTurismos() {
        * List<Vehiculo> turismos = new ArrayList<>();
        * for (Vehiculo v : vehiculos) {
        * if (v instanceof Turismo) {
        * turismos.add(v);
        * }
        * }
        * return turismos;
        * }
        */

    /**
     *
     * @return
     *//*
        * public Vehiculo getVehiculoMasBarato() {
        * return Collections.min(vehiculos, new ComparadorPrecio() {
        * });// Buscame por medio de Collections, el minimo de la lista de vehiculos
        * utilizando el comparador de precio externo
        * }
        */
}
