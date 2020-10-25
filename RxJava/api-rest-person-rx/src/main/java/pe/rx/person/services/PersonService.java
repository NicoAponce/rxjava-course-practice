package pe.rx.person.services;

import pe.rx.person.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Flux<Person> select();

    Mono<Person> get(String id);

    Mono<Person> insert(Person person);

    Mono<Void> delete(Person person);
}
