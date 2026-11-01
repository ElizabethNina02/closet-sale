package coreclosetsale.closet_sale;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition (
		info = @Info (
				title = "Student API",
				version = "1.0",
				description = "API documentation for managing students"
		)
)

@SpringBootApplication
public class ClosetSaleApplication {

	public static void main(String[] args) {
		try {
            if (Files.exists(Paths.get(".env"))) {
                List<String> lines = Files.readAllLines(Paths.get(".env"));
                for (String line : lines) {
                    if (!line.trim().isEmpty() && !line.startsWith("#") && line.contains("=")) {
                        String[] parts = line.split("=", 2);
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        System.setProperty(key, value);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo .env local: " + e.getMessage());
        }
		SpringApplication.run(ClosetSaleApplication.class, args);
	}

	    // INICIALIZADOR SEGURO PARA SPRING BOOT 4 / POSTGRESQL
    @Bean
    public CommandLineRunner initDatabase(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                System.out.println("====== INICIANDO CARGA DE DATA.SQL EN SPRING BOOT 4 ======");
                
                // 1. Lee todo el contenido del archivo SQL
                ClassPathResource resource = new ClassPathResource("data.sql");
                String sql = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                
                // 2. Divide el archivo en consultas individuales usando el punto y coma (;)
                // El (?<!\B'[^']*) evita romper si hay un punto y coma dentro de un texto
                String[] statements = sql.split(";");
                
                // 3. Ejecuta cada consulta una por una de forma limpia
                for (String statement : statements) {
                    String cleanStatement = statement.trim();
                    if (!cleanStatement.isEmpty()) {
                        jdbcTemplate.execute(cleanStatement);
                    }
                }
                
                System.out.println("====== DATA.SQL EJECUTADO CON ÉXITO ======");
            } catch (Exception e) {
                System.err.println("Error crítico al ejecutar el script data.sql: " + e.getMessage());
                e.printStackTrace(); // Esto te mostrará la línea exacta si vuelve a fallar
            }
        };
    }

}
