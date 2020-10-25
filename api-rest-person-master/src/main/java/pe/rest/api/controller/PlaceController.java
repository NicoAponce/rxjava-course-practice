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
import pe.rest.api.model.entity.Place;
import pe.rest.api.model.filter.PersonFilter;
import pe.rest.api.model.filter.PlaceFilter;
import pe.rest.api.model.vo.Response;
import pe.rest.api.service.PlaceService;

@RestController
@RequestMapping("/api/place")
@CrossOrigin(origins = "*")
public class PlaceController {
	
	@Autowired
	private PlaceService service;
	
	@PostMapping("/get")
	public ResponseEntity<Response> select(@RequestBody PlaceFilter filter){
		return ResponseEntity.ok(service.select(filter));
	}
	
	@PostMapping
	public ResponseEntity<Response> insert(@RequestBody Place place){
		return ResponseEntity.ok(service.insert(place));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> get(@PathVariable Long id){
		return ResponseEntity.ok(service.get(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Place place){
		return ResponseEntity.ok(service.update(id, place));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.delete(id));
	}
}
