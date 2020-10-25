package lol.demo.api.pokemon.lolapipokemon.repository;

import lol.demo.api.pokemon.lolapipokemon.entity.Type;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TypeRepository extends ReactiveMongoRepository<Type,String> {
}
