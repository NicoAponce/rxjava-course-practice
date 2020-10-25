package lol.demo.api.pokemon.lolapipokemon.repository;

import lol.demo.api.pokemon.lolapipokemon.entity.Generation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GenerationRepository extends ReactiveMongoRepository<Generation,String> {
}
