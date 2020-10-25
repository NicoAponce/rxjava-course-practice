package pe.rx.person.services;

import pe.rx.person.entity.Profession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfessionService {

    Flux<Profession> select();
    Mono<Profession> get(String id);
    Mono<Profession> insert(Profession profession);
}
