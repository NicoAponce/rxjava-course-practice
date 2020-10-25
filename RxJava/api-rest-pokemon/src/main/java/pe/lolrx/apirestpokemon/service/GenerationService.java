package pe.lolrx.apirestpokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.lolrx.apirestpokemon.entity.Generation;
import pe.lolrx.apirestpokemon.entity.Response;
import pe.lolrx.apirestpokemon.repository.GenerationRepository;
import reactor.core.publisher.Mono;

@Service
public class GenerationService {

    @Autowired
    private GenerationRepository repository;

    public Mono<Response> select(){
        return repository.findAll()
                .collectList()
                .map(generations -> Response.builder()
                        .result(generations).build());
    }

    public Mono<Response> insert(Generation generation){
        return repository.save(generation)
                .map(generations -> Response.builder()
                        .result(generations).build());
    }

    public Mono<Response> get(String id){
        return repository.findById(id)
                .map(generation -> Response.builder()
                        .result(generation).build());
    }

    public Mono<Response> update(String id, Generation generation){
        return repository.findById(id)
                .map(generation1 -> Generation.builder()
                .id(generation1.id)
                .name(generation.name)
                .build())
                .flatMap(generation1 -> repository.save(generation1))
                .map(generation1 -> Response.builder()
                        .result(generation1).build());
    }

    public Mono<Response> delete(String id){
        return repository.findById(id)
                .flatMap(generation -> repository.delete(generation).thenReturn(generation))
                .map(generation -> Response.builder().result(generation).build());
    }
}
