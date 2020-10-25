package pe.rest.api.interfaze.repository;

import java.util.List;

import pe.rest.api.model.dto.DepartmentResponse;

public interface IDepartmentRepository {
	List<DepartmentResponse> select();
}
