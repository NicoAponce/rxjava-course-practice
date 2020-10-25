package pe.lol.app.apirestpokedex.implementation;

import org.springframework.stereotype.Repository;
import pe.lol.app.apirestpokedex.interfaze.repository.IGenerationRepository;
import pe.lol.app.apirestpokedex.model.dto.GenerationResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GenerationRepositoryImpl implements IGenerationRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public GenerationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<GenerationResponse> select() {
        List<GenerationResponse> result = null;
        try {
            StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_select_generation");
            query.execute();
            List<Object[]> list = query.getResultList();
            result = list.stream().map(row -> {
                GenerationResponse response = new GenerationResponse();
                response.id = Long.parseLong(row[0].toString());
                response.name = row[1].toString();
                return response;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
