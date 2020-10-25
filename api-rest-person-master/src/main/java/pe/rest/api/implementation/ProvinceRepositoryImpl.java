package pe.rest.api.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IProvinceRepository;
import pe.rest.api.model.dto.ProvinceResponse;
import pe.rest.api.model.filter.ProvinceFilter;

@Repository
public class ProvinceRepositoryImpl implements IProvinceRepository{

	@PersistenceContext
	private final EntityManager entityManager;
	
	public ProvinceRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<ProvinceResponse> select() {
		List<ProvinceResponse> result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_province_select");
			query.execute();
			
			List<Object[]> list=query.getResultList();
			result=list.stream().map(row ->{
				ProvinceResponse response=new ProvinceResponse();
				response.id=Long.parseLong(row[0].toString());
				response.nameProvince=row[1].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ProvinceResponse> get(ProvinceFilter filter) {
		List<ProvinceResponse> result=null;
		try {
			StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_province_get");
			query.registerStoredProcedureParameter("$idDepartment",Long.class,ParameterMode.IN);
			query.setParameter("$idDepartment", filter.idDepartment);
			query.execute();
			
			List<Object[]> list=query.getResultList();
			result=list.stream().map(row ->{
				ProvinceResponse response=new ProvinceResponse();
				response.id=Long.parseLong(row[0].toString());
				response.nameProvince=row[1].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
