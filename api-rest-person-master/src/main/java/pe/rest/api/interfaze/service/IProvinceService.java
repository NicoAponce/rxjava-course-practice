package pe.rest.api.interfaze.service;

import pe.rest.api.model.filter.ProvinceFilter;
import pe.rest.api.model.vo.Response;

public interface IProvinceService {
	Response select();
	Response get(ProvinceFilter filter);
}
