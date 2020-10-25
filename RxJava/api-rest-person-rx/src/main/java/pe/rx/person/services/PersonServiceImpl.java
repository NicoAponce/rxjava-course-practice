package pe.rx.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.rx.person.entity.Person;
import pe.rx.person.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository repository;

    @Override
    public Flux<Person> select() {
        return repository.findAll();
    }

    @Override
    public Mono<Person> get(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Person> insert(Person person) {
        return repository.save(person);
    }

    @Override
    public Mono<Void> delete(Person person) {
        return repository.delete(person);
    }
}
