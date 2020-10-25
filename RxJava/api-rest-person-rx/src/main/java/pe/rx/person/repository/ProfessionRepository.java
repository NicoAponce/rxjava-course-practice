package pe.rx.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.rx.person.entity.Profession;

public interface ProfessionRepository extends ReactiveMongoRepository<Profession,String> {
}
