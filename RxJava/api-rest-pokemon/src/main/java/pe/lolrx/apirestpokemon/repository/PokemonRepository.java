package pe.lolrx.apirestpokemon.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.lolrx.apirestpokemon.entity.Pokemon;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon,String> {
}
