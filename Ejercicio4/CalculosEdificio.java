package Ejercicio4;

public class CalculosEdificio {

    public static double consumoTotal(Apartamento[] aptos) {
        double total = 0;
        for (Apartamento a : aptos) {
            total += a.getConsumoM3();
        }
        return total;
    }

    public static double valorTotal(Apartamento[] aptos) {
        double total = 0;
        for (Apartamento a : aptos) {
            total += a.valorPagar();
        }
        return total;
    }

    public static Apartamento mayorConsumo(Apartamento[] aptos) {
        if (aptos.length == 0) return null;

        Apartamento mayor = aptos[0];
        for (Apartamento a : aptos) {
            if (a.getConsumoM3() > mayor.getConsumoM3()) {
                mayor = a;
            }
        }
        return mayor;
    }

    public static Apartamento menorConsumo(Apartamento[] aptos) {
        if (aptos.length == 0) return null;

        Apartamento menor = aptos[0];
        for (Apartamento a : aptos) {
            if (a.getConsumoM3() < menor.getConsumoM3()) {
                menor = a;
            }
        }
        return menor;
    }
}