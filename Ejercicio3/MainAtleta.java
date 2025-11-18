package Ejercicio3;

import java.util.Scanner;

public class MainAtleta {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        Atleta[] atletas = SolicitarAtletas.registrarAtleta(miScanner);
        // Atleta[] atletas = SolicitarAtletas.atletasAleatorios(10);

        if (atletas != null) {
            Impresion.imprimirEncabezado();
            Impresion.imprimirAtletas(atletas);
            Impresion.mostrarEstadisticas(atletas);
        } else {
            System.out.println("No se realizó el registro de ningún atleta");
        }
        miScanner.close();
    }
}
