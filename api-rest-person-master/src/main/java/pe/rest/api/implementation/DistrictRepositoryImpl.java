package pe.rest.api.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IDistrictRepository;
import pe.rest.api.model.dto.DistrictResponse;
import pe.rest.api.model.filter.DistrictFilter;

@Repository
public class DistrictRepositoryImpl implements IDistrictRepository{

	@PersistenceContext
	private final EntityManager ntityManager;
	
	public DistrictRepositoryImpl(EntityManager ntityManager) {
		super();
		this.ntityManager = ntityManager;
	}

	@Override
	public List<DistrictResponse> select() {
		List<DistrictResponse> result=null;
		try {
			StoredProcedureQuery query=this.ntityManager.createStoredProcedureQuery("usp_district_select");
			query.execute();
			
			List<Object[]> list=query.getResultList();
			result=list.stream().map(row ->{
				DistrictResponse response=new DistrictResponse();
				response.id=Long.parseLong(row[0].toString());
				response.nameDistrict=row[1].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<DistrictResponse> get(DistrictFilter filter) {
		List<DistrictResponse> result=null;
		try {
			StoredProcedureQuery query=this.ntityManager.createStoredProcedureQuery("usp_district_get");
			query.registerStoredProcedureParameter("$idProvince", Long.class, ParameterMode.IN);
			query.setParameter("$idProvince", filter.idProvince);
			query.execute();
			
			List<Object[]> list=query.getResultList();
			result=list.stream().map(row ->{
				DistrictResponse response=new DistrictResponse();
				response.id=Long.parseLong(row[0].toString());
				response.nameDistrict=row[1].toString();
				return response;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
