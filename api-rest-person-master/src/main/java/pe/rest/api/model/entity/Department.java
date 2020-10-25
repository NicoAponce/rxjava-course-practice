package pe.rest.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@Column(name = "Id")
	public Long id;
	
	@Column(name = "NameDepartment")
	public String nameDepartment;
}
