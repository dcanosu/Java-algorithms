package Ejercicio1;

import java.util.Scanner;

public class Tramo {
    // Atributos
    private double xi, yi, zi; // Posición inicial
    private double xf, yf, zf; // Posición final
    private double tiempo; // Tiempo en segundos
    
    // Constructor que recibe todos los valores
    public Tramo(double xi, double yi, double zi, double xf, double yf, double zf, double tiempo) {
        this.xi = xi;
        this.yi = yi;
        this.zi = zi;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
        this.tiempo = tiempo;
    }
    
    // Método que calcula la distancia recorrida en ese tramo (3D)
    public double calcularDistancia() {
        double dx = xf - xi;
        double dy = yf - yi;
        double dz = zf - zi;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    
    // Método que calcula la velocidad del tramo (distancia / tiempo)
    public double calcularVelocidad() {
        if (tiempo > 0) {
            return calcularDistancia() / tiempo;
        }
        return 0;
    }
    
    // Método que indica si el tramo debe considerarse válido para estadísticas
    public boolean esValido() {
        double distancia = calcularDistancia();
        return tiempo > 0 && distancia >= 0.5;
    }
    
    // Getters
    public double getXi() { return xi; }
    public double getYi() { return yi; }
    public double getZi() { return zi; }
    public double getXf() { return xf; }
    public double getYf() { return yf; }
    public double getZf() { return zf; }
    public double getTiempo() { return tiempo; }
    
    public static void main(String[] args) {
        // Crear un arreglo de 50 objetos Tramo
        Tramo[] tramos = new Tramo[50];
        
        // Usar valores de prueba (puedes cambiar esto para usar Scanner si lo prefieres)
        // Generar 50 tramos con valores variados para pruebas
        java.util.Random random = new java.util.Random();
        
        for (int i = 0; i < 50; i++) {
            // Generar posiciones aleatorias entre -10 y 10
            double xi = random.nextDouble() * 20 - 10;
            double yi = random.nextDouble() * 20 - 10;
            double zi = random.nextDouble() * 20 - 10;
            
            double xf = random.nextDouble() * 20 - 10;
            double yf = random.nextDouble() * 20 - 10;
            double zf = random.nextDouble() * 20 - 10;
            
            // Tiempo entre 0.1 y 10 segundos (algunos pueden ser 0 o negativos para pruebas)
            double tiempo = i < 45 ? random.nextDouble() * 9.9 + 0.1 : random.nextDouble() * 0.4; // Últimos 5 pueden ser inválidos
            
            tramos[i] = new Tramo(xi, yi, zi, xf, yf, zf, tiempo);
        }
        
        // Si prefieres usar entrada por teclado, descomenta el siguiente bloque y comenta el anterior:
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Registro de 50 Tramos del Dron ===\n");
        
        for (int i = 0; i < 50; i++) {
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
            
            tramos[i] = new Tramo(xi, yi, zi, xf, yf, zf, tiempo);
            System.out.println();
        }
        scanner.close();
        */
        
        // Mostrar todos los tramos
        System.out.println("\n=== LISTADO DE TRAMOS ===\n");
        System.out.printf("%-8s %-12s %-10s %-12s %-10s%n", 
                         "Tramo", "Distancia(m)", "Tiempo(s)", "Velocidad(m/s)", "Válido");
        System.out.println("------------------------------------------------------------");
        
        for (int i = 0; i < 50; i++) {
            double distancia = tramos[i].calcularDistancia();
            double velocidad = tramos[i].calcularVelocidad();
            boolean valido = tramos[i].esValido();
            
            System.out.printf("%-8d %-12.2f %-10.2f %-12.2f %-10s%n",
                             (i + 1), distancia, tramos[i].getTiempo(), 
                             velocidad, valido ? "Sí" : "No");
        }
        
        // Calcular estadísticas usando solo los tramos válidos
        double distanciaTotal = 0;
        double tiempoTotal = 0;
        int contadorValidos = 0;
        int tramoMasRapido = -1;
        int tramoMasLento = -1;
        double velocidadMaxima = Double.MIN_VALUE;
        double velocidadMinima = Double.MAX_VALUE;
        
        for (int i = 0; i < 50; i++) {
            if (tramos[i].esValido()) {
                contadorValidos++;
                distanciaTotal += tramos[i].calcularDistancia();
                tiempoTotal += tramos[i].getTiempo();
                
                double velocidad = tramos[i].calcularVelocidad();
                if (velocidad > velocidadMaxima) {
                    velocidadMaxima = velocidad;
                    tramoMasRapido = i + 1;
                }
                if (velocidad < velocidadMinima) {
                    velocidadMinima = velocidad;
                    tramoMasLento = i + 1;
                }
            }
        }
        
        // Mostrar estadísticas
        System.out.println("\n=== ESTADÍSTICAS (Solo tramos válidos) ===\n");
        
        if (contadorValidos == 0) {
            System.out.println("No se pueden calcular las estadísticas porque ningún tramo es válido.");
        } else {
            double velocidadPromedio = distanciaTotal / tiempoTotal;
            
            System.out.printf("Distancia total: %.2f metros%n", distanciaTotal);
            System.out.printf("Tiempo total: %.2f segundos%n", tiempoTotal);
            System.out.printf("Velocidad promedio general: %.2f m/s%n", velocidadPromedio);
            System.out.printf("Tramo más rápido: #%d (%.2f m/s)%n", tramoMasRapido, velocidadMaxima);
            System.out.printf("Tramo más lento: #%d (%.2f m/s)%n", tramoMasLento, velocidadMinima);
            System.out.printf("Total de tramos válidos: %d%n", contadorValidos);
        }
        
        scanner.close();
    }
}
