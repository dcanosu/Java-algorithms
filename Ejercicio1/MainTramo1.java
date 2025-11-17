package Ejercicio1;

public class MainTramo1 {

    public static void main(String[] args) {
        // Tramo1 test = new Tramo1(5, 6, 8, 10, 11, 25, 5);
        // System.out.println("Distancia: " + test.calculateDistance());

        // -------------------------------------------------------------------
        // 1. Crear tramos aleatorios
        // -------------------------------------------------------------------
        final int dronesNumber = 50;
        Tramo1[] tramos = new Tramo1[dronesNumber];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < dronesNumber; i++) {
            double xi = random.nextDouble() * 20 - 10;
            double yi = random.nextDouble() * 20 - 10;
            double zi = random.nextDouble() * 20 - 10;

            double xf = random.nextDouble() * 20 - 10;
            double yf = random.nextDouble() * 20 - 10;
            double zf = random.nextDouble() * 20 - 10;

            // double time = random.nextDouble() * 9.9 + 0.1;
            double time = random.nextDouble() * 20 - 5;

            tramos[i] = new Tramo1(xi, yi, zi, xf, yf, zf, time);
        }


        // -------------------------------------------------------------------
        // 2. Mostrar tabla
        // -------------------------------------------------------------------

        System.out.println("\n=== LISTADO DE TRAMOS ===\n");
        System.out.printf("%-8s %-12s %-10s %-12s %-10s%n",
                "Tramo", "Distancia(m)", "Tiempo(s)", "Velocidad(m/s)", "Válido");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < dronesNumber; i++) {
            double distancia = tramos[i].calculateDistance();
            double velocidad = tramos[i].calculateSpeed();
            boolean valido = tramos[i].esValido();

            System.out.printf("%-8d %-12.2f %-10.2f %-12.2f %-10s%n",
                    (i + 1),
                    distancia,
                    tramos[i].getTime(),
                    velocidad,
                    valido ? "Sí" : "No"
            );
        }

        // -------------------------------------------------------------------
        // 3. Calcular estadísticas solo de tramos válidos
        // -------------------------------------------------------------------
        double distanciaTotal = 0;
        double tiempoTotal = 0;
        int contadorValidos = 0;

        int indiceMasRapido = -1;
        int indiceMasLento = -1;

        double velocidadMaxima = Double.MIN_VALUE;
        double velocidadMinima = Double.MAX_VALUE;
        
        for (int i = 0; i < dronesNumber; i++) {

            if (tramos[i].esValido()) {

                contadorValidos++;

                double distancia = tramos[i].calculateDistance();
                double tiempo = tramos[i].getTime();
                double velocidad = tramos[i].calculateSpeed();

                distanciaTotal += distancia;
                tiempoTotal += tiempo;

                if (velocidad > velocidadMaxima) {
                    velocidadMaxima = velocidad;
                    indiceMasRapido = i + 1;
                }
                if (velocidad < velocidadMinima) {
                    velocidadMinima = velocidad;
                    indiceMasLento = i + 1;
                }
            }
        }

// -------------------------------------------------------------------
        // 4. Mostrar estadísticas
        // -------------------------------------------------------------------
        System.out.println("\n=== ESTADÍSTICAS (Solo tramos válidos) ===\n");

        if (contadorValidos == 0) {
            System.out.println("No se pueden calcular estadísticas: ningún tramo es válido.");
        } else {
            double velocidadPromedio = distanciaTotal / tiempoTotal;

            System.out.printf("Distancia total: %.2f metros%n", distanciaTotal);
            System.out.printf("Tiempo total: %.2f segundos%n", tiempoTotal);
            System.out.printf("Velocidad promedio: %.2f m/s%n", velocidadPromedio);
            System.out.printf("Tramo más rápido: #%d (%.2f m/s)%n", indiceMasRapido, velocidadMaxima);
            System.out.printf("Tramo más lento: #%d (%.2f m/s)%n", indiceMasLento, velocidadMinima);
            System.out.printf("Total de tramos válidos: %d%n", contadorValidos);
        }
    }
}
