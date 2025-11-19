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

    public static void imprimirAtletas(Atleta[] atletas){
        for (int i = 0; i < atletas.length; i++) {
            System.out.printf("%-7d %-10s %,-12.3f %-10.3f %,-15.3f %-10s%n",i+1,
                atletas[i].getNombre(),
                atletas[i].getDistanciaRecorrida(),
                atletas[i].getTiempoEmpleado(),
                atletas[i].calcularVelocidad(),
                atletas[i].esValido() ? "Sí" : "No");
        }
    }
    
    public static void mostrarEstadisticas(Atleta [] atletas){
        double velocidadPromedio = CalculosAtleta.velocidadPromedio(atletas);
        double distanciaTotal = CalculosAtleta.distanciaTotalValida(atletas);
        
        Atleta masRapido = CalculosAtleta.atletaMasRapido(atletas);
        Atleta masLento = CalculosAtleta.atletaMasLento(atletas);
        
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                  ESTADÍSTICAS TRAMOS VÁLDIDOS");
        System.out.println("=".repeat(repeticiones)+"\n");

        if (velocidadPromedio == 0.0 && distanciaTotal == 0.0) {
            System.out.println("No se pueden calcular estadísticas: ningún tramo es válido.");
            System.out.println("-".repeat(repeticiones));
        } else {
            System.out.printf("Velocidad promedio: %.3f m/s%n", velocidadPromedio);

            if (masRapido != null) {
                System.out.printf("Atleta más rápido: %s (Velocidad: %,.3f m/s)%n", masRapido.getNombre(), masRapido.calcularVelocidad());
            } else {
                System.out.println("Atleta más rápido: No encontrado.");
            }
            
            if (masLento != null) {
                System.out.printf("Atleta más lento: %s (Velocidad: %,.3f m/s)%n", masLento.getNombre(), masLento.calcularVelocidad());
            } else {
                System.out.println("Atleta más lento: No encontrado.");
            }

            System.out.printf("Distancia total válida: %,.3f metros%n", distanciaTotal);
            System.out.println("-".repeat(repeticiones));
        }
    }
}
