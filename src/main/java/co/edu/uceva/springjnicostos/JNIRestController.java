package co.edu.uceva.springjnicostos;
import ejemplojni.lib.JavaCostos;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jni-service")
public class JNIRestController {

    private final JavaCostos costos;

    public JNIRestController() {
        this.costos = new JavaCostos();
    }

    // Endpoint para calcular el costo total de producción
    @GetMapping("/calcularCostoTotal/{costoFijo}/{costoVariable}/{cantidadProducida}")
    public double calcularCostoTotal(@PathVariable double costoFijo,
                                     @PathVariable double costoVariable,
                                     @PathVariable int cantidadProducida) {
        return costos.calcularCostoTotal(costoFijo, costoVariable, cantidadProducida);
    }

    // Endpoint para calcular el punto de equilibrio
    @GetMapping("/calcularPuntoEquilibrio/{precioVenta}/{costoFijo}/{costoVariable}")
    public double calcularPuntoEquilibrio(@PathVariable double precioVenta,
                                          @PathVariable double costoFijo,
                                          @PathVariable double costoVariable) {
        return costos.calcularPuntoEquilibrio(precioVenta, costoFijo, costoVariable);
    }

    // Endpoint para calcular el costo unitario
    @GetMapping("/calcularCostoUnitario/{costoTotal}/{cantidadProducida}")
    public double calcularCostoUnitario(@PathVariable double costoTotal,
                                        @PathVariable int cantidadProducida) {
        return costos.calcularCostoUnitario(costoTotal, cantidadProducida);
    }
}
