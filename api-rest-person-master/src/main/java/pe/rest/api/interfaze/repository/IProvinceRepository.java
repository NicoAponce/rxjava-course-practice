package pe.rest.api.interfaze.repository;

import java.util.List;

import pe.rest.api.model.dto.ProvinceResponse;
import pe.rest.api.model.filter.ProvinceFilter;

public interface IProvinceRepository {
	List<ProvinceResponse> select();
	List<ProvinceResponse> get(ProvinceFilter filter);
}
