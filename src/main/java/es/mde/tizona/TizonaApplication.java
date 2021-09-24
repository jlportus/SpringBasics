package es.mde.tizona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:config/jpa-config.xml"})
@Import({ ClaseConfiguracionJava.class })
public class TizonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TizonaApplication.class, args);
		System.out.println("Hola API");
	}

}
