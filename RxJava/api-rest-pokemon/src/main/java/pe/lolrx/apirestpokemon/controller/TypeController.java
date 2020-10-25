package pe.lolrx.apirestpokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.lolrx.apirestpokemon.entity.Response;
import pe.lolrx.apirestpokemon.entity.Type;
import pe.lolrx.apirestpokemon.service.TypeService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pokemon/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping
    public Mono<ResponseEntity<Response>> select(){
        return service.select()
                .map(response -> ResponseEntity.ok(response));
    }

    @PostMapping
    public Mono<ResponseEntity<Response>> insert(@RequestBody Type type){
        return service.insert(type)
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Response>> get(@PathVariable String id){
        return service.get(id)
                .map(response -> ResponseEntity.ok(response));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Response>> update(@PathVariable String id, @RequestBody Type type){
        return service.update(id,type)
                .map(response -> ResponseEntity.ok(response));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Response>> delete(@PathVariable String id){
        return service.delete(id)
                .map(response -> ResponseEntity.ok(response));
    }
}
