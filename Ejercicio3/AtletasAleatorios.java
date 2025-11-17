package Ejercicio3;
import java.util.Random;

public class AtletasAleatorios {
    public static Atleta[] atletasAleatorios(int numeroAtletas){

        final String[] nombreAtletas = {"Alex", "Brenda", "Carlos", "Diana", "Emilio","Fabiola", "Guillermo", "Heidi", "Ivan", "Julieta"};
        final int MIN_DISTANCIA = 100;
        final int MAX_DISTANCIA = 1000;
        final double MIN_TIEMPO = 10.0;
        final double MAX_TIEMPO = 120.0;

        Atleta[] atletas = new Atleta[numeroAtletas];
        Random random = new java.util.Random();

        for (int i = 0; i < numeroAtletas; i++) {
            String nombre = nombreAtletas[random.nextInt(nombreAtletas.length)];
            int distancia = MIN_DISTANCIA + random.nextInt(MAX_DISTANCIA - MIN_DISTANCIA + 1);
            double tiempo = MIN_TIEMPO + (random.nextDouble() * (MAX_TIEMPO - MIN_TIEMPO));
            
            atletas[i] = new Atleta(nombre, distancia, tiempo);
        }
        return atletas;
    }



    public static void imprimirAtletas(Atleta[] atletas){
        for (int i = 0; i < atletas.length; i++) {
            System.out.printf("%-7d %-10s %-12.2f %-10.2f %-15.2f %-10s%n",i+1,
                atletas[i].getNombre(),
                atletas[i].getDistanciaRecorrida(),
                atletas[i].getTiempoEmpleado(),
                atletas[i].calcularVelocidad(),
                atletas[i].esValido() ? "Si" : "No");
            }
    }
}