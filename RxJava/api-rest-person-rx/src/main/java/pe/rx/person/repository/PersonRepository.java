package pe.rx.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.rx.person.entity.Person;

public interface PersonRepository extends ReactiveMongoRepository<Person,String> {
}
