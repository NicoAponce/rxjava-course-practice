package pe.rest.api.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rest.api.interfaze.repository.IDepartmentRepository;
import pe.rest.api.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>,IDepartmentRepository{

}
