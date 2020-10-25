package pe.rest.api.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IPersonRepository;
import pe.rest.api.model.dto.PersonResponse;
import pe.rest.api.model.entity.Person;
import pe.rest.api.model.filter.PersonFilter;

@Repository
public class PersonRepositoryImpl implements IPersonRepository {

	@PersistenceContext
	private final EntityManager entityManager;

	public PersonRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<PersonResponse> select(PersonFilter filter) {
		List<PersonResponse> result = null;
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_person_select");
			query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
			query.setParameter("$name", filter.name);
			query.execute();

			List<Object[]> list = query.getResultList();
			result = list.stream().map(row -> {
				PersonResponse response = new PersonResponse();
				response.id = Long.parseLong(row[0].toString());
				response.name = row[1].toString();
				response.lastName = row[2].toString();
				response.age = Integer.parseInt(row[3].toString());
				response.phone = row[4].toString();
				response.documentNumber = row[5].toString();
				response.address = row[6].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public Person insert(Person person) {
		Person result=null;
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_person_insert");
			query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$lastName", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$age", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$phone", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$documentNumber", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$address", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$userAuditor", String.class, ParameterMode.IN);
			
			query.setParameter("$name", person.name);
			query.setParameter("$lastName", person.lastName);
			query.setParameter("$age", person.age);
			query.setParameter("$phone", person.phone);
			query.setParameter("$documentNumber", person.documentNumber);
			query.setParameter("$address", person.address);
			query.setParameter("$userAuditor", person.userAuditor);
			
			query.execute();
			result=person;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Person get(Long id) {
		Person result=null;
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_person_get");
			query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
			query.setParameter("$id", id);
			query.execute();
			
			Object row[]=(Object[]) query.getResultList().get(0);
			result =new Person();
			result.id = Long.parseLong(row[0].toString());
			result.name = row[1].toString();
			result.lastName = row[2].toString();
			result.age = Integer.parseInt(row[3].toString());
			result.phone = row[4].toString();
			result.documentNumber = row[5].toString();
			result.address = row[6].toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Person update(Person person) {
		Person result=null;
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_person_update");
			query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$lastName", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$age", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$phone", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$documentNumber", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$address", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$userAuditor", String.class, ParameterMode.IN);
			
			query.setParameter("$id", person.id);
			query.setParameter("$name", person.name);
			query.setParameter("$lastName", person.lastName);
			query.setParameter("$age", person.age);
			query.setParameter("$phone", person.phone);
			query.setParameter("$documentNumber", person.documentNumber);
			query.setParameter("$address", person.address);
			query.setParameter("$userAuditor", person.userAuditor);
			
			query.execute();
			result=person;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean delete(Long id) {
		Boolean result=false;
		try {
			StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_person_delete");
			query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
			query.setParameter("$id", id);
			query.execute();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
