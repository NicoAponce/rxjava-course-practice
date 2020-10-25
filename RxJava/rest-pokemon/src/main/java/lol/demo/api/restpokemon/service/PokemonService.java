package lol.demo.api.restpokemon.service;

import lol.demo.api.restpokemon.interfaze.jpa.PokemonRepository;
import lol.demo.api.restpokemon.interfaze.service.IPokemonService;
import lol.demo.api.restpokemon.model.entity.Pokemon;
import lol.demo.api.restpokemon.model.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public Response select() {
        Response response=new Response();
        try{
            response.result=repository.select();
            response.ok=response.result != null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response insert(Pokemon pokemon) {
        Response response=new Response();
        try{
            response.result=repository.save(pokemon);
            response.ok=response.result != null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response get(Long id) {
        Response response=new Response();
        try {
            response.result=repository.findById(id);
            response.ok=response.result != null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response update(Long id, Pokemon pokemon) {
        Response response=new Response();
        try {
            if(id>0){
                Optional<Pokemon> pokemon1=repository.findById(id);
                Pokemon pokemon2=Pokemon.builder().id(pokemon1.get().id).name(pokemon.name).build();
                repository.save(pokemon2);
                response.result=pokemon2;
            }
            response.ok=response.result != null;


        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        Response response=new Response();
        try {
            if(id>0){
                repository.deleteById(id);
                response.ok=true;
                response.result=id;
            }else{
                response.ok=response.result != null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

}
