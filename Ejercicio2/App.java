package Ejercicio2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        // Articulo[] articulos = SolicitarArticulos.generarArticulosAleatorios(5);
        Articulo[] articulos = SolicitarArticulos.registrarArticulos(miScanner);
        
        if (articulos != null) {
            Impresion.imprimirEncabezado();
            Impresion.imprimirArticulos(articulos);
            Impresion.mostrarEstadisticas(articulos);
        } else {
            System.out.println("No se realizó el registro de ningún articulo");
        }
        miScanner.close();
    }
}