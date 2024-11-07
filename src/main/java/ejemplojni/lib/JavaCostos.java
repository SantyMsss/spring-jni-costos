package ejemplojni.lib;

/**
 * Clase que representa el cálculo de costos con funciones nativas
 */
public class JavaCostos {

    // Método nativo para calcular el costo total
    public native double calcularCostoTotal(double costoFijo, double costoVariable, int cantidadProducida);

    // Método nativo para calcular el punto de equilibrio
    public native double calcularPuntoEquilibrio(double precioVenta, double costoFijo, double costoVariable);

    // Método nativo para calcular el costo unitario
    public native double calcularCostoUnitario(double costoTotal, int cantidadProducida);
}
