package pe.rest.api.interfaze.service;

import pe.rest.api.model.filter.DistrictFilter;
import pe.rest.api.model.vo.Response;

public interface IDistrictService {
	Response select();
	Response get(DistrictFilter filter);
}
