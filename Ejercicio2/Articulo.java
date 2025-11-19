package Ejercicio2;

public class Articulo {
    private int numeroAritculo;
    private int claveProducto;
    private double costoMateriaPrima;

    public Articulo(int numeroAritculo, int claveProducto, double costoMateriaPrima) {
        if (claveProducto < 1 || claveProducto > 6) {
            throw new IllegalArgumentException("La clave del producto debe estar entre 1 y 6.");
        }
        if (costoMateriaPrima < 0) {
            throw new IllegalArgumentException("El costo de la materia prima no puede ser negativo.");
        }
        this.numeroAritculo = numeroAritculo;
        this.claveProducto = claveProducto;
        this.costoMateriaPrima = costoMateriaPrima;
    }

    public int getNumeroArticulo() {
        return numeroAritculo;
    }

    public int getClaveProducto() {
        return claveProducto;
    }
    public double getCostoMateriaPrima() {
        return costoMateriaPrima;
    }
}