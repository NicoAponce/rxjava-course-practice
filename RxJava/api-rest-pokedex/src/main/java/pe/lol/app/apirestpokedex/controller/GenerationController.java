package pe.lol.app.apirestpokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.lol.app.apirestpokedex.model.entity.Generation;
import pe.lol.app.apirestpokedex.model.vo.Response;
import pe.lol.app.apirestpokedex.service.GenerationService;

@RestController
@RequestMapping("/api/pokemon/generation")
public class GenerationController {

    @Autowired
    private GenerationService service;

    @GetMapping
    public ResponseEntity<Response> select(){
        return ResponseEntity.ok(service.select());
    }

    @PostMapping
    public ResponseEntity<Response> insert(@RequestBody Generation generation){
        return ResponseEntity.ok(service.insert(generation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Generation generation){
        return ResponseEntity.ok(service.update(id,generation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
