package pe.lolrx.apirestpokemon.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.lolrx.apirestpokemon.entity.Pokemon;
import pe.lolrx.apirestpokemon.entity.Response;
import pe.lolrx.apirestpokemon.service.PokemonService;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class PokemonHandler {

    @Autowired
    private PokemonService service;

    public Mono<ServerResponse> select(ServerRequest request){
        return ServerResponse.ok().body(service.select(), Pokemon.class);
    }

    public Mono<ServerResponse> insert(ServerRequest request){
        Mono<Pokemon> pokemonMono=request.bodyToMono(Pokemon.class);
        return pokemonMono.flatMap(pokemon -> service.insert(pokemon))
                .flatMap(response -> ServerResponse.ok()
                        .syncBody(response));
    }

    public Mono<ServerResponse> get(ServerRequest request){
        String id=request.pathVariable("id");
        return service.get(id).flatMap(response -> ServerResponse.ok()
        .syncBody(response));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        String id=request.pathVariable("id");
        Mono<Response> pokemonMono1=service.get(id);
        Pokemon pokemon=Pokemon.builder()
                .name("demo")
                .power("demo")
                .build();
        return pokemonMono1.flatMap(response ->service.update(id,pokemon))
                .flatMap(response -> ServerResponse.ok()
                .syncBody(response));
    }
}
