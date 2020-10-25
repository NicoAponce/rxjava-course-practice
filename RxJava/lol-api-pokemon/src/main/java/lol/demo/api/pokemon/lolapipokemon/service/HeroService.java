package lol.demo.api.pokemon.lolapipokemon.service;

import lol.demo.api.pokemon.lolapipokemon.entity.Hero;
import lol.demo.api.pokemon.lolapipokemon.entity.Response;
import lol.demo.api.pokemon.lolapipokemon.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HeroService {

    @Autowired
    private HeroRepository repository;

    public Mono<Response> select(){
        return repository.findAll()
                .collectList()
                .map(heroes -> Response.builder()
                        .result(heroes).build());
    }

    public Mono<Response> insert(Hero hero){
        return repository.save(hero)
                .map(hero1 -> Response.builder()
                        .result(hero1).build());
    }

    public Mono<Response> get(String id){
        return repository.findById(id)
                .map(hero -> Response.builder()
                        .result(hero).build());
    }

    public Mono<Response> update(String id, Hero hero){
        return repository.findById(id)
                .map(hero1 -> Hero.builder()
                .id(hero1.id)
                .name(hero.name)
                .power(hero.power)
                .weakness(hero.weakness)
                .origin(hero.origin)
                .build())
                .flatMap(hero1 -> repository.save(hero1)
                .map(hero2 -> Response.builder()
                        .result(hero2).build()));
    }

    public Mono<Response> delete(String id){
        return repository.findById(id)
                .flatMap(hero -> repository.delete(hero)
                .thenReturn(hero))
                .map(hero -> Response.builder()
                        .result(hero).build());
    }
}
