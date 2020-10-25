package pe.rx.person.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.rx.person.entity.Profession;
import pe.rx.person.services.ProfessionService;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ProfessionHandler {

    @Autowired
    private ProfessionService service;

    public Mono<ServerResponse> select(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.select(), Profession.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.get(id).flatMap(val -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(val).switchIfEmpty(ServerResponse.notFound().build()));
    }

    public Mono<ServerResponse> insert(ServerRequest request) {
        Mono<Profession> professionMono = request.bodyToMono(Profession.class);
        return professionMono.flatMap(service::insert)
                .flatMap(val -> ServerResponse.created(URI
                        .create("/api/v2/profession/".concat(val.id)))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .syncBody(val));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        Mono<Profession> professionMono=request.bodyToMono(Profession.class);
        String id=request.pathVariable("id");
        Mono<Profession> pMono=service.get(id);
        return pMono.zipWith(professionMono,(db,req) ->{
            db.name=req.name;
            return db;
        }).flatMap(val ->ServerResponse.created(URI.create("/api/v2/profession/".concat(val.id)))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(service.insert(val),Profession.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
