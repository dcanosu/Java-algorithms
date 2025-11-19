package Ejercicio2;

public class Impresion {

    public static void imprimirEncabezado() {
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                     LISTA DE ARTICULOS");
        System.out.println("=".repeat(repeticiones)+"\n");
        System.out.printf("%-4s %-6s %-10s %-11s %-12s %-12s %-10s%n",
                        "N°", "Clave", "Costo MP", "Mano Obra", "Gasto Fab.", "Costo Prod.", "Precio Venta");
        System.out.println("-".repeat(repeticiones));
    }

    public static void imprimirArticulos(Articulo[] articulos) {
        for (int i = 0; i < articulos.length; i++) {
            System.out.printf("%-4d %-6d $%,-10.0f $%,-10.0f $%,-10.0f $%,-10.0f $%,-13.0f%n",
                (i + 1),
                
                articulos[i].getClaveProducto(), 
                articulos[i].getCostoMateriaPrima(), 
                
                CalculosArticulo.calcularManoObra(articulos[i]), 
                CalculosArticulo.calcularGastosFabricacion(articulos[i]), 
                CalculosArticulo.calcularCostoProduccion(articulos[i]),
                CalculosArticulo.calcularPrecioVenta(articulos[i]));
        }
    }

    public static void mostrarEstadisticas(Articulo[] articulos) {
        Articulo masCaro = CalculosArticulo.encontrarArticuloExtremo(articulos, true);
        Articulo masEconomico = CalculosArticulo.encontrarArticuloExtremo(articulos, false);
        double totalMP = CalculosArticulo.calcularTotalMateriaPrima(articulos);
        double totalVenta = CalculosArticulo.calcularTotalPrecioVenta(articulos);
        
        boolean hayDatos = (articulos != null && articulos.length > 0 && totalVenta > 0); 
        
        int repeticiones = 65;
        System.out.println("\n"+"=".repeat(repeticiones));
        System.out.println("                  ESTADÍSTICAS COSTO Y VENTAS");
        System.out.println("=".repeat(repeticiones)+"\n");

        if (!hayDatos) {
            System.out.println("No se pueden calcular estadísticas: el arreglo de artículos está vacío.");
            System.out.println("=".repeat(repeticiones)+"\n");
        } else {
            System.out.println("Precio de Venta Promedio por Clave:");
            for (int clave = 1; clave <= 6; clave++) {
                double promedio = CalculosArticulo.calcularPromedioVentaPorClave(articulos, clave);
                if (promedio > 0) {
                    System.out.printf("  Clave %d: $%,.0f%n", clave, promedio);
                }
            }
            System.out.println("=".repeat(repeticiones)+"\n");


            if (masCaro != null) {
                System.out.printf("Artículo Más Caro (Articulo %d): $%,.0f%n", 
                                masCaro.getNumeroArticulo(), CalculosArticulo.calcularPrecioVenta(masCaro));
            } else {
                System.out.println("Artículo Más Caro: No encontrado.");
            }
            
            if (masEconomico != null) {
                System.out.printf("Artículo Más Económico (Articulo %d): $%,.0f%n", 
                                masEconomico.getNumeroArticulo(), CalculosArticulo.calcularPrecioVenta(masEconomico));
            } else {
                System.out.println("Artículo Más Económico: No encontrado.");
            }
            System.out.println("=".repeat(repeticiones)+"\n");

            System.out.println("Totales Acumulados:");
            System.out.printf("  Total Materia Prima: $%,.0f%n", totalMP);
            System.out.printf("  Total Precios de Venta: $%,.0f%n", totalVenta);
            System.out.println("=".repeat(repeticiones)+"\n");
        }
    }
}