package pe.rest.api.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long id;
	
	@Column(name = "Name")
	@Size(max =100 )
	public String name;
	
	@Column(name = "Description")
	@Size(max = 100)
	public String description;
	
	@Column(name = "IdDepartment")
	public Long idDepartment;
	
	@Column(name = "IdProvince")
	public Long idProvince;
	
	@Column(name = "IdDistrict")
	public Long idDistrict;
	
	@Column(name = "State")
	public Boolean state;
	
	@Column(name = "CreatedAt")
	public Date createdAt;
	
	@Column(name = "UpdatedAt")
	public Date updatedAt;
	
	@Column(name = "UserAuditor")
	public String userAuditor;
}
