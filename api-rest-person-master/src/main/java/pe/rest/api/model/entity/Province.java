package pe.rest.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Province")
public class Province {
	
	@Id
	@Column(name = "Id")
	public Long id;
	
	@Column(name = "NameProvince")
	public String nameProvince;
	
	@Column(name = "IdDepartment")
	public Long idDepartment;
}
