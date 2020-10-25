package pe.rest.api.interfaze.service;

import pe.rest.api.model.entity.Person;
import pe.rest.api.model.filter.PersonFilter;
import pe.rest.api.model.vo.Response;

public interface IPersonService {

	Response select(PersonFilter filter);
    Response insert(Person person);
    Response get(Long id);
    Response update(Long id,Person person);
    Response delete(Long id);
}
