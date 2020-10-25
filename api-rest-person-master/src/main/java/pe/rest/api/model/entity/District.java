package pe.rest.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "District")
public class District {

	@Id
	@Column(name = "Id")
	public Long id;
	
	@Column(name = "NameDistrict")
	public String nameDistrict;
	
	@Column(name = "IdProvince")
	public Long idProvince;
}
