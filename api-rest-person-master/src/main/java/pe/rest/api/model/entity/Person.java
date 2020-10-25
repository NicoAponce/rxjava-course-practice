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
@Table(name = "Person")
public class Person {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public Long id;
	
	@Column(name = "Name")
	@Size(max = 100)
	public String name;
	
	@Column(name = "LastName")
	@Size(max = 100)
	public String lastName;
	
	@Column(name = "Age")
	public Integer age;
	
	@Column(name = "Phone")
	@Size(max = 15)
	public String phone;
	
	@Column(name = "DocumentNumber")
	@Size(max = 20)
	public String documentNumber;
	
	@Column(name = "Address")
	@Size(max = 250)
	public String address;
	
	@Column(name = "State")
	public Boolean state;
	
	@Column(name = "CreatedAt")
	public Date createdAt;
	
	@Column(name = "UpdatedAt")
	public Date updatedAt;
	
	@Column(name = "UserAuditor")
	public String userAuditor;
	
}
