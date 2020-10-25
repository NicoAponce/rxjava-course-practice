package pe.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rest.api.interfaze.jpa.PersonRepository;
import pe.rest.api.interfaze.service.IPersonService;
import pe.rest.api.model.entity.Person;
import pe.rest.api.model.filter.PersonFilter;
import pe.rest.api.model.vo.Response;

@Service("person")
public class PersonService implements IPersonService{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Response select(PersonFilter filter) {
		Response response=new Response();
		try {
			response.result=personRepository.select(filter);
			response.ok=response.result != null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response insert(Person person) {
		Response response=new Response();
		try {
			response.result=personRepository.insert(person);
			response.ok=response.result != null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response get(Long id) {
		Response response=new Response();
		try {
			response.result=personRepository.get(id);
			response.ok=response.result != null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response update(Long id, Person person) {
		Response response=new Response();
		try {
			response.result=personRepository.update(person);
			response.ok=response.result != null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response delete(Long id) {
		Response response=new Response();
		try {
			response.ok=personRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
