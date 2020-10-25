package pe.rx.person.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.rx.person.entity.Person;
import pe.rx.person.services.PersonService;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@Component
public class PersonHandler {

    @Autowired
    private PersonService service;

    public Mono<ServerResponse> select(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.select(), Person.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.get(id).flatMap(val -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(val).switchIfEmpty(ServerResponse.notFound().build()));
    }

    public Mono<ServerResponse> insert(ServerRequest request) {
        Mono<Person> personMono = request.bodyToMono(Person.class);
        return personMono.flatMap(val -> {
            if (val.createdAt == null) {
                val.createdAt = new Date();
            }
            return service.insert(val);
        }).flatMap(val -> ServerResponse.created(URI.create("/api/v2/person/".concat(val.id)))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(val));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        Mono<Person> personMono=request.bodyToMono(Person.class);
        String id=request.pathVariable("id");
        Mono<Person>pMono=service.get(id);
        return pMono.zipWith(personMono, (db,req)->{
            db.name=req.name;
            db.lastName=req.lastName;
            db.age=req.age;
            db.phone=req.phone;
            db.mail=req.mail;
            db.sex=req.sex;
            db.document=req.document;
            db.profession=req.profession;
            return  db;
        }).flatMap(val ->ServerResponse.created(URI.create("/api/v2/person/".concat(val.id)))
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(service.insert(val),Person.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        String id=request.pathVariable("id");
        Mono<Person> personMono=service.get(id);
        return personMono.flatMap(val -> service.delete(val)
        .then(ServerResponse.notFound().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
