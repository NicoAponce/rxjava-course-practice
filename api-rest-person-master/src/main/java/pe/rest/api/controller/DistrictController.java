package pe.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rest.api.model.filter.DistrictFilter;
import pe.rest.api.model.vo.Response;
import pe.rest.api.service.DistrictService;

@RestController
@RequestMapping("/api/district")
@CrossOrigin(origins = "*")
public class DistrictController {

	@Autowired
	private DistrictService service;
	
	@GetMapping
	public ResponseEntity<Response> select(){
		return ResponseEntity.ok(service.select());
	}
	
	@PostMapping("/get")
	public ResponseEntity<Response> get(@RequestBody DistrictFilter filter){
		return ResponseEntity.ok(service.get(filter));
	}
}
