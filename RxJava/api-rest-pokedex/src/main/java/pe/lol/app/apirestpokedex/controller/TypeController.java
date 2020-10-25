package pe.lol.app.apirestpokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.lol.app.apirestpokedex.model.entity.Type;
import pe.lol.app.apirestpokedex.model.vo.Response;
import pe.lol.app.apirestpokedex.service.TypeService;

@RestController
@RequestMapping("/api/pokemon/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping
    public ResponseEntity<Response> select(){
        return ResponseEntity.ok(service.select());
    }

    @PostMapping
    public ResponseEntity<Response> insert(@RequestBody Type type){
        return ResponseEntity.ok(service.insert(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Type type){
        return ResponseEntity.ok(service.update(id,type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
