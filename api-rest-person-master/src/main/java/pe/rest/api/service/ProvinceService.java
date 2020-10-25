package pe.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rest.api.interfaze.jpa.ProvinceRepository;
import pe.rest.api.interfaze.service.IProvinceService;
import pe.rest.api.model.filter.ProvinceFilter;
import pe.rest.api.model.vo.Response;

@Service("province")
public class ProvinceService implements IProvinceService {

	@Autowired
	private ProvinceRepository repository;

	@Override
	public Response select() {
		Response response = new Response();
		try {
			response.result = repository.select();
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public Response get(ProvinceFilter filter) {
		Response response = new Response();
		try {
			response.result = repository.get(filter);
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
