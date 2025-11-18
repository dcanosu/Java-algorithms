package Ejercicio1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        Tramo[] tramos = SolicitarDrones.tramosAleatorios(50);

        if (tramos != null) {
            System.out.println("\nRegistro de " + tramos.length + " tramos completado con éxito."); 
            Impresion.imprimirEncabezado();
            Impresion.imprimirTramos(tramos);
            Impresion.imprimirEstadisticas(tramos);
        } else {
            System.out.println("No se realizó el registro de ningún tramo");
        }
        miScanner.close();
    }
}
