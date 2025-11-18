package Ejercicio4;

import java.util.Scanner;

public class SolicitarDatos {
    public static Apartamento[] registrarApartamentos(Scanner lea) {
        
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     INGRESO DE DATOS DE APARTAMENTOS");
        System.out.println("=".repeat(repeticiones)+"\n");
        
        System.out.print("Ingrese la cantidad de apartamentos a registrar: ");
        int K = lea.nextInt();

        if (K <= 0) {
            System.out.println("\n"+"=".repeat(repeticiones));
            System.out.println("Cantidad inválida. No se registrarán apartamentos.");
            System.out.println("=".repeat(repeticiones)+"\n");
            System.out.println("Saliendo del programa...");
            return null; 
        }

        Apartamento[] apartamentos = new Apartamento[K];
        
        for (int i = 0; i < K; i++) {
            System.out.println("\n=== Apartamento " + (i + 1) + " ===");

            System.out.print("Número del apartamento: ");
            int numero = lea.nextInt(); 

            System.out.print("Consumo en m³: ");
            double consumo = lea.nextDouble();

            System.out.print("Costo por m³: ");
            double costo = lea.nextDouble();

            apartamentos[i] = new Apartamento(numero, consumo, costo);
        }return apartamentos;
    }

    public static Apartamento[] registrarAparatamentosAleatorios(int numeroApartamentos) {
        final int MIN_APTO = 1;
        final int MAX_APTO = 100;
        final double MIN_CONSUMO = 1;
        final double MAX_CONSUMO = 30;
        final double MIN_COSTO = 10000;
        final double MAX_COSTO = 25000;

        Apartamento[] apartamentos = new Apartamento[numeroApartamentos];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < numeroApartamentos; i++) {
            int numApartamento = random.nextInt(MAX_APTO - MIN_APTO +1 ) + MIN_APTO;
            double consumo = random.nextDouble() * (MAX_CONSUMO - MIN_CONSUMO) + MIN_CONSUMO;
            double costo = random.nextDouble() * (MAX_COSTO - MIN_COSTO) + MIN_COSTO;

            apartamentos[i] = new Apartamento(numApartamento, consumo, costo);
        }return apartamentos;
    }
}