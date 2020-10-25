package pe.lolrx.apirestpokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.lolrx.apirestpokemon.entity.Pokemon;
import pe.lolrx.apirestpokemon.entity.Response;
import pe.lolrx.apirestpokemon.repository.PokemonRepository;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    public Mono<Response> select() {
        return repository.findAll()
                .collectList()
                .map(pokemonList ->
                        Response.builder()
                                .result(pokemonList)
                                .build());
    }

    public Mono<Response> insert(Pokemon pokemon) {
        return repository.save(pokemon)
                .map(pokemon1 -> Response
                        .builder()
                        .result(pokemon1)
                        .build());
    }

    public Mono<Response> get(String id) {
        return repository.findById(id)
                .map(pokemon -> Response.builder().result(pokemon).build());
    }

    public Mono<Response> update(String id, Pokemon pokemon) {
        return repository.findById(id)
                .map(pokemon1 -> Pokemon.builder()
                        .id(pokemon1.id)
                        .name(pokemon.name)
                        .type(pokemon.type)
                        .power(pokemon.power)
                        .sex(pokemon.sex)
                        .attack(pokemon.attack)
                        .defense(pokemon.defense)
                        .stamina(pokemon.stamina)
                        .cp(pokemon.cp)
                        .generation(pokemon.generation)
                        .build())
                .flatMap(pokemon1 ->
                        repository.save(pokemon1)
                                .map(pokemon2 ->
                                        Response.builder()
                                                .result(pokemon2)
                                                .build()));
    }

    public Mono<Response> delete(String id){
        return repository.findById(id)
                .flatMap(pokemon ->
                        repository.delete(pokemon)
                                .thenReturn(pokemon))
                .map(pokemon -> Response.builder()
                        .result(pokemon).build());
    }
}
