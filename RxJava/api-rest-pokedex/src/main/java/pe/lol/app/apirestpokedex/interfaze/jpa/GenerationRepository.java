package pe.lol.app.apirestpokedex.interfaze.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.lol.app.apirestpokedex.interfaze.repository.IGenerationRepository;
import pe.lol.app.apirestpokedex.model.entity.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long>, IGenerationRepository {
}
