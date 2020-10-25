package pe.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rest.api.interfaze.jpa.DepartmentRepository;
import pe.rest.api.interfaze.service.IDepartmentService;
import pe.rest.api.model.vo.Response;

@Service("department")
public class DepartmentService implements IDepartmentService{

	@Autowired
	private DepartmentRepository repository;
	
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

}
