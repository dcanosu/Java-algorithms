package Ejercicio1;

public class Tramo1 {

    private double xi, yi, zi;
    private double xf, yf, zf;
    private double time;

    public Tramo1(double xi, double yi, double zi, double xf, double yf, double zf, double time) {
        this.xi = xi;
        this.yi = yi;
        this.zi = zi;
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
        this.time = time;
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
    public double getTime() {
        return time;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }
    public void setYi(double yi) {
        this.yi = yi;
    }
    public void setZi(double zi) {
        this.zi = zi;
    }
    public void setXf(double xf) {
        this.xf = xf;
    }
    public void setYf(double yf) {
        this.yf = yf;
    }
    public void setZf(double zf) {
        this.zf = zf;
    }
    public void setTime(double time){
        this.time = time;
    }

    public double calculateDistance() {
        double dx = xi - xf;
        double dy = yi - yf;
        double dz = zi - zf;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double calculateSpeed() {
        if (time > 0) {
            return calculateDistance() / time;
        }
        return 0;
    }

    // Método que indica si el tramo debe considerarse válido para estadísticas
    public boolean esValido() {
        double distance = calculateDistance();
        return time > 0 && distance >= 0.5;
    }
}
