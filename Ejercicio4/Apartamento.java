package Ejercicio4;

public class Apartamento {

    private int numeroApartamento;
    private double consumoM3;
    private double costoPorM3;

    public Apartamento(int numeroApartamento, double consumoM3, double costoPorM3) {
        if (numeroApartamento < 0 || consumoM3 < 0 || costoPorM3 < 0)
            throw new IllegalArgumentException("Valores no pueden ser negativos");

        this.numeroApartamento = numeroApartamento;
        this.consumoM3 = consumoM3;
        this.costoPorM3 = costoPorM3;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public double getConsumoM3() {
        return consumoM3;
    }

    public double getCostoPorM3() {
        return costoPorM3;
    }

    public double valorPagar() {
        return consumoM3 * costoPorM3;
    }

    public boolean consumoAlto() {
        return consumoM3 > 25;
    }
}