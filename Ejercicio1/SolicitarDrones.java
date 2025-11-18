package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class SolicitarDrones {
    public static Tramo[] registrarTramos(Scanner scanner){

        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     INGRESO DE TRAMOS");
        System.out.println("=".repeat(repeticiones)+"\n");

        Tramo[] tramos = new Tramo[50];

        for (int i = 0; i < tramos.length; i++) {
            System.out.println("Tramo #" + (i + 1) + ":");

            System.out.print("Posición inicial (xi yi zi): ");
            double xi = scanner.nextDouble();
            double yi = scanner.nextDouble();
            double zi = scanner.nextDouble();
            
            System.out.print("Posición final (xf yf zf): ");
            double xf = scanner.nextDouble();
            double yf = scanner.nextDouble();
            double zf = scanner.nextDouble();

            System.out.print("Tiempo (segundos): ");
            double tiempo = scanner.nextDouble();

            scanner.nextLine();
            
            tramos[i] = new Tramo((i + 1), xi, yi, zi, xf, yf, zf, tiempo);
            System.out.println();
        } return tramos;
    }

    public static Tramo[] tramosAleatorios(int numeroTramos){
        
        Tramo[] tramos = new Tramo[numeroTramos];
        Random random = new java.util.Random();
        
        for (int i = 0; i < tramos.length; i++) {

            double xi = random.nextDouble() * 49 + 1;
            double yi = random.nextDouble() * 49 + 1;
            double zi = random.nextDouble() * 49 + 1;
            
            double xf = random.nextDouble() * 49 + 1;
            double yf = random.nextDouble() * 49 + 1;
            double zf = random.nextDouble() * 49 + 1;

            double tiempo = random.nextDouble() * 30.0;
            
            tramos[i] = new Tramo((i + 1), xi, yi, zi, xf, yf, zf, tiempo);
        } return tramos;
    }
}