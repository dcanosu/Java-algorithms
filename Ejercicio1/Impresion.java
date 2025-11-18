package Ejercicio1;

public class Impresion {
    
    public static void imprimirEncabezado() {
        int repeticiones = 55;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     REPORTE DE TRAMOS");
        System.out.println("=".repeat(repeticiones)+"\n");
        System.out.printf("%-8s %-12s %-10s %-12s %-10s%n",
                "N° ", "Distancia(m)", "Tiempo(s)", "Velocidad(m/s)", "Válido");
        System.out.println("-".repeat(repeticiones));
    }

    public static void imprimirTramos(Tramo[] tramos) {
        for (int i = 0; i < tramos.length; i++){
            double distancia = tramos[i].distanciaRecorrida();
            double velocidad = tramos[i].velocidadTramo();
            boolean valido = tramos[i].esValido();
            
            System.out.printf("%-8d %-12.2f %-10.2f %-12.2f %-10s%n",
                                    (i + 1), distancia, tramos[i].getTiempo(), velocidad, 
                                    valido ? "Sí" : "No");
        }
    }
    public static void imprimirEstadisticas(Tramo[] tramos) {
        int contadorValidos = CalculosTramos.contarValidos(tramos);
        double distanciaTotal = CalculosTramos.distanciaTotalValida(tramos);
        double tiempoTotal = CalculosTramos.tiempoTotalValido(tramos);

        Tramo masRapido = CalculosTramos.tramoMasRapido(tramos);
        Tramo masLento = CalculosTramos.tramoMasLento(tramos);

        int repeticiones = 55;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     RESUMEN TRAMOS");
        System.out.println("=".repeat(repeticiones)+"\n");

        if (contadorValidos == 0) {
            System.out.println("No se pueden calcular las estadísticas porque ningún tramo es válido.");
            System.out.println("-".repeat(repeticiones));
        } else {
            double velocidadPromedio = CalculosTramos.velocidadPromedio(tramos); 
            
            System.out.printf("Total de tramos válidos: %d%n", contadorValidos);
            System.out.printf("Distancia total válida: %.2f metros%n", distanciaTotal);
            System.out.printf("Tiempo total válido: %.2f segundos%n", tiempoTotal);
            System.out.printf("Velocidad promedio general: %.2f m/s%n", velocidadPromedio);
            
            if (tramos.length > 1){
                
                System.out.printf("Tramo más rápido: N° %d -> (%.2f m/s)%n", 
                                    masRapido.getNumeroTramo(), masRapido.velocidadTramo());
                System.out.printf("Tramo más lento: N° %d -> (%.2f m/s)%n", 
                                    masLento.getNumeroTramo(), masLento.velocidadTramo());
                System.out.println("-".repeat(repeticiones));
            } else {
                System.out.println("Existe solo 1 tramo, no podemos calcular el más rápido/lento");
            }
        }
    }
}