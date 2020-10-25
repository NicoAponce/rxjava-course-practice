package pe.rest.api.interfaze.repository;

import java.util.List;
import pe.rest.api.model.dto.PlaceResponse;
import pe.rest.api.model.entity.Place;
import pe.rest.api.model.filter.PlaceFilter;

public interface IPlaceRepository {
	List<PlaceResponse> select(PlaceFilter filter);
	Place insert(Place place);
	Place get(Long id);
	Place update(Place place);
	Boolean delete(Long id);
}
