package lol.demo.api.restpokemon.implementation;

import lol.demo.api.restpokemon.interfaze.repository.IPokemonRepository;
import lol.demo.api.restpokemon.model.dto.PokemonResponse;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonRepositoryImpl implements IPokemonRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PokemonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<PokemonResponse> select() {
        List<PokemonResponse> result = null;
        try {
            StoredProcedureQuery query=this.entityManager.createStoredProcedureQuery("usp_get_generation");
            query.execute();
            List<Object[]> list=query.getResultList();
            result=list.stream().map( row ->{
                PokemonResponse response=new PokemonResponse();
                response.id=Long.parseLong(row[0].toString());
                response.name=row[1].toString();
                return response;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




}
