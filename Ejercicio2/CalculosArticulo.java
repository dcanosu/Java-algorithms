package Ejercicio2;

public class CalculosArticulo {
    public static double calcularManoObra(Articulo articulo) {
        double manoObra;
        switch (articulo.getClaveProducto()) {
            case 1:
                manoObra = 1000;
                break;
            case 2:
                manoObra = 2000;
                break;
            case 3:
                manoObra = 3000;
                break;
            case 4:
                manoObra = 4000;
                break;
            case 5:
            case 6:
                manoObra = 6000;
                break;
            default:
                manoObra = 500;
        }
        return manoObra;
    }

    public static double calcularGastosFabricacion(Articulo articulo) {
        double porcentaje;
        switch (articulo.getClaveProducto()) {
            case 1:
            case 2:
                porcentaje = 0.05;
                break;
            case 3:
            case 4:
                porcentaje = 0.10;
                break;
            case 5:
            case 6:
                porcentaje = 0.15;
                break;
            default:
                porcentaje = 0.0;
        }
        return articulo.getCostoMateriaPrima() * porcentaje;
    }

    public static double calcularCostoProduccion(Articulo articulo) {
        double manoObra = CalculosArticulo.calcularManoObra(articulo);
        double gastosFabricacion = CalculosArticulo.calcularGastosFabricacion(articulo);
        
        return articulo.getCostoMateriaPrima() + manoObra + gastosFabricacion;
    }

    public static double calcularPrecioVenta(Articulo articulo) {
        double costoProduccion = calcularCostoProduccion(articulo);
        double porcentajeGanancia;
        
        switch (articulo.getClaveProducto()) {
            case 1:
            case 2:
                porcentajeGanancia = 0.20;
                break;
            case 3:
            case 4:
                porcentajeGanancia = 0.30;
                break;
            case 5:
            case 6:
                porcentajeGanancia = 0.40;
                break;
            default:
                porcentajeGanancia = 0.0;
        }return costoProduccion * (1 + porcentajeGanancia);
    }

    public static double calcularTotalMateriaPrima(Articulo[] articulos) {
            double total = 0.0;
            for (Articulo a : articulos) {
                if (a != null) {
                    total += a.getCostoMateriaPrima();
                }
            }
            return total;
        }

    public static double calcularTotalPrecioVenta(Articulo[] articulos) {
        double total = 0.0;
        for (Articulo a : articulos) {
            if (a != null) {
                total += CalculosArticulo.calcularPrecioVenta(a);
            }
        }
        return total;
    }

    public static Articulo encontrarArticuloExtremo(Articulo[] articulos, boolean buscarMax) {
        Articulo extremo = null;
        double valorExtremo = buscarMax ? Double.MIN_VALUE : Double.MAX_VALUE;

        for (Articulo a : articulos) {
            if (a != null) {
                double precioVenta = CalculosArticulo.calcularPrecioVenta(a);
                
                if (extremo == null) {
                    extremo = a;
                    valorExtremo = precioVenta;
                    continue; 
                }
                
                if (buscarMax) {
                    if (precioVenta > valorExtremo) {
                        valorExtremo = precioVenta;
                        extremo = a;
                    }
                } else {
                    if (precioVenta < valorExtremo) {
                        valorExtremo = precioVenta;
                        extremo = a;
                    }
                }
            }
        }
        return extremo;
    }
    
    public static double calcularPromedioVentaPorClave(Articulo[] articulos, int clave) {
        double sumaVentas = 0.0;
        int contador = 0;
        for (Articulo a : articulos) {
            if (a != null && a.getClaveProducto() == clave) {
                sumaVentas += CalculosArticulo.calcularPrecioVenta(a);
                contador++;
            }
        }
        return (contador > 0) ? sumaVentas / contador : 0.0;  
    }
}