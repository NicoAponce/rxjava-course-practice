package pe.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rest.api.model.filter.ProvinceFilter;
import pe.rest.api.model.vo.Response;
import pe.rest.api.service.ProvinceService;

@RestController
@RequestMapping("/api/province")
@CrossOrigin(origins = "*")
public class ProvinceController {

	@Autowired
	private ProvinceService service;
	
	@GetMapping
	public ResponseEntity<Response> select(){
		return ResponseEntity.ok(service.select());
	}
	
	@PostMapping("/get")
	public ResponseEntity<Response> get(@RequestBody ProvinceFilter filter){
		return ResponseEntity.ok(service.get(filter));
	}

}
