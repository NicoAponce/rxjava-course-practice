package pe.rest.api.interfaze.repository;

import java.util.List;

import pe.rest.api.model.dto.DistrictResponse;
import pe.rest.api.model.filter.DistrictFilter;

public interface IDistrictRepository {

	List<DistrictResponse> select();
	List<DistrictResponse> get(DistrictFilter filter);
	
}
