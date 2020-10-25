package lol.demo.api.pokemon.lolapipokemon.controller;

import lol.demo.api.pokemon.lolapipokemon.entity.Generation;
import lol.demo.api.pokemon.lolapipokemon.entity.Response;
import lol.demo.api.pokemon.lolapipokemon.service.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pokemon/generation")
public class GenerationController {

    @Autowired
    private GenerationService service;

    @GetMapping
    public Mono<ResponseEntity<Response>> select(){
        return service.select()
                .map(response -> ResponseEntity.ok(response));
    }

    @PostMapping
    public Mono<ResponseEntity<Response>> insert(@RequestBody Generation generation){
        return service.insert(generation)
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Response>> get(@PathVariable String id){
        return service.get(id)
                .map(response -> ResponseEntity.ok(response));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Response>> update(@PathVariable String id, @RequestBody Generation generation){
        return service.update(id,generation)
                .map(response -> ResponseEntity.ok(response));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Response>> delete(@PathVariable String id){
        return service.delete(id)
                .map(response -> ResponseEntity.ok(response));
    }
}
