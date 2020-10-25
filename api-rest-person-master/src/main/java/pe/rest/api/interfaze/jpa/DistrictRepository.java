package pe.rest.api.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IDistrictRepository;
import pe.rest.api.model.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>,IDistrictRepository{

}
