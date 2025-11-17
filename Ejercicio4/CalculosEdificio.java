package Ejercicio4;

public class CalculosEdificio {

    public static double consumoTotal(Apartamento[] aptos) {
        double total = 0;
        for (Apartamento actual : aptos) {
            total += actual.getConsumoM3();
        }
        return total;
    }

    public static double valorTotal(Apartamento[] aptos) {
        double total = 0;
        for (Apartamento actual : aptos) {
            total += actual.valorPagar();
        }
        return total;
    }

    public static Apartamento mayorConsumo(Apartamento[] aptos) {
        if (aptos.length == 0) return null;

        Apartamento mayor = aptos[0];
        for (Apartamento actual : aptos) {
            if (actual.getConsumoM3() > mayor.getConsumoM3()) {
                mayor = actual;
            }
        }
        return mayor;
    }

    public static Apartamento menorConsumo(Apartamento[] aptos) {
        if (aptos.length == 0) return null;

        Apartamento menor = aptos[0];
        for (Apartamento actual : aptos) {
            if (actual.getConsumoM3() < menor.getConsumoM3()) {
                menor = actual;
            }
        }
        return menor;
    }
}