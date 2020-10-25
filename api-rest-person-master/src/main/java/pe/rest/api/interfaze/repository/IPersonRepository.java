package pe.rest.api.interfaze.repository;

import java.util.List;

import pe.rest.api.model.dto.PersonResponse;
import pe.rest.api.model.entity.Person;
import pe.rest.api.model.filter.PersonFilter;

public interface IPersonRepository {

	List<PersonResponse> select(PersonFilter filter);
    Person insert(Person person);
    Person get(Long id);
    Person update(Person person);
    Boolean delete(Long id);
}
