package Ejercicio4;

public class Impresion {

    public static void imprimirEncabezado() {
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     REPORTE DE APARTAMENTOS");
        System.out.println("=".repeat(repeticiones)+"\n");
        System.out.printf("%-10s %-12s %-12s %-12s %-12s%n",
                "N° Apto", "Consumo/m³", "Costo/m³", "Pago", "Alto?");
        System.out.println("-".repeat(repeticiones));
    }

    public static void imprimirApartamentos(Apartamento[] apartamentos) {
        for (Apartamento actual : apartamentos) {
            System.out.printf("%-10d %-12.2f $%,-12.0f $%,-12.0f %-12s%n",
                    actual.getNumeroApartamento(),
                    actual.getConsumoM3(),
                    actual.getCostoPorM3(),
                    actual.valorPagar(),
                    actual.consumoAlto() ? "Sí" : "No");
        }
    }

    public static void imprimirEstadisticas(Apartamento[] apartamentos) {
        double totalConsumo = CalculosEdificio.consumoTotal(apartamentos);
        double totalPago = CalculosEdificio.valorTotal(apartamentos);

        Apartamento mayor = CalculosEdificio.mayorConsumo(apartamentos);
        Apartamento menor = CalculosEdificio.menorConsumo(apartamentos);

        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     RESUMEN EDIFICIO");
        System.out.println("=".repeat(repeticiones)+"\n");
        if (totalConsumo == 0) {
            System.out.println("No hubo consumo en el edificio");
            System.out.println("-".repeat(repeticiones));
        } else {
            System.out.printf("Consumo total del edificio: %.2f m³%n", totalConsumo);
            System.out.printf("Valor total a pagar: $%,.0f%n", totalPago);
            if (apartamentos.length > 1){
                System.out.printf("Apartamento mayor consumo: Apto N° %d -> (%.2f m³)%n", mayor.getNumeroApartamento(), mayor.getConsumoM3());
                System.out.printf("Apartamento menor consumo: Apto N° %d -> (%.2f m³)%n", menor.getNumeroApartamento(), menor.getConsumoM3());
                System.out.println("-".repeat(repeticiones));
            } else {
                System.out.println("Existe solo 1 apartamento, no podemos calcular mayor/menor consumo");
            }
        }
    }
}