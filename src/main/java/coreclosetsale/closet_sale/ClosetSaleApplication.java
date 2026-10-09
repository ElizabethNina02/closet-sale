package coreclosetsale.closet_sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(ClosetSaleApplication.class, args);
	}

}
