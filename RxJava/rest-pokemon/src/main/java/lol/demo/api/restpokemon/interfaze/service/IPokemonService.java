package lol.demo.api.restpokemon.interfaze.service;

import lol.demo.api.restpokemon.model.entity.Pokemon;
import lol.demo.api.restpokemon.model.vo.Response;

public interface IPokemonService {
    Response select();
    Response insert(Pokemon pokemon);
    Response get(Long id);
    Response update(Long id, Pokemon pokemon);
    Response delete(Long id);
}
