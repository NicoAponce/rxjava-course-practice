package pe.lolrx.apirestpokemon.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.lolrx.apirestpokemon.entity.Generation;

public interface GenerationRepository extends ReactiveMongoRepository<Generation, String> {
}
