package co.edu.uceva.springjnicostos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringJniCostosApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringJniCostosApplication.class);

    static {
        logger.info("Cargando la biblioteca nativa costos...");
        System.loadLibrary("costos");  // Asegúrate de que el nombre coincida con tu archivo .so
        logger.info("Biblioteca cargada exitosamente!");
    }

    public static void main(String[] args) {
        logger.info("Iniciando aplicación Spring Boot");
        SpringApplication.run(SpringJniCostosApplication.class, args);
    }
}
