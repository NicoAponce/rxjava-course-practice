package pe.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rest.api.model.entity.Person;
import pe.rest.api.model.filter.PersonFilter;
import pe.rest.api.model.vo.Response;
import pe.rest.api.service.PersonService;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = "*")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/get")
	public ResponseEntity<Response> select(@RequestBody PersonFilter filter){
			return ResponseEntity.ok(personService.select(filter));
	}
	
	@PostMapping
	public ResponseEntity<Response> insert(@RequestBody Person person){
			return ResponseEntity.ok(personService.insert(person));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> get(@PathVariable Long id){
			return ResponseEntity.ok(personService.get(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Person person){
			return ResponseEntity.ok(personService.update(id, person));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id){
			return ResponseEntity.ok(personService.delete(id));
	}
}
