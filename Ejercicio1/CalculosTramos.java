package Ejercicio1;

public class CalculosTramos {
    public static int contarValidos(Tramo[] tramos) {
        int contador = 0;
        for (Tramo t : tramos) {
            if (t.esValido()) {
                contador++;
            }
        }
        return contador;
    }

    public static double distanciaTotalValida(Tramo[] tramos) {
        double total = 0.0;
        for (Tramo t : tramos) {
            if (t.esValido()) {
                total += t.distanciaRecorrida();
            }
        }
        return total;
    }
    
    public static double tiempoTotalValido(Tramo[] tramos) {
        double total = 0.0;
        for (Tramo t : tramos) {
            if (t.esValido()) {
                total += t.getTiempo();
            }
        }
        return total;
    }

    public static double velocidadPromedio(Tramo[] tramos) {

        double distanciaTotal = 0.0;
        double tiempoTotal = 0.0;

        for (Tramo t : tramos) {
            if (t.esValido()) {
                distanciaTotal += t.distanciaRecorrida();
                tiempoTotal += t.getTiempo();
            }
        }
        if (tiempoTotal > 0.0) {
            return distanciaTotal / tiempoTotal;
        } else {
            return 0.0;
        }
    }

    public static Tramo tramoMasRapido(Tramo[] tramos) {
        Tramo masRapido = null;
        double velocidadMaxima = -1.0;

        for (Tramo t : tramos) {
            if (t.esValido()) {
                double velocidadActual = t.velocidadTramo();
                if (velocidadActual > velocidadMaxima) {
                    velocidadMaxima = velocidadActual;
                    masRapido = t;
                }
            }
        }
        return masRapido;
    }

    public static Tramo tramoMasLento(Tramo[] tramos) {
        Tramo masLento = null;
        double velocidadMinima = Double.MAX_VALUE;

        for (Tramo t : tramos) {
            if (t.esValido()) {
                double velocidadActual = t.velocidadTramo();
                if (velocidadActual < velocidadMinima) {
                    velocidadMinima = velocidadActual;
                    masLento = t;
                }
            }
        }
        return masLento;
    }
}