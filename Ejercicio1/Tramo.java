package Ejercicio1;

public class Tramo {

    private int numeroTramo;
    private double xi, yi, zi;
    private double xf, yf, zf;
    private double tiempo;

    public Tramo(int numeroTramo, double xi, double yi, double zi, double xf, double yf, double zf, double tiempo) {
        if (xi < 0 || yi < 0 || zi < 0 || xf < 0 || yf < 0 || zf < 0)
            throw new IllegalArgumentException("Las coordenadas no pueden ser negativas");

        if (tiempo < 0)
        throw new IllegalArgumentException("El tiempo no puede ser negativo.");

        this.numeroTramo = numeroTramo;
        this.xi = xi;
        this.yi = yi;
        this.zi = zi;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
        this.tiempo = tiempo;
    }

    public int getNumeroTramo(){
        return numeroTramo;
    }

    public double getXi() {
        return xi;
    }
    public double getYi() {
        return yi;
    }
    public double getZi() {
        return zi;
    }
    public double getXf() {
        return xf;
    }
    public double getYf() {
        return yf;
    }
    public double getZf() {
        return zf;
    }
    public double getTiempo() {
        return tiempo;
    }

    public double distanciaRecorrida() {
        double dx = xi - xf;
        double dy = yi - yf;
        double dz = zi - zf;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double velocidadTramo() {
        return (tiempo > 0) ? distanciaRecorrida() / tiempo : 0;
    }

    public boolean esValido() {
        double distancia = distanciaRecorrida();
        return tiempo > 0 && distancia >= 0.5;
    }
}