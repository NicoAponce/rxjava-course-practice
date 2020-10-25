package lol.demo.api.restpokemon.controller;

import lol.demo.api.restpokemon.model.entity.Pokemon;
import lol.demo.api.restpokemon.model.vo.Response;
import lol.demo.api.restpokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public ResponseEntity<Response> select(){
        return ResponseEntity.ok(service.select());
    }

    @PostMapping
    public ResponseEntity<Response> insert(@RequestBody Pokemon pokemon){
        return ResponseEntity.ok(service.insert(pokemon));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return ResponseEntity.ok(service.update(id,pokemon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
