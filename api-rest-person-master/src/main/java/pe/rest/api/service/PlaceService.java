package pe.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rest.api.interfaze.jpa.PlaceRepository;
import pe.rest.api.interfaze.service.IPlaceService;
import pe.rest.api.model.entity.Place;
import pe.rest.api.model.filter.PlaceFilter;
import pe.rest.api.model.vo.Response;

@Service("place")
public class PlaceService implements IPlaceService {

	@Autowired
	private PlaceRepository repository;

	@Override
	public Response select(PlaceFilter filter) {
		Response response = new Response();
		try {
			response.result = repository.select(filter);
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response insert(Place place) {
		Response response = new Response();
		try {
			response.result = repository.insert(place);
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response get(Long id) {
		Response response = new Response();
		try {
			response.result = repository.get(id);
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response update(Long id, Place place) {
		Response response = new Response();
		try {
			response.result = repository.update(place);
			response.ok = response.result != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response delete(Long id) {
		Response response = new Response();
		try {
			response.ok = repository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
