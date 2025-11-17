package Ejercicio4;


public class MainEdificio {

    public static void main(String[] args) {
        Apartamento[] apartamentos = SolicitarDatos.registrarAparatamentosAleatorios(50);
        // Apartamento[] apartamentos = SolicitarDatos.registrarApartamentos();

        if (apartamentos != null) {
            System.out.println("\nRegistro de " + apartamentos.length + " apartamentos completado con éxito."); 
            Impresion.imprimirEncabezado();
            Impresion.imprimirApartamentos(apartamentos);
            Impresion.imprimirEstadisticas(apartamentos);
        } else {
            System.out.println("No se realizó el registro de ningún apartamento");
        }
    }
}