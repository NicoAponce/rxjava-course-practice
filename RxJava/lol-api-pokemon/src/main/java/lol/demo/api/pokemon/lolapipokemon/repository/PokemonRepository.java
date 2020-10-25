package lol.demo.api.pokemon.lolapipokemon.repository;

import lol.demo.api.pokemon.lolapipokemon.entity.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon,String> {
}
