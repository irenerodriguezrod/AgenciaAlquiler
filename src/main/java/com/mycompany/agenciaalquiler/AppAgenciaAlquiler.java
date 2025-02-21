package com.mycompany.agenciaalquiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 *
 * @author Irene RODRÍGUEZ RODRÍGUEZ
 * @version 1.0
 */
public class AppAgenciaAlquiler {

    public static void main(String[] args) throws DataFormatException {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        float capacidad;
        int plazas;
        String matricula, grupo, seguro;
        AgenciaAlquiler aa = new AgenciaAlquiler("Sauces");

        do {
            System.out.println("-- Agencia alquiler --");
            System.out.println("1.- Añadir turismo.");
            System.out.println("2.- Añadir furgoneta.");
            System.out.println("3.- Consultar vehiculo.");
            System.out.println("4.- Eliminar vehiculo.");
            System.out.println("5.- Listado de vehículos por precio.");
            System.out.println("6.- Listado de turismos");
            System.out.println("7.- Listado de furgonetas");
            System.out.println("8.- Consultar alquiler más barato");
            System.out.println("0.- Salir.");
            System.out.print("Introduzca opción: ");

            // Intentamos leer la opción, controlando la entrada de datos incorrecta
            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Entrada incorrecta");
                opcion = 1000; // Valor no válido para salir del ciclo
            }

            switch (opcion) {

                case 1 -> { // crear vehiculo
                    try {
                        System.out.println("Introduzca la matrícula del turismo:");
                        matricula = teclado.nextLine();
                        System.out.println("Introduzca grupo " + Arrays.toString(Grupo.values()));
                        grupo = teclado.nextLine();
                        System.out.println("Introduzca nº plazas:");
                        plazas = teclado.nextInt();
                        teclado.nextLine(); // salto de línea
                        Vehiculo vehiculo = new Turismo(matricula, Grupo.valueOf(grupo), plazas);
                        if (aa.incluirVehiculo(vehiculo)) {
                            System.out.println("Vehiculo incluido.");
                        } else {
                            System.out.println("No se ha podido añadir.");
                        }
                    } catch (InputMismatchException | IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    /*
                     * do {
                     * System.out.println("-- Crear vehículo --");
                     * System.out.println("1.- Crear turismo.");
                     * System.out.println("2.- Crear furgoneta.");
                     * System.out.println("0.- Volver al menú principal.");
                     * System.out.print("Introduzca su opción: ");
                     * 
                     * while (!teclado.hasNextInt()) {
                     * System.out.println("Por favor, introduzca un número válido.");
                     * teclado.next();
                     * }
                     * opcion2 = teclado.nextInt();
                     * teclado.nextLine(); // salto de línea
                     * 
                     * switch (opcion2) {
                     * case 1 -> { //turismo
                     * System.out.println("Introduzca la matrícula del turismo:");
                     * String matricula = teclado.nextLine();
                     * System.out.println("Introduzca el grupo del turismo (A, B, C):");
                     * char grupo = teclado.nextLine().toUpperCase().charAt(0);
                     * Vehiculo turismo = new Turismo(matricula,
                     * Grupo.valueOf(String.valueOf(grupo)));
                     * }
                     * case 2 -> { //furgoneta
                     * System.out.println("Introduzca la matrícula de la furgoneta:");
                     * String matricula = teclado.nextLine();
                     * System.out.println("Introduzca el grupo de la furgoneta (A, B, C):");
                     * char grupo = teclado.nextLine().toUpperCase().charAt(0);
                     * Vehiculo furgoneta = new Furgoneta(matricula,
                     * Grupo.valueOf(String.valueOf(grupo)));
                     * }
                     * case 0 -> // menu principal
                     * System.out.println("Volviendo al menú.");
                     * default ->
                     * System.out.println("Opción no válida.");
                     * }
                     * } while (opcion2 != 0);
                     */
                }
                case 2 -> { //
                    try {
                        System.out.println("Introduzca la matrícula del furgoneta:");
                        matricula = teclado.nextLine();
                        System.out.println("Introduzca grupo " + Arrays.toString(Grupo.values()));
                        grupo = teclado.nextLine();
                        System.out.println("Introduzca capacidad:");
                        capacidad = teclado.nextInt();
                        Vehiculo vehiculo = new Furgoneta(matricula, Grupo.valueOf(grupo), capacidad);
                        if (aa.incluirVehiculo(vehiculo)) {
                            System.out.println("Furgoneta incluida.");
                        } else {
                            System.out.println("No se ha podido añadir.");
                        }
                    } catch (InputMismatchException | IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    /*
                     * System.out.println("Introduzca la matrícula del vehículo a consultar:");
                     * String matricula = teclado.nextLine();
                     * vehiculo.consultarVehiculo(matricula);
                     * if (vehiculo != null) {
                     * System.out.println("Vehículo encontrado: " + vehiculo);
                     * } else {
                     * System.out.println("No se encontró ningún vehículo con esa matrícula.");
                     * }
                     */
                }
                case 3 -> { // consultar vehiculo
                    System.out.println("Introduzca la matrícula del furgoneta:");
                    matricula = teclado.nextLine();
                    Vehiculo vehiculo = aa.consultarVehiculo(matricula);
                    if (vehiculo != null) {
                        System.out.println(vehiculo);
                    } else {
                        System.out.println("No existe el vehiculo");
                    }

                    /*
                     * System.out.println("Introduzca la matrícula del vehículo a eliminar:");
                     * String matricula = teclado.nextLine();
                     * vehiculo.consultarVehiculo(matricula);
                     * if (vehiculo != null) {
                     * System.out.println("Vehículo eliminado con éxito.");
                     * } else {
                     * System.out.println("No se pudo eliminar.");
                     * }
                     */
                }
                case 4 -> { // eliminar vehiculo
                    System.out.println("Introduzca la matrícula del furgoneta:");
                    matricula = teclado.nextLine();
                    Vehiculo vehiculo = aa.consultarVehiculo(matricula);
                    if (vehiculo != null) {
                        System.out.print(vehiculo);
                        System.out.print("Seguro?S/N");
                        seguro = teclado.nextLine();
                        if (seguro.equalsIgnoreCase("S")) {
                            if (aa.eliminarVehiculo(vehiculo)) {
                                System.out.println("Vehiculo eliminado");
                            }
                        } else {
                            System.out.print("No ha podido eliminarse");
                        }
                    }
                    /*
                     * System.out.println("Lista de vehículos:");
                     * vehiculo.listarVehiculosPorPrecio().forEach(System.out::println);
                     */
                }
                case 5 -> { // listar vehiculos ordenados
                    /*
                     * for(Vehiculo v: aa.listarVehiculosPorPrecio()){
                     * System.out.println(v);
                     * }
                     */
                    /*
                     * vehiculo.getVehiculoMasBarato();
                     * if (masBarato != null) {
                     * System.out.println("El vehículo más barato es: " + masBarato);
                     * }
                     */

                    List<Vehiculo> listadoAImprimir = aa.listarVehiculosPorPrecio();
                    mostrarListadoVehiculos(listadoAImprimir);
                }

                case 6 -> { // listar turismos
                    List<Vehiculo> listadoAImprimir = new ArrayList<>();
                    for (Vehiculo v : aa.getFlota()) {
                        if (v instanceof Turismo t) {
                            listadoAImprimir.add(v);
                        }
                    }
                    mostrarListadoVehiculos(listadoAImprimir);
                }

                case 7 -> { // listar furgoneta
                    for (Vehiculo v : aa.getFlota()) {
                        if (v instanceof Furgoneta f) {
                            System.out.println(f); // esto evita hacer casting
                        }
                    }

                }

                case 8 -> {
                    Vehiculo vehiculo = aa.getVehiculoMasBarato();
                    if (vehiculo != null) {
                        System.out.println(aa.getVehiculoMasBarato());
                    } else {
                        System.out.println("No hay vehiculos en el sistema");
                    }
                }

                case 9 -> {
                    System.out.println("Introduzca grupo; ");
                    grupo = teclado.nextLine();
                    List<Vehiculo> listadoAImprimir = aa.listarVehiculos(Grupo.valueOf(grupo));
                    mostrarListadoVehiculos(listadoAImprimir);
                }

                case 0 ->
                    System.out.println("Adiós.");

                default ->
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarListadoVehiculos(List<Vehiculo> listado) {
        for (Vehiculo v : listado) {
            System.out.println(v); // Se imprime el `toString()` de cada vehículo
        }
    }
}
