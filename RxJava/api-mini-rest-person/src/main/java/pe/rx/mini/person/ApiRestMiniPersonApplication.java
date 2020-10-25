package pe.rx.mini.person;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class ApiRestMiniPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestMiniPersonApplication.class, args);
		log.info("Hola mundo cruel");
	}

}
