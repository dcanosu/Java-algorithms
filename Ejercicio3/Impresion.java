package Ejercicio3;

public class Impresion {

    public static void imprimirEncabezado() {
    int repeticiones = 65;
    System.out.println("\n"+"=".repeat(repeticiones));
    System.out.println("                     LISTA DE ATLETAS");
    System.out.println("=".repeat(repeticiones)+"\n");
    System.out.printf("%-7s %-10s %-12s %-10s %-15s %-10s%n",
            "Número", "Nombre", "Distancia(m)", "Tiempo(s)", "Velocidad(m/s)", "Válido");
    System.out.println("-".repeat(repeticiones));
    }
    
    public static void mostrarEstadisticas(Atleta [] atletas){
        double velocidadPromedio = CalculosAtleta.velocidadPromedio(atletas);
        double distanciaTotal = CalculosAtleta.distanciaTotalValida(atletas);
        Atleta masRapido = CalculosAtleta.atletaMasRapido(atletas);
        Atleta masLento = CalculosAtleta.atletaMasLento(atletas);
        
        System.out.println("\n=== ESTADÍSTICAS (Solo tramos válidos) ===\n");

        if (velocidadPromedio == 0.0 && distanciaTotal == 0.0) {
            System.out.println("No se pueden calcular estadísticas: ningún tramo es válido.");
            return;
        }
        System.out.printf("Velocidad promedio: %.2f m/s%n", velocidadPromedio);
    // Atleta más rápido
        if (masRapido != null) {
            System.out.printf("Atleta más rápido: %s (Velocidad: %.2f m/s)%n", 
                            masRapido.getNombre(), masRapido.calcularVelocidad());
        } else {
            System.out.println("Atleta más rápido: No encontrado.");
        }
        
        // Atleta más lento
        if (masLento != null) {
            System.out.printf("Atleta más lento: %s (Velocidad: %.2f m/s)%n", 
                            masLento.getNombre(), masLento.calcularVelocidad());
        } else {
            System.out.println("Atleta más lento: No encontrado.");
        }
        System.out.printf("Distancia total válida: %.2f metros%n", distanciaTotal);
    }
}
