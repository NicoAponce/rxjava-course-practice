package pe.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rest.api.interfaze.jpa.DistrictRepository;
import pe.rest.api.interfaze.service.IDistrictService;
import pe.rest.api.model.filter.DistrictFilter;
import pe.rest.api.model.vo.Response;

@Service("district")
public class DistrictService implements IDistrictService{

	@Autowired
	private DistrictRepository repository;
	
	@Override
	public Response select() {
		Response response=new Response();
		try {
			response.result=repository.select();
			response.ok=response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	@Override
	public Response get(DistrictFilter filter) {
		Response response=new Response();
		try {
			response.result=repository.get(filter);
			response.ok=response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


}
