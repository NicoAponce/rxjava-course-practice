package lol.demo.api.pokemon.lolapipokemon.repository;

import lol.demo.api.pokemon.lolapipokemon.entity.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HeroRepository extends ReactiveMongoRepository<Hero, String> {
}
