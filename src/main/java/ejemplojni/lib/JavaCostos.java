package ejemplojni.lib;

public class JavaCostos {
    // Declaración de métodos nativos
    public native void calcularValores(float a, float b, int meses, int mesesPronostico);
    public native void generarEstadoResultados(float totalPronostico, float precioVenta, float totalCostoProduccion);

    // Cargar la librería nativa
    static {
        try {
            System.loadLibrary("costos"); // Carga la biblioteca nativa `libcostos.so`
            System.out.println("Biblioteca cargada exitosamente!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error al cargar la biblioteca: " + e.getMessage());
        }
    }

    // Constructor vacío
    public JavaCostos() {
    }
}
