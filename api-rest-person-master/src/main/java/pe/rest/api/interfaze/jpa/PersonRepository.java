package pe.rest.api.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IPersonRepository;
import pe.rest.api.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>,IPersonRepository{

}
