package lol.demo.api.restpokemon.interfaze.jpa;

import lol.demo.api.restpokemon.interfaze.repository.IPokemonRepository;
import lol.demo.api.restpokemon.model.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>, IPokemonRepository {
}
