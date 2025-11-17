package Ejercicio3;

public class MainAtleta {
    public static void main(String[] args) {
        // Atleta atleta = new Atleta("Daniel", 100, 60);
        // Atleta.imprimirEncabezado();
        // System.out.printf("%-5d %-10s %-12.2f %-10.2f %-15.2f %-10s%n", 1, atleta.getNombre(), atleta.getDistanciaRecorrida(), atleta.getTiempoEmpleado(), atleta.calcularVelocidad(), atleta.esValido() ? "Si" : "No");
        
        Atleta[] atletas = SolicitarAtletas.atletasAleatorios(10);
        Impresion.imprimirEncabezado();
        Impresion.imprimirAtletas(atletas);
        Impresion.mostrarEstadisticas(atletas);
    }
}
