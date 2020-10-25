package pe.lol.app.apirestpokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.lol.app.apirestpokedex.interfaze.jpa.TypeRepository;
import pe.lol.app.apirestpokedex.interfaze.service.ITypeService;
import pe.lol.app.apirestpokedex.model.entity.Type;
import pe.lol.app.apirestpokedex.model.vo.Response;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeRepository repository;

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
    public Response insert(Type type) {
        Response response = new Response();
        try {
            Type data = Type.builder()
                    .name(type.name)
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
    public Response update(Long id, Type type) {
        Response response = new Response();
        try {
            Optional<Type> getById = repository.findById(id);
            Type data = Type.builder()
                    .id(getById.get().id)
                    .name(type.name)
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
            Optional<Type> getById=repository.findById(id);
            Type data=Type.builder()
                    .id(getById.get().id)
                    .state(false)
                    .build();
            repository.save(data);
            if(data.id >0){
                response.ok=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
