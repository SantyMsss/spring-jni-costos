package co.edu.uceva.springjnicostos;



import ejemplojni.lib.JavaCostos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jni-service")
public class JNIRestController {
    private final JavaCostos miCostos;
    private float totalPronostico;
    private float precioVenta;
    private float totalCostoProduccion;

    public JNIRestController() {
        this.miCostos = new JavaCostos();
    }

    @GetMapping("/calcularValores/{a}/{b}/{meses}/{mesesPronostico}")
    public Map<String, Object> calcularValores(@PathVariable float a, @PathVariable float b, @PathVariable int meses, @PathVariable int mesesPronostico) {
        // Llama a la función nativa para calcular valores
        miCostos.calcularValores(a, b, meses, mesesPronostico);

        // Devuelve los resultados en un mapa JSON-friendly
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("mensaje", "Cálculo de pronóstico completado.");
        resultado.put("totalPronostico", totalPronostico);  // Muestra el resultado del pronóstico
        return resultado;
    }

    @GetMapping("/generarEstadoResultados/{totalPronostico}/{precioVenta}/{totalCostoProduccion}")
    public Map<String, Object> generarEstadoResultados(
            @PathVariable float totalPronostico,
            @PathVariable float precioVenta,
            @PathVariable float totalCostoProduccion) {

        // Llama a la función nativa para generar el estado de resultados
        miCostos.generarEstadoResultados(totalPronostico, precioVenta, totalCostoProduccion);

        // Devuelve los resultados en un mapa JSON-friendly
        Map<String, Object> estadoResultados = new HashMap<>();
        estadoResultados.put("totalPronostico", totalPronostico);
        estadoResultados.put("precioVenta", precioVenta);
        estadoResultados.put("totalCostoProduccion", totalCostoProduccion);
        estadoResultados.put("mensaje", "Estado de resultados generado exitosamente.");

        return estadoResultados;
    }
}
