package pe.lol.app.apirestpokedex.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.lol.app.apirestpokedex.interfaze.repository.ITypeRepository;
import pe.lol.app.apirestpokedex.model.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>, ITypeRepository {
}
