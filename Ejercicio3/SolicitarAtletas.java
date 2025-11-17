package Ejercicio3;
import java.util.Random;

public class SolicitarAtletas {


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