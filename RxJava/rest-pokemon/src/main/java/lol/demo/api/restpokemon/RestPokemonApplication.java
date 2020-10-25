package lol.demo.api.restpokemon;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class RestPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPokemonApplication.class, args);
		log.info("Hello World");
	}

}
