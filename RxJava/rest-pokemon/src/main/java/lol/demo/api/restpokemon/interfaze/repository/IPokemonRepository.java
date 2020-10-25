package lol.demo.api.restpokemon.interfaze.repository;

import lol.demo.api.restpokemon.model.dto.PokemonResponse;
import lol.demo.api.restpokemon.model.entity.Pokemon;

import java.util.List;

public interface IPokemonRepository {
    List<PokemonResponse> select();
}
