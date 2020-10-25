package pe.rest.api.interfaze.service;

import pe.rest.api.model.entity.Place;
import pe.rest.api.model.filter.PlaceFilter;
import pe.rest.api.model.vo.Response;

public interface IPlaceService {
	Response select(PlaceFilter filter);
	Response insert(Place place);
	Response get(Long id);
	Response update(Long id,Place place);
	Response delete(Long id);
}
