package pe.rest.api.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IPlaceRepository;
import pe.rest.api.model.dto.PersonResponse;
import pe.rest.api.model.dto.PlaceResponse;
import pe.rest.api.model.entity.Place;
import pe.rest.api.model.filter.PlaceFilter;

@Repository
public class PlaceRepositoryImpl implements IPlaceRepository {

		@PersistenceContext
		private final EntityManager entityManager;
		
	
	public PlaceRepositoryImpl(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
		}



	@Override
	public List<PlaceResponse> select(PlaceFilter filter) {
		List<PlaceResponse> result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_place_select");
			query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
			query.setParameter("$name", filter.name);
			query.execute();
			
			List<Object[]> list = query.getResultList();
			result = list.stream().map(row -> {
				PlaceResponse response = new PlaceResponse();
				response.id = Long.parseLong(row[0].toString());
				response.name = row[1].toString();
				response.description = row[2].toString();
				response.department=row[3].toString();
				response.province=row[4].toString();
				response.district=row[5].toString();
				return response;
			}).collect(Collectors.toList());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Place insert(Place place) {
		Place result=null;
		try {
				StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_place_insert");
				query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("$description", String.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("$idDepartment", Long.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("$idProvince", Long.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("$idDistrict", Long.class, ParameterMode.IN);
				query.registerStoredProcedureParameter("$userAuditor", String.class, ParameterMode.IN);
				
				query.setParameter("$name", place.name);
				query.setParameter("$description", place.description);
				query.setParameter("$idDepartment", place.idDepartment);
				query.setParameter("$idProvince", place.idProvince);
				query.setParameter("$idDistrict", place.idDistrict);
				query.setParameter("$userAuditor", place.userAuditor);
				
				query.execute();
				result=place;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Place get(Long id) {
		Place result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_place_get");
			query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
			query.setParameter("$id", id);
			query.execute();
			
			Object row[]=(Object[])query.getResultList().get(0);
			result=new Place();
			result.id=Long.parseLong(row[0].toString());
			result.name=row[1].toString();
			result.description=row[2].toString();
			result.idDepartment=Long.parseLong(row[3].toString());
			result.idProvince=Long.parseLong(row[4].toString());
			result.idDistrict=Long.parseLong(row[5].toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public Place update(Place place) {
		Place result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_place_update");
			query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$name", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$description", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$idDepartment", Long.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$idProvince", Long.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$idDistrict", Long.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("$userAuditor", String.class, ParameterMode.IN);
			
			query.setParameter("$id", place.id);
			query.setParameter("$name", place.name);
			query.setParameter("$description", place.description);
			query.setParameter("$idDepartment", place.idDepartment);
			query.setParameter("$idProvince", place.idProvince);
			query.setParameter("$idDistrict", place.idDistrict);
			
			query.execute();
			result=place;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public Boolean delete(Long id) {
		Boolean result=null;
		try {
				StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_place_delete");
				query.registerStoredProcedureParameter("$id", Long.class, ParameterMode.IN);
				query.setParameter("$id", id);
				query.execute();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
