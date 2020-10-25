package pe.rest.api.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IProvinceRepository;
import pe.rest.api.model.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long>,IProvinceRepository{

}
