package Ejercicio2;

import java.util.Scanner;

public class SolicitarArticulos {
    
    private static final int NUM_ARTICULOS = 10;
    private static final int CLAVE_MIN = 1;
    private static final int CLAVE_MAX = 6;

    public static Articulo[] registrarArticulos(Scanner scanner) {
        
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     INGRESO DE DATOS DE ARTÍCULOS");
        System.out.println("=".repeat(repeticiones)+"\n");

        Articulo[] articulos = new Articulo[NUM_ARTICULOS];

        for (int i = 0; i < NUM_ARTICULOS; i++) {
            System.out.println("\n=== Artículo N° " + (i + 1) + " ===");
            
            int clave;
            double costoMP;

            do {
                System.out.print("Ingrese Clave del producto (1 a 6): ");
                clave = scanner.nextInt();
                
                if (clave < CLAVE_MIN || clave > CLAVE_MAX) {
                    System.out.println("ERROR: La clave debe estar entre " + CLAVE_MIN + " y " + CLAVE_MAX + ". Reintente.");                }

            } while (clave < CLAVE_MIN || clave > CLAVE_MAX);
            
            do {
                System.out.print("Ingrese Costo de la Materia Prima ($): ");
                costoMP = scanner.nextDouble();
                
                if (costoMP < 0) {
                    throw new IllegalArgumentException("El costo no puede ser negativo.");
                }
            } while (costoMP < 0);

            scanner.nextLine();

            articulos[i] = new Articulo((i + 1), clave, costoMP);
            
        } return articulos;
    }

    public static Articulo[] generarArticulosAleatorios(int numeroArticulos) {
        
        final double MIN_COSTO = 10000;
        final double MAX_COSTO = 200000;

        Articulo[] articulos = new Articulo[numeroArticulos];
        java.util.Random random = new java.util.Random();
        
        double RANGO_COSTO = MAX_COSTO - MIN_COSTO;

        for (int i = 0; i < numeroArticulos; i++) {
            
            int clave = random.nextInt(CLAVE_MAX - CLAVE_MIN + 1) + CLAVE_MIN;
            double costoMP = random.nextDouble() * RANGO_COSTO + MIN_COSTO;
            
            articulos[i] = new Articulo((i + 1), clave, costoMP);
        }
        return articulos;
    }
}