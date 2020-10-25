package pe.rx.mini.person.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.rx.mini.person.entity.Person;
import pe.rx.mini.person.services.PersonService;
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
                .syncBody(val)).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> insert(ServerRequest request) {
        Mono<Person> personMono = request.bodyToMono(Person.class);
        return personMono.flatMap(val -> {
            if (val.createdAt == null) {
                val.createdAt = new Date();
            }
            return service.insert(val);
        }).flatMap(val -> ServerResponse.created(URI.create("/rx/person/".concat(val.id)))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(val));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<Person> personMono=request.bodyToMono(Person.class);
        String id=request.pathVariable("id");
        return personMono.flatMap(val ->ServerResponse.created(URI.create("/rx/person/".concat(id)))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.update(val,id),Person.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        String id =request.pathVariable("id");
        return service.delete(id).then(ServerResponse.noContent().build());
    }
}
