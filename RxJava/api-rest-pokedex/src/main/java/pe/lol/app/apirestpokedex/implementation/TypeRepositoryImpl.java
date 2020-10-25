package pe.lol.app.apirestpokedex.implementation;

import org.springframework.stereotype.Repository;
import pe.lol.app.apirestpokedex.interfaze.repository.ITypeRepository;
import pe.lol.app.apirestpokedex.model.dto.TypeResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TypeRepositoryImpl implements ITypeRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public TypeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TypeResponse> select() {
        List<TypeResponse> result = null;
        try {
            StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("usp_select_type");
            query.execute();
            List<Object[]> list = query.getResultList();
            result = list.stream().map(row -> {
                TypeResponse response = new TypeResponse();
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
