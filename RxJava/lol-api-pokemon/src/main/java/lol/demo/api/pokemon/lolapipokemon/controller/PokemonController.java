package lol.demo.api.pokemon.lolapipokemon.controller;

import lol.demo.api.pokemon.lolapipokemon.entity.Pokemon;
import lol.demo.api.pokemon.lolapipokemon.entity.Response;
import lol.demo.api.pokemon.lolapipokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public Mono<ResponseEntity<Response>> select(){
        return service.select()
                .map(response -> ResponseEntity.ok(response));
    }

    @PostMapping
    public Mono<ResponseEntity<Response>> insert(@RequestBody Pokemon pokemon){
        return service.insert(pokemon)
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Response>> get(@PathVariable String id){
        return service.get(id)
                .map(response -> ResponseEntity.ok(response));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Response>> update(@PathVariable String id, @RequestBody Pokemon pokemon){
        return service.update(id,pokemon)
                .map(response -> ResponseEntity.ok(response));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Response>> delete(@PathVariable String id){
        return service.delete(id)
                .map(response -> ResponseEntity.ok(response));
    }
}
