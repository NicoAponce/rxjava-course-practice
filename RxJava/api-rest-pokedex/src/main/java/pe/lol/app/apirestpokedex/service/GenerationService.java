package pe.lol.app.apirestpokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.lol.app.apirestpokedex.interfaze.jpa.GenerationRepository;
import pe.lol.app.apirestpokedex.interfaze.service.IGenerationService;
import pe.lol.app.apirestpokedex.model.entity.Generation;
import pe.lol.app.apirestpokedex.model.vo.Response;

import java.util.Optional;

@Service
public class GenerationService implements IGenerationService {

    @Autowired
    private GenerationRepository repository;

    @Override
    public Response select() {
        Response response = new Response();
        try {
            response.result = repository.select();
            response.ok = response.result != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response insert(Generation generation) {
        Response response = new Response();
        try {
            Generation data = Generation.builder()
                    .name(generation.name)
                    .state(true)
                    .build();
            response.result = repository.save(data);
            response.ok = response.result != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response get(Long id) {
        Response response = new Response();
        try {
            response.result = repository.findById(id);
            response.ok = response.result != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response update(Long id, Generation generation) {
        Response response = new Response();
        try {
            Optional<Generation> getById = repository.findById(id);
            Generation data = Generation.builder()
                    .id(getById.get().id)
                    .name(generation.name)
                    .state(true)
                    .build();
            repository.save(data);
            response.result = data;
            response.ok = response.result != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        Response response=new Response();
        try{
            Optional<Generation> getById=repository.findById(id);
            Generation data=Generation.builder()
                    .id(getById.get().id)
                    .state(false)
                    .build();
            repository.save(data);
            if(data.state=false){
                response.ok=false;
            }
            response.ok=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
