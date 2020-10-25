package lol.demo.api.pokemon.lolapipokemon.service;

import lol.demo.api.pokemon.lolapipokemon.entity.Response;
import lol.demo.api.pokemon.lolapipokemon.entity.Type;
import lol.demo.api.pokemon.lolapipokemon.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public Mono<Response> select(){
        return repository.findAll()
                .collectList()
                .map(types -> Response.builder().result(types).build());
    }

    public Mono<Response> insert(Type type){
        return repository.save(type)
                .map(type1 -> Response.builder().result(type1).build());
    }

    public Mono<Response> get(String id){
        return repository.findById(id)
                .map(type -> Response.builder().result(type).build());
    }

    public Mono<Response> update(String id, Type type){
        return repository.findById(id)
                .map(type1 -> Type.builder()
                .id(type1.id)
                .name(type.name)
                .build())
                .flatMap(type1 -> repository.save(type1)
                .map(type2 -> Response.builder().result(type2).build()));
    }

    public Mono<Response> delete(String id){
        return repository.findById(id)
                .flatMap(type -> repository.delete(type).thenReturn(type))
                .map(type -> Response.builder().result(type).build());
    }
}
