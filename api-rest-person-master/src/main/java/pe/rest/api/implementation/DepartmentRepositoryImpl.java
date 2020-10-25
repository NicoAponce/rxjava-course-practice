package pe.rest.api.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IDepartmentRepository;
import pe.rest.api.model.dto.DepartmentResponse;

@Repository
public class DepartmentRepositoryImpl implements IDepartmentRepository{

	@PersistenceContext
	private final EntityManager entityManager;
	
	public DepartmentRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<DepartmentResponse> select() {
		List<DepartmentResponse> result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_department_select");
			query.execute();
			List<Object[]> list=query.getResultList();
			result=list.stream().map(row ->{
				DepartmentResponse response=new DepartmentResponse();
				response.id=Long.parseLong(row[0].toString());
				response.nameDepartment=row[1].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
