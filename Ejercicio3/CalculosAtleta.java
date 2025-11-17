package Ejercicio3;

public class CalculosAtleta {
    public static double velocidadPromedio(Atleta[] atletas){
        double suma = 0;
        double count = 0;

        for (int i = 0; i < atletas.length; i++) {
            Atleta atleta = atletas[i];

            if (atleta != null && atleta.esValido()) {
                suma += atleta.calcularVelocidad();
                count++;
            }
        } return (count > 0) ? suma / count : 0;
    }

    public static Atleta atletaMasRapido(Atleta[] atletas) {
        Atleta masRapido = null;

        for (int i = 0; i < atletas.length; i++) {
            Atleta actual = atletas[i];

            if (actual == null || !actual.esValido()) {
                continue;
            }

            if (masRapido == null || actual.calcularVelocidad() > masRapido.calcularVelocidad()) {
                masRapido = actual;
            }
        } return masRapido;
    }

    public static Atleta atletaMasLento(Atleta[] atletas) {
        Atleta masLento = null;

        for (int i = 0; i < atletas.length; i++){
            Atleta actual = atletas[i];

            if (actual == null || !actual.esValido()) {
                continue;
            }

            if (masLento == null || actual.calcularVelocidad() < masLento.calcularVelocidad()) {
                masLento = actual;
            }
        } return masLento;
    }

    public static double distanciaTotalValida(Atleta[] atletas) {
        double suma = 0;
        for (Atleta actual : atletas) {
            if (actual.esValido()) {
                suma += actual.getDistanciaRecorrida();
            }
        }return suma;
    }
}