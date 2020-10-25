package lol.demo.api.pokemon.lolapipokemon.controller;

import lol.demo.api.pokemon.lolapipokemon.entity.Hero;
import lol.demo.api.pokemon.lolapipokemon.entity.Response;
import lol.demo.api.pokemon.lolapipokemon.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

    @Autowired
    private HeroService service;

    @GetMapping
    public Mono<ResponseEntity<Response>> select(){
        return service.select()
                .map(response -> ResponseEntity.ok(response));
    }

    @PostMapping
    public Mono<ResponseEntity<Response>> insert(@RequestBody Hero hero){
        return service.insert(hero)
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Response>> get(@PathVariable String id){
        return service.get(id)
                .map(response -> ResponseEntity.ok(response));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Response>> update(@PathVariable String id, @RequestBody Hero hero){
        return service.update(id,hero)
                .map(response -> ResponseEntity.ok(response));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Response>> delete(@PathVariable String id){
        return service.delete(id)
                .map(response -> ResponseEntity.ok(response));
    }
}
