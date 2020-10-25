package pe.rest.api.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IPlaceRepository;
import pe.rest.api.model.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>,IPlaceRepository{

}
