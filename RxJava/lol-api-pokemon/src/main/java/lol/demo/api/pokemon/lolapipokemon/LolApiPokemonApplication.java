package lol.demo.api.pokemon.lolapipokemon;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class LolApiPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LolApiPokemonApplication.class, args);
		log.info("Hello World");
	}

}
