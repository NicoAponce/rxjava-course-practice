package pe.rx.mini.person.services;

import pe.rx.mini.person.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    public Flux<Person> select();
    public Mono<Person> get(String id);
    public Mono<Person> insert(Person person);
    public Mono<Person> update(Person person, String id);
    public Mono<Void> delete(String id);
}
