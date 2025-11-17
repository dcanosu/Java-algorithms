package Ejercicio3;

public class Atleta {

    private String nombre;
    private double distanciaRecorrida, tiempoEmpleado;

    public Atleta(String nombre, double distanciaRecorrida, double tiempoEmpleado) {
        if (distanciaRecorrida < 0 || tiempoEmpleado < 0)
            throw new IllegalArgumentException("Valores no pueden ser negativos");
        
        this.nombre = nombre;
        this.distanciaRecorrida = distanciaRecorrida;
        this.tiempoEmpleado = tiempoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public double getTiempoEmpleado() {
        return tiempoEmpleado;
    }

    public double calcularVelocidad() {
        return (tiempoEmpleado > 0) ? (distanciaRecorrida / tiempoEmpleado) : 0;
    }

    public boolean esValido() {
        return (distanciaRecorrida > 0 && tiempoEmpleado > 0);
    }
}