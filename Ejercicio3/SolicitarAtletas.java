package Ejercicio3;
import java.util.Random;
import java.util.Scanner;

public class SolicitarAtletas {
    public static Atleta[] registrarAtleta(){

        Scanner lea = new Scanner(System.in);
        int numeroAtletas;

        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     INGRESO DE DATOS DE ATLETAS");
        System.out.println("=".repeat(repeticiones)+"\n");

        System.out.print("Ingrese la cantidad de atletas a registrar: ");
        numeroAtletas = lea.nextInt();
        lea.nextLine();

        if (numeroAtletas <= 0) {
            System.out.println("\n"+"=".repeat(repeticiones));
            System.out.println("Cantidad inválida. No se registrarán atletas.");
            System.out.println("=".repeat(repeticiones)+"\n");
            System.out.println("Saliendo del programa...");
            return null; 
        }

        Atleta [] atletas = new Atleta[numeroAtletas];

        for (int i = 0; i < numeroAtletas; i++) {
            System.out.println("\n=== Atleta " + (i + 1) + " ===");

            System.out.print("Nombre del atleta: ");
            String nombre = lea.nextLine();

            System.out.println("Ingrese la distancia recorrdida en metros: ");
            double distancia = lea.nextDouble();

            System.out.println("Ingrese el tiempo empleado en segundos: ");
            double tiempo = lea.nextDouble();

            // if (tiempo == 0 || distancia == 0) {
            //     tiempo = 0;
            //     distancia = 0;
            // }

            atletas[i] = new Atleta(nombre, distancia, tiempo);
        }return atletas;
    }

    public static Atleta[] atletasAleatorios(int numeroAtletas){
        
        final String[] NOMBRE_ATLETA = {
        "Alex", "Brenda", "Carlos", "Diana", "Emilio", 
        "Fabiola", "Guillermo", "Heidi", "Ivan", "Julieta", 
        "Kevin", "Laura", "Mateo", "Nicole", "Oscar", 
        "Paula", "Quique", "Rosa", "Sergio", "Tamara",
        "Uriel", "Valeria", "William", "Ximena", "Yago",
        "Zara", "Andrés", "Beatriz", "Camilo", "Daniela",
        "Elias", "Florencia", "Gabriel", "Hanna", "Iker",
        "Jazmín", "Leo", "Mónica", "Néstor", "Olivia",
        "Pedro", "Rebeca", "Ricardo", "Silvia", "Tadeo",
        "Ursula", "Víctor", "Wendy", "Yanet", "Zoe"
        };
        final int MIN_DISTANCIA = 100;
        final int MAX_DISTANCIA = 1000;
        final double MIN_TIEMPO = 0.0;
        final double MAX_TIEMPO = 10.0;

        Atleta[] atletas = new Atleta[numeroAtletas];
        Random random = new java.util.Random();

        double tiempo;

        for (int i = 0; i < numeroAtletas; i++) {
            String nombre = NOMBRE_ATLETA[random.nextInt(NOMBRE_ATLETA.length)];
            int distancia = MIN_DISTANCIA + random.nextInt(MAX_DISTANCIA - MIN_DISTANCIA + 1);
            if (random.nextInt(20) == 0){
                tiempo = 0.0;
            } else {
                tiempo = MIN_TIEMPO + (random.nextDouble() * (MAX_TIEMPO - MIN_TIEMPO));
                tiempo = Math.round(tiempo * 100.0) / 100.0;
            }
            
            atletas[i] = new Atleta(nombre, distancia, tiempo);
        }return atletas;
    }
}