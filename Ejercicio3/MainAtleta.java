package Ejercicio3;

public class MainAtleta {
    public static void main(String[] args) {
        // Atleta[] atletas = SolicitarAtletas.registrarAtleta();
        Atleta[] atletas = SolicitarAtletas.atletasAleatorios(10);

        if (atletas != null) {
            Impresion.imprimirEncabezado();
            Impresion.imprimirAtletas(atletas);
            Impresion.mostrarEstadisticas(atletas);
        } else {
            System.out.println("No se realizó el registro de ningún atleta");
        }
    }
}
