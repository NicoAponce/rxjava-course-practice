package pe.rx.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.rx.person.entity.Profession;
import pe.rx.person.services.ProfessionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<Profession>>> select(){
        return Mono.just(
                ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.select())
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Profession>> get(@PathVariable String id){
        return service.get(id).map(val ->ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(val)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Profession>> insert(@RequestBody Mono<Profession> profession){
        return profession.flatMap(val ->{
            return service.insert(val).map(pro ->ResponseEntity
            .created(URI.create("/api/profession/".concat(pro.id)))
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(pro));
        });
    }
}
