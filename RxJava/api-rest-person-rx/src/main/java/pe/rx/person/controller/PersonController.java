package pe.rx.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.rx.person.entity.Person;
import pe.rx.person.services.PersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<Person>>> select() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.select()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> get(@PathVariable String id){
        return service.get(id).map(val ->ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(val)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Person>> insert(@RequestBody Mono<Person> person){
        return person.flatMap(val ->{
            if(val.createdAt==null){
                val.createdAt=new Date();
            }
            return service.insert(val).map(per ->ResponseEntity
            .created(URI.create("/api/person/".concat(per.id)))
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(per));
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Person>> update(@PathVariable String id, @RequestBody Person person){
        return service.get(id).flatMap(val ->{
            val.name=person.name;
            val.lastName=person.lastName;
            val.age=person.age;
            val.document=person.document;
            val.mail=person.mail;
            val.phone=person.phone;
            val.sex=person.sex;
            val.profession=person.profession;
            return service.insert(val);
        }).map(per ->ResponseEntity.created(URI.create("/api/person/".concat(per.id)))
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(per)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return service.get(id).flatMap(val ->{
            return service.delete(val).then(Mono
                    .just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
