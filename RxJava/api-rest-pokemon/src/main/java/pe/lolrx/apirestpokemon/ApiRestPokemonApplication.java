package pe.lolrx.apirestpokemon;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class ApiRestPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPokemonApplication.class, args);
		log.info("Hello World");
	}

}
